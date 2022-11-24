package com.springboot.repo;

import com.springboot.model.Student;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// needs to be an interface not a class so that we do not have to implement the methods ourselves
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    // we do not need to implement the method as long as the method is in the correct syntax
    //void findByName(String b);

    //void findByNameAndId(String b, int i);

}
