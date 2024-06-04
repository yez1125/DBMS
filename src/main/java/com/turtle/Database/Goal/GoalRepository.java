package com.turtle.Database.Goal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends ReactiveMongoRepository<Goal,String> {
    
}
