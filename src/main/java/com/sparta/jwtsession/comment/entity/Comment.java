package com.sparta.jwtsession.comment.entity;

import com.sparta.jwtsession.Timestamped;
import com.sparta.jwtsession.comment.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

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

    @OneToMany(mappedBy = "comment")
    private List<Reply> raplies = new ArrayList<>();


    public Comment(CommentRequestDto requestDto) {
        this.comments= requestDto.getComments();
    }

    public Comment(CommentRequestDto requestDto, Account account){
        this.comments= requestDto.getComments();
        this.email= account.getEmail();
        this.account= account;

    }


    public void update(CommentRequestDto requestDto){
    this.comments = requestDto.getComments();
    }



}
