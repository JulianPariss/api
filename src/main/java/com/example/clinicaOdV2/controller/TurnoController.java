package com.example.clinicaOdV2.controller;

import com.example.clinicaOdV2.model.Turno;
import com.example.clinicaOdV2.service.OdontologoService;
import com.example.clinicaOdV2.service.PacienteService;
import com.example.clinicaOdV2.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasAuthority('ADMIN')")
@RestController
@RequestMapping("/turno")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private PacienteService pacienteService;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarTurnoPorID(@PathVariable Long id) {
        Turno tu = turnoService.buscarTurnoPorID(id);
        if(tu != null) {
            return ResponseEntity.ok(tu);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping()
    public ResponseEntity<List<Turno>> listarTurnos() {
        return ResponseEntity.ok(turnoService.listarTurnos());

    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminarTurnoPorID(@PathVariable Long id) {
        if(turnoService.buscarTurnoPorID(id) != null) {
            turnoService.eliminarTurnoPorID(id);
            return ResponseEntity.ok("Se borro el turno exitosamente");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo borrar el turno");
        }
    }


    @PostMapping("/asignarTurno/{idPaciente}/{idOdontologo}")
    public ResponseEntity<Turno> asignarTurno(@PathVariable Long idPaciente,@PathVariable Long idOdontologo,@RequestBody Turno tu){

        if ((odontologoService.buscarOdontologoPorID(idOdontologo)!= null) && pacienteService.buscarPorId(idPaciente) != null) {
            tu.setPaciente(pacienteService.buscarPorId(idPaciente));
            tu.setOdontologo(odontologoService.buscarOdontologoPorID(idOdontologo));
            return  ResponseEntity.ok(turnoService.asignarTurno(tu));
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
