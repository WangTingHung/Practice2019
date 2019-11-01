package com.example.job.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.job.entity.Member;
/**	 
 * @author Rick;	 
 * @param 
 * @return return_type
 * @see com.example.job.respository#mathod()	 
 * @date 2019年9月28日	 
 */
@Repository
public interface MemberRespository extends JpaRepository<Member, Integer> {
	@Query(value ="select SEQ, NAME, PHONE" +
			"from MEMBER where " + 
			"SEQ = (case when :seq = '' then seq else :SEQ end)"+ 
			"and (NAME = (case when :name = '' then NAME else :name end))" +
			"and (PHONE = (case when :phone = '' then PHONE else :addr end))"
			, nativeQuery = true)
	List<Member> findBySeqId(
			@Param("seq") Integer seq 
			, @Param("name") String name
			, @Param("phone") String phone
			
			);
}










//@Repository
//public interface MemberRespository extends JpaRepository<Member, Integer> {
//
//	@Query(value ="select MEM_ID, MEM_PWD, MEM_FAVOURITE, MEM_MAIL, MEM_NAME, MEM_PHONE " +
//			"from MEMBER where " + 
//			"MEM_ID = (case when :mem_id = '' then MEM_ID else :mem_id end)"+ 
//			"and (MEM_PWD = (case when :mem_pwd = '' then MEM_PWD else :mem_pwd end))" +
//			"and (MEM_FAVOURITE = (case when :mem_favourite = '' then MEM_FAVOURITE else :mem_favourite end))" +
//			"and (MEM_MAIL = (case when :mem_mail = '' then MEM_MAIL else :mem_mail end))" +
//			"and (MEM_NAME = (case when :mem_name = '' then MEM_NAME else :mem_name end))"+
//			"and (MEM_PHONE = (case when :mem_phone = '' then MEM_PHONE else :mem_phone end))"
//			, nativeQuery = true)
//	List<Member> findByMemberAllColumn(
//			@Param("mem_id") String mem_id 
//			, @Param("mem_favourite") Integer mem_favourite
//			, @Param("mem_mail") String mem_mail
//			, @Param("mem_name") String mem_name
//			, @Param("mem_phone") String mem_phone
//			);
//
//}
