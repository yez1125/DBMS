package com.turtle.Database.Workout;
import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.turtle.Database.User.Users;

import reactor.core.publisher.Flux;

@Repository
public interface WorkoutRepository  extends ReactiveMongoRepository<Workout,Long>{
    Flux<Workout> findByUserAndDate(Users user , Date date);
}
