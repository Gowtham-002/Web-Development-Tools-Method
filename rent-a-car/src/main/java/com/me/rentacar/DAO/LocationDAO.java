package com.me.rentacar.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.rentacar.pojo.Location;

public class LocationDAO extends MainDAO {

	 public Location get(int location_id) throws Exception {
	        try {
	            begin();
	            Query q=getSession().createQuery("from Location where location_id= :location_id");
	            System.out.print(q.setInteger("location_id",location_id));
	            q.setInteger("location_id",location_id);
	            Location location=(Location)q.uniqueResult();
	            commit();
	            return location;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not obtain the named category " + location_id + " " + e.getMessage());
	        }
	    }
	 
//	 public List getAllLocation() throws Exception {
//	        try {
//	            begin();
//	            Query q=getSession().createQuery("Select loc from CarType ");
//	            List modelList = q.list();
//	            commit();
//	            return modelList;
//	        } catch (HibernateException e) {
//	            rollback();
//	            throw new Exception("Could not obtain the named category "  + e.getMessage());
//	        }
//	    }
	 
	 public List getAllLocation() throws Exception {
	        try {
	            begin();
	            Query q=getSession().createQuery("from Location ");
	            List locationlist = q.list();
	            commit();
	            return locationlist;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not obtain the named category "  + e.getMessage());
	        }
	    }
	 
		 
    public Location create(String state,String city)
            throws Exception {
        try {
            begin();
            Location addloc = new Location();
            
            addloc.setState(state);
            addloc.setCity(city);

            
            getSession().save(addloc);
            commit();
            return addloc;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Exception while adding Location: " + e.getMessage());
        }
    }

    public int delete(int location_id)
            throws Exception {
        try {
            begin();
            Query query = getSession().createQuery("Delete from Location where location_id= :location_id");
            query.setInteger("location_id", location_id);
            int result = query.executeUpdate();
            commit();
            return result;
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete Location", e);
        }
    }
    
//    public CarType searchCarType(String carbrand) throws Exception{
//    	CarType carType;
//    	 CarType productList = null;
//    	 try{
//    		 begin();
//    		 String queryString = "from Cartype where carbrand = :carbrand";
//    		  Query query = getSession().createQuery(queryString);
//    		  query.setString("carType", carbrand);
//    		  Object queryResult = query.uniqueResult();
//    		  productList=(CarType)query.uniqueResult();
//              commit();
//              System.out.println("CarType");
//              return productList;
//              
//    		 
//    	 }catch (HibernateException e) {
//             rollback();
//             throw new Exception("Could not obtain the named category " + carbrand + " " + e.getMessage());
//         }
//    	
//    }
    public int updateLocation(int location_id, String state, String city) throws Exception{
    	try{
    		begin();
    		Query query = getSession().createQuery("update Location set state= :state,city= :city where location_id= :location_id");
    		query.setString("state", state);
    		query.setString("city", city);
    		query.setInteger("location_id", location_id);
    		int result = query.executeUpdate();
    		commit();
    		return result;
    	}catch(HibernateException e){
    		rollback();
    		throw new Exception("Details Cannot be Updated",e);
    	}
    	
    }
}