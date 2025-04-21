package com.ecommerce.service.admin;

import com.ecommerce.dto.GsfMembersDto;

import java.util.List;
import java.util.Optional;

public interface AdminGsfMembersService {
    List<GsfMembersDto> getAllMembers();
    Optional<GsfMembersDto> getMemberById(Long id);
    GsfMembersDto saveMember(GsfMembersDto memberDto);
    GsfMembersDto updateMember(Long id, GsfMembersDto updatedMemberDto);
    void deleteMember(Long id);
}