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

import com.me.rentacar.DAO.*;
import com.me.rentacar.pojo.*;
import com.me.rentacar.Validator.CarValidator;
import com.me.rentacar.Interceptor.UserroleInterceptor;

@Controller
public class CarController {

	@Autowired
	UserroleInterceptor userroleInterceptor;
	
    @PostMapping("/addCar.htm")
	protected String addCar(@Valid @ModelAttribute("car") Car car, BindingResult Bindingresult, HttpServletRequest req)
			throws Exception {

		HttpSession session = req.getSession();

		if (Bindingresult.hasErrors()) {
			return "addCar";
		}
		int location_id = car.getLocation_id();
		if(location_id == 0) {
			location_id = 5;
		}

		try {
			LocationDAO locationdao = new LocationDAO();
			CarDAO carDAO1 = new CarDAO();

			Location location = locationdao.get(location_id);

			carDAO1.create(car.getCarnumplate(),car.getCarname(),car.getPerhourrate(),car.getAvailability(), car.getYearofmanufacture(),car.getRating(),car.getMilageinmiles(), car.getCarbrand(), 
					car.getNoofseats(),car.getLocation_id());

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addCarSuccess";
	}

    @GetMapping("/addCar.htm")
	public String AddaCar(@ModelAttribute("car") Car car, BindingResult Bindingresult,SessionStatus status, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (!userroleInterceptor.adminRoleIntercept(request, response)) {
			response.sendRedirect("/rentacar/");
		}
		return "addCar";
	}

    @GetMapping("/deleteCar.htm")
	public String DeleteCar(@ModelAttribute("car") Car car, BindingResult Bindingresult,SessionStatus status, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (!userroleInterceptor.adminRoleIntercept(request, response)) {
			response.sendRedirect("/rentacar/");
		}
		return "deleteCar";
	}

    @GetMapping("/updateCar.htm")
	public String Updateacar(@ModelAttribute("car") Car car, BindingResult Bindingresult,SessionStatus status, HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (!userroleInterceptor.adminRoleIntercept(request, response)) {
			response.sendRedirect("/rentacar/");
		}
		return "updateCar";
	}

    @PostMapping("/deleteCar.htm")
	protected String DeleteaCarSubmit(@ModelAttribute("car") Car car, BindingResult Bindingresult) throws Exception {


		try {
			System.out.print("inside delete car");
			CarDAO carDao_d = new CarDAO();
			System.out.print("created delete car DAO");
			int cardelete = carDao_d.delete(car.getCarid());
			if (cardelete > 0) {
				System.out.print("Car DataDeleted");
				return "AdminWelcome";
			} else {
				return null;
			}


		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return null;
	}

    @PostMapping("/updateCar.htm")
	protected String UpdateacarSubmit(@ModelAttribute("car") Car car, BindingResult Bindingresult, HttpServletRequest request)
			throws Exception {

		HttpSession session = request.getSession(false);

		if (Bindingresult.hasErrors()) {
			return "updateCar";
		}

		try {

			CarDAO carDao = new CarDAO();
			

			Car car_d = carDao.getCar(car.getCarid());
			System.out.print("car id:"+ car.getCarid());
			request.setAttribute("car", car_d);
			session.setAttribute("car", car_d);
			return "updateCarDetails";
		}

		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return null;
	}
	
	@PostMapping("/updateCarDetails.htm")
	public String UpdateCarDetails(HttpServletRequest request) throws Exception {
		CarDAO cardao_u = new CarDAO();
		System.out.print("update car details post");
		
		int car_id = Integer.parseInt(request.getParameter("carid"));
		int location_id = Integer.parseInt(request.getParameter("location_id"));
		String car_name = request.getParameter("carname");
		String car_num_plate = request.getParameter("carnumplate");
		String availability = request.getParameter("availability");
		int year_of_manufacture = Integer.parseInt(request.getParameter("yearofmanufacture"));
		String rating = request.getParameter("rating");
		float milage_in_miles = Float.parseFloat(request.getParameter("milageinmiles"));
		String car_brand = request.getParameter("carbrand");
		int noofseats = Integer.parseInt(request.getParameter("noofseats"));
		float per_hour_rate = Float.parseFloat(request.getParameter("perhourrate"));
		
		

		System.out.println("Carnumplate : "+ car_num_plate+" "+car_name+" "+ "per_hour_rate :"+ per_hour_rate);
		int updatecarstatus = cardao_u.updateCarDetailsDAO(car_num_plate,car_name,per_hour_rate,availability,year_of_manufacture,rating,milage_in_miles,car_brand, noofseats,
				 location_id, car_id);
		if (updatecarstatus > 0) {
			return "AdminWelcome";
		}
		return null;
	}
}