package com.devweb.sbceventoapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devweb.sbceventoapi.model.Edicao;
import com.devweb.sbceventoapi.repository.EdicaoRepository;
import com.devweb.sbceventoapi.service.EdicaoService;

@RestController
@RequestMapping({ "/api/v1/edicao" })
public class EdicaoController {

    @Autowired
    private EdicaoRepository edicaoRepository;

    @Autowired
    private EdicaoService edicaoService;

    // Listar todas as edições
    @GetMapping
    public ResponseEntity<List<Edicao>> getAllEspacos() {
        List<Edicao> edicoes = edicaoRepository.findAll();
        return ResponseEntity.ok(edicoes);
    }

    // Obter uma edição pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Edicao> buscarPorId(@PathVariable Long id) {
        return edicaoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar uma nova edição
    @PostMapping
    public Edicao create(@RequestBody Edicao edicao) {
        edicao.setAno(String.valueOf(edicao.getAno()));
        return edicaoRepository.save(edicao);
    }

    // Atualizar uma edição
    @PutMapping(value = "/{id}")
    public ResponseEntity<Edicao> updateEdicao(@PathVariable Long id, @RequestBody Edicao edicao) {
        return edicaoRepository.findById(id)
                .map(record -> {
                    record.setNumero(edicao.getNumero());
                    record.setAno(edicao.getAno());
                    record.setData_inicio(edicao.getData_inicio());
                    record.setData_fim(edicao.getData_fim());
                    record.setCidade(edicao.getCidade());
                    record.setEvento(edicao.getEvento());
                    Edicao updated = edicaoRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Deletar uma edição
    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return edicaoRepository.findById(id)
                .map(record -> {
                    edicaoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    // Adicione este método para definir um organizador para uma edição
    @PostMapping("/organizador")

    public ResponseEntity<?> definirOrganizador(
            @RequestBody Map<String, Long> payload) {
        try {
            Long usuarioId = payload.get("usuario_id");
            Long edicaoId = payload.get("edicao_id");

            if (usuarioId != null && edicaoId != null) {
                edicaoService.definirOrganizador(edicaoId, usuarioId);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest()
                        .body("Os IDs do usuário e da edição são obrigatórios no payload.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
