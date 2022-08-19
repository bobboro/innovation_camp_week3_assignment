package com.example.assignment.controller;

import com.example.assignment.domain.Note;
import com.example.assignment.domain.NoteRequestDto;
import com.example.assignment.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoteController {

    private final NoteService noteService;

    // 전체 게시글 목록 조회 API
    @GetMapping("/api/notes")
    public List readNote () {
        return noteService.read();
    }

    // 특정 게시글 조회 API
    @GetMapping("/api/notes/{id}")
    public List readNote (@PathVariable Long id) {
        return noteService.readOne(id);
    }

    // 게시글 작성 API
    @PostMapping("/api/notes")
    public Note createNote(@RequestBody NoteRequestDto requestDto) {
        return noteService.create(requestDto);
    }

    // 게시글 비밀번호 확인 API
    @PostMapping("/api/notes/{id}")
    public boolean checkPassword (@PathVariable Long id, @RequestBody NoteRequestDto requestDto) {
        return noteService.check(id, requestDto);
    }

    // 게시글 수정 API
    @PutMapping("/api/notes/{id}")
    public Long updateNote (@PathVariable Long id, @RequestBody NoteRequestDto requestDto) {
        return noteService.update(id, requestDto);
    }

    // 게시글 삭제 API
    @DeleteMapping("/api/notes/{id}")
    public Long deleteNote (@PathVariable Long id) {
        return noteService.delete(id);
    }

}
