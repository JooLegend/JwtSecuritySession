package com.sparta.jwtsession.comment.repository;

import com.sparta.jwtsession.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByOrderByCreatedAtDesc();
    Comment findById(String Id);
   // Comment findBy
    List<Comment> findAllByEmail(String email);
}
