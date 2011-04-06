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
public class TipoFacturaJpaController {

    public TipoFacturaJpaController() {
        emf = Persistence.createEntityManagerFactory("dzsistemaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoFactura tipoFactura) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoFactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoFactura tipoFactura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoFactura = em.merge(tipoFactura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tipoFactura.getId();
                if (findTipoFactura(id) == null) {
                    throw new NonexistentEntityException("The tipoFactura with id " + id + " no longer exists.");
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
            TipoFactura tipoFactura;
            try {
                tipoFactura = em.getReference(TipoFactura.class, id);
                tipoFactura.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoFactura with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoFactura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoFactura> findTipoFacturaEntities() {
        return findTipoFacturaEntities(true, -1, -1);
    }

    public List<TipoFactura> findTipoFacturaEntities(int maxResults, int firstResult) {
        return findTipoFacturaEntities(false, maxResults, firstResult);
    }

    private List<TipoFactura> findTipoFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoFactura.class));
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

    public TipoFactura findTipoFactura(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoFactura.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoFactura> rt = cq.from(TipoFactura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
