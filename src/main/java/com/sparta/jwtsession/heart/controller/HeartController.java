package com.sparta.jwtsession.heart.controller;

import com.sparta.jwtsession.heart.service.HeartService;
import com.sparta.jwtsession.security.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HeartController {
    private final HeartService heartService;

    @PostMapping("/heart/{postId}")
    public ResponseEntity<Boolean> isHeart(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long accountId = userDetails.getAccount().getId();
        return new ResponseEntity<> ( heartService.clickToLike (postId, accountId), HttpStatus.OK);
    }
}
