package principal;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entidades.Regions;

public class RegionesDAO {
	
	private SessionFactory sf;
	
	public RegionesDAO (SessionFactory sf)
	{
		this.sf = sf;
	}
	
	//CREATE
	public boolean create (Regions region)
	{
		return false;
	}
	//READ
	public Regions read (BigDecimal id_region)
	{
		Regions region = null;
			
			Session sesion = this.sf.openSession();
			Transaction tx =sesion.beginTransaction();
			region = sesion.get(Regions.class, id_region);
			tx.commit();
			sesion.close();
		
		return region;
	}
	//UPDATE
	public boolean update (Regions region_nueva)
	{
		return false;
	}
	//DELETE
	public boolean delete (BigDecimal id_region)
	{
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
