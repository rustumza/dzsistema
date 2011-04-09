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
public class CondicionFrenteAlIvaJpaController {

    public CondicionFrenteAlIvaJpaController() {
        emf = Persistence.createEntityManagerFactory("dzsistemaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CondicionFrenteAlIva condicionFrenteAlIva) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(condicionFrenteAlIva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CondicionFrenteAlIva condicionFrenteAlIva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            condicionFrenteAlIva = em.merge(condicionFrenteAlIva);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = condicionFrenteAlIva.getId();
                if (findCondicionFrenteAlIva(id) == null) {
                    throw new NonexistentEntityException("The condicionFrenteAlIva with id " + id + " no longer exists.");
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
            CondicionFrenteAlIva condicionFrenteAlIva;
            try {
                condicionFrenteAlIva = em.getReference(CondicionFrenteAlIva.class, id);
                condicionFrenteAlIva.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The condicionFrenteAlIva with id " + id + " no longer exists.", enfe);
            }
            em.remove(condicionFrenteAlIva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CondicionFrenteAlIva> findCondicionFrenteAlIvaEntities() {
        return findCondicionFrenteAlIvaEntities(true, -1, -1);
    }

    public List<CondicionFrenteAlIva> findCondicionFrenteAlIvaEntities(int maxResults, int firstResult) {
        return findCondicionFrenteAlIvaEntities(false, maxResults, firstResult);
    }

    private List<CondicionFrenteAlIva> findCondicionFrenteAlIvaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CondicionFrenteAlIva.class));
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

    public CondicionFrenteAlIva findCondicionFrenteAlIva(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CondicionFrenteAlIva.class, id);
        } finally {
            em.close();
        }
    }

    public int getCondicionFrenteAlIvaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CondicionFrenteAlIva> rt = cq.from(CondicionFrenteAlIva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public CondicionFrenteAlIva buscarPorNombre(String nombre) {
        EntityManager em = getEntityManager();
        CondicionFrenteAlIva encontrado;
        encontrado = (CondicionFrenteAlIva) em.createQuery("SELECT a FROM CondicionFrenteAlIva a WHERE a.nombre = '"+nombre+"'").getSingleResult();
        return encontrado;
    }

}
