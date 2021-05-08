package com.springreact.dsvendas.controllers;

import com.springreact.dsvendas.dto.SaleDTO;
import com.springreact.dsvendas.dto.SaleSuccessDTO;
import com.springreact.dsvendas.dto.SaleSumDTO;
import com.springreact.dsvendas.services.SaleService;
import com.springreact.dsvendas.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> sellerList = saleService.findAll(pageable);
        return ResponseEntity.ok(sellerList);
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> saleSumList = saleService.amountGroupedBySeller();
        return ResponseEntity.ok(saleSumList);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
        List<SaleSuccessDTO> saleSuccessList = saleService.successGroupedBySeller();
        return ResponseEntity.ok(saleSuccessList);
    }
}
