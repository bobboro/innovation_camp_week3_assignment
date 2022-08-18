package com.example.assignment.controller;

import com.example.assignment.domain.Note;
import com.example.assignment.domain.NoteRepository;
import com.example.assignment.domain.NoteRequestDto;
import com.example.assignment.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoteController {

    private final NoteRepository noteRepository;
    private final NoteService noteService;

    // 전체 게시글 목록 조회 API
    @GetMapping("/api/notes")
    public List<Note> readNote () {
        return noteRepository.findAllByOrderByCreatedAtDesc();
    }

    // 특정 게시글 조회 API
    @GetMapping("/api/notes/{id}")
    public List<Note> readNote (@PathVariable Long id) {
        return noteRepository.findAllById(Collections.singleton(id));
    }

    // 게시글 작성 API
    @PostMapping("/api/notes")
    public Note createNote(@RequestBody NoteRequestDto requestDto) {
        Note note = new Note(requestDto);
        return noteRepository.save(note);
    }

    // 게시글 비밀번호 확인 API
    @PostMapping("/api/notes/{id}")
    public boolean checkPassword (@PathVariable Long id, @RequestBody NoteRequestDto requestDto) {
        Note note = noteRepository.findById(id).orElseThrow(
                () -> new NullPointerException("에러")
        );
        if(!note.getPassword().equals(requestDto.getPassword())) {
            return false;
        }
        return true;
    }

    // 게시글 수정 API
    @PutMapping("/api/notes/{id}")
    public Long updateNote (@PathVariable Long id, @RequestBody NoteRequestDto requestDto) {
        return noteService.update(id, requestDto);
    }

    // 게시글 삭제 API
    @DeleteMapping("/api/notes/{id}")
    public Long deleteNote (@PathVariable Long id) {
        noteRepository.deleteById(id);
        return id;
    }

}
