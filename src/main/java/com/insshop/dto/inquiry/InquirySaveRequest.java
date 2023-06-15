package com.insshop.dto.inquiry;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InquirySaveRequest {

    private Long userId;
    private Type type;
    private TypeDetail typeDetail;
    private String title;
    private String contents;
    private Boolean secret;
    private String pw;
    private Status status;

    public InquirySaveRequest(Long userId, Type type, TypeDetail typeDetail, String title, String contents, Boolean secret, String pw, Status status) {
        this.userId = userId;
        this.type = type;
        this.typeDetail = typeDetail;
        this.title = title;
        this.contents = contents;
        this.secret = secret;
        this.pw = pw;
        this.status = status;
    }
}
