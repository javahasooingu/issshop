package com.insshop.service;

import com.insshop.dto.inquiry.InquirySaveRequest;
import com.insshop.dto.inquiry.Status;
import com.insshop.dto.inquiry.Type;
import com.insshop.dto.inquiry.TypeDetail;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class InquiryServiceTest {

    @Autowired InquiryService inquiryService;
    @Autowired PasswordEncoder passwordEncoder;

    @Test
    void findInquiresByType() {
        //g

        inquiryService.findInquiresByType(Type.ORDER);
        //w

        //t
    }

    @Test
    void findById() {
    }

    @Test
    void saveNoPw() {
        InquirySaveRequest inquiry = new InquirySaveRequest();
        inquiry.setUserId(44l);
        inquiry.setType(Type.DELIVERY);
        inquiry.setTypeDetail(TypeDetail.etc);
        inquiry.setTitle("제목1");
        inquiry.setContents("내용2");
        inquiry.setSecret(false);

        inquiryService.save(inquiry);

        Assertions.assertThat(inquiryService.findById(4l).getUserId()).isEqualTo(inquiry.getUserId());
        Assertions.assertThat(inquiryService.findById(4l).getContents()).isEqualTo("내용2");
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchElementException.class, () -> {
            inquiryService.findById(123124l);
        });

    }
    @Test
    void saveExistPw() {
        InquirySaveRequest inquiry = new InquirySaveRequest();
        inquiry.setUserId(44l);
        inquiry.setType(Type.DELIVERY);
        inquiry.setTypeDetail(TypeDetail.etc);
        inquiry.setTitle("제목1");
        inquiry.setContents("내용2");
        inquiry.setSecret(true);
//        inquiry.setPw("비~밀");
        inquiry.setPw("비~밀245678912312");

        inquiryService.save(inquiry);

        Assertions.assertThat(inquiryService.findById(4l).getContents()).isEqualTo("내용2");
        assert  passwordEncoder.matches("비~밀",inquiryService.findById(4l).getPw());
    }

    @Test
    void updateStatusToDeleted() {
        Assertions.assertThat(inquiryService.findById(1l).getStatus()).isEqualTo(Status.PENDING);

        inquiryService.updateStatusToDeleted(1l);

        Assertions.assertThat(inquiryService.findById(1l).getStatus()).isEqualTo(Status.DELETED);
    }

    @Test
    void updateResponse() {
        Assertions.assertThat(inquiryService.findById(1l).getResponse()).isNull();

        inquiryService.updateResponse(1l, "한마디~");

        Assertions.assertThat(inquiryService.findById(1l).getResponse()).isEqualTo("한마디~");
    }
}