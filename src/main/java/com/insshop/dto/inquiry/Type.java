package com.insshop.dto.inquiry;

import com.fasterxml.jackson.annotation.JsonValue;
import com.insshop.util.CodeEnum;
import com.insshop.util.CodeEnumTypeHandler;
import lombok.Getter;
import org.apache.ibatis.type.MappedTypes;


@Getter
public enum Type implements CodeEnum {

//    NOTICE("notice","공지"),
    PAYMENT("payment","결제"),
    DELIVERY("delivery", "배송"),
    PRODUCT("product","상품"),
    ORDER("order", "주문");

    private String code;
    private String description;

    Type(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @MappedTypes(Type.class)
    public static class TypeHandler extends CodeEnumTypeHandler<Type> {
        public TypeHandler(){
            super(Type.class);
        }
    }

    @Override
    @JsonValue
    public String getCode(){
        return code;
    }
}
