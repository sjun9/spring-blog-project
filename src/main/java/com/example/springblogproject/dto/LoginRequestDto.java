package com.example.springblogproject.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

import org.aspectj.bridge.IMessage;

@Getter
@NoArgsConstructor
public class LoginRequestDto {

    //유효성검사
    @Pattern(regexp = "[0-9a-z]{4,10}", message = "이름은 숫자나 알파벳 소문자 4~10자리 입력해주세요")
    @NotNull(message="이름을 입력해주세요")
    private String username;
    @Pattern(regexp = "[0-9a-z]{4,10}", message = "이름은 숫자나 알파벳 소문자 4~10자리 입력해주세요")
    @NotNull(message="비밀번호를 입력해주세요")
    private String password;

    //Setter대신 사용
    @Builder
    public LoginRequestDto(String username, String password)
    {
        this.username = username;
        this.password = password;


    }
}