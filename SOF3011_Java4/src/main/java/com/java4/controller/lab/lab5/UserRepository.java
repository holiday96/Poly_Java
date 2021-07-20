package com.java4.controller.lab.lab5;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class UserRepository {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-data");

	public String save(UserEntity entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		String id = null;
		try {
			et = em.getTransaction();
			et.begin();

			em.persist(entity);
			et.commit();

			id = em.find(UserEntity.class, entity.getId()).getId();
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

	public void update(UserEntity entity) {
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

			em.remove(em.find(UserEntity.class, id));
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

	public List<UserEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT u FROM UserEntity u";

		TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
		List<UserEntity> list = new ArrayList<UserEntity>();
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

	public List<UserEntity> findByRole(boolean role) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT u FROM UserEntity u WHERE u.admin=:role";

		TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
		List<UserEntity> list = new ArrayList<UserEntity>();
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

	public List<UserEntity> findByName(String fullname) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT U FROM UserEntity U WHERE U.fullname LIKE?0";

		TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
		List<UserEntity> list = new ArrayList<UserEntity>();
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

	public UserEntity findOne(String username, String password) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT U FROM UserEntity U WHERE U.id=:id AND U.password=:password";

		TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
		tq.setParameter("id", username);
		tq.setParameter("password", password);
		UserEntity user = null;
		try {
			user = tq.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}

	public UserEntity findById(String id) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT U FROM UserEntity U WHERE U.id=:id";

		TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
		tq.setParameter("id", id);
		UserEntity user = null;
		try {
			user = tq.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}
	
	public UserEntity findByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT U FROM UserEntity U WHERE U.email=:email";

		TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
		tq.setParameter("email", email);
		UserEntity user = null;
		try {
			user = tq.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}

	public List<UserEntity> findPage(int page, int size) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT U FROM UserEntity U";

		TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
		List<UserEntity> list = new ArrayList<UserEntity>();
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
