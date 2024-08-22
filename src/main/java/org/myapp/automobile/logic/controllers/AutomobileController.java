package org.myapp.automobile.logic.controllers;

import org.myapp.automobile.logic.Automovil;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class AutomobileController {
    private EntityManagerFactory emf = null;

    public AutomobileController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    //! Estable la Conexión a la Base de Datos: Usando la configuración en persistence.xml
    public AutomobileController() {
        this.emf = Persistence.createEntityManagerFactory("myUnity");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Automovil auto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(auto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Automovil auto) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            auto = em.merge(auto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAutomovil(auto.getId_Automovil()) == null) {
                throw new EntityNotFoundException("The student with id " + auto.getId_Automovil() + " no longer exists.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws EntityNotFoundException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Automovil auto;
            try {
                auto = em.getReference(Automovil.class, id);
                auto.getId_Automovil();
            } catch (EntityNotFoundException enfe) {
                throw new EntityNotFoundException("The Automobile with id " + id + " no longer exists.");
            }
            em.remove(auto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Automovil findAutomovil(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Automovil.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Automovil> findAutomovilEntities() {
        return findAutomovilEntities(true, -1, -1);
    }

    public List<Automovil> findStudentEntities(int maxResults, int firstResult) {
        return findAutomovilEntities(false, maxResults, firstResult);
    }

    private List<Automovil> findAutomovilEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery<Automovil> cq = em.getCriteriaBuilder().createQuery(Automovil.class);
            cq.select(cq.from(Automovil.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

//    public int getStudentCount() {
//        EntityManager em = getEntityManager();
//        try {
//            CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
//            Root<Student> rt = cq.from(Student.class);
//            cq.select(em.getCriteriaBuilder().count(rt));
//            Query q = em.createQuery(cq);
//            return ((Long) q.getSingleResult()).intValue();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
//        }
//    }
}
