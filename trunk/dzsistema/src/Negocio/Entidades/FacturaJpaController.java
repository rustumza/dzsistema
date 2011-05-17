/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Entidades;

import Negocio.Entidades.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.persistence.sessions.Session;

/**
 *
 * @author juampa
 */
public class FacturaJpaController {

    public FacturaJpaController() {
        emf = Persistence.createEntityManagerFactory("dzsistemaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factura factura) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(factura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factura factura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            factura = em.merge(factura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = factura.getId();
                if (findFactura(id) == null) {
                    throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            em.remove(factura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factura> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factura.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Factura findFactura(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Factura> buscarPorNumero(long numero) {
        EntityManager em = getEntityManager();
        List<Factura> encontrados;
        encontrados = em.createQuery("SELECT a FROM Factura a WHERE a.numero = '"+numero+"'").getResultList();
        return encontrados;
    }

     public List<Factura> buscarTodasLasFacturas() {
        EntityManager em = getEntityManager();
        List<Factura> encontrados;
        encontrados = em.createQuery("SELECT a FROM Factura a WHERE a.estado = '" + 1 + "'").getResultList();
        return encontrados;
    }
    
     
    /*public List<Factura> buscarFacturaEntreFechas1(Date fechaInicio, Date fechaFin) {
        EntityManager em = getEntityManager();
        List<Factura> encontrados;
        String fechaInicioString = String.valueOf(fechaInicio.getYear()+1900) + "-" + String.valueOf(fechaInicio.getMonth()+1) + "-" + String.valueOf(fechaInicio.getDate());
        String fechaFinString = String.valueOf(fechaFin.getYear()+1900) + "-" + String.valueOf(fechaFin.getMonth()+1) + "-" + String.valueOf(fechaFin.getDate());
        encontrados = em.createQuery("SELECT a FROM Factura a WHERE a.fecha >= '" + fechaInicioString + "' AND a.fecha <= '" + fechaFinString + "' AND a.estado = '1'").getResultList();
        return encontrados;
    }
*/
     
    public List<Factura> buscarFacturaEntreFechas(Date fechaInicio, Date fechaFin) {
        EntityManager em = getEntityManager();
        List<Factura> encontrados;
        Query objQuery = em.createQuery("SELECT a FROM Factura a WHERE a.fecha >=  :regDate1 AND a.fecha <=  :regDate2 AND a.estado = '1'");
        objQuery.setParameter("regDate1", fechaInicio);
        objQuery.setParameter("regDate2", fechaFin);

        return objQuery.getResultList();
    }

    public List<Factura> buscarFacturaEntreFechasSinLaFechaFin(Date fechaInicio, Date fechaFin) {
        EntityManager em = getEntityManager();
        List<Factura> encontrados;
        Query objQuery = em.createQuery("SELECT a FROM Factura a WHERE a.fecha >=  :regDate1 AND a.fecha <  :regDate2 AND a.estado = '1'");
        objQuery.setParameter("regDate1", fechaInicio);
        objQuery.setParameter("regDate2", fechaFin);

        return objQuery.getResultList();
    }

    public List<Factura> buscarFacturaEntreFechasSinLaFechaFinYConCliente(Date fechaInicio, Date fechaFin, Cliente cliente) {
        EntityManager em = getEntityManager();
        List<Factura> encontrados;
        Query objQuery = em.createQuery("SELECT a FROM Factura a WHERE a.cliente = :regCliente AND a.fecha >=  :regDate1 AND a.fecha <  :regDate2 AND a.estado = '1'");
        objQuery.setParameter("regDate1", fechaInicio);
        objQuery.setParameter("regDate2", fechaFin);
        objQuery.setParameter("regCliente", cliente);

        return objQuery.getResultList();
    }

}
