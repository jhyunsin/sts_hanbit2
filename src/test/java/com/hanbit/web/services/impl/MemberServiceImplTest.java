package com.hanbit.web.services.impl;

import static org.junit.Assert.assertEquals;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hanbit.web.domains.MemberDTO;
import com.hanbit.web.mappers.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:META-INF/*-context.xml"})
public class MemberServiceImplTest {
 @Autowired private SqlSession sqlSession;
 @Autowired private MemberDTO member;
 
 @Test
 public void login() {
  MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
  member = mapper.findOne(null);
  System.out.println(member.getName());
  assertEquals(member.getName(), "제임스 고슬링");
 }
@Test
public void testFindbyId(){
	 MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	 
}
}