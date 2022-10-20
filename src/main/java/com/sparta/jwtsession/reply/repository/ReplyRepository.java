package com.sparta.jwtsession.reply.repository;


import com.sparta.jwtsession.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
