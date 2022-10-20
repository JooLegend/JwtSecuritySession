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
    //@AuthenticationPrincipal UserDetailsImpl userDetails -> account repository중에 지금 헤더값에 넣은 토큰의 주인을 받아오게 해줌
    //account repository에는 회원가입한 많은 유저의 정보가 있는데
    // 그중에 지금 토큰값을 넣은 유저를 찾아주는 것

    //예를들면, 회원 sa1, sa2, sa3이 있다고 가정을 하면
    // sa1이 로그인을 하면 abcd라는 토큰값이 생성됨.
    //우리가 포스트맨에서 포스트를 변경할때 실제로 넣는 값은 제목,내용,글의번호만 치고
    // 헤더에 토큰값(abcd)만 넣어주는데
    // 유저 이메일을 이 토큰값에서 찾아와야함
    //그것을 userdetails에서 해줌.

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
    public Post update(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) throws Exception {
        return postService.update(id, postRequestDto, userDetails.getAccount());
    }

    @DeleteMapping("/deletePost/{id}")
    public Long delete(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }

}
