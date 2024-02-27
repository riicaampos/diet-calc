package com.dietcalc.repository;

import com.dietcalc.entity.ErrorTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorTableRepository extends JpaRepository<ErrorTable, Long> {
}
