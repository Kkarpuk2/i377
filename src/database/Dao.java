package database;

import java.util.List;

import javax.persistence.*;

import model.Unit;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class Dao {

   @PersistenceContext
   private EntityManager em;

   @Transactional
   public void deleteAll() {
      em.createQuery("DELETE FROM Unit").executeUpdate();
   }

   @Transactional
   public void deleteUnitByCode(String code) {
      Query query = em.createQuery("DELETE FROM Unit u WHERE u.code = :code");
      query.setParameter("code", code).executeUpdate();
   }

   @Transactional
   public Unit findUnitByCode(String code) {
      TypedQuery<Unit> query = em.createQuery(
            "SELECT p FROM Unit p WHERE p.code = :code", Unit.class);
      query.setParameter("code", code);
      return query.getSingleResult();
   }

   @Transactional
   public Unit findUnitById(Long id) {
      TypedQuery<Unit> query = em.createQuery(
            "SELECT p FROM Unit p WHERE p.id = :id", Unit.class);
      query.setParameter("id", id);
      return query.getSingleResult();
   }

   @Transactional
   public void addItem(Unit unit) {
      em.persist(unit);
   }

   @Transactional
   public List<Unit> search(String keyword) {
      TypedQuery<Unit> query = em.createQuery(
            "SELECT p FROM Unit p WHERE LOWER(p.name) LIKE(:keyword)",
            Unit.class);
      query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");
      return query.getResultList();
   }

   @Transactional
   public List<String> getSubUnitCodes(String id) {
      TypedQuery<String> query = em.createQuery(
            "SELECT p.code FROM Unit p WHERE p.super_unit_id = :id",
            String.class);
      query.setParameter("id", Long.parseLong(id));
      return query.getResultList();
   }

   @Transactional
   public List<Unit> findAllUnits() {
      return em.createQuery("SELECT p FROM Unit p", Unit.class).getResultList();
   }
}