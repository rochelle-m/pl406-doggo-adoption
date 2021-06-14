package com.doggos.server.repository;

import com.doggos.server.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String > {

    List<Comment> findAll();
}
