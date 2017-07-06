package principal;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entidades.Departments;
import entidades.Regions;

public class ConsultaJPA {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;//SESSIONFACTORY de HIBERNATE
		EntityManager em = null;
		
		//iniciamos JPA
		emf = Persistence.createEntityManagerFactory("unit");
		em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		/*Regions rg =  em.find(Regions.class, new BigDecimal(1));
		System.out.println(rg);*/
		//vamos  LEER TODOS LOS DEPARTAMENTOS
		TypedQuery<Departments> query = em.createNamedQuery("Departments.todos", Departments.class);
		List<Departments> ld = query.getResultList();
		for (Departments d : ld)
		{
			System.out.println(d.toString());
		}
		//mostrar la lista
		tx.commit();
		em.close();
		emf.close();
		
	}

}
