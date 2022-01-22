package com.me.rentacar.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
import org.springframework.web.bind.annotation.RequestParam;



import com.me.rentacar.DAO.*;
import com.me.rentacar.Interceptor.UserroleInterceptor;
import com.me.rentacar.pojo.*;
import com.me.rentacar.Validator.BookingValidator;

@Controller
public class BookingController {
	
	@Autowired
	UserroleInterceptor userroleInterceptor;

	@Autowired
	private JavaMailSender EmailSender;

	@GetMapping("/searchCar.htm")
	protected String selectCar(HttpServletRequest req) throws Exception {

		List<Location> locationList = new ArrayList<Location>();
		LocationDAO locaitondao = new LocationDAO();
		locationList = locaitondao.getAllLocation();
		req.setAttribute("locationList", locationList);
		if (locationList != null) {
			return "searchCar";
		}

		try {

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "searchCar";

	}

	@PostMapping("/searchCar.htm")
	public String getLocationTypes(@RequestParam("location_id") String location_id, HttpServletRequest req) throws Exception {
		int location_id1 = Integer.parseInt(location_id);

		List<Car> getcarList = new ArrayList<Car>();
		CarDAO card = new CarDAO();
		getcarList = card.getCars(location_id1);
		req.setAttribute("carList", getcarList);
		req.getSession().setAttribute("locationList", location_id1);
		if (getcarList != null) {
			return "successCar";
		} else {
			return "successCar";
		}
	}

	@PostMapping("/successCar.htm")
	public String AddedCarSuccess(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		int car_id = Integer.valueOf(request.getParameter("carid"));
		CarDAO cdao = new CarDAO();
		Car car = cdao.getCar(car_id);
		request.setAttribute("car", car);
		request.getSession().setAttribute("carid", car_id);
		
		return "carBooking";
	}

	@PostMapping("/carBooking.htm")
	public String CarBooking(HttpServletRequest request) throws Exception {

		CarBookingDAO carbookingDAO = new CarBookingDAO();
		CarDAO cardao = new CarDAO();
		Booking car_book = new Booking();
		HttpSession session = request.getSession();
		String bookedFrom, bookedTill;
		
		int car_id = Integer.valueOf(request.getParameter("carid"));
		car_book.setCarid(car_id);
		
		System.out.print("carId :"+car_id);
	
		if (null != request.getParameter("location_id") && !request.getParameter("location_id").isEmpty()) {
			int location_id = Integer.parseInt(request.getParameter("location_id"));
			
		}
		if (!request.getParameter("bookedFrom").isEmpty() && !request.getParameter("bookedTill").isEmpty()) {
			
           
			bookedFrom = request.getParameter("bookedFrom");
			car_book.setBookedFrom(bookedFrom);
		
			bookedTill = request.getParameter("bookedTill");
			car_book.setBookedTill(bookedTill);

		}
		
		User user = (User) request.getSession().getAttribute("user");
		car_book.setUserid(user);
		session.setAttribute("userid",user.getUserid());
		car_book.setStatus("Booked");
		carbookingDAO.create(car_book);
   
		request.getSession().setAttribute("bookingDetails", car_book);

		SimpleMailMessage sendemail = new SimpleMailMessage();
		sendemail.setTo(user.getEmailId());
		sendemail.setSubject("Your Car is booked!");
		sendemail.setText("Hello " + user.getFirstname() + "," + "\n"
				+ "\nThanks for  Choosing rent-A-Car on order for the " + "\n"
				+ "We’re thrilled to serve you and join hands in saving the environment in releasing CO2.!"
				+ "\n" + "\nBooking Details : " +  "\n" + "From : "+car_book.getBookedFrom() +"\n"+"To:"+car_book.getBookedTill()
				+ "\n" + ""
				+ "\n" + "\nRegards," + "\nrent-A-car team");

		EmailSender.send(sendemail);
		
		return "addBookingSuccess";
	}

	@GetMapping("/viewBooking.htm")
	public String viewBookingGet(@ModelAttribute("userbooking") Booking booking, BindingResult result) {
		return "viewBooking";
	}

	@PostMapping("/viewBooking.htm")
	public String viewBookingPost( HttpServletRequest req) throws Exception {
	
		User user_u = (User)req.getSession().getAttribute("user");

		List<Booking> viewbookingList = new ArrayList<Booking>();
		CarBookingDAO carbookdao = new CarBookingDAO();
		CarDAO cdao_v = new CarDAO();
		viewbookingList = carbookdao.getBookings(user_u.getUserid());
		req.setAttribute("bookingList", viewbookingList);
		System.out.print(viewbookingList);
		if (viewbookingList != null) {
			return "myBookings";
		}
		return "myBookings";
			
	}	
	
	@PostMapping("/myBookings.htm")
	public String cancelBooking(@RequestParam("booking_id") String booking_id,HttpServletRequest request) throws Exception {
		CarBookingDAO bookingDAO = new CarBookingDAO();
		Booking book = new Booking();
		HttpSession session = request.getSession();
		
		int location_id1 = Integer.parseInt(booking_id);
		System.out.print("first " + location_id1);
		int booking_id_c = Integer.valueOf(request.getParameter("booking_id"));
		System.out.print("second " + booking_id_c);
		book.setStatus("cancelled");
		book.setBooking_id(booking_id_c);
		bookingDAO.cancelbooking(booking_id_c);
		request.getSession().setAttribute("bookingDetails", book);
		
		
		User userobj = (User) request.getSession().getAttribute("user");
        book.setUserid(userobj);
		session.setAttribute("userid",userobj.getUserid());
		SimpleMailMessage sendemail = new SimpleMailMessage();
		sendemail.setTo(userobj.getEmailId());
		sendemail.setSubject("Your Car Has been Cancelled!");
		sendemail.setText("Hello " + userobj.getFirstname() + "," + "\n"
				+ "\nThanks for  Choosing rent-A-Car  " + "\n"
				+ "Sorry We couldn't serve you this time and do join us in the future to reduce co2 emission"
				+ "\n" + "\nBooking Details : " +  "\n" + "From : "+book.getBookedFrom() +"\n"+"To:"+book.getBookedTill()
				+ "\n" + ""
				+ "\n" + "See You Soon!!!"
				+ "\n" + "\nRegards," + "\nrent-A-car team");

		EmailSender.send(sendemail);
		
		
		return "cancelBookingSuccess";
	}
	
	@GetMapping("adminAllBookings.htm")
	public String adminviewBookings( HttpServletRequest req) throws Exception {
		List<Booking> viewbookingList = new ArrayList<Booking>();
		CarBookingDAO carbookdao = new CarBookingDAO();
		CarDAO admincdao = new CarDAO();
		viewbookingList = carbookdao.getCarBooking();
		req.setAttribute("bookingList", viewbookingList);
		System.out.print(viewbookingList);
		if (viewbookingList != null) {
			return "adminAllBookings";
		}
		return "adminAllBookings";
	}
	
	
	
}
