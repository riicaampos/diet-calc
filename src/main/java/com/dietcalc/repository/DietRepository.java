package com.dietcalc.repository;

import com.dietcalc.entity.Diet;
import com.dietcalc.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends JpaRepository<Diet, Long> {

    Diet findByPerson(Person person);

}
