package com.example.CRUD_SQL_JPA.Service;

import com.example.CRUD_SQL_JPA.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);
    User save(User user);
    void delete(Long id);
    Page<User> search(String keyword, User user);
}
