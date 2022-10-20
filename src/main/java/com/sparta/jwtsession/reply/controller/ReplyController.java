package com.sparta.jwtsession.reply.controller;


import com.sparta.jwtsession.reply.dto.ReplyDto;
import com.sparta.jwtsession.reply.entity.Reply;
import com.sparta.jwtsession.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reply")
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/")
    public Reply createReply(@RequestBody ReplyDto replyDto){
        return replyService.save(replyDto);
    }
}
