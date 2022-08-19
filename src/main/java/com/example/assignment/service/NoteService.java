package com.example.assignment.service;

import com.example.assignment.domain.Note;
import com.example.assignment.domain.NoteRepository;
import com.example.assignment.domain.NoteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    // 게시글 목록 조회
    @Transactional
    public List<Note> read () {
        return noteRepository.findAllByOrderByCreatedAtDesc();
    }

    // 특정 게시글 조회
    @Transactional
    public List<Note> readOne (Long id) {
        return noteRepository.findAllById(Collections.singleton(id));
    }

    // 게시글 작성
    @Transactional
    public Note create (NoteRequestDto requestDto) {
        Note note = new Note(requestDto);
        return noteRepository.save(note);
    }

    // 게시글 수정
    @Transactional
    public long update(Long id, NoteRequestDto requestDto){
        Note note = noteRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        note.update(requestDto);
        return note.getId();
    }
    // 비밀번호 확인
    @Transactional
    public boolean check(Long id, NoteRequestDto requestDto) {
        Note note = noteRepository.findById(id).orElseThrow(
                () -> new NullPointerException("에러")
        );
        if(!note.getPassword().equals(requestDto.getPassword())) {
            return false;
        }
        return true;
    }

    // 게시글 삭제
    @Transactional
    public Long delete (Long id) {
        noteRepository.deleteById(id);
        return id;
    }

}
