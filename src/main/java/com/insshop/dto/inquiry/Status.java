package com.insshop.dto.inquiry;


import com.fasterxml.jackson.annotation.JsonValue;
import com.insshop.util.CodeEnum;
import com.insshop.util.CodeEnumTypeHandler;
import lombok.Getter;
import org.apache.ibatis.type.MappedTypes;

@Getter
public enum Status implements CodeEnum {

    PENDING("prnding","답변 대기중"),
    IN_PROGRESS("inProgress", "처리중"),
    RESOLVED("resolved","답변완료"),
    DELETED("deleted", "삭제됨");

    private String code;
    private String description;

    Status(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @MappedTypes(Status.class)
    public static class TypeHandler extends CodeEnumTypeHandler<Status> {
        public TypeHandler(){
            super(Status.class);
        }
    }

    @Override
    @JsonValue
    public String getCode(){
        return code;
    }
}
