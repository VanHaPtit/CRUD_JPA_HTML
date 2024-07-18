package com.example.CRUD_SQL_JPA.Service;

import com.example.CRUD_SQL_JPA.Model.User;
import com.example.CRUD_SQL_JPA.Reponsitory.UserReponsitory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserReponsitory userReponsitory ;

    @Override
    public List<User> findAll() {
        return  userReponsitory.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userReponsitory.findById(id);
    }

    @Override
    public User save(User user) {
        return userReponsitory.save(user);
    }

    @Override
    public void delete(Long id) {
        userReponsitory.deleteById(id);
    }

    @Override
    public Page<User> search(String keyword, User user) {
        return null;
    }
}
