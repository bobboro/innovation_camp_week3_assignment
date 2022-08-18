package com.example.assignment.service;

import com.example.assignment.domain.Note;
import com.example.assignment.domain.NoteRepository;
import com.example.assignment.domain.NoteRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Transactional
    public long update(Long id, NoteRequestDto requestDto){
        Note note = noteRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지 않습니다.")
        );
        note.update(requestDto);
        return note.getId();
    }

}
