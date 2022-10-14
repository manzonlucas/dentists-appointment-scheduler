package com.dh.projectodontologos.services;

import com.dh.projectodontologos.models.Domicilio;
import com.dh.projectodontologos.models.DomicilioDTO;
import com.dh.projectodontologos.repositories.DomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService {
    @Autowired
    DomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    public DomicilioDTO crearDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = guardarDomicilio(domicilioDTO);
        DomicilioDTO domicilioDTO1 = mapper.convertValue(domicilio, DomicilioDTO.class);
        return domicilioDTO1;
    }

    public void modificarDomicilio(DomicilioDTO domicilioDTO){
        guardarDomicilio(domicilioDTO);
    }

    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }

    public DomicilioDTO buscarDomicilio(Long id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
        return domicilioDTO;
    }

    public Set<DomicilioDTO> listarDomicilios() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTOS = new HashSet<>();
        for (Domicilio domicilio : domicilios) {
            domicilioDTOS.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        return domicilioDTOS;
    }

    public Domicilio guardarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        return domicilioRepository.save(domicilio);
    }
}
