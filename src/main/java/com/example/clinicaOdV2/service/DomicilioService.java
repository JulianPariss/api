package com.example.clinicaOdV2.service;

import com.example.clinicaOdV2.Dao.DomicilioRepository;
import com.example.clinicaOdV2.model.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioService {
    @Autowired
    private DomicilioRepository domicilioRepository;

    public Domicilio guardar(Domicilio dom){
       return domicilioRepository.save(dom);
    }

    public List<Domicilio> buscarTodos() {
        return domicilioRepository.findAll();
    }

    public Domicilio buscarPorId (Long id) {
        return domicilioRepository.findById(id).get();
    }

    public String borrar(Long id) {
        domicilioRepository.deleteById(id);
        return "OK";
    }

    public String modificarDomicilioPorID(Domicilio dom,Long id) {
        domicilioRepository.modificarDomicilioPorID(dom.getCalle(),dom.getNumero(),dom.getLocalidad(),dom.getProvincia(),id);
        return "ok";
    }

}
