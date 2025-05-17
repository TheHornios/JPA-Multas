package es.ubu.lsi.dao.multas;

import java.util.List;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.multas.Incidencia;
import es.ubu.lsi.model.multas.IncidenciaPK;

public class IncidenciaDAO extends JpaDAO<Incidencia, IncidenciaPK> {
	private static final Logger logger = LoggerFactory.getLogger(IncidenciaDAO.class);

    public IncidenciaDAO(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * Recupera todas las incidencias registradas en la base de datos
     *
     * @return lista de incidencias
     */
    @Override
    public List<Incidencia> findAll() {
        try {
            return getEntityManager()
                    .createNamedQuery("Incidencia.findAll", Incidencia.class)
                    .getResultList();
        } catch (Exception ex) {
            logger.error("Error al obtener las incidencias", ex);
            throw new RuntimeException("No se pudieron recuperar las incidencias", ex);
        }
    }

    /**
     * Elimina todas las incidencias asociadas a un conductor por su NIF
     *
     * @param nif NIF del conductor cuyas incidencias se deben eliminar
     */
    public void deleteAllWithNIF(String nif) {
        try {
            getEntityManager()
                .createNamedQuery("Incidencia.deleteAllWithNIF")
                .setParameter("p", nif)
                .executeUpdate();
        } catch (Exception ex) {
            logger.error("Error al eliminar incidencias para el NIF: {}", nif, ex);
            throw new RuntimeException("No se pudieron eliminar las incidencias del conductor con NIF: " + nif, ex);
        }
    }
}
