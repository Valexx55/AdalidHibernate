package principal;

public interface CRUD<T> {
	
	boolean create (T entidad);
	T read (Object id);
	boolean update (T entidad);
	boolean delete (T entidad);

}
