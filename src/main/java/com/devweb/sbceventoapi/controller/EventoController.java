package com.devweb.sbceventoapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.devweb.sbceventoapi.model.Evento;
import com.devweb.sbceventoapi.repository.EventoRepository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    @PostMapping
    public Evento adicionar(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
        return eventoRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{path:[a-zA-Z0-9-]*[a-zA-Z][a-zA-Z0-9-]*}")
    public ResponseEntity<Evento> buscarPorPath(@PathVariable String path) {
        return eventoRepository.findByPath(path)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizar(@PathVariable Long id, @RequestBody Evento evento) {
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return eventoRepository.findById(id)
                .map(record -> {
                    eventoRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{path}/{ano}")
    public ResponseEntity<Map<String, String>> acessarSiteEvento(@PathVariable String path, @PathVariable String ano,
            HttpServletRequest request) {
        // Implemente a lógica para buscar um evento pelo path e ano
        // Se o evento existir, retorne a URL desejada
        String rootUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
        Map<String, String> response = new HashMap<>();
        response.put("url", rootUrl + "/" + path + "/" + ano);
        return ResponseEntity.ok(response);
    }
}
