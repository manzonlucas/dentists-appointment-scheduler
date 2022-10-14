package com.dh.projectodontologos.services;

import com.dh.projectodontologos.models.Odontologo;
import com.dh.projectodontologos.models.OdontologoDTO;
import com.dh.projectodontologos.models.Paciente;
import com.dh.projectodontologos.models.PacienteDTO;
import com.dh.projectodontologos.repositories.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService {
    @Autowired
    OdontologoRepository odontologoRepository;
    @Autowired
    ObjectMapper mapper;

    public OdontologoDTO crearOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = guardarOdontologo(odontologoDTO);
        OdontologoDTO odontologoDTO1 = mapper.convertValue(odontologo, OdontologoDTO.class);
        return odontologoDTO1;
    }

    public void modificarOdontologo(OdontologoDTO odontologoDTO){
        guardarOdontologo(odontologoDTO);
    }

    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    public OdontologoDTO buscarOdontologo(Long id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        return odontologoDTO;
    }

    public Set<OdontologoDTO> listarOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOS = new HashSet<>();
        for (Odontologo odontologo : odontologos) {
            odontologoDTOS.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologoDTOS;
    }


    public Odontologo guardarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        return odontologoRepository.save(odontologo);
    }

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }
}
