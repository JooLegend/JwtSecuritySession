package com.sparta.jwtsession.account.entity;

import com.sparta.jwtsession.account.dto.AccountReqDto;
import com.sparta.jwtsession.heart.entity.Heart;
import com.sparta.jwtsession.reply.entity.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String phoneNumber;

    @OneToMany(mappedBy = "account")
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "account")
    List<Heart> heart = new ArrayList<>();

    public Account(AccountReqDto accountReqDto) {
        this.email = accountReqDto.getEmail();
        this.password = accountReqDto.getPassword();
        this.phoneNumber = accountReqDto.getPhoneNumber();
    }

}
