package com.dh.projectodontologos.controllers;

import com.dh.projectodontologos.models.PacienteDTO;
import com.dh.projectodontologos.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("{id}")
    public PacienteDTO buscarPaciente(@PathVariable Long id) {
        return pacienteService.buscarPaciente(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<PacienteDTO> listarPacientes() {
        return pacienteService.listarPacientes();
    }
}
