package com.devweb.sbceventoapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.devweb.sbceventoapi.model.Edicao;
import com.devweb.sbceventoapi.model.Evento;
import com.devweb.sbceventoapi.repository.EdicaoRepository;
import com.devweb.sbceventoapi.repository.EventoRepository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/evento")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EdicaoRepository edicaoRepository;

    // Endpoint para obter a lista de todos os eventos
    @GetMapping
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    // Endpoint para adicionar um novo evento
    @PostMapping
    public ResponseEntity<Evento> adicionarEvento(@RequestBody Evento evento) {
        // Adiciona um novo evento e retorna a resposta com o evento criado
        Evento novoEvento = eventoRepository.save(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEvento);
    }

    // Endpoint para obter um evento pelo ID
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<Evento> buscarEventoPorId(@PathVariable Long id) {
        // Busca um evento pelo ID e retorna uma resposta apropriada
        return eventoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para obter um evento pelo path
    @GetMapping("/{path:[a-zA-Z0-9-]*[a-zA-Z][a-zA-Z0-9-]*}")
    public ResponseEntity<Evento> buscarEventoPorPath(@PathVariable String path) {
        // Busca um evento pelo path e retorna uma resposta apropriada
        return eventoRepository.findByPath(path)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para atualizar as informações de um evento existente
    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizarEvento(@PathVariable Long id, @RequestBody Evento evento) {
        // Atualiza as informações de um evento existente e retorna a resposta
        // apropriada
        return eventoRepository.findById(id)
                .map(record -> {
                    record.setNome(evento.getNome());
                    record.setSigla(evento.getSigla());
                    record.setDescricao(evento.getDescricao());
                    record.setPath(evento.getPath());
                    Evento updated = eventoRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para excluir um evento pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEvento(@PathVariable Long id) {
        // Deleta um evento pelo ID e retorna a resposta apropriada
        return eventoRepository.findById(id)
                .map(record -> {
                    eventoRepository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para acessar o site de um evento com base no path e ano
    @GetMapping("/{path}/{ano}")
    public ResponseEntity<Map<String, String>> acessarSiteEvento(@PathVariable String path, @PathVariable String ano) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

            Optional<Evento> eventoOptional = eventoRepository.findByPath(path);

            if (eventoOptional.isPresent()) {
                Evento evento = eventoOptional.get();
                Optional<Edicao> edicaoOptional = edicaoRepository.findByAnoAndEvento(ano, evento);

                if (edicaoOptional.isPresent()) {
                    String rootUrl = request.getRequestURL().toString().replace(request.getRequestURI(),
                            request.getContextPath());

                    Map<String, String> response = new HashMap<>();
                    response.put("url", rootUrl + "/" + path + "/" + ano);

                    return ResponseEntity.ok(response);
                }
            }
        }

        return ResponseEntity.notFound().build();
    }
}
