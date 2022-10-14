package com.dh.projectodontologos.services;

import com.dh.projectodontologos.models.Domicilio;
import com.dh.projectodontologos.models.DomicilioDTO;
import com.dh.projectodontologos.models.Paciente;
import com.dh.projectodontologos.models.PacienteDTO;
import com.dh.projectodontologos.repositories.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    ObjectMapper mapper;

    public PacienteDTO crearPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = guardarPaciente(pacienteDTO);
        PacienteDTO pacienteDTO1 = mapper.convertValue(paciente, PacienteDTO.class);
        return pacienteDTO1;
    }

    public void modificarPaciente(PacienteDTO pacienteDTO){
        guardarPaciente(pacienteDTO);
    }

    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public PacienteDTO buscarPaciente(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        return pacienteDTO;
    }

    public Set<PacienteDTO> listarPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDTO> pacienteDTOS = new HashSet<>();
        for (Paciente paciente : pacientes) {
            pacienteDTOS.add(mapper.convertValue(paciente, PacienteDTO.class));
        }
        return pacienteDTOS;
    }

    public Paciente guardarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        return pacienteRepository.save(paciente);
    }
}
