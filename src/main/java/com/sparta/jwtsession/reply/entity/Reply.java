package com.sparta.jwtsession.reply.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.jwtsession.account.entity.Account;
import com.sparta.jwtsession.comment.entity.Comment;
import com.sparta.jwtsession.reply.dto.ReplyDto;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;


@Entity
@NoArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


    public Reply(ReplyDto replyDto) {
        this.replyComent = replyDto.getReplyComment();
        this.comment = comment; //asd
        this.Account = account; //asd
    }
}
