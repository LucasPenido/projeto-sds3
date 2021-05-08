package com.springreact.dsvendas.dto;

import com.springreact.dsvendas.entities.Seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class SellerDTO implements Serializable {

    private Long id;
    private String name;

    public SellerDTO(Seller seller) {
        id = seller.getId();
        name = seller.getName();
    }
}
