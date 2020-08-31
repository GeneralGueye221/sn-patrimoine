package com.sen.patrimoine.snpatrimoine.repository;

import com.sen.patrimoine.snpatrimoine.model.Heritage;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeritageRepository extends JpaRepository<Heritage, Long> {
    List<Heritage> findByTitleContaining(String title, Sort sort);
}
