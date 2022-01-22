package com.me.rentacar.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

import com.me.rentacar.pojo.Location;
import com.me.rentacar.DAO.*;
import com.me.rentacar.Validator.LocationValidator;
import com.me.rentacar.Interceptor.UserroleInterceptor;


@Controller
public class LocationController {
	@Autowired
	UserroleInterceptor userroleInterceptor;
	

	@PostMapping("/addLocation.htm")
	protected String AddaLocationSubmit(@Valid @ModelAttribute("location") Location location, BindingResult result,
			HttpServletRequest req) throws Exception {

		HttpSession session = req.getSession(true);

		if (result.hasErrors()) {
			System.out.print("error login");
			return "addLocation";
		}

		try {
	
			LocationDAO locationdao = new LocationDAO();
	

			locationdao.create(location.getState(),location.getCity());

		
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "successLocation";
	}

	@GetMapping("/addLocation.htm")
	public String AddaLocationGet(@ModelAttribute("location") Location location, BindingResult result,SessionStatus status, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (!userroleInterceptor.adminRoleIntercept(request, response)) {
			response.sendRedirect("/rentacar/");
		}
		return "addLocation";
	}

	@GetMapping("/deleteLocation.htm")
	public String DeleteaLocationGet(@ModelAttribute("location") Location location, BindingResult result,SessionStatus status, HttpServletRequest request, HttpServletResponse response) throws IOException  {
		if (!userroleInterceptor.adminRoleIntercept(request, response)) {
			response.sendRedirect("/rentacar/");
		}
		return "deleteLocation";
	}

	@GetMapping("/updateLocation.htm")
	public String UpdateaLocationGet(@ModelAttribute("location") Location location, BindingResult result,SessionStatus status, HttpServletRequest request, HttpServletResponse response) throws IOException  {
		if (!userroleInterceptor.adminRoleIntercept(request, response)) {
			response.sendRedirect("/rentacar/");
		}
		return "updateLocation";
	}

	@PostMapping("/deleteLocation.htm")
	protected String DeleteaLocationSubmit(@ModelAttribute("location") Location location, BindingResult result) throws Exception {


		try {

			LocationDAO locationdao = new LocationDAO();

			int deletestatuslocation = locationdao.delete(location.getLocation_id());
			if (deletestatuslocation > 0) {
				System.out.print("location is deleted");
				return "AdminWelcome";
			} else {
				return null;
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return null;
	}

	@PostMapping("/updateLocation.htm")
	protected String UpdateaLocationSubmit(@ModelAttribute("location") Location location, BindingResult result, HttpServletRequest req) throws Exception {

	HttpSession session = req.getSession(true);

		try {
			System.out.print("update location DAO");
			LocationDAO locationdao = new LocationDAO();
			System.out.print("Location_id is :" + location.getLocation_id());

			Location locationupd = locationdao.get(location.getLocation_id());
			System.out.print(locationupd);
			
			session.setAttribute("location", locationupd);
			return "updateLocationDetails";
		}

		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return null;
	}

	@PostMapping("/updateLocationDetails.htm")
	public String UpdateaLocationDetails(HttpServletRequest request) throws Exception {
		LocationDAO locationdao = new LocationDAO();
		
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		int location_id = Integer.parseInt(request.getParameter("location_id"));

		System.out.println(state+" "+city+" "+location_id);
		int updatelocationresult = locationdao.updateLocation(location_id, state, city);
		if (updatelocationresult > 0) {
			return "AdminWelcome";
		}
		return null;
	}

}
