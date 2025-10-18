package com.escambo.Controller;

import com.escambo.Dto.MercadoriaDto;
import com.escambo.Entity.Mercadoria;
import com.escambo.Service.MercadoriaService;
import jakarta.persistence.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercadoria")
public class MercadoriaController {

    private final MercadoriaService mercadoriaService;

    public MercadoriaController(MercadoriaService mercadoriaService) {
        this.mercadoriaService = mercadoriaService;
    }

    @PostMapping
    public ResponseEntity<Mercadoria> salvar(@RequestBody MercadoriaDto mercadoriaDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mercadoriaService.salvarMercadoria(mercadoriaDto));
    }

    @GetMapping
    public ResponseEntity<List<Mercadoria>> listarTodas() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(mercadoriaService.listarTodasAsMercadorias());
    }

    @GetMapping("/{mercadoriaId}")
    public ResponseEntity<Mercadoria> visualizar(@PathVariable(name = "mercadoriaId") Long mercadoriaId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(mercadoriaService.visualizarMercadoria(mercadoriaId));
    }

}
