package com.sparta.jwtsession.post.repository;

import com.sparta.jwtsession.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

}
