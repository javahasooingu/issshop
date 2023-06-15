package com.insshop.dto.inquiry;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Inquiry {

    private Long id;
    private Long userId;
    private Type type;
    private TypeDetail typeDetail;
    private String title;
    private String contents;
    private Boolean secret;
    private String pw;
    private String response;
    private Status status;
    private LocalDateTime createdDate;
    private LocalDateTime responsedDate;

}
