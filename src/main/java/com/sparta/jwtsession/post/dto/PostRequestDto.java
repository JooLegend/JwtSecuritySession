package com.sparta.jwtsession.post.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String email;
    private String title;
    private String contents;
}
