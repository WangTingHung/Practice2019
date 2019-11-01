package com.example.job.service;

import java.util.List;

import com.example.job.entity.Member;

public interface MemberService {

		/**	 
		 * @author Rick;	 
		 * @param 
		 * @return return_type
		 * @see com.example.job.service#mathod()	 
		 * @date 2019年9月28日	 
		 */
		Member findBySeq(Integer seq);
	
		void save(Member member);
	
		void update(Member member);
	
		void delete(Integer seq);
		
		List<Member> findAll();
		List<Member>findBySeqId(Member member);
}
