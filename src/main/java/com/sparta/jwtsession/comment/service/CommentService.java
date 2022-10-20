package com.sparta.jwtsession.comment.service;

import com.sparta.jwtsession.account.entity.Account;
import com.sparta.jwtsession.comment.dto.CommentRequestDto;
import com.sparta.jwtsession.comment.dto.CommentResponseDto;
import com.sparta.jwtsession.comment.entity.Comment;
import com.sparta.jwtsession.comment.repository.CommentRepository;
import com.sparta.jwtsession.security.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    //커멘트 생성
    public Comment createComment(CommentRequestDto requestDto, Account account) {
        var a = new Comment(requestDto,account);
        commentRepository.save(a);
        return a;
    }

    // 커멘트 수정
    public Comment updateComment(CommentRequestDto requestDto, Long id) {
        var comment = commentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("comment is not exist")
        );
        comment.update(requestDto);
        return comment;
    }

    //커멘트 삭제
    public String deleteComment(Long Id) {
        var comment = commentRepository.findById(Id).orElseThrow(
                () -> new RuntimeException("comment is not exist")
        );
        deleteComment(Id);
        return "success";
    }



    //모든 내 커멘트 불러오기
    public void getAllMyComments() {
    }
    //커멘트 읽기
    public Comment getOneComment(Long Id) {
        var r = commentRepository.findById(Id).orElseThrow(
                ()-> new RuntimeException("comment is not exist")
        );
        return r;
    }

    // 커멘트 수정
  /*  public CommentResponseDto updateComment(CommentRequestDto requestDto, Long id) {
        var comment = commentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("comment is not exist")
        );
        comment.update(requestDto);
        var commentResponseDto = new CommentResponseDto(comment);
        return commentResponseDto;
    }*/


}