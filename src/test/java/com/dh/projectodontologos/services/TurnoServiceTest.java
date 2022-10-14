package com.dh.projectodontologos.services;

import com.dh.projectodontologos.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {

    @Autowired
    TurnoService turnoService;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    OdontologoService odontologoService;

    @Autowired
    ObjectMapper mapper;

    private TurnoDTO turnoDTO;
    private OdontologoDTO odontologoDTO;
    private PacienteDTO pacienteDTO;

    @BeforeEach
    private void setDatos() {
        odontologoDTO = new OdontologoDTO();
        odontologoDTO.setApellido("ManzonOdonto");
        odontologoDTO.setNombre("LucasOdonto");
        odontologoDTO.setMatricula(12345);

        Odontologo odontologo1 = mapper.convertValue(odontologoService.crearOdontologo(odontologoDTO), Odontologo.class);

        pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("Manzon");
        pacienteDTO.setNombre("Lucas");

        Paciente paciente = mapper.convertValue(pacienteService.crearPaciente(pacienteDTO), Paciente.class);

        turnoDTO = new TurnoDTO();
        turnoDTO.setPaciente(paciente);

        turnoDTO.setOdontologo(odontologo1);
        turnoDTO.setFechaTurno(new Date());
    }

    @Test
    void crearTurno() {
        TurnoDTO crearDTOTurno = turnoService.crearTurno(turnoDTO);
        assertNotNull(crearDTOTurno);
    }

//    @Test
//    void listarTurnos() {
//        TurnoDTO crearDTOTurno = turnoService.crearTurno(turnoDTO);
//        Set<TurnoDTO> listaTurnos2 = turnoService.listarTurnos();
//        assertTrue(!listaTurnos2.isEmpty());
//    }
}