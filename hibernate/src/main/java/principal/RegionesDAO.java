package principal;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entidades.Regions;

public class RegionesDAO {

	private SessionFactory sf;

	public RegionesDAO(SessionFactory sf) {
		this.sf = sf;
	}

	// CREATE
	public boolean create(Regions region) {
		boolean funca = false;
		Session sesion = null;
		Transaction tx = null;

		try {
			sesion = this.sf.openSession();
			tx = sesion.beginTransaction();
			sesion.save(region);
			tx.commit();
			funca = true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			sesion.close();
		}
		return funca;
	}

	// READ
	public Regions read(BigDecimal id_region) {
		Regions region = null;
		Session sesion = null;
		Transaction tx = null;

		try {
			sesion = this.sf.openSession();
			tx = sesion.beginTransaction();
			region = sesion.get(Regions.class, id_region);
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();// informar el error
			tx.rollback();
		} finally {
			sesion.close();
		}

		return region;
	}

	// UPDATE
	public boolean update(Regions region_nueva) {
		boolean actualizar = false;
		Session sesion = null;
		Transaction tx = null;

		try {
			sesion = this.sf.openSession();
			tx = sesion.beginTransaction();
			sesion.update(region_nueva);
			tx.commit();
			actualizar = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		} finally {
			sesion.close();
		}

		return actualizar;
	}

	// DELETE
	public boolean delete(Regions region_borrar) {
		boolean borrado = false;
		Session sesion = null;
		Transaction tx = null;

		try {
			sesion = this.sf.openSession();
			tx = sesion.beginTransaction();
			sesion.delete(region_borrar);
			tx.commit();
			borrado = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		} finally {
			sesion.close();
		}

		return borrado;
	}

}

















