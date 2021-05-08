package com.springreact.dsvendas.services;

import com.springreact.dsvendas.dto.SaleDTO;
import com.springreact.dsvendas.dto.SaleSuccessDTO;
import com.springreact.dsvendas.dto.SaleSumDTO;
import com.springreact.dsvendas.dto.SellerDTO;
import com.springreact.dsvendas.entities.Sale;
import com.springreact.dsvendas.entities.Seller;
import com.springreact.dsvendas.respositories.SaleRepository;
import com.springreact.dsvendas.respositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        //Realiza uma consulta para armazenar os dados em cash evitando múltiplas consultas
        //posteriores. É recomendado para quando houver poucas tuplas na tabelas.
        sellerRepository.findAll();
        Page<Sale> result = saleRepository.findAll(pageable);
        return result.map(SaleDTO::new);
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller(){
        return saleRepository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller(){
        return saleRepository.successGroupedBySeller();
    }
}
