package com.dev.mvc_spring.dto;

public class PostDto {
    private Long id;   
    private String title;
    private String description;

    // Constructors
    public PostDto() {}

    public PostDto(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

  
}
