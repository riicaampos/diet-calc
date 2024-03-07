package com.dietcalc.repository;

import com.dietcalc.entity.SuggestedFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestedFoodRespository extends JpaRepository<SuggestedFood, Long> {
}
