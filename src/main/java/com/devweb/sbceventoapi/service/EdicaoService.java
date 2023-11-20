package com.devweb.sbceventoapi.service;

import org.springframework.stereotype.Service;

import com.devweb.sbceventoapi.model.Edicao;
import com.devweb.sbceventoapi.model.Usuario;
import com.devweb.sbceventoapi.repository.EdicaoRepository;
import com.devweb.sbceventoapi.repository.UsuarioRepository;

@Service
public class EdicaoService {

    private final EdicaoRepository edicaoRepository;
    private final UsuarioRepository usuarioRepository;

    public EdicaoService(EdicaoRepository edicaoRepository, UsuarioRepository usuarioRepository) {
        this.edicaoRepository = edicaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Método para o admin definir um organizador para uma edição
    public void definirOrganizador(Long edicaoId, Long usuarioId) {
        // Obtém a edição
        Edicao edicao = edicaoRepository.findById(edicaoId).orElse(null);

        // Verifica se a edição existe
        if (edicao != null) {
            // Obtém o organizador
            Usuario organizador = usuarioRepository.findById(usuarioId).orElse(null);

            // Verifica se o organizador existe
            if (organizador != null) {
                // Define o organizador para a edição
                edicao.setOrganizador(organizador);
                edicaoRepository.save(edicao);
            } else {
                throw new IllegalArgumentException("Organizador não encontrado");
            }
        } else {
            throw new IllegalArgumentException("Edição não encontrada");
        }
    }
}
