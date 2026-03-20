package com.nathan.petshop.controller;


import com.nathan.petshop.model.Servico;
import com.nathan.petshop.service.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/servicos")
@RequiredArgsConstructor
public class ServicoController {

    private final ServicoService servicoService;

    @GetMapping("")
    public ResponseEntity<List<Servico>> getAll(){
        return ResponseEntity.ok(servicoService.getServicoList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getById(@PathVariable Long id){
        return ResponseEntity.ok(servicoService.getServico(id));
    }

    @PostMapping("")
    public ResponseEntity<Servico> create(@RequestBody Servico servico){
        return ResponseEntity.ok(servicoService.insertServico(servico));
    }

    @PutMapping("")
    public ResponseEntity<Servico> update(@RequestBody Servico servico){
        return ResponseEntity.ok(servicoService.updateServico(servico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        servicoService.deleteServico(id);
        return ResponseEntity.noContent().build();
    }


}
