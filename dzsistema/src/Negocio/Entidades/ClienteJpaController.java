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
public class ClienteJpaController {

    public ClienteJpaController() {
        emf = Persistence.createEntityManagerFactory("dzsistemaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cliente = em.merge(cliente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cliente.getId();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Cliente> buscarPorCUIT(String CUIT) {
        EntityManager em = getEntityManager();
        List<Cliente> encontrados;
        encontrados = em.createQuery("SELECT a FROM Cliente a WHERE a.CUIT = '"+CUIT+"' and a.estado = true ").getResultList();
        return encontrados;
    }

    public List<Cliente> buscarDeAlta() {
        EntityManager em = getEntityManager();
        List<Cliente> encontrados;
        encontrados = em.createQuery("SELECT a FROM Cliente a WHERE a.estado = true").getResultList();
        return encontrados;
    }

    public List<Cliente> buscarPorCodigo(String codigo) {
        EntityManager em = getEntityManager();
        List<Cliente> encontrados;
        encontrados = em.createQuery("SELECT a FROM Cliente a WHERE a.codigo = '"+codigo+"' and a.estado = true ").getResultList();
        return encontrados;
    }

    public List<Cliente> buscarPorNombre(String nombre) {
        EntityManager em = getEntityManager();
        List<Cliente> encontrados;
        encontrados = em.createQuery("SELECT a FROM Cliente a WHERE a.nombre = '"+nombre+"' and a.estado = true ").getResultList();
        return encontrados;
    }

    public Object buscarUltimoCodigo() {
        EntityManager em = getEntityManager();
        Object resultado;
        resultado = em.createQuery("SELECT max(a.codigo) FROM Cliente a ").getSingleResult();
        return resultado;
    }


    public List<Cliente> buscarPorParteDelNombre(String nombre) {
        EntityManager em = getEntityManager();
        List<Cliente> encontrados;
        encontrados = em.createQuery("SELECT a FROM Cliente a WHERE a.nombre LIKE '%"+nombre+"%' and a.estado = true ").getResultList();
        return encontrados;
    }

}
