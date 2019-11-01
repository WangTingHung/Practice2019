package com.example.job.service;

import java.util.List;

import com.example.job.entity.MemberJob;

public interface MemberJobService {
	
	/**	 
	 * @author Rick;	 
	 * @param 
	 * @return return_type
	 * @see com.example.job.service#mathod()	 
	 * @date 2019年9月28日	 
	 */
	public MemberJob findBySeq(Integer seq);

	public void save(MemberJob memberJob);
	
	public void delete (Integer seq);

	public List<MemberJob> findAll();
	
	public List<MemberJob> findByJobId(MemberJob memberJob);
	
	/**
	 * @author Tillie Hung
	 * @param String action,Integer jobSeq, Integer memSeq
	 * @return void
	 * @see com.example.job.service.impl.MemberJobServiceImpl#addToFavorite()
	 * @date 2019年9月29日
	 */
	public void addToFavorite(String action,Integer jobSeq, Integer memSeq);

	/**
	 * @author Tillie Hung
	 * @param Integer memSeq,Integer jobSeq
	 * @return List<MemberJob>
	 * @see com.example.job.service.impl.MemberJobServiceImpl(Integer memSeq,Integer jobSeq)
	 * @date 2019年9月29日
	 */
	public List<MemberJob> getMemberJobByMemberAndJob(Integer memSeq,Integer jobSeq);
	
	/**
	 * @author Tillie Hung
	 * @param Integer memSeq
	 * @return List<Integer>
	 * @see com.example.job.service.impl.MemberJobServiceImpl#getJobSeqByMember(Integer memSeq
	 * @date 2019年9月29日
	 */
	public List<Integer> getJobSeqByMember(Integer memSeq);
}
