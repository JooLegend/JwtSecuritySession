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
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import java.net.URL;
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

    // 이미지 entity
    @Column(nullable = true)
    private String imgUrl;
    // URL url = new URL("http://google.com")
    // String s = url.toExternalForm()

    //PUt 레포지토리에 있는거를 수정하는거 update
    //Postmaping("/") public String(@requestBody String a)레포지토리에 쓰는거

    @Column
    private int likeCnt;

    public Post(PostRequestDto postRequestDto) {
        this.email = postRequestDto.getEmail();
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
        this.imgUrl = postRequestDto.getImgUrl();
    }

    public Post(PostRequestDto postRequestDto, Account account) {
        this.email = postRequestDto.getEmail();
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
        this.email = account.getEmail();
    }


    public void update(PostRequestDto postRequestDto) {
        this.email = postRequestDto.getEmail();
        this.title = postRequestDto.getTitle();
        this.contents = postRequestDto.getContents();
    }

}
