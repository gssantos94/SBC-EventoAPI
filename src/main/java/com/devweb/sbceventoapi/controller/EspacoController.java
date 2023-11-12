package com.devweb.sbceventoapi.controller;

import java.util.List;
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

import com.devweb.sbceventoapi.dto.EspacoDTO;
import com.devweb.sbceventoapi.model.Espaco;
import com.devweb.sbceventoapi.repository.EspacoRepository;

@RestController
@RequestMapping("/espacos")
public class EspacoController {

    @Autowired
    private EspacoRepository espacoRepository;

    // Endpoint para listar todos os espaços
    @GetMapping
    public ResponseEntity<List<Espaco>> getAllEspacos() {
        List<Espaco> espacos = espacoRepository.findAll();
        return ResponseEntity.ok(espacos);
    }

    // Endpoint para buscar um espaço pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Espaco> buscarPorId(@PathVariable Long id) {
        return espacoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para criar um novo espaço
    @PostMapping
    public ResponseEntity<Espaco> createEspaco(@RequestBody EspacoDTO criarEspacoDTO) {
        Espaco espaco = new Espaco(criarEspacoDTO.getNome(), criarEspacoDTO.getLocalizacao(),
                criarEspacoDTO.getCapacidade(), criarEspacoDTO.getRecursos());
        Espaco savedEspaco = espacoRepository.save(espaco);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEspaco);
    }

    // Endpoint para atualizar um espaço existente
    @PutMapping("/{id}")
    public ResponseEntity<Espaco> updateEspaco(@PathVariable Long id,
            @RequestBody EspacoDTO atualizarEspacoDTO) {
        Optional<Espaco> existingEspaco = espacoRepository.findById(id);
        if (existingEspaco.isPresent()) {
            Espaco updatedEspaco = existingEspaco.get();
            updatedEspaco.setNome(atualizarEspacoDTO.getNome());
            updatedEspaco.setLocalizacao(atualizarEspacoDTO.getLocalizacao());
            updatedEspaco.setCapacidade(atualizarEspacoDTO.getCapacidade());
            updatedEspaco.setRecursos(atualizarEspacoDTO.getRecursos());
            espacoRepository.save(updatedEspaco);
            return ResponseEntity.ok(updatedEspaco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para deletar um espaço pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEspaco(@PathVariable Long id) {
        Optional<Espaco> espaco = espacoRepository.findById(id);
        if (espaco.isPresent()) {
            espacoRepository.delete(espaco.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
