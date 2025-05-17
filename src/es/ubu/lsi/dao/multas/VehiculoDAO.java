package es.ubu.lsi.dao.multas;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.multas.Vehiculo;

public class VehiculoDAO extends JpaDAO<Vehiculo, String> {
	private static final Logger logger = LoggerFactory.getLogger(VehiculoDAO.class);

    public VehiculoDAO(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * Obtiene todos los vehículos sin usar grafo.
     * 
     * @return Lista de vehículos
     */
    @Override
    public List<Vehiculo> findAll() {
        try {
            TypedQuery<Vehiculo> query = getEntityManager()
                .createNamedQuery("Vehiculo.findAll", Vehiculo.class);
            return query.getResultList();
        } catch (Exception ex) {
            logger.error("Error al obtener todos los vehículos", ex);
            throw new RuntimeException("No se pudieron obtener los vehículos", ex);
        }
    }

    /**
     * Obtiene todos los vehículos usando grafo de entidad para carga anticipada.
     * 
     * @return Lista de vehículos con grafo cargado
     */
    public List<Vehiculo> findAllWithGraph() {
        try {
            TypedQuery<Vehiculo> query = getEntityManager()
                .createNamedQuery("Vehiculo.findAll", Vehiculo.class)
                .setHint("javax.persistence.loadgraph", 
                    getEntityManager().getEntityGraph("Vehiculo.graph"));

            return query.getResultList();
        } catch (Exception ex) {
            logger.error("Error al obtener vehículos con grafo", ex);
            throw new RuntimeException("No se pudieron obtener los vehículos con grafo", ex);
        }
    }
}
