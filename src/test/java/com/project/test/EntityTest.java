package com.project.test;

import com.project.test.entity.Member;
import com.project.test.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
public class EntityTest {
    @Autowired
    MemberRepository memberRepository;
    private Member member;
    @Test
    @DisplayName("엔티티 잘 작동하는지 확인")
    public void testEntity(){
        member.builder().name("jossi").build();
        assertThat(member.getName()).isEqualTo("jossi");
    }


    @Test
    @DisplayName("이름 저장 및 멤버 불러오기")
    public void testEntityJpa(){
        String name = "jossi";
        memberRepository.save(member.builder().name(name).build());

        //when
        List<Member> memberList = memberRepository.findAll();

        //then
        Member members = memberList.get(0);
        assertThat(members.getName()).isEqualTo(name);

    }
}