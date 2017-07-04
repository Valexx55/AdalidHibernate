package principal;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import entidades.Countries;
import entidades.Employees;
import entidades.Regions;
import entidades.RegistroSecuencia;
import entidades.RegistroUuid;

public class MainHibernate5 {

	public static void main(String[] args) {
		
		StandardServiceRegistry registry = 
				new StandardServiceRegistryBuilder().configure().build(); 
		
		SessionFactory sf = 
		new MetadataSources(registry).buildMetadata().buildSessionFactory();
		
		
		Session sesion = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = sesion.beginTransaction();
			RegistroSecuencia r1 = new RegistroSecuencia();
			RegistroSecuencia r2 = new RegistroSecuencia();
			RegistroSecuencia r3 = new RegistroSecuencia();
			
			sesion.save(r1);
			sesion.save(r2);
			sesion.save(r3);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
				
		
		
		sesion.close();
		sf.close();
		
		
	}
}


















