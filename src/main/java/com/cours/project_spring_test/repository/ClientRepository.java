package com.cours.project_spring_test.repository;

import com.cours.project_spring_test.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Client c SET c.username = ?1 WHERE c.id = ?2")
    void updateClientUsername(String username, Long id);


    @Modifying
    @Transactional
    @Query("UPDATE Client c SET c.password = ?1 WHERE c.id = ?2")
    void updateClientPassword(String password, Long id);


}
