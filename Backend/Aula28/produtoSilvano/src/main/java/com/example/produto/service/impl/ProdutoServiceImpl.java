package com.example.produto.service.impl;

import com.example.produto.model.entities.ProdutoEntity;
import com.example.produto.model.repository.ProdutoRepository;
import com.example.produto.service.ProdutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService<ProdutoEntity> {
    private static final Logger LOG = LoggerFactory.getLogger(ProdutoServiceImpl.class);

    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    public ProdutoEntity salvar(ProdutoEntity produto) {
        LOG.info("Produto " + produto.getName() + " criado com sucesso.");
        return produtoRepository.save(produto);
    }

    @Override
    public List<ProdutoEntity> buscarTodos() {
        LOG.info("Buscar todos produtos.");
        return produtoRepository.findAll();
    }

    @Override
    public void deletar(Integer id) {
        LOG.info("Deletar produto.");
        produtoRepository.deleteById(id);
    }

    @Override
    public void subtrairQuantidade(Integer id, Integer qt) {
        ProdutoEntity produtoBase = produtoRepository.getById(id);
        Integer quantidadeDoProduto = produtoBase.getQuantidade();
        produtoBase.setQuantidade(quantidadeDoProduto-qt);
        LOG.info("A quantidade do produto " + produtoBase.getName() + " agora é de " + (quantidadeDoProduto-qt) + ".");
        produtoRepository.saveAndFlush(produtoBase);

    }
}
