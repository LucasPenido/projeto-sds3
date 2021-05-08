package com.springreact.dsvendas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class SaleSuccessDTO implements Serializable {
    private String sellerName;
    private Long visited;
    private Long deals;
}
