package es.ubu.lsi.dao.multas;

import java.util.List;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ubu.lsi.dao.JpaDAO;
import es.ubu.lsi.model.multas.TipoIncidencia;

public class TipoIncidenciaDAO extends JpaDAO<TipoIncidencia, Long> {

    private static final Logger logger = LoggerFactory.getLogger(TipoIncidenciaDAO.class);

    public TipoIncidenciaDAO(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * Recupera todos los tipos de incidencia registrados en la base de datos
     *
     * @return lista de tipos de incidencia
     */
    @Override
    public List<TipoIncidencia> findAll() {
        try {
            return getEntityManager()
                    .createNamedQuery("TipoIncidencia.findAll", TipoIncidencia.class)
                    .getResultList();
        } catch (Exception e) {
            logger.error("Error al obtener todos los tipos de incidencia", e);
            throw new RuntimeException("No se pudieron recuperar los tipos de incidencia", e);
        }
    }
}
