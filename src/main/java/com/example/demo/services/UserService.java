package com.example.demo.services;


import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<User> obtenerUsuarios(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public User guardarUsuario(User user){
        return userRepository.save(user);
    }

    public Optional<User> obtenerId(Integer id){
        return userRepository.findById(id);
    }

    //Aqui hacer la eliminacion logica

}
