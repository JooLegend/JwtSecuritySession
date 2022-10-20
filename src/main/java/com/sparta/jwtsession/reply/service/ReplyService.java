package com.sparta.jwtsession.reply.service;

import com.sparta.jwtsession.reply.dto.ReplyDto;
import com.sparta.jwtsession.reply.entity.Reply;
import com.sparta.jwtsession.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;

    public Reply save(ReplyDto replyDto) {
        Reply reply = new Reply(replyDto);
        return replyRepository.save(reply);
    }
}
