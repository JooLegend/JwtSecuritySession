package com.sparta.jwtsession.reply.controller;


import com.sparta.jwtsession.reply.dto.ReplyDto;
import com.sparta.jwtsession.reply.entity.Reply;
import com.sparta.jwtsession.reply.service.ReplyService;
import com.sparta.jwtsession.security.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reply")
public class ReplyController {
    private final ReplyService replyService;

    // 대댓글 등록 api
    @PostMapping("/{commentId}")
    public Reply createReply(@PathVariable Long commentId,
                             @RequestBody ReplyDto replyDto,
                             @AuthenticationPrincipal UserDetailsImpl userDetails){
        return replyService.create(commentId ,replyDto, userDetails.getAccount());
    }

    // 대댓글 삭제 api
}
