package com.insshop.construct;

import com.insshop.dto.inquiry.InquirySaveRequest;
import com.insshop.dto.inquiry.Status;
import com.insshop.dto.inquiry.Type;
import com.insshop.dto.inquiry.TypeDetail;
import com.insshop.mapper.InquiryMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Profile("test")
@RequiredArgsConstructor
@Component
public class SampleConstruct {

    private final InquiryMapper inquiryMapper;

    @Transactional
    @PostConstruct
    public void initSample() {
        InquirySaveRequest request1 = new InquirySaveRequest(1l, Type.PAYMENT, TypeDetail.etc, "title1","contents1",false,null, Status.PENDING);
        inquiryMapper.save(request1);
        InquirySaveRequest request2 = new InquirySaveRequest(1l, Type.PAYMENT, TypeDetail.etc, "title2","contents2",true,"1234", Status.PENDING);
        inquiryMapper.save(request2);
        InquirySaveRequest request3 = new InquirySaveRequest(1l, Type.PAYMENT, TypeDetail.etc, "title3","contents3",false,null, Status.PENDING);
        inquiryMapper.save(request3);
    }
}
