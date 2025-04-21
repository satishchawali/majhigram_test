package com.ecommerce.service.user.impl;

import com.ecommerce.dto.GsfMembersDto;
import com.ecommerce.entity.GsfMembers;
import com.ecommerce.repo.GsfMembersRepository;
import com.ecommerce.service.user.GsfMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GsfMembersServiceImpl implements GsfMembersService {

    @Autowired
    private GsfMembersRepository gsfMembersRepository;

    @Override
    public List<GsfMembersDto> getAllMembers() {
        return gsfMembersRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GsfMembersDto> getMemberById(Long id) {
        return gsfMembersRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public GsfMembersDto saveMember(GsfMembersDto memberDto) {
        GsfMembers member = convertToEntity(memberDto);
        GsfMembers savedMember = gsfMembersRepository.save(member);
        return convertToDto(savedMember);
    }

    @Override
    public GsfMembersDto updateMember(Long id, GsfMembersDto updatedMemberDto) {
        return gsfMembersRepository.findById(id).map(existingMember -> {
            existingMember.setFullname(updatedMemberDto.getFullname());
            existingMember.setDesignation(updatedMemberDto.getDesignation());
            existingMember.setEmail(updatedMemberDto.getEmail());
            existingMember.setMobile(updatedMemberDto.getMobile());
            existingMember.setPlan(updatedMemberDto.getPlan());
            existingMember.setDob(updatedMemberDto.getDob());
            existingMember.setSdate(updatedMemberDto.getSdate());
            existingMember.setPhoto(updatedMemberDto.getPhoto());
            existingMember.setStatus(updatedMemberDto.getStatus());
            existingMember.setRemarks(updatedMemberDto.getRemarks());
            existingMember.setRenewplan(updatedMemberDto.getRenewplan());
            existingMember.setBillingAddress(updatedMemberDto.getBillingAddress());
            existingMember.setDistrict(updatedMemberDto.getDistrict());
            existingMember.setTaluka(updatedMemberDto.getTaluka());
            existingMember.setGstin(updatedMemberDto.getGstin());
            existingMember.setIsStateBody(updatedMemberDto.getIsStateBody());
            existingMember.setShowNumber(updatedMemberDto.getShowNumber());
            return convertToDto(gsfMembersRepository.save(existingMember));
        }).orElseThrow(() -> new RuntimeException("Member not found with id " + id));
    }

    @Override
    public void deleteMember(Long id) {
        gsfMembersRepository.deleteById(id);
    }

    private GsfMembersDto convertToDto(GsfMembers member) {
        if (member == null) {
            return null;
        }
        return new GsfMembersDto(
                member.getId(),
                member.getFullname(),
                member.getDesignation(),
                member.getEmail(),
                member.getMobile(),
                member.getPlan(),
                member.getDob(),
                member.getSdate(),
                member.getPhoto(),
                member.getStatus(),
                member.getRemarks(),
                member.getCreated(),
                member.getModify(),
                member.getHistory(),
                member.getRenewplan(),
                member.getBillingAddress(),
                member.getDistrict(),
                member.getTaluka(),
                member.getGstin(),
                member.getIsStateBody(),
                member.getShowNumber()
        );
    }

    private GsfMembers convertToEntity(GsfMembersDto dto) {
        GsfMembers member = new GsfMembers();
        member.setId(dto.getId());
        member.setFullname(dto.getFullname());
        member.setDesignation(dto.getDesignation());
        member.setEmail(dto.getEmail());
        member.setMobile(dto.getMobile());
        member.setPlan(dto.getPlan());
        member.setDob(dto.getDob());
        member.setSdate(dto.getSdate());
        member.setPhoto(dto.getPhoto());
        member.setStatus(dto.getStatus());
        member.setRemarks(dto.getRemarks());
        member.setRenewplan(dto.getRenewplan());
        member.setBillingAddress(dto.getBillingAddress());
        member.setDistrict(dto.getDistrict());
        member.setTaluka(dto.getTaluka());
        member.setGstin(dto.getGstin());
        member.setIsStateBody(dto.getIsStateBody());
        member.setShowNumber(dto.getShowNumber());
        member.setCreated(dto.getCreated());
        member.setModify(dto.getModify());
        member.setHistory(dto.getHistory());
        return member;
    }
}