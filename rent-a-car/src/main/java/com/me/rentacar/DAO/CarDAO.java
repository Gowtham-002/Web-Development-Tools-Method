package com.me.rentacar.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.rentacar.pojo.Car;


public class CarDAO extends MainDAO {

	 public Car getCar(int carid) throws Exception {
	        try {
	            begin();
	            Query q=getSession().createQuery("from Car where carid= :carid");
	            q.setInteger("carid",carid);
	            Car car=(Car)q.uniqueResult();
	            commit();
	            System.out.print("carid from DAO: "+ carid);
	            return car;
	        } catch (HibernateException e) {
	            rollback();
	            throw new Exception("Could not obtain the named category " + carid + " " + e.getMessage());
	        }
	    }
	 
   public Car create(String carnumplate, String carname, float perhourrate, String availability,
			int yearofmanufacture, String rating, float milageinmiles, String carbrand, int noofseats,
			int location_id)
           throws Exception {
       try {
           begin();
           Car car = new Car(carnumplate,carname,perhourrate,availability,yearofmanufacture,rating,milageinmiles,carbrand,noofseats,location_id);    
           getSession().save(car);
           System.out.println("saved "+ carnumplate +" "+ carname+" "+noofseats);
           commit();
           return car;
       } catch (HibernateException e) {
           rollback();
           throw new Exception("Exception while creating car: " + e.getMessage());
       }
   }

   public int delete(int carid)
           throws Exception {
       try {
           begin();
           Query query = getSession().createQuery("Delete from Car where carid= :carid");
           query.setInteger("carid", carid);
           int result = query.executeUpdate();
           commit();
           return result;
       } catch (HibernateException e) {
           rollback();
           throw new Exception("Could not delete car", e);
       }
   }
   
   public List getCars(int location_id) throws Exception {
       try {
           begin();
           Query q=getSession().createQuery("from Car where location_id = :location_id ");
           q.setInteger("location_id",location_id);
           List carList = q.list();
           commit();
           return carList;
       } catch (HibernateException e) {
           rollback();
           throw new Exception("Could not obtain the named category "  + e.getMessage());
       }
   }
   
   public Car searchCar(String carname) throws Exception{
   	Car car;
   	 Car carList = null;
   	 try{
   		 begin();
   		 String queryString = "from Car where carname = :carname";
   		  Query query = getSession().createQuery(queryString);
   		  query.setString("car", carname);
   		  Object queryResult = query.uniqueResult();
   		  carList=(Car)query.uniqueResult();
             commit();
             System.out.println("Car");
             return carList;
             
   		 
   	 }catch (HibernateException e) {
            rollback();
            throw new Exception("Could not obtain the named category " + carname + " " + e.getMessage());
        }
   	
   }
   
   public int updateCarDetailsDAO(String carnumplate, String carname, float perhourrate, String availability,
			int yearofmanufacture, String rating, float milageinmiles, String carbrand, int noofseats,
			int location_id,int carid) throws Exception{
   	try{
   		begin();
   		Query query = getSession().createQuery("update Car set carbrand= :carbrand,carname= :carname, carnumplate =:carnumplate , milageinmiles = :milageinmiles, noofseats = :noofseats,perhourrate = :perhourrate, rating = :rating, yearofmanufacture = :yearofmanufacture,availability =:availability where location_id= :location_id and carid = :carid");
   		query.setString("carbrand", carbrand);
   		query.setString("carname", carname);
   		query.setString("carnumplate", carnumplate);
        query.setString("availability", availability);
   		query.setFloat("milageinmiles", milageinmiles);
   		query.setFloat("perhourrate", perhourrate);
   		query.setString("rating",rating);
   		query.setInteger("carid", carid);
   		query.setInteger("noofseats", noofseats);
   		query.setInteger("yearofmanufacture", yearofmanufacture);
   		query.setInteger("location_id", location_id);
   		System.out.print("updateDAO");
   		int result = query.executeUpdate();
   		commit();
   		return result;
   	}catch(HibernateException e){
   		rollback();
   		throw new Exception("Details Cannot be Updated",e);
   	}
   	
   }
}
