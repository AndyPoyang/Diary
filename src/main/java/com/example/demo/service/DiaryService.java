package com.example.demo.service;

import com.example.demo.dto.DiaryRequestDto;
import com.example.demo.entity.Diary;
import com.example.demo.entity.User;
import com.example.demo.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public void createDiary(DiaryRequestDto request, User user) {
        Diary diary = Diary.builder()
                .user(user)
                .content(request.getContent())
                .isPublic(request.isPublic())
                .createdAt(LocalDateTime.now())
                .build();

        diaryRepository.save(diary);
    }
}
