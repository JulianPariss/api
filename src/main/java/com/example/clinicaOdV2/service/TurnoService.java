package com.example.clinicaOdV2.service;


import com.example.clinicaOdV2.Dao.TurnoRepository;
import com.example.clinicaOdV2.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    public Turno guardarTurno(Turno tu) { return turnoRepository.save(tu); }

    public Turno buscarTurnoPorID(Long id) { return  turnoRepository.getById(id); }

    public List<Turno> listarTurnos () { return turnoRepository.findAll(); }

    public String eliminarTurnoPorID(Long id) {
        turnoRepository.deleteById(id);
        return "ok";
    }

    public Turno asignarTurno(Turno tu) {
       return turnoRepository.save(tu);
    }
}
