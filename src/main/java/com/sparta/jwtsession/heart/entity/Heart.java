package com.sparta.jwtsession.heart.entity;

import com.sparta.jwtsession.account.entity.Account;
import com.sparta.jwtsession.heart.dto.HeartReponseDto;
import com.sparta.jwtsession.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Heart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heart_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Heart(HeartReponseDto heartReponseDto){
        this.account = heartReponseDto.getAccount();
        this.post = heartReponseDto.getPost();
    }

    public Heart(Account account, Post post){
        this.account =account;
        this.post = post;
    }
}
