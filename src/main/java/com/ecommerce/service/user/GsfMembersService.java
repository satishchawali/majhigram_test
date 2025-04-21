package com.ecommerce.service.user;

import com.ecommerce.dto.GsfMembersDto;

import java.util.List;
import java.util.Optional;

public interface GsfMembersService {
    List<GsfMembersDto> getAllMembers();
    Optional<GsfMembersDto> getMemberById(Long id);
    GsfMembersDto saveMember(GsfMembersDto memberDto);
    GsfMembersDto updateMember(Long id, GsfMembersDto updatedMemberDto);
    void deleteMember(Long id);
}