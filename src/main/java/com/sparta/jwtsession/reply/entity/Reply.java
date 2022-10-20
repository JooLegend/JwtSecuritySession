package com.sparta.jwtsession.reply.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.jwtsession.account.entity.Account;
import com.sparta.jwtsession.comment.entity.Comment;
import com.sparta.jwtsession.reply.dto.ReplyDto;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@NoArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @Column(nullable = false)
    private String replyComent;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "account_id")
    private Account account;


    //replyDto에서는 대댓글의 내용, account에서는 이메일
    public Reply(ReplyDto replyDto, Account account, Comment comment) {
        this.replyComent = replyDto.getReplyComment();
        this.account = account;
        this.comment = comment;

    }
}
