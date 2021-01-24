package com.example.demo3;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContentDto { //-->DTO에 접근해서하는거 이해하기
    private int id;
    @NotNull(message="writer is null.")
    @NotEmpty(message="writer is empty.")
    @Size(min=3, max=10, message="writer min 3, max 10.")
    private String writer;
    @NotNull(message="content is null.")
    @NotEmpty(message="content is empty.")
    private String content;
}
