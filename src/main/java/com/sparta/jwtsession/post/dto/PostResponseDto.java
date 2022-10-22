package com.sparta.jwtsession.post.dto;

import com.sparta.jwtsession.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor

public class PostResponseDto<T> {
    private String email;

    private String title;

    private String contents;

    private String imgUrl;

    //그냥 post로 반환하면 account 엔티티가 반환되는데 그걸 postResponseDto를 사용해서 막음
    public PostResponseDto(Post post) {
        this.email = post.getEmail();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.imgUrl = post.getImgUrl();
    }


}
