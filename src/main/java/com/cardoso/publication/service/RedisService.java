package com.cardoso.publication.service;

import com.cardoso.publication.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

public class RedisService {
    private static final String KEY = "Comment";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public void save(List<Comment> comments, String id) {
        redisTemplate.opsForHash().put(KEY, id, comments);
    }

    public List<Comment> findById(String id) {
        return (List<Comment>) redisTemplate.opsForHash().get(KEY, id);
    }
}
