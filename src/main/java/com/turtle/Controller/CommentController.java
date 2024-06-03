package com.turtle.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turtle.Database.Article.Article;
import com.turtle.Database.Comment.Comment;
import com.turtle.Service.CommentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public Mono<Comment>create(Comment comment){
        return commentService.createComment(comment);
    }

    @GetMapping("/getByArticle")
    public Flux<Comment> getComment(Article article){
        return commentService.getCommentByArticle(article).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Comment")));    
    }
}
