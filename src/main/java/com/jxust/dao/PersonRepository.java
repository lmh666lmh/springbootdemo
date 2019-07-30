package com.jxust.dao;

import com.jxust.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    public List<Person> findByAge(Integer age);
    public List<Person> findByName(String name);
    @Query(value = "select id,name,age from person where age>?1 and age<?2", nativeQuery = true)
    List<Person> findByPriceRange(int age1, int age2);
}
