package com.turtle.Database.Food;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;



@Repository
public interface FoodRepository extends ReactiveMongoRepository<Food,Long>{
    Flux<Food> findByName(String name);
}
