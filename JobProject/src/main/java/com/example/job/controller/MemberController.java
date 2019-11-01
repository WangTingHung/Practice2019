package com.example.job.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.job.dto.AsyncResponse;
import com.example.job.dto.CommonHeader;
import com.example.job.dto.MemberRequest;
import com.example.job.dto.MemberResponse;
import com.example.job.dto.MemberResponseBody;
import com.example.job.entity.Member;
import com.example.job.service.MemberJobService;
import com.example.job.service.impl.MemberServiceImpl;
/**	 
 * @author Rick;	 
 * @param 
 * @return return_type
 * @see com.example.job.controller#mathod()	 
 * @date 2019年9月28日	 
 */

@RestController
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	
	@Autowired
	public MemberServiceImpl MemberService;
	
	@Autowired
	public MemberJobService memberJobService;
	
	private Integer memberSeq = 1; //寫死
	private String memberName = "王小明"; //寫死
	
	@PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MemberResponse hello(@RequestBody MemberRequest request) {
		System.out.println(request);
		
		MemberResponse response = new MemberResponse();
		MemberResponseBody responseBody = new MemberResponseBody();
		
		CommonHeader header = new CommonHeader();
		BeanUtils.copyProperties(request.getHeader(), header);
		response.setHeader(header);
		
		Member member = MemberService.findBySeq(request.getBody().getSeq());
		BeanUtils.copyProperties(member, responseBody);
		
		response.setBody(responseBody);
		return response;
	}
	
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MemberResponse save(@RequestBody MemberRequest request) {
		System.out.println("====="+request);
		
		MemberResponse response = new MemberResponse();
		Member member = new Member();
		BeanUtils.copyProperties(request.getBody(), member);
		MemberService.save(member);
		MemberResponseBody body = new MemberResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);
		
		return response;
	}
	
	@PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MemberResponse update(@RequestBody MemberRequest request) {
		System.out.println("====="+request);
		
		MemberResponse response = new MemberResponse();
		MemberResponseBody responseBody = new MemberResponseBody();
		
		CommonHeader header = new CommonHeader();
		BeanUtils.copyProperties(request.getHeader(), header);
		response.setHeader(header);
		
		Member member = MemberService.findBySeq(request.getBody().getSeq());
		BeanUtils.copyProperties(request.getBody(), member);
		
		MemberService.save(member);
		response.setBody(responseBody);
		return response;
	}
	
	@PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MemberResponse delete(@RequestBody MemberRequest request) {
		System.out.println("====="+request);
		
		MemberResponse response = new MemberResponse();
		MemberResponseBody responseBody = new MemberResponseBody();
		
		CommonHeader header = new CommonHeader();
		BeanUtils.copyProperties(request.getHeader(), header);
		response.setHeader(header);
		
		MemberService.delete(request.getBody().getSeq());
		response.setBody(responseBody);
		return response;
	}
	
	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MemberResponse findAll() {

		MemberResponse response = new MemberResponse();
		List<Member> dataList = MemberService.findAll();
		MemberResponseBody body = new MemberResponseBody();
		body.setReturnCode("0000");
		body.setDataList(dataList);
		response.setBody(body);

		return response;
	}

	@RequestMapping(value = "/findBySeqId", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public MemberResponse findBySeqId(@RequestBody MemberRequest request) {

		MemberResponse response = new MemberResponse();
		Member member = new Member();
		BeanUtils.copyProperties(request.getBody(), member);

		List<Member> dataList = MemberService.findBySeqId(member);
		MemberResponseBody body = new MemberResponseBody();
		body.setReturnCode("0000");
		body.setDataList(dataList);
		response.setBody(body);

		return response;

	}
	
	@GetMapping(value = "/login")
	public AsyncResponse login(HttpSession session) {
		logger.info("#####   WebRequest - logout  #####");

		AsyncResponse response = new AsyncResponse();
		session.setAttribute("memberSeq", memberSeq);
		session.setAttribute("memberName", memberName);
		response.setData(memberJobService.getJobSeqByMember(memberSeq));
		response.setMessage(memberName);
		return response;
	}
	
	@GetMapping(value = "/logout")
	public AsyncResponse logout(HttpSession session) {
		logger.info("#####   WebRequest - logout  #####");
		AsyncResponse response = new AsyncResponse();
		session.invalidate();
		return response;
	}
}
