package com.sparta.jwtsession.post.entity;

import com.sparta.jwtsession.Timestamped;
import com.sparta.jwtsession.account.entity.Account;
import com.sparta.jwtsession.post.dto.PostRequestDto;
import com.sparta.jwtsession.security.user.UserDetailsImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Post extends Timestamped {

    @Column(nullable = false)
    @CreatedDate
    public LocalDateTime createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    public LocalDateTime modifiedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postid;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String account;

    @Column
    private int likeCnt;

    public Post(PostRequestDto postRequestDto) {
        this.email = postRequestDto.getEmail();
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
    }

    public Post(PostRequestDto postRequestDto, Account account) {
        this.email = postRequestDto.getEmail();
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
        this.email = account.getEmail();
    }



    public void update(PostRequestDto postRequestDto){
        this.email = postRequestDto.getEmail();
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
    }

}
