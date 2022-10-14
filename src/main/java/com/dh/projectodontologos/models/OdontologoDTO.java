package com.dh.projectodontologos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OdontologoDTO {
    private Long id;
    private String apellido;
    private String nombre;
    private Integer matricula;

    public OdontologoDTO() {
    }
}
