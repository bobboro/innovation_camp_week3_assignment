package com.example.assignment.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NoteRequestDto {
    private String username;
    private String contents;
    private String password;
}
