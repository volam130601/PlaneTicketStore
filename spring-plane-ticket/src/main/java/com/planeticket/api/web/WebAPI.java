package com.planeticket.api.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planeticket.dto.sub.SearchFlightDTO;

@CrossOrigin
@RestController(value = "WebAPI")
public class WebAPI {

	@PostMapping("/api/search-flight")
	public SearchFlightDTO getSearchFlight(@RequestBody SearchFlightDTO searchFlightDTO, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(); 
//		session.setMaxInactiveInterval(60 * 60 * 24);
//		session.setAttribute("list", searchFlightDTO);
//		Cookie codeFrom = new Cookie("codeFrom", searchFlightDTO.getCodeFrom());
//		Cookie codeTo = new Cookie("codeTo", searchFlightDTO.getCodeFrom());
//	 	codeFrom.setMaxAge(60 * 60 * 24);
//	 	codeTo.setMaxAge(60 * 60 * 24);
//	 	response.addCookie(codeFrom);
//	 	response.addCookie(codeTo);
		System.out.println("HEllo sdsd");

		return searchFlightDTO;
	}
}