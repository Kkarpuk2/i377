package dbNeljas;

import java.util.List;

import javax.persistence.*;

import model.Unit;
import util.JpaUtil;

public class Dao {

   private Dao() {} 

   public static void deleteAll() {

      EntityManager em = null;
      try {
         em = JpaUtil.getFactory().createEntityManager();
         em.getTransaction().begin();

         em.createQuery("DELETE FROM Unit").executeUpdate();

         em.getTransaction().commit();
      } finally {
         em.close();
      } 
   }
   public static List<Unit> getAllUnits() {
	      EntityManager em = null;
	      try {
	         em = JpaUtil.getFactory().createEntityManager();
	         em.getTransaction().begin();

	         TypedQuery<Unit> query = em.createQuery(
	               "SELECT p FROM Unit p", Unit.class);
	         return query.getResultList();
	      } finally {
	         em.close();
	      }
	   }
   public static void deleteUnitById(String id) {
      EntityManager em = null;
      try {
         em = JpaUtil.getFactory().createEntityManager();
         em.getTransaction().begin();

         Query query = em.createQuery(
               "DELETE FROM Unit u WHERE u.id = :id");
         query.setParameter("id", Long.parseLong(id)).executeUpdate();

         em.getTransaction().commit();
      } finally {
         em.close();
      } 
   }
   public static Unit findUnitById(String id) {
      EntityManager em = null;
      try {
         em = JpaUtil.getFactory().createEntityManager();
         em.getTransaction().begin();

         TypedQuery<Unit> query = em.createQuery(
               "SELECT p FROM Unit p WHERE p.id = :id", Unit.class);
         query.setParameter("id", Long.parseLong(id));
         return query.getSingleResult();
      } finally {
         em.close();
      } 
   }
   public static Unit findUnitById(Long id) {
	      EntityManager em = null;
	      try {
	         em = JpaUtil.getFactory().createEntityManager();
	         em.getTransaction().begin();

	         TypedQuery<Unit> query = em.createQuery(
	               "SELECT p FROM Unit p WHERE p.id = :id", Unit.class);
	         query.setParameter("id", id);
	         return query.getSingleResult();
	      } finally {
	         em.close();
	      } 
	   }
   public static void addItem(Unit unit) {
	      EntityManager em = null;
	      try {
	         em = JpaUtil.getFactory().createEntityManager();
	         em.getTransaction().begin();
	         em.persist(unit);
	         em.getTransaction().commit();
	      } finally {
	         em.close();
	      }
	   }
   public static void addItem(String name, String code, Long superUnitID) {
      EntityManager em = null;
      try {
         em = JpaUtil.getFactory().createEntityManager();
         em.getTransaction().begin();

         Unit item = new Unit();
         item.setName(name);
         item.setCode(code);
         item.setSuper_unit_id(superUnitID);

         em.persist(item);
         em.getTransaction().commit();
      } finally {
         em.close();
      }
   }
   public static List<Unit> searchByKeyword(String keyword) {
      EntityManager em = null;
      try {
         em = JpaUtil.getFactory().createEntityManager();
         em.getTransaction().begin();

         TypedQuery<Unit> query = em.createQuery(
               "SELECT p FROM Unit p WHERE LOWER(p.name) LIKE(:keyword)", Unit.class);
         query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");
         return query.getResultList();
      } finally {
         em.close();
      }
   }
   public static List<String> getSubUnitCodes(String id) {
      EntityManager em = null;
      try {
         em = JpaUtil.getFactory().createEntityManager();
         em.getTransaction().begin();

         TypedQuery<String> query = em.createQuery(
               "SELECT p.code FROM Unit p WHERE p.super_unit_id = :id", String.class);
         query.setParameter("id", Long.parseLong(id));
         return query.getResultList();
      } finally {
         em.close();
      }
   }

   public static List<String> getAllDistinctUnitNames() {
      EntityManager em = null;
      try {
         em = JpaUtil.getFactory().createEntityManager();
         em.getTransaction().begin();

         TypedQuery<String> query = em.createQuery(
               "SELECT DISTINCT p.name FROM Unit p", String.class);
         return query.getResultList();
      } finally {
         em.close();
      }
   }
}