package com.dh.projectodontologos;

import com.dh.projectodontologos.models.PacienteDTO;
import com.dh.projectodontologos.services.PacienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    PacienteService pacienteService;
    private PacienteDTO pacienteDTO;
    @BeforeEach
    private void setDatos() {
        pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("Manzon");
        pacienteDTO.setNombre("Lucas");
    }

    @Test
    void crearPaciente() {
        PacienteDTO crearDTOPaciente = pacienteService.crearPaciente(pacienteDTO);
        assertNotNull(crearDTOPaciente);
    }

    @Test
    void listarPacientes() {
        PacienteDTO crearDTOPaciente = pacienteService.crearPaciente(pacienteDTO);
        Set<PacienteDTO> listaPacientes = pacienteService.listarPacientes();
        assertTrue(!listaPacientes.isEmpty());
    }
}