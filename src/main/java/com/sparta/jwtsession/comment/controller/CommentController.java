package com.sparta.jwtsession.comment.controller;

import com.sparta.jwtsession.comment.dto.CommentRequestDto;
import com.sparta.jwtsession.comment.entity.Comment;
import com.sparta.jwtsession.comment.service.CommentService;
import com.sparta.jwtsession.security.user.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/comment")
@RestController
public class CommentController {
    private final CommentService commentService;

    @Autowired
    CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글쓰기 api
    @PostMapping("/")
    public Comment createComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.createComment(requestDto, userDetails.getAccount());
    }

    // 댓글수정 api
    @PutMapping("/{id}")
    public Comment updateComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long Id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.updateComment(requestDto, Id, userDetails.getAccount());
    }

    // 댓글삭제 api
    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable Long Id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.deleteComment(Id,userDetails.getAccount());
    }

    //댓글 1개 읽기 api
    @GetMapping("/{id}")
    public Comment getOneComment(@PathVariable Long Id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.getOneComment(Id,userDetails.getAccount());
    }

    //내 모든 comments 보여주기
    @GetMapping("/my")
    public List<Comment> getAllMyComments(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return commentService.getAllMyComments(userDetails.getAccount());
    }
}
