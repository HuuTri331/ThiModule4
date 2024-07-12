package com.springproject.danhsachkhuyenmai.services;

import com.springproject.danhsachkhuyenmai.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPromotionsRepository extends JpaRepository<Promotion, Long> {

}

