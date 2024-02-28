package com.dietcalc.repository;

import com.dietcalc.entity.NutritionalTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutritionalTableRepository extends JpaRepository<NutritionalTable, Long> {

    List<NutritionalTable> findByDescriptionContainingIgnoreCase(String description);

}
