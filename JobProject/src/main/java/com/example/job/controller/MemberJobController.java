package com.example.job.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.job.dto.AsyncResponse;
import com.example.job.dto.AsyncResponse.HttpStatus;
import com.example.job.dto.CommonHeader;
//import com.example.job.dto.CommonHeader;
import com.example.job.dto.MemberJobRequest;
import com.example.job.dto.MemberJobResponse;
import com.example.job.dto.MemberJobResponseBody;
import com.example.job.dto.MemberRequest;
import com.example.job.entity.MemberJob;
import com.example.job.enums.ErrorCode;
import com.example.job.service.MemberJobService;


@RestController
public class MemberJobController {

	private static final Logger logger = LoggerFactory.getLogger(MemberJobController.class);
	
	@Autowired
	public MemberJobService memberJobService;
	
	/**
	 * @author Tillie Hung
	 * @param @PathVariable("action") String action,@PathVariable("seq")Integer seq
	 * @return AsyncResponse
	 * @see com.example.job.controller.MemberJobController#addToFavorite()
	 * @date 2019年9月29日
	 * @apiNote 加入或移除我的最愛,action = on 時加入; action = off 時移除
	 */
	@GetMapping(value = "job/addToFavorite/{action}/{seq}")
	public AsyncResponse addToFavorite(@PathVariable("action") String action,@PathVariable("seq")Integer seq, HttpServletRequest request,HttpSession session) {
		logger.info("#####   WebRequest - "+request.getRequestURI()+" ,method: "+request.getMethod()+"  #####");
		
		AsyncResponse response = new AsyncResponse();
		try {
			if(session.getAttribute("memberSeq") != null) {
				memberJobService.addToFavorite(action.toLowerCase(), seq, (Integer)session.getAttribute("memberSeq"));
			}else {
				response.setStatus(HttpStatus.UNAUTHORIZED);
				response.setErrorCode(ErrorCode.E0002);
			}
		}catch(Exception e) {
			logger.error("Exception - "+e.getMessage());
			e.printStackTrace();
			response.setStatus(HttpStatus.FAILED);
			response.setErrorCode(ErrorCode.E0001);
		}
		
		return response;
	}
	
	@GetMapping(value = "job/getAllFavorite")
	public AsyncResponse getAllFavorite(HttpServletRequest request,HttpSession session) {
		logger.info("#####   WebRequest - "+request.getRequestURI()+" ,method: "+request.getMethod()+"  #####");
		
		AsyncResponse response = new AsyncResponse();
		try {
			if(session.getAttribute("memberSeq") != null) {
				response.setData(memberJobService.getJobSeqByMember((Integer)session.getAttribute("memberSeq")));
				logger.info("name"+(String)session.getAttribute("memberName"));
				response.setMessage((String)session.getAttribute("memberName"));
			}else {
				response.setStatus(HttpStatus.UNAUTHORIZED);
				response.setErrorCode(ErrorCode.E0002);
			}
		}catch(Exception e) {
			logger.error("Exception - "+e.getMessage());
			e.printStackTrace();
			response.setStatus(HttpStatus.FAILED);
			response.setErrorCode(ErrorCode.E0001);
		}
		
		return response;
	}
	
	
	/**	 
	 * @author Rick;	 
	 * @param 
	 * @return return_type
	 * @see com.example.job.controller#mathod()	 
	 * @date 2019年9月28日	 
	 */
	@PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MemberJobResponse save(@RequestBody MemberJobRequest request) {
		System.out.println(request);

		MemberJobResponse response = new MemberJobResponse();
		MemberJob memberJob = new MemberJob();
		BeanUtils.copyProperties(request.getBody(), memberJob);
		memberJobService.save(memberJob);
		MemberJobResponseBody body = new MemberJobResponseBody();
		body.setReturnCode("0000");
		response.setBody(body);

		return response;
	}
	
	@PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MemberJobResponse delete(@RequestBody MemberRequest request) {
		System.out.println("====="+request);
		
		MemberJobResponse response = new MemberJobResponse();
		MemberJobResponseBody responseBody = new MemberJobResponseBody();
		
		CommonHeader header = new CommonHeader();
		BeanUtils.copyProperties(request.getHeader(), header);
		response.setHeader(header);
		
		memberJobService.delete(request.getBody().getSeq());
		response.setBody(responseBody);
		return response;
	}
	
	
//	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public MemberJobResponse findAll() {
//
//		MemberJobResponse response = new MemberJobResponse();
//		List<MemberJob> dataList = customerService.findAll();
//		MemberJobResponseBody body = new MemberJobResponseBody();
//		body.setReturnCode("0000");
//		body.setDataList(dataList);
//		response.setBody(body);
//
//		return response;
//	}
//
//	@RequestMapping(value = "/findBySpecificColumn", method = { RequestMethod.GET, RequestMethod.POST })
//	@ResponseBody
//	public MemberJobResponse findBySpecificColumn(@RequestBody MemberJobRequest request) {
//
//		MemberJobResponse response = new MemberJobResponse();
//		MemberJob customer = new MemberJob();
//		BeanUtils.copyProperties(request.getBody(), customer);
//
//		List<MemberJob> dataList = customerService.findBySpecificColumn(customer);
//		MemberJobResponseBody body = new MemberJobResponseBody();
//		body.setReturnCode("0000");
//		body.setDataList(dataList);
//		response.setBody(body);
//
//		return response;
//
//	}

	

}
