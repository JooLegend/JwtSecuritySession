package com.sparta.jwtsession.heart.repository;

import com.sparta.jwtsession.account.entity.Account;
import com.sparta.jwtsession.heart.entity.Heart;
import com.sparta.jwtsession.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {
    Optional<Heart> findByPostAndAccount(Post post, Account account);
}
