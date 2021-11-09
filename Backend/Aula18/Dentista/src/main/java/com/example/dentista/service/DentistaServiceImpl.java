package com.example.dentista.service;

import com.example.dentista.domain.Dentista;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DentistaServiceImpl implements DentistaService{
    @Override
    public List<Dentista> listaDentistas() {
        return Arrays.asList(new Dentista("Maria"), new Dentista("João"));
    }
}
