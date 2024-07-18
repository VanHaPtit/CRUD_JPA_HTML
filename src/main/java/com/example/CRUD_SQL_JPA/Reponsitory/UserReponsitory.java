package com.example.CRUD_SQL_JPA.Reponsitory;

import com.example.CRUD_SQL_JPA.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReponsitory extends JpaRepository<User , Long> {
}
