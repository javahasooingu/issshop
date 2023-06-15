package com.insshop.dto.inquiry;

import com.fasterxml.jackson.annotation.JsonValue;
import com.insshop.util.CodeEnum;
import com.insshop.util.CodeEnumTypeHandler;
import lombok.Getter;
import org.apache.ibatis.type.MappedTypes;


@Getter
public enum TypeDetail implements CodeEnum {

//    NOTICE("notice","공지"),
    REFUND("refund","결제-환불"),
    SIZE("size", "상품-사이즈"),
    RESTOCK("restock","상품-재입고"),
    RETURN("return", "주문-반품"),
    EXCHANGE("exchange", "주문-교환"),
    etc("etc", "기타");

    private String code;
    private String description;

    TypeDetail(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @MappedTypes(TypeDetail.class)
    public static class TypeHandler extends CodeEnumTypeHandler<TypeDetail>{
        public TypeHandler(){
            super(TypeDetail.class);
        }
    }

    @Override
    @JsonValue
    public String getCode(){
        return code;
    }

}
