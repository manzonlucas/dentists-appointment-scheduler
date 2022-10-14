package com.dh.projectodontologos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PacienteDTO {
    private Long id;
    private String apellido;
    private String nombre;

    public PacienteDTO() {
    }
}
