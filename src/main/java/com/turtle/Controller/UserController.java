package com.turtle.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turtle.Database.User.Users;
import com.turtle.Service.UserService;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Mono<Users> register(Users user) {
        return userService.getUserByEmail(user.getEmail()).flatMap(_user -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exist");
        })
        .switchIfEmpty(userService.saveUser(user))
        .cast(Users.class);
    }
    /*FIX */
    @PostMapping("/login")
    public Mono<Users> login(String email,String password){
        return userService.getUserByEmail(email).flatMap(user -> {
            if (user.getPassword() != password) {
                return Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Password error")) ;     
            }
            System.out.println(user);
            return Mono.just(user);
        }).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"))); 
    }

    @GetMapping("/fetch")
    public Mono<Users> fetch(String email){
        return userService.getUserByEmail(email);
    }
    


}
