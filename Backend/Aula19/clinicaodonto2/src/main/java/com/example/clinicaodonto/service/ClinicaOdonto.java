package com.example.clinicaodonto.service;

import java.util.List;

public interface ClinicaOdonto<T> {
    T search(Integer id);
    List<T> searchAll();
    T searchEmail(String word);


}
