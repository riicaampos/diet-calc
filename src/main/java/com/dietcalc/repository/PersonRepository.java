package com.dietcalc.repository;

import com.dietcalc.entity.Person;
import com.dietcalc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByUser(User user);

}
