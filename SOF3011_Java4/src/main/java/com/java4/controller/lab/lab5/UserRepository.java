package com.java4.controller.lab.lab5;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.java4.controller.lab.lab6.entity.UserrEntity;

public class UserRepository {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-data");

	public String save(UserrEntity entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		String id = null;
		try {
			et = em.getTransaction();
			et.begin();

			em.persist(entity);
			et.commit();

			id = em.find(UserrEntity.class, entity.getId()).getId();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		return id;
	}

	public void update(UserrEntity entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();

			em.merge(entity);
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public void delete(String id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();

			em.remove(em.find(UserrEntity.class, id));
			et.commit();
		} catch (Exception e) {
			if (et != null) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public List<UserrEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT u FROM UserEntity u";

		TypedQuery<UserrEntity> tq = em.createQuery(query, UserrEntity.class);
		List<UserrEntity> list = new ArrayList<UserrEntity>();
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

	public List<UserrEntity> findByRole(boolean role) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT u FROM UserEntity u WHERE u.admin=:role";

		TypedQuery<UserrEntity> tq = em.createQuery(query, UserrEntity.class);
		List<UserrEntity> list = new ArrayList<UserrEntity>();
		tq.setParameter("role", role);
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

	public List<UserrEntity> findByName(String fullname) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT U FROM UserEntity U WHERE U.fullname LIKE?0";

		TypedQuery<UserrEntity> tq = em.createQuery(query, UserrEntity.class);
		List<UserrEntity> list = new ArrayList<UserrEntity>();
		tq.setParameter(0, fullname);
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

	public UserrEntity findOne(String username, String password) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT U FROM UserEntity U WHERE U.id=:id AND U.password=:password";

		TypedQuery<UserrEntity> tq = em.createQuery(query, UserrEntity.class);
		tq.setParameter("id", username);
		tq.setParameter("password", password);
		UserrEntity user = null;
		try {
			user = tq.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}

	public UserrEntity findById(String id) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT U FROM UserEntity U WHERE U.id=:id";

		TypedQuery<UserrEntity> tq = em.createQuery(query, UserrEntity.class);
		tq.setParameter("id", id);
		UserrEntity user = null;
		try {
			user = tq.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}
	
	public UserrEntity findByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT U FROM UserEntity U WHERE U.email=:email";

		TypedQuery<UserrEntity> tq = em.createQuery(query, UserrEntity.class);
		tq.setParameter("email", email);
		UserrEntity user = null;
		try {
			user = tq.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}

	public List<UserrEntity> findPage(int page, int size) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT U FROM UserEntity U";

		TypedQuery<UserrEntity> tq = em.createQuery(query, UserrEntity.class);
		List<UserrEntity> list = new ArrayList<UserrEntity>();
		tq.setFirstResult((page - 1) * size);
		tq.setMaxResults(size);
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}
}
