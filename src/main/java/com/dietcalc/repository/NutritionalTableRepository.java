package com.dietcalc.repository;

import com.dietcalc.entity.NutritionalTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionalTableRepository extends JpaRepository<NutritionalTable, Long> {
}
