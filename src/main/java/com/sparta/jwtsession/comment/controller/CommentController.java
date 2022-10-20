package com.sparta.jwtsession.comment.controller;

import com.sparta.jwtsession.comment.dto.CommentRequestDto;
import com.sparta.jwtsession.comment.entity.Comment;
import com.sparta.jwtsession.comment.service.CommentService;
import com.sparta.jwtsession.security.user.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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
    public Comment updateComment(@RequestBody CommentRequestDto requestDto, @PathVariable Long Id) {
        return commentService.updateComment(requestDto, Id);
    }

    // 댓글삭제 api
    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable Long Id) {
        return commentService.deleteComment(Id);
    }
    //댓글읽기
    @GetMapping("/{id}")
    public Comment getOneComment(@PathVariable Long Id){
        return commentService.getOneComment(Id);
    }

    //내 모든 comments 보여주기
    @GetMapping("/")
    public void getAllMyComments() {
        //return commentService.getAllMyComments();
    }

}
