package com.dh.projectodontologos.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
public class DomicilioDTO {
    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

    public DomicilioDTO() {
    }
}
