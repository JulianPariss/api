package com.example.clinicaOdV2.controller;

import com.example.clinicaOdV2.model.Paciente;
import com.example.clinicaOdV2.service.DomicilioService;
import com.example.clinicaOdV2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasAuthority('ADMIN')")
@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DomicilioService domicilioService;

    @PostMapping("/crear")
    public ResponseEntity<Paciente> crear(@RequestBody Paciente p) {
        domicilioService.guardar(p.getDomicilio());
        return ResponseEntity.ok(pacienteService.guardar(p));
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos () {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId (@PathVariable Long id){
        Paciente p = pacienteService.buscarPorId(id);
        if (p != null) {
            return ResponseEntity.ok(p);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrar (@PathVariable Long id) {
        ResponseEntity<String> respuesta = null;
        if (pacienteService.borrar(id) != null){
            respuesta = ResponseEntity.ok("Se borro al paciente exitosamente");
        } else {
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo borrar el odontologo");
        }
       return respuesta;
    }

}
