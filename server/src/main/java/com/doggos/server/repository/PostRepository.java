package com.doggos.server.repository;

import com.doggos.server.model.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findAll();

    List<Post> findPosts(Date date, Sort sort);
}
