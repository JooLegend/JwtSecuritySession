package com.sparta.jwtsession.comment.entity;

import com.sparta.jwtsession.Timestamped;
import com.sparta.jwtsession.account.entity.Account;
import com.sparta.jwtsession.comment.dto.CommentRequestDto;
import com.sparta.jwtsession.reply.entity.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String comments;

    @Column(nullable = true)
    private String email;

//    @Column(nullable = true)
//    private Account account;

    @Column(nullable = true)
    @OneToMany(mappedBy = "comment")
    private List<Reply> replyList = new ArrayList<>();


    public Comment(CommentRequestDto requestDto) {
        this.comments = requestDto.getComments();
    }

    //account를 token에서 받아와서 comment에 저장한다.
    public Comment(CommentRequestDto requestDto, Account account) {
        this.comments = requestDto.getComments();
        this.email = account.getEmail();
        // this.account= account;
    }


    public void update(CommentRequestDto requestDto) {
        this.comments = requestDto.getComments();
    }


}
