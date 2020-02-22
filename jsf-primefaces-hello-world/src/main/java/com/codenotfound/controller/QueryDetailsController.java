package com.codenotfound.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.codenotfound.dto.QueryDto;
import com.codenotfound.dto.QueryResponseDto;
import com.codenotfound.entity.DriverInfo;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.google.gson.Gson;

@Named
@Controller
@ViewScoped

public class QueryDetailsController {
	private static final String HTML_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";
	private Pattern pattern = Pattern.compile(HTML_PATTERN);

	private List<QueryResponseDto> queryResponseDtos;
	
	public boolean hasHTMLTags(String text) {
		Matcher matcher = pattern.matcher(text);
		return matcher.find();
	}
	
	
	public List<QueryResponseDto> getQueryResponseDtos() {
		return queryResponseDtos;
	}


	public void setQueryResponseDtos(List<QueryResponseDto> queryResponseDtos) {
		this.queryResponseDtos = queryResponseDtos;
	}


	@PostConstruct
	public void init() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
		try {
			queryResponseDtos = queueStatus(session);
		} catch (Exception e) {

		}

	}
	

	public List<QueryResponseDto> openedQuaryDetails(HttpSession httpSession) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> templateResult = null;
		HttpHeaders qureryHeader = new HttpHeaders();
		if (httpSession.getAttribute("TNSAND_SESSION") != null) {
			qureryHeader.add("Cookie", (String) httpSession.getAttribute("TNSAND_SESSION"));
			templateResult = getQuaryDetails(restTemplate, qureryHeader);
			String jsonResult = templateResult.getBody();
			if (this.hasHTMLTags(jsonResult)) {
				String cookie = this.getCookies();
				qureryHeader.add("Cookie", cookie);
				httpSession.setAttribute("TNSAND_SESSION", cookie);
				templateResult = getQuaryDetails(restTemplate, qureryHeader);
			}

		} else {
			String cookie = this.getCookies();
			qureryHeader.add("Cookie", cookie);
			httpSession.setAttribute("TNSAND_SESSION", cookie);
			templateResult = getQuaryDetails(restTemplate, qureryHeader);
		}
		Gson gson = new Gson();
		String jsonResult = templateResult.getBody();
		List<QueryDto> queryDetailResponse = Arrays.asList(gson.fromJson(jsonResult, QueryDto[].class));
		List<QueryResponseDto> listdataResponse = new ArrayList<>();
		for (QueryDto aQueryDto : queryDetailResponse) {
			QueryResponseDto aQueryResponseDto = new QueryResponseDto();
			if (aQueryDto.getBalanceSandUnits() > 0 && !aQueryDto.getQuarryTypeName().equalsIgnoreCase("Port")) {
				BeanUtils.copyProperties(aQueryDto, aQueryResponseDto);
				listdataResponse.add(aQueryResponseDto);
			}
		}
		return listdataResponse;

		// final WebClient

	}


	public List<QueryResponseDto> queueStatus(HttpSession httpSession) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> templateResult = null;
		HttpHeaders qureryHeader = new HttpHeaders();
		if (httpSession.getAttribute("TNSAND_SESSION") != null) {
			qureryHeader.add("Cookie", (String) httpSession.getAttribute("TNSAND_SESSION"));
			templateResult = getQuaryDetails(restTemplate, qureryHeader);
			String jsonResult = templateResult.getBody();
			if (this.hasHTMLTags(jsonResult)) {
				String cookie = this.getCookies();
				qureryHeader.add("Cookie", cookie);
				httpSession.setAttribute("TNSAND_SESSION", cookie);
				templateResult = getQuaryDetails(restTemplate, qureryHeader);
			}

		} else {
			String cookie = this.getCookies();
			qureryHeader.add("Cookie", cookie);
			httpSession.setAttribute("TNSAND_SESSION", cookie);
			templateResult = getQuaryDetails(restTemplate, qureryHeader);
		}
		Gson gson = new Gson();
		String jsonResult = templateResult.getBody();
		List<QueryDto> queryDetailResponse = Arrays.asList(gson.fromJson(jsonResult, QueryDto[].class));
		List<QueryResponseDto> listdataResponse = new ArrayList<>();
		for (QueryDto aQueryDto : queryDetailResponse) {
			QueryResponseDto aQueryResponseDto = new QueryResponseDto();
			if (aQueryDto.getBalanceSandUnits() >= 0 && !aQueryDto.getQuarryTypeName().equalsIgnoreCase("Port")) {
				BeanUtils.copyProperties(aQueryDto, aQueryResponseDto);
				listdataResponse.add(aQueryResponseDto);
			}
		}
		return listdataResponse;

		// final WebClient

	}

	private ResponseEntity<String> getQuaryDetails(RestTemplate restTemplate, HttpHeaders qureryHeader) {
		final String baseUrl = "https://www.tnsand.in/Public/GetQuarryList";
		HttpEntity<String> entity1 = new HttpEntity<>(null, qureryHeader);
		ResponseEntity<String> templateResult = restTemplate.exchange(baseUrl, HttpMethod.GET, entity1, String.class);
		return templateResult;
	}

	private String getCookies() throws Exception {

		final WebClient webClient = new WebClient();
		webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setCssEnabled(false);
		webClient.getPage("https://www.tnsand.in");
		webClient.getPage("https://www.tnsand.in/User/GuestLogin");

		Set<Cookie> browserCookie = webClient.getCookieManager().getCookies();
		webClient.close();
		String cookies = "";
		for (Cookie a : browserCookie) {
			cookies = cookies.concat(a.getName() + "=" + a.getValue() + ";");
		}

		return cookies;
	}

	/*
	 * @ApiOperation(value = "Returns Query which can be booked")
	 * 
	 * @GetMapping("/") public ResponseEntity<List<QueryResponseDto>>
	 * getQueryDetails(@RequestParam("cookie") String cookie) throws
	 * URISyntaxException { RestTemplate restTemplate = new RestTemplate();
	 * HttpHeaders qureryHeader = new HttpHeaders(); qureryHeader.add("Cookie",
	 * cookie); final String baseUrl =
	 * "https://www.tnsand.in/Public/GetQuarryList"; HttpEntity<String> entity1
	 * = new HttpEntity<String>(qureryHeader); ResponseEntity<String>
	 * templateResult = restTemplate.exchange(baseUrl, HttpMethod.GET, entity1,
	 * String.class); Gson gson = new Gson(); String jsonResult =
	 * templateResult.getBody(); List<QueryDto> queryDetailResponse =
	 * Arrays.asList(gson.fromJson(jsonResult, QueryDto[].class));
	 * List<QueryResponseDto> listdataResponse = new ArrayList<>(); for
	 * (QueryDto aQueryDto : queryDetailResponse) { QueryResponseDto
	 * aQueryResponseDto = new QueryResponseDto(); if
	 * (aQueryDto.getBalanceSandUnits() > 0) {
	 * BeanUtils.copyProperties(aQueryDto, aQueryResponseDto);
	 * listdataResponse.add(aQueryResponseDto); } } return new
	 * ResponseEntity<List<QueryResponseDto>>(listdataResponse, HttpStatus.OK);
	 * }
	 * 
	 * @ApiOperation(value = "Just an sample code to check rest api")
	 * 
	 * @GetMapping(path = "hello", produces = { MediaType.APPLICATION_JSON_VALUE
	 * }) public ResponseEntity<String> getSample() throws URISyntaxException {
	 * 
	 * return new ResponseEntity<String>("hello world", HttpStatus.OK); }
	 * 
	 * @ApiOperation(value =
	 * "Returns Query which can be booked using Guest login")
	 * 
	 * @GetMapping("/login") public ResponseEntity<String>
	 * login(@RequestParam("cookie") String cookie) throws URISyntaxException {
	 * RestTemplate restTemplate = new RestTemplate();
	 * restTemplate.getInterceptors().add(new
	 * BasicAuthorizationInterceptor("9698126726", "lokeshkumar")); HttpHeaders
	 * qureryHeader = new HttpHeaders(); qureryHeader.add("Cookie", cookie);
	 * final String baseUrl = "https://www.tnsand.in/User/Login";
	 * HttpEntity<String> entity1 = new HttpEntity<String>(qureryHeader);
	 * ResponseEntity<String> templateResult = restTemplate.exchange(baseUrl,
	 * HttpMethod.POST, entity1, String.class);
	 * 
	 * Gson gson = new Gson(); String jsonResult = templateResult.getBody();
	 * List<QueryDto> queryDetailResponse=
	 * Arrays.asList(gson.fromJson(jsonResult, QueryDto[].class));
	 * List<QueryResponseDto> listdataResponse = new ArrayList<>(); for
	 * (QueryDto aQueryDto : queryDetailResponse) { QueryResponseDto
	 * aQueryResponseDto = new QueryResponseDto(); if
	 * (aQueryDto.getBalanceSandUnits() > 0) {
	 * BeanUtils.copyProperties(aQueryDto, aQueryResponseDto);
	 * listdataResponse.add(aQueryResponseDto); } }
	 * 
	 * return new ResponseEntity<String>(templateResult.getBody(),
	 * HttpStatus.OK); }
	 * 
	 * @Bean RestOperations rest(RestTemplateBuilder restTemplateBuilder) {
	 * return restTemplateBuilder.basicAuthentication("user",
	 * "password").build(); }
	 */
}
