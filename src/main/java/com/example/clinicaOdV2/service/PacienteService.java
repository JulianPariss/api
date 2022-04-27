package com.example.clinicaOdV2.service;

import com.example.clinicaOdV2.Dao.PacienteRepository;
import com.example.clinicaOdV2.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente guardar(Paciente p) {
        return pacienteRepository.save(p);
    }

    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    public Paciente buscarPorId (Long id) {
        return pacienteRepository.findById(id).get();
    }

    public String borrar (Long id) {
        pacienteRepository.deleteById(id);
        return "OK";
    }
}
