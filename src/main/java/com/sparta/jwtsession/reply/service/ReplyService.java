package com.sparta.jwtsession.reply.service;

import com.sparta.jwtsession.account.entity.Account;
import com.sparta.jwtsession.comment.entity.Comment;
import com.sparta.jwtsession.comment.repository.CommentRepository;
import com.sparta.jwtsession.reply.dto.ReplyDto;
import com.sparta.jwtsession.reply.entity.Reply;
import com.sparta.jwtsession.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;

    // 대댓글 등록 과정
    @Transactional
    public Reply create(Long commentId ,ReplyDto replyDto, Account account) {

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("댓글이 없습니다")
        );

        Reply reply = new Reply(replyDto, account, comment);
        replyRepository.save(reply);

        return replyRepository.save(reply);
    }


}
