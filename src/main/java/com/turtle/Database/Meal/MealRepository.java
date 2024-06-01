package com.turtle.Database.Meal;
import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.turtle.Database.User.Users;

import reactor.core.publisher.Flux;


@Repository
public interface MealRepository extends ReactiveMongoRepository<Meal,Long>{
    Flux<Meal> findByUserAndDate(Users user , Date date);
}
