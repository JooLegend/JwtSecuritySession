package com.sparta.jwtsession.post.service;

import com.sparta.jwtsession.account.entity.Account;
import com.sparta.jwtsession.account.repository.AccountRepository;
import com.sparta.jwtsession.comment.dto.CommentRequestDto;
import com.sparta.jwtsession.post.dto.PostRequestDto;
import com.sparta.jwtsession.post.entity.Post;
import com.sparta.jwtsession.post.repository.PostRepository;
import com.sparta.jwtsession.security.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final PostRequestDto postRequestDto;
    private final AccountRepository accountRepository;

    public Post createPost(PostRequestDto postRequestDto, Account account) {
        //userdetail정보를 받아와서, 실제 포스트에 저장된 유저아이디 값이랑 비교 하는게 들어잇어요
        Post post = new Post(postRequestDto, account);
        return postRepository.save(post);
    }

    @Transactional
    public Post update(Long id, PostRequestDto postRequestDto, Account account) throws Exception {
        //지금 토큰갖고잇는 사람이랑 , 글쓴사람 토큰이랑 똑같은지 판별식 필요
        // 어차피 둘다 유효토큰이면 jwt 필터를 인증하고 수정이 되므로
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Not found Id")
        );
        String email = post.getEmail();
        if (account.getEmail().equals(email)){
            post.update(postRequestDto);
            return post;
        } else {
            throw new Exception("Don't have Access");
        }
    }
}
