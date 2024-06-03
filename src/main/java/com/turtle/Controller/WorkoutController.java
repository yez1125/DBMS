package com.turtle.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turtle.Database.User.Users;
import com.turtle.Database.Workout.Workout;
import com.turtle.Service.WorkoutService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/workout")
public class WorkoutController {
    @Autowired
    private WorkoutService workoutService;

    @PostMapping("/create")
    public Mono<Workout> create(Workout workout){
        return workoutService.createWorkout(workout);
    }

    @GetMapping("/get")
    public Flux<Workout> getByUser(Users user , Date date){
        return workoutService.getWorkout(user,date).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Comment")));
    }
}
