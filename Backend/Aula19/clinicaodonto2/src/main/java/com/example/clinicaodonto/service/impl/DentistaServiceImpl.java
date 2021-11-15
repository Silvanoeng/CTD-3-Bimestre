package com.example.clinicaodonto.service.impl;

import com.example.clinicaodonto.model.Dentista;
import com.example.clinicaodonto.service.ClinicaOdonto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DentistaServiceImpl implements ClinicaOdonto<Dentista> {

    private Dentista dent1 = new Dentista(1,"Isadora", "Pereira", "Od2908");
    private Dentista dent2 = new Dentista(2, "Marina", "Alves", "Od2111");

    @Override
    public Dentista search(Integer id) {
        List<Dentista> search = Arrays.asList(dent1, dent2);
        for (Dentista dentista: search) {
            if (dentista.getId().equals(id)){
                return dentista;
            }
        }
        return null;
    }

    @Override
    public List<Dentista> searchAll() {return Arrays.asList(dent1, dent2);
    }

    @Override
    public Dentista searchEmail(String word) {
        return null;
    }
}
