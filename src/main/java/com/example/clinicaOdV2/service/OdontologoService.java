package com.example.clinicaOdV2.service;

import com.example.clinicaOdV2.Dao.OdontologoRepository;
import com.example.clinicaOdV2.model.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    @Autowired
    private OdontologoRepository repository;

    public Odontologo guardar(Odontologo o) { return repository.save(o); }

    public List<Odontologo> buscarTodos() { return repository.findAll();}

    public Odontologo buscarOdontologoPorID(Long ID) {
        return repository.findById(ID).get();
    }

    public String borrar(Long ID) {
        repository.deleteById(ID);
        return "ok";
    }

    public String modificarOdontologoPorID(Odontologo od,Long ID) {
        repository.actualizarOdontologoPorID(od.getNombre(),od.getApellido(),od.getMatricula(),ID);
        return "ok";
    }
}
