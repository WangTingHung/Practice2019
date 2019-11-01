package com.example.job.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job.entity.Member;
import com.example.job.respository.MemberRespository;
import com.example.job.service.MemberService;

/**	 
 * @author Rick;	 
 * @param 
 * @return return_type
 * @see com.example.job.service.impl#mathod()	 
 * @date 2019年9月28日	 
 */

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	public MemberRespository memberRespository;

	@Override
	public Member findBySeq(Integer seq) {
		Optional<Member> custOpt = memberRespository.findById(seq);
		return custOpt.orElse(new Member());
	}
	
	@Override
	public void save(Member member) {
		memberRespository.save(member);	
	}
	
	@Override
	public void update(Member member) {
		memberRespository.save(member);
	}
	
	@Override
	public void delete(Integer seq) {
		memberRespository.deleteById(seq);
	}
	
	public List<Member> findBySeqId(Member member){
	
		return memberRespository.findBySeqId(
				member.getSeq(), member.getName(), member.getPhone());
	}
	
	public List<Member>findAll(){
		return memberRespository.findAll();
	}
	
}
