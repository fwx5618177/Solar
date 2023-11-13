package com.moxi.solar.solarservice.model;

public class SolarPost {
    private Long id;
    private String title;
    private String content;

    public SolarPost() {
    }

    public SolarPost(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // getters and setters
}
