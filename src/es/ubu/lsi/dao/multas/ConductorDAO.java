package es.ubu.lsi.dao.multas;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.multas.Conductor;
import es.ubu.lsi.model.multas.Incidencia;

public class ConductorDAO extends JpaDAO<Conductor, String> {
	private static final Logger logger = LoggerFactory.getLogger(ConductorDAO.class);

    public ConductorDAO(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * Obtiene la lista completa de conductores.
     *
     * @return Lista de conductores
     */
    @Override
    public List<Conductor> findAll() {
        try {
            TypedQuery<Conductor> query = getEntityManager()
                .createNamedQuery("Conductor.findAll", Conductor.class);
            return query.getResultList();
        } catch (Exception ex) {
            logger.error("Error obteniendo todos los conductores", ex);
            throw new RuntimeException("No se pudieron obtener los conductores", ex);
        }
    }

    /**
     * Obtiene todas las incidencias asociadas a un conductor identificado por su NIF.
     *
     * @param nif NIF del conductor
     * @return Lista de incidencias asociadas
     */
    public List<Incidencia> findByConductor(String nif) {
        try {
            TypedQuery<Incidencia> query = getEntityManager()
                .createNamedQuery("Incidencia.findByConductor", Incidencia.class);
            query.setParameter("nif", nif);
            return query.getResultList();
        } catch (Exception ex) {
            logger.error("Error obteniendo incidencias para conductor con NIF {}", nif, ex);
            throw new RuntimeException("No se pudieron obtener las incidencias para el conductor con NIF: " + nif, ex);
        }
    }
}
