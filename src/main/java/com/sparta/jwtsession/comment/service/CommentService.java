package com.sparta.jwtsession.comment.service;

import com.sparta.jwtsession.account.entity.Account;
import com.sparta.jwtsession.comment.dto.CommentRequestDto;
import com.sparta.jwtsession.comment.entity.Comment;
import com.sparta.jwtsession.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    //커멘트 생성
    public Comment createComment(CommentRequestDto requestDto, Account account) {
        var r = new Comment(requestDto, account);
        commentRepository.save(r);
        return r;
    }

    // 커멘트 수정
    public Comment updateComment(CommentRequestDto requestDto, Long id, Account account) {
        //입력한 id의 comment가 존재하는지 확인
        var r = commentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("comment is not exist")
        );
        //이 글의 원래 주인과 지금 수정하려는 사람(token)의 일치 여부
        //불일치 ->exception
        if (!account.getEmail().equals(r.getEmail())) {
            throw new RuntimeException("not matched email");
        }
        //일치하면 update
        r.update(requestDto);
        return r;
    }

    //커멘트 삭제
    public String deleteComment(Long Id, Account account) {
        var r = commentRepository.findById(Id).orElseThrow(
                () -> new RuntimeException("comment is not exist")
        );
        //이 글의 원래 주인과 지금 수정하려는 사람의 일치 여부
        //불일치 ->exception
        if (!account.getEmail().equals(r.getEmail())) {
            throw new RuntimeException("not matched email");
        }
        commentRepository.deleteById(Id);
        return "success";
    }

    //모든 내 커멘트 불러오기
    public List<Comment> getAllMyComments(Account account) {
        var r = commentRepository.findAllByEmail(account.getEmail());
        return r;
    }

    //커멘트 읽기
    public Comment getOneComment(Long Id, Account account) {
        //입력한 id의 commend가 존재하는지 확인
        var r = commentRepository.findById(Id).orElseThrow(
                () -> new RuntimeException("comment is not exist")
        );
        //이 글의 원래 주인과 지금 수정하려는 사람의 일치 여부
        //불일치 ->exception
        if (!r.getEmail().equals(account.getEmail())) {
            throw new RuntimeException("email does not match");
        }
        //일치하면 return!
        return r;
    }
}