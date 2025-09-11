package com.example.spring_2.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EditorialCreateRequest {
    private String ruc;
    private Date fechaFundacion;
}
