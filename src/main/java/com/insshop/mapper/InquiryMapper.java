package com.insshop.mapper;

import com.insshop.dto.inquiry.Inquiry;
import com.insshop.dto.inquiry.InquirySaveRequest;
import com.insshop.dto.inquiry.Status;
import com.insshop.dto.inquiry.Type;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InquiryMapper {

    List<Inquiry> findByType(@Param("type")Type type);
    Optional<Inquiry> findById(Long id);
    Long save(InquirySaveRequest inquiry);
    void updateStatus(@Param("id") Long id, @Param("status") Status status);
    void updateResponse(@Param("id") Long id, @Param("response")String response);
}
