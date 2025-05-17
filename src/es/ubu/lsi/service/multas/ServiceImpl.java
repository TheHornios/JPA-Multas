package es.ubu.lsi.service.multas;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.ubu.lsi.dao.multas.ConductorDAO;
import es.ubu.lsi.dao.multas.IncidenciaDAO;
import es.ubu.lsi.dao.multas.TipoIncidenciaDAO;
import es.ubu.lsi.dao.multas.VehiculoDAO;
import es.ubu.lsi.model.multas.Conductor;
import es.ubu.lsi.model.multas.Incidencia;
import es.ubu.lsi.model.multas.IncidenciaPK;
import es.ubu.lsi.model.multas.TipoIncidencia;
import es.ubu.lsi.model.multas.Vehiculo;
import es.ubu.lsi.service.PersistenceException;
import es.ubu.lsi.service.PersistenceService;

public class ServiceImpl extends PersistenceService implements Service {

    private static final Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

    @Override
    public void insertarIncidencia(Date fecha, String nif, long tipo) throws PersistenceException {
        EntityManager em = createSession();

        try {
            beginTransaction(em);

            ConductorDAO conductorDAO = new ConductorDAO(em);
            TipoIncidenciaDAO tipoIncidenciaDAO = new TipoIncidenciaDAO(em);

            Conductor conductor = conductorDAO.findById(nif);
            if (conductor == null) {
                throw new IncidentException(IncidentError.NOT_EXIST_DRIVER);
            }

            TipoIncidencia tipoIncidencia = tipoIncidenciaDAO.findById(tipo);
            if (tipoIncidencia == null) {
                throw new IncidentException(IncidentError.NOT_EXIST_INCIDENT_TYPE);
            }

            if (conductor.getPuntos().compareTo(tipoIncidencia.getValor()) < 0) {
                throw new IncidentException(IncidentError.NOT_AVAILABLE_POINTS);
            }

            IncidenciaPK pk = new IncidenciaPK(nif, fecha);
            Incidencia incidencia = new Incidencia(pk, "", conductor, tipoIncidencia);

            conductor.setPuntos(conductor.getPuntos().subtract(tipoIncidencia.getValor()));
            conductor.addIncidencia(incidencia);

            em.persist(incidencia);
            commitTransaction(em);

        } catch (IncidentException e) {
            rollbackTransaction(em);
            logger.error(e.getLocalizedMessage(), e);
            throw e;
        } catch (Exception e) {
            rollbackTransaction(em);
            logger.error("Excepción inesperada:", e);
            throw new PersistenceException("Error general:", e);
        } finally {
            close(em);
            logger.debug("Sesión cerrada.");
        }
    }

    @Override
    public void indultar(String nif) throws PersistenceException {
        EntityManager em = createSession();

        try {
            beginTransaction(em);

            ConductorDAO conductorDAO = new ConductorDAO(em);
            IncidenciaDAO incidenciaDAO = new IncidenciaDAO(em);

            Conductor conductor = conductorDAO.findById(nif);
            if (conductor == null) {
                throw new IncidentException(IncidentError.NOT_EXIST_DRIVER);
            }

            conductor.setPuntos(BigDecimal.valueOf(MAXIMO_PUNTOS));

            incidenciaDAO.deleteAllWithNIF(nif);

            Set<Incidencia> incidencias = new HashSet<>(conductor.getIncidencias());
            for (Incidencia incidencia : incidencias) {
                conductor.removeIncidencia(incidencia);
            }

            commitTransaction(em);

        } catch (IncidentException e) {
            rollbackTransaction(em);
            logger.error(e.getLocalizedMessage(), e);
            throw e;
        } catch (Exception e) {
            rollbackTransaction(em);
            logger.error("Excepción inesperada:", e);
            throw new PersistenceException("Error general:", e);
        } finally {
            close(em);
            logger.debug("Sesión cerrada.");
        }
    }

    @Override
    public List<Vehiculo> consultarVehiculos() throws PersistenceException {
        EntityManager em = createSession();

        try {
            beginTransaction(em);

            VehiculoDAO vehiculoDAO = new VehiculoDAO(em);
            List<Vehiculo> vehiculos = vehiculoDAO.findAllWithGraph();

            commitTransaction(em);
            return vehiculos;

        } catch (Exception e) {
            rollbackTransaction(em);
            logger.error("Excepción inesperada:", e);
            throw new PersistenceException("Error general:", e);
        } finally {
            close(em);
            logger.debug("Sesión cerrada.");
        }
    }
}