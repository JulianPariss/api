package com.example.clinicaOdV2.controller;

import com.example.clinicaOdV2.model.Domicilio;
import com.example.clinicaOdV2.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilio")
public class DomicilioController {
    @Autowired
    private DomicilioService domicilioService;


    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> buscarPorID(@PathVariable Long id) {
        Domicilio dom = domicilioService.buscarPorId(id);
        if (dom != null) {
            return ResponseEntity.ok(dom);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping
    public ResponseEntity<List<Domicilio>> buscarTodos() {
        return ResponseEntity.ok(domicilioService.buscarTodos());
    }

    @PostMapping("/crear")
    public ResponseEntity<Domicilio> crear (@RequestBody Domicilio dom) {
        return ResponseEntity.ok(domicilioService.guardar(dom));
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarDomicilio(@PathVariable Long id){
        ResponseEntity<String> respuesta=null;
        if (domicilioService.borrar(id)!=null){
            respuesta=ResponseEntity.ok("Se borro el domicilio exitosamente");
        }
        else{
            respuesta=ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo borrar el domicilio");
        }
        return respuesta;
    }
    @PutMapping("/modificar/{id}")
    public ResponseEntity<String> modificarDomicilio(@PathVariable Long id,@RequestBody Domicilio dom) {
        ResponseEntity<String> respuesta = null;
        if (domicilioService.buscarPorId(id) != null) {
            domicilioService.modificarDomicilioPorID(dom,id);
            respuesta = ResponseEntity.ok("Se modifico el domicilio exitosamente");
        } else {
            respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo modificar el domicilio");
        }
        return respuesta;

    }

}
