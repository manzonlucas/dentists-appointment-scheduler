package com.dh.projectodontologos.services;

import com.dh.projectodontologos.models.PacienteDTO;
import com.dh.projectodontologos.models.Turno;
import com.dh.projectodontologos.models.TurnoDTO;
import com.dh.projectodontologos.repositories.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class TurnoService {
    @Autowired
    TurnoRepository turnoRepository;
    @Autowired
    ObjectMapper mapper;

    public TurnoDTO crearTurno(TurnoDTO turnoDTO) {
        Turno turno = guardarTurno(turnoDTO);
        TurnoDTO turnoDTO1 = mapper.convertValue(turno, TurnoDTO.class);
        return turnoDTO1;
    }

    public void modificarTurno(TurnoDTO turnoDTO){
        guardarTurno(turnoDTO);
    }

    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    public TurnoDTO buscarTurno(Long id) {
        Turno turno = turnoRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        TurnoDTO turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        return turnoDTO;
    }

    public Set<TurnoDTO> listarTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOS = new HashSet<>();
        for (Turno turno : turnos) {
            turnoDTOS.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnoDTOS;
    }

    public Turno guardarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
        return turno;
    }
}
