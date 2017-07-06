package principal;

import java.math.BigDecimal;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entidades.Regions;

public class TestRegionesDAO {
	
	private SessionFactory sf;
	
	@Before
	public void iniciarTest ()
	{	//abro la factoría
		System.out.println("INICIO TEST @Before");
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); 
		this.sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			
	}
	
	@After
	public void finTest ()
	{
		System.out.println("FIN TEST @After");
		this.sf.close();//cierro la factory
	}
	
	@AfterClass
	public static void finClaseTest ()
	{
		System.out.println("FIN clase TEST @AfterClass");
	}
	
	@BeforeClass
	public static void inicioClaseTest ()
	{
		System.out.println("INICIO clase TEST @BeforeClass ");
	}
	/*
	@Test
	public void testCreate ()
	{	
		System.out.println("Pasa por CREATE");
		
		Regions nueva_region = new Regions();
		nueva_region.setRegionId(new BigDecimal(900));
		nueva_region.setRegionName("SALAMANCA");
		
		RegionesDAO regionesDAO = new RegionesDAO(sf);
		regionesDAO.create(nueva_region);
		
		Regions region2 = regionesDAO.read(new BigDecimal(900));
		Assert.assertEquals(region2, nueva_region);
		
	}*/
	@Test
	public void testEquals ()
	{	
		//PROBAR SI EL MÉTODO EQUALS FUNCIONA :)
		Regions region1 = new Regions();
		region1.setRegionId(new BigDecimal(500));
		region1.setRegionName("SORIAS");
		
		Regions region2 = region1;
		
		System.out.println("region 1 = " + region1.toString());
		System.out.println("region 2 = " + region2.toString());
		
		boolean iguales = region1.equals(region2);
		Assert.assertEquals(true, iguales);
	}
	
	@Test
	public void testRead ()
	{	
		System.out.println("Pasa por READ");
		RegionesDAO regions_dao = new RegionesDAO(sf);
		//leo una región conocida y debe coincidir
		Regions region_america = new Regions();
		region_america.setRegionId(new BigDecimal(2));
		region_america.setRegionName("Americas");
		
		Regions region_leida = regions_dao.read(new BigDecimal(2));
		
		Assert.assertEquals(region_america, region_leida);
	
		
	}
	@Test
	public void testUpdate ()
	{	
		System.out.println("Pasa por UPDATE");
	}
	//http://192.168.1.54:9090/springbasics9/html/indexws.html
	//https://github.com/Valexx55/2016Spring4
	@Test
	public void testDelete()
	{	
		System.out.println("Pasa por DELETE");
		RegionesDAO regions_dao = new RegionesDAO(sf);
		
		Regions region_salamanca = regions_dao.read(new BigDecimal(700));//leo SALAMANCA
		regions_dao.delete(region_salamanca);//borro Salamanca
		
		Regions region_salamanca2 = regions_dao.read(new BigDecimal(700));//intento leer Salamanca
		Assert.assertNull(region_salamanca2);//no debería existir
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
