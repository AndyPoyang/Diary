package com.example.demo.controller;

import com.example.demo.dto.DiaryRequestDto;
import com.example.demo.entity.User;
import com.example.demo.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diaries")
public class DiaryController {

    private final DiaryService diaryService;

    @PostMapping
    public ResponseEntity<Void> createDiary(
            @RequestBody DiaryRequestDto request,
            @AuthenticationPrincipal User user  // JWT 연동 후 동작
    ) {
        diaryService.createDiary(request, user);
        return ResponseEntity.ok().build();
    }
}
