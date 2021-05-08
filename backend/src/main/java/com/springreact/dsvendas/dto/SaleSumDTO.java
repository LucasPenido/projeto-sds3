package com.springreact.dsvendas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class SaleSumDTO implements Serializable {
    private String sellerName;
    private Double sum;
}
