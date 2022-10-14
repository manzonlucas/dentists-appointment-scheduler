package com.dh.projectodontologos;

import com.dh.projectodontologos.models.OdontologoDTO;
import com.dh.projectodontologos.services.OdontologoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    OdontologoService odontologoService;
    private OdontologoDTO odontologoDTO;

    @BeforeEach
    private void setDatos() {
        odontologoDTO = new OdontologoDTO();
        odontologoDTO.setApellido("Manzon");
        odontologoDTO.setNombre("Lucas");
        odontologoDTO.setMatricula(12345);
    }

    @Test
    void crearOdontologo() {
        OdontologoDTO crearDTOOdontologo = odontologoService.crearOdontologo(odontologoDTO);
        assertNotNull(crearDTOOdontologo);
    }

    @Test
    void listarOdontologos() {
        OdontologoDTO crearDTOOdontologo = odontologoService.crearOdontologo(odontologoDTO);
        Set<OdontologoDTO> listaOdontologos = odontologoService.listarOdontologos();
        assertTrue(!listaOdontologos.isEmpty());
    }
}