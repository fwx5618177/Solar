package com.moxi.solar.solarservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moxi.solar.solarservice.model.SolarPost;
import com.moxi.solar.solarservice.service.SolarService;

@RestController
@RequestMapping("/api/blog")
public class SolarController {
    @Autowired
    private SolarService solarService;

    @GetMapping("/{id}")
    public ResponseEntity<SolarPost> getSolarPost(Long id) {
        SolarPost post = solarService.getPostById(id);

        return ResponseEntity.ok(post);
    }

    // 其他CRUD操作的方法
}
