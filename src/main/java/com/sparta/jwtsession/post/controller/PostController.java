package com.sparta.jwtsession.post.controller;

import com.sparta.jwtsession.post.dto.PostRequestDto;
import com.sparta.jwtsession.post.entity.Post;
import com.sparta.jwtsession.post.repository.PostRepository;
import com.sparta.jwtsession.post.service.PostService;
import com.sparta.jwtsession.security.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;

    //회원가입(test123) -> 로그인 -> 토큰발급(1234)-> 유효토큰 인증 ->글쓰기
    // 회원가입(asdf123)-> '' -> '' -> ''(asdf) -> 글쓰기나 수정
    // /*    @PostMapping("/comment/{postId}")
    //    public CommentResponseDto createComment(@PathVariable Long postId, @RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl){
    //        return commentService.createComment(postId, commentRequestDto, userDetailsImpl);
    //    }
    //    */
    //



    @PostMapping("/posts")
    public Post creatPost(@RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return postService.createPost(postRequestDto, userDetails.getAccount());
    }



    @GetMapping("/getPost/{id}")
    public Optional<Post> getPost(@PathVariable Long id) {
        return postRepository.findById(id);
    }

    @GetMapping("/getPosts")
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    @PutMapping("/updatePost/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        postService.update(id, postRequestDto);
        return id;
    }

    @DeleteMapping("/deletePost/{id}")
    public Long delete(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }


}
