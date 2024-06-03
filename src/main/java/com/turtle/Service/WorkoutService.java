package com.turtle.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.Database.User.Users;
import com.turtle.Database.Workout.Workout;
import com.turtle.Database.Workout.WorkoutRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WorkoutService {
    @Autowired
    private  WorkoutRepository workoutRepository;

    public Mono<Workout> createWorkout(Workout workout){
        return workoutRepository.save(workout);
    }

    public void deleteWorkout(Workout workout){
        workoutRepository.delete(workout);
    }

    public Flux<Workout> getWorkout(Users user , Date date){
        return workoutRepository.findByUserAndDate(user, date);
    }
}
