package com.eungsoo.blog.controller;


import com.eungsoo.blog.models.Contents;
import com.eungsoo.blog.models.ContentsRepository;
import com.eungsoo.blog.models.ContentsRequestDto;
import com.eungsoo.blog.service.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ContentsRestController {

    private final ContentsRepository ContentsRepository;
    private final ContentsService ContentsService;


    @GetMapping("/api/contents")
    public List<Contents> getContents() {
        return ContentsRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/contents/{id}")
    public Contents getContents(@PathVariable Long id) {
        Contents contents =  ContentsRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException(" "));
        return contents;
    }

    @PostMapping("/api/contents")
    public Contents createContents(@RequestBody ContentsRequestDto requestDto) {
        Contents Contents = new Contents(requestDto);
        return ContentsRepository.save(Contents);
    }

    @PutMapping("/api/contents/{id}")
    public Long updateContents(@PathVariable Long id, @RequestBody ContentsRequestDto requestDto) {
        ContentsService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/contents/{id}")
    public Long deleteContents(@PathVariable Long id) {
        ContentsRepository.deleteById(id);
        return id;
    }

}