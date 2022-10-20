package com.sparta.jwtsession.heart.dto;

import com.sparta.jwtsession.account.entity.Account;
import com.sparta.jwtsession.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeartReponseDto {
    private Post post;
    private Account account;
}
