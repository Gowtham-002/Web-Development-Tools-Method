package com.me.rentacar.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.me.rentacar.pojo.Booking;


@Component
public class CarBookingDAO extends MainDAO {

	 public List<Booking> getBookings(long userid)
	            throws Exception {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Booking where userid = :userid");
//	            Query q = getSession().createQuery("from Booking as b inner join Car as c on c.carid = b.carid and b.userid = :userid order by b.booking_id DESC");
	            q.setLong("userid", userid);
           List bookingList = q.list();
//	            List bookingList = q.getResultList();
	            commit();
	            return bookingList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not get bookings " +  e);
	        }
	    }
	 
	 
    public Booking create(Booking booking)
            throws Exception {
        try {
            begin();      
            getSession().save(booking);
            commit();
            return booking;
        } catch (HibernateException e) {
            rollback();
            System.out.println(e);
            throw new Exception("Exception while creating booking: " + e.getMessage());
        }
    }
    
        
    public List<Booking> getCarBooking() throws Exception {
        try {
            begin();
            Query q=getSession().createQuery("from Booking ");
            
            List<Booking> bookingList = q.list(); 
            commit();
            return bookingList;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not obtain the named category " + " " + e.getMessage());
        }
    }

    public int delete(int booking_id)
            throws Exception {
        try {
            begin();
            Query query = getSession().createQuery("Delete from Booking where booking_id= :booking_id");
            query.setInteger("booking_id", booking_id);
            int result = query.executeUpdate();
            commit();
            return result;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete booking", e);
        }
    }
    
    public void save(Booking booking) throws Exception {
        try {
            begin();
            getSession().update(booking);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not save the booking", e);
        }
    }
    public Booking searchBooking(int booking_id) throws Exception{
    	Booking booking;
    	 Booking bookingList = null;
    	 try{
    		 begin();
    		 String queryString = "from Booking where booking_id = :booking_id";
    		  Query query = getSession().createQuery(queryString);
    		  query.setString(booking_id, "booking_id");
    		  Object queryResult = query.uniqueResult();
    		  bookingList=(Booking)query.uniqueResult();
              commit();
              System.out.println("Booking Found");
              return bookingList;
              
    		 
    	 }catch (HibernateException e) {
             rollback();
             throw new Exception("Could not obtain the named category " + booking_id + " " + e.getMessage());
         }
    	
    }
    
    public int cancelbooking(int booking_id) throws Exception{
   	try{
   		begin();
   		Query query = getSession().createQuery("update Booking set status= :status where booking_id= :booking_id");
   		query.setInteger("booking_id", booking_id);
   		query.setString("status", "cancelled");

   		int result = query.executeUpdate();
   		commit();
   		return result;
   	}catch(HibernateException e){
   		rollback();
   		throw new Exception("Details Cannot be Updated",e);
   	}
   	
   }
}
