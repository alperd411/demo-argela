package com.example.demoargela.Repositories;

import com.example.demoargela.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<List<User>> findAllByDobBetween(Date start, Date end);


}
