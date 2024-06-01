package com.turtle.Database.Comment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.turtle.Database.Article.Article;

import reactor.core.publisher.Flux;


@Repository
public interface CommentRepository extends ReactiveMongoRepository<Comment,Long>{
    Flux<Comment> findByArticle(Article article);
}
