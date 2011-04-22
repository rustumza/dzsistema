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
public class NumeradorJpaController {

    public NumeradorJpaController() {
        emf = Persistence.createEntityManagerFactory("dzsistemaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Numerador numerador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(numerador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Numerador numerador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            numerador = em.merge(numerador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = numerador.getId();
                if (findNumerador(id) == null) {
                    throw new NonexistentEntityException("The numerador with id " + id + " no longer exists.");
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
            Numerador numerador;
            try {
                numerador = em.getReference(Numerador.class, id);
                numerador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The numerador with id " + id + " no longer exists.", enfe);
            }
            em.remove(numerador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Numerador> findNumeradorEntities() {
        return findNumeradorEntities(true, -1, -1);
    }

    public List<Numerador> findNumeradorEntities(int maxResults, int firstResult) {
        return findNumeradorEntities(false, maxResults, firstResult);
    }

    private List<Numerador> findNumeradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Numerador.class));
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

    public Numerador findNumerador(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Numerador.class, id);
        } finally {
            em.close();
        }
    }

    public int getNumeradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Numerador> rt = cq.from(Numerador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Numerador buscarNumerador() {
        EntityManager em = getEntityManager();
        List<Numerador> encontrados;
        encontrados = em.createQuery("SELECT a FROM Numerador a ").getResultList();
        Numerador encont = encontrados.get(0);
        return encont;
    }


}
