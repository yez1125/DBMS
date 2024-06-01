package com.turtle.Database.Workout;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository  extends ReactiveMongoRepository<Workout,Long>{
    
}
