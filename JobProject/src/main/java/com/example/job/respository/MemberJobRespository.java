package com.example.job.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.job.entity.MemberJob;
/**	 
 * @author Rick;	 
 * @param 
 * @return return_type
 * @see com.example.job.respository#mathod()	 
 * @date 2019年9月28日	 
 */
@Repository
public interface MemberJobRespository extends JpaRepository<MemberJob, Integer> {

	@Query(value ="select SEQ, MEMBER_SEQ, JOB_SEQ" +
			"from MEMBER_JOB where " + 
			"SEQ = (case when :seq = '' then SEQ else :seq end)"+ 
			"and (MEMBER_SEQ = (case when :member_seq = '' then MEMBER_SEQ else :member_seq end))" +
			"and (JOB_SEQ = (case when :job_seq = '' then JOB_SEQ else :job_seq end))" 
			, nativeQuery = true)
	List<MemberJob> findByJobId(
			@Param("seq") Integer seq 
			, @Param("member_seq") Integer member_seq
			, @Param("job_seq") Integer job_seq
			
			);
	
	

}
