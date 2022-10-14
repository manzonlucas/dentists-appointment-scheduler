package com.dh.projectodontologos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TurnoDTO {
    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private Date fechaTurno;

    public TurnoDTO() {
    }
}