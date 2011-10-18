/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Entidades;

import Negocio.Entidades.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author juampa
 */
public class MovimientoStockJpaController {

    public MovimientoStockJpaController() {
        emf = Persistence.createEntityManagerFactory("dzsistemaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MovimientoStock movimientoStock) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movimientoStock);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MovimientoStock movimientoStock) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movimientoStock = em.merge(movimientoStock);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = movimientoStock.getId();
                if (findMovimientoStock(id) == null) {
                    throw new NonexistentEntityException("The movimientoStock with id " + id + " no longer exists.");
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
            MovimientoStock movimientoStock;
            try {
                movimientoStock = em.getReference(MovimientoStock.class, id);
                movimientoStock.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movimientoStock with id " + id + " no longer exists.", enfe);
            }
            em.remove(movimientoStock);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MovimientoStock> findMovimientoStockEntities() {
        return findMovimientoStockEntities(true, -1, -1);
    }

    public List<MovimientoStock> findMovimientoStockEntities(int maxResults, int firstResult) {
        return findMovimientoStockEntities(false, maxResults, firstResult);
    }

    private List<MovimientoStock> findMovimientoStockEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MovimientoStock.class));
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

    public MovimientoStock findMovimientoStock(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MovimientoStock.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovimientoStockCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MovimientoStock> rt = cq.from(MovimientoStock.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
