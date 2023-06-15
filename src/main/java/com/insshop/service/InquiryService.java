package com.insshop.service;

import com.insshop.dto.inquiry.Inquiry;
import com.insshop.dto.inquiry.InquirySaveRequest;
import com.insshop.dto.inquiry.Status;
import com.insshop.dto.inquiry.Type;
import com.insshop.mapper.InquiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InquiryService {

    private final InquiryMapper inquiryMapper;
    private final PasswordEncoder passwordEncoder;

    public List<Inquiry> findInquiresByType(Type type){

        return inquiryMapper.findByType(type);
    }

    public Inquiry findById(Long id){

        return inquiryMapper.findById(id).get();
    }

    public Long save(InquirySaveRequest inquiry){

        passwordEncoding(inquiry);

        return inquiryMapper.save(inquiry);
    }

    private void passwordEncoding(InquirySaveRequest inquiry) {
        if(inquiry.getSecret()){
            inquiry.setPw(passwordEncoder.encode(inquiry.getPw()));
        }
    }

    public void updateStatusToDeleted(Long id) {

        inquiryMapper.updateStatus(id, Status.DELETED);
    }
    
    public void updateResponse(Long id, String response){

        inquiryMapper.updateResponse(id, response);
    }

}
