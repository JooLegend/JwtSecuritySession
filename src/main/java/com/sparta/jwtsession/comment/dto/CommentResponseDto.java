package com.sparta.jwtsession.comment.dto;

import com.sparta.jwtsession.comment.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    public String comments;

    CommentResponseDto(Comment comment){
        this.comments = comment.getComments();
    }

}
