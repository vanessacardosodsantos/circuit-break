package com.cardoso.publication.service;

import com.cardoso.publication.client.CommentClient;
import com.cardoso.publication.domain.Comment;
import com.cardoso.publication.exception.FallbackException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentService {

    @Autowired
    private CommentClient client;
    @Autowired
    private RedisService redisService;

    @CircuitBreaker(name = "comments", fallbackMethod = "getCommentsFallback")
    public List<Comment> getComments(String id) {
        var comments = client.getComments(id);
        redisService.save(comments, id);
        return comments;
    }

    private List<Comment> getCommentsFallback(String id, Throwable cause) {
        log.warn("[WARN] fallback with id {}", id);
        return redisService.findById(id);
    }
}
