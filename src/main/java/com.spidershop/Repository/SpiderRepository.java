package com.spidershop.Repository;

import com.spidershop.Entity.Spider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpiderRepository extends JpaRepository<Spider, Long>{
    List<Spider> findByGenus(String genus);

}