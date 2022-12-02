package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ArrayList<User> obtenerUsuarios(){
        return userService.obtenerUsuarios();
    }

    @GetMapping("/user/{id}")
    public Optional<User> obtenerId(@PathVariable("id") Integer id){
        return this.userService.obtenerId(id);
    }

    @PostMapping("/user")
    public User guardarUser(@RequestBody User user){
        return this.userService.guardarUsuario(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> eliminarUser(@PathVariable("id") Integer id){
        Optional<User> userOptional = userService.obtenerId(id);
        if(userOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("No se encontró");
        }

        //Aqui hacer la eliminación



        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }
}
