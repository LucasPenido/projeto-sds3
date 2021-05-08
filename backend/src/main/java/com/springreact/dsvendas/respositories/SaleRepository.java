package com.springreact.dsvendas.respositories;

import com.springreact.dsvendas.dto.SaleSuccessDTO;
import com.springreact.dsvendas.dto.SaleSumDTO;
import com.springreact.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.springreact.dsvendas.dto.SaleSumDTO(obj.seller.name, SUM(obj.amount))"
            + " FROM Sale AS obj GROUP BY obj.seller.name")
    List<SaleSumDTO> amountGroupedBySeller();

    @Query("SELECT new com.springreact.dsvendas.dto.SaleSuccessDTO(obj.seller.name, SUM(obj.visited), SUM(obj.deals))"
            + " FROM Sale AS obj GROUP BY obj.seller.name")
    List<SaleSuccessDTO> successGroupedBySeller();

}
