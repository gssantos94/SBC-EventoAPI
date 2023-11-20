package com.devweb.sbceventoapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devweb.sbceventoapi.model.Atividade;
import com.devweb.sbceventoapi.model.Atividade.Tipo;
import com.devweb.sbceventoapi.model.Edicao;
import com.devweb.sbceventoapi.repository.AtividadeRepository;
import com.devweb.sbceventoapi.repository.EdicaoRepository;

@RestController
@RequestMapping("/api/v1/atividade")
public class AtividadeController {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private EdicaoRepository edicaoRepository;

    // Listar todas as atividades
    @GetMapping
    public ResponseEntity<List<Atividade>> getAllAtividades() {
        List<Atividade> atividades = atividadeRepository.findAll();
        return ResponseEntity.ok(atividades);
    }

    // Obter uma atividade pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Atividade> findById(@PathVariable long id) {
        return atividadeRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar uma nova atividade
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Atividade atividade) {
        // Verificar se o valor do campo "tipo" é válido
        if (!Tipo.isValidTipo(atividade.getTipo())) {
            return ResponseEntity.badRequest().body("Tipo inválido. As opções válidas são: " + Arrays.toString(Tipo.values()));
        }
        // Se o valor do tipo for válido, continue com a criação da atividade
        Atividade createdAtividade = atividadeRepository.save(atividade);
        return ResponseEntity.ok(createdAtividade);
    }

    // Atualizar uma atividade
    @PutMapping("/{id}")
    public ResponseEntity<Atividade> update(@PathVariable("id") long id, @RequestBody Atividade atividade) {
        return atividadeRepository.findById(id)
                .map(record -> {
                    record.setNome(atividade.getNome());
                    record.setTipo(atividade.getTipo());
                    record.setDescricao(atividade.getDescricao());
                    record.setData(atividade.getData());
                    record.setHora_inicio(atividade.getHora_inicio());
                    record.setHora_fim(atividade.getHora_fim());
                    record.setEdicao(atividade.getEdicao());
                    record.setEspaco(atividade.getEspaco());
                    Atividade updated = atividadeRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Deletar uma atividade
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return atividadeRepository.findById(id)
                .map(record -> {
                    atividadeRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
