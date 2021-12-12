package com.example.produto.controller;

import com.example.produto.model.entities.ProdutoEntity;
import com.example.produto.service.impl.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    @PostMapping
    public ResponseEntity salvar(@RequestBody ProdutoEntity produto) {
        return ResponseEntity.ok(produtoService.salvar(produto));
    }

    @GetMapping("/buscartodos")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(produtoService.buscarTodos());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        produtoService.deletar(id);
        return ResponseEntity.ok("Produto deletado.");
    }
}
