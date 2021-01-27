package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;

@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria>{

	public CategoriaFacade() {
		super(Categoria.class);
	}

	@PersistenceContext(unitName = "PracticaDeLaboratorio03EJB-JSF-JPA")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public Categoria obtenerCategoriaPorID(Producto producto) {
		String jpql = "SELECT cat FROM Categoria cat WHERE cat.producto.id=" + producto.getId();
		Categoria cat = (Categoria) em.createQuery(jpql).getSingleResult();
		return cat;
	}
	
	public Categoria obtenerCategoriaPorNombre(String nombreProducto) {
		String jpql = "SELECT cat FROM Categoria cat WHERE cat.producto.nombre= '" + nombreProducto + "'";   
		Categoria cat = (Categoria) em.createQuery(jpql).getSingleResult();
		return cat;
	}
	
	public Categoria obtenerCategoria(String nombreCategoria) {
		String jpql = "SELECT cat FROM Categoria cat WHERE cat.nombre= '" + nombreCategoria +"'" ;
		Categoria cat = (Categoria) em.createQuery(jpql).getSingleResult();
		return cat;
	}
}
