package com.insshop.mapper;


import com.insshop.dto.inquiry.*;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class InquiryMapperTest {

    @Autowired
    InquiryMapper inquiryMapper;

    @Test
    void save(){
        InquirySaveRequest inquiry = new InquirySaveRequest();
        inquiry.setUserId(1l);
        inquiry.setType(Type.ORDER);
        inquiry.setTypeDetail(TypeDetail.RETURN);
        inquiry.setTitle("제목");
        inquiry.setContents("내용");
        inquiry.setSecret(false);

        inquiryMapper.save(inquiry);

        Assertions.assertThat(inquiry.getContents()).isEqualTo(inquiryMapper.findById(4l).get().getContents());
    }

    @Test
    void findByType() {
        List<Inquiry> result = inquiryMapper.findByType(Type.PAYMENT);

        Assertions.assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void findById() {
        Assertions.assertThat(inquiryMapper.findByType(Type.PAYMENT).size()).isEqualTo(3);

        InquirySaveRequest inquiry = new InquirySaveRequest();
        inquiry.setUserId(1l);
        inquiry.setType(Type.ORDER);
        inquiry.setTypeDetail(TypeDetail.RETURN);
        inquiry.setTitle("제목");
        inquiry.setContents("내용");
        inquiry.setSecret(false);

        inquiryMapper.save(inquiry);

        Assertions.assertThat(inquiry.getUserId()).isEqualTo(inquiryMapper.findById(4l).get().getUserId());
        Assertions.assertThat(inquiry.getTitle()).isEqualTo(inquiryMapper.findById(4l).get().getTitle());
    }

    @Test
    void updateStatus() {
        Inquiry inquiry = inquiryMapper.findById(3l).get();

        inquiryMapper.updateStatus(3l, Status.DELETED);

        Assertions.assertThat(inquiryMapper.findById(3l).get().getStatus()).isEqualTo(Status.DELETED);
    }

    @Test
    void updateResponse() {
        Inquiry inquiry = inquiryMapper.findById(3l).get();

        inquiryMapper.updateResponse(3l, "답변 했어요~");

        Assertions.assertThat(inquiryMapper.findById(3l).get().getResponse()).isEqualTo("답변 했어요~");
    }
}
