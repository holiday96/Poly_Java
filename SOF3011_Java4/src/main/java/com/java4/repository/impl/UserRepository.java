package com.java4.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.java4.entity.UserEntity;
import com.java4.repository.IUserRepository;

public class UserRepository implements IUserRepository {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-data-asm");

	@Override
	public List<UserEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT t FROM UserEntity t";

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

	@Override
	public Long save(UserEntity entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		Long id = null;
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

	@Override
	public UserEntity findOne(Long id) {
		EntityManager em = emf.createEntityManager();
		UserEntity entity = new UserEntity();
		try {
			entity = em.find(UserEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return entity;
	}

	@Override
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

	@Override
	public void delete(Long id) {
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

	@Override
	public boolean findByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT u FROM UserEntity u WHERE u.email IN (:email)";

		TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
		tq.setParameter("email", email);
		try {
			UserEntity user = tq.getSingleResult();
			if (user != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public boolean findByUsername(String username) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT u FROM UserEntity u WHERE u.username IN (:username)";

		TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
		tq.setParameter("username", username);
		try {
			UserEntity user = tq.getSingleResult();
			if (user != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return false;
	}

	@Override
	public UserEntity findByUserLogin(String username, String password) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT u FROM UserEntity u WHERE u.username=:username AND u.password=:password";

		UserEntity user = new UserEntity();
		TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
		tq.setParameter("username", username);
		tq.setParameter("password", password);
		try {
			user = tq.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}

	@Override
	public UserEntity findByVerify(String verify) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT u FROM UserEntity u WHERE u.verify=:verify";

		UserEntity user = new UserEntity();
		TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
		tq.setParameter("verify", verify);
		try {
			user = tq.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}

	@Override
	public UserEntity findUserByEmail(String email) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT u FROM UserEntity u WHERE u.email IN (:email)";

		TypedQuery<UserEntity> tq = em.createQuery(query, UserEntity.class);
		tq.setParameter("email", email);
		UserEntity user = new UserEntity();
		try {
			user = tq.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}

}
