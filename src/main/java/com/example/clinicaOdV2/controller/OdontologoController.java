package com.example.clinicaOdV2.controller;


import com.example.clinicaOdV2.model.Odontologo;
import com.example.clinicaOdV2.service.OdontologoService;
import com.example.clinicaOdV2.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {
    @Autowired
    private OdontologoService service;
    @Autowired
    private TurnoService turnoService;

    @Secured({"USER","ADMIN"})
    @GetMapping
    public ResponseEntity<List<Odontologo>> traerOdontologos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @Secured({"USER","ADMIN"})
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> traerOdontologoPorID(@PathVariable Long id) {
        Odontologo od = service.buscarOdontologoPorID(id);
        if (od != null) {
            return ResponseEntity.ok(od);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Secured({"ADMIN"})
    @PostMapping("/crear")
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody Odontologo o) {
        return ResponseEntity.ok(service.guardar(o));
    }

    @Secured({"ADMIN"})
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarOdontologo(@PathVariable Long id) {
        ResponseEntity<String> respuesta = null;
        if (service.buscarOdontologoPorID(id) != null) {
            service.borrar(id);
            respuesta = ResponseEntity.ok("Se borro al odontologo exitosamente");
        } else {
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo borrar el odontologo");
        }
        return respuesta;
    }

    @Secured({"ADMIN"})
    @PutMapping("/modificar/{id}")
    public ResponseEntity<String> modificarOdontologo(@PathVariable Long id, @RequestBody Odontologo o) {
        ResponseEntity<String> respuesta = null;
        if (service.buscarOdontologoPorID(id) != null) {
            service.modificarOdontologoPorID(o,id);
            respuesta = ResponseEntity.ok("Se modifico el odontologo exitosamente");
        } else {
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo modificar el odontologo");
        }
        return respuesta;
    }

}
