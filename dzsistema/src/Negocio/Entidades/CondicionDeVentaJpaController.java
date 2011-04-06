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
public class CondicionDeVentaJpaController {

    public CondicionDeVentaJpaController() {
        emf = Persistence.createEntityManagerFactory("dzsistemaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CondicionDeVenta condicionDeVenta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(condicionDeVenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CondicionDeVenta condicionDeVenta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            condicionDeVenta = em.merge(condicionDeVenta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = condicionDeVenta.getId();
                if (findCondicionDeVenta(id) == null) {
                    throw new NonexistentEntityException("The condicionDeVenta with id " + id + " no longer exists.");
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
            CondicionDeVenta condicionDeVenta;
            try {
                condicionDeVenta = em.getReference(CondicionDeVenta.class, id);
                condicionDeVenta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The condicionDeVenta with id " + id + " no longer exists.", enfe);
            }
            em.remove(condicionDeVenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CondicionDeVenta> findCondicionDeVentaEntities() {
        return findCondicionDeVentaEntities(true, -1, -1);
    }

    public List<CondicionDeVenta> findCondicionDeVentaEntities(int maxResults, int firstResult) {
        return findCondicionDeVentaEntities(false, maxResults, firstResult);
    }

    private List<CondicionDeVenta> findCondicionDeVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CondicionDeVenta.class));
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

    public CondicionDeVenta findCondicionDeVenta(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CondicionDeVenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getCondicionDeVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CondicionDeVenta> rt = cq.from(CondicionDeVenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
