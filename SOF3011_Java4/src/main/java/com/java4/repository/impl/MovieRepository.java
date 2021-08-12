package com.java4.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.java4.entity.MovieEntity;
import com.java4.repository.IMovieRepository;

public class MovieRepository implements IMovieRepository {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-data-asm");

	@Override
	public List<MovieEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT t FROM MovieEntity t";

		TypedQuery<MovieEntity> tq = em.createQuery(query, MovieEntity.class);
		List<MovieEntity> list = new ArrayList<MovieEntity>();
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
	public Long save(MovieEntity entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		Long id = null;
		try {
			et = em.getTransaction();
			et.begin();

			em.persist(entity);
			et.commit();

			id = em.find(MovieEntity.class, entity.getId()).getId();
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
	public MovieEntity findOne(Long id) {
		EntityManager em = emf.createEntityManager();
		MovieEntity entity = new MovieEntity();
		try {
			entity = em.find(MovieEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return entity;
	}

	@Override
	public void update(MovieEntity entity) {
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

			em.remove(em.find(MovieEntity.class, id));
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
	public List<MovieEntity> findByTitle(String title) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT t FROM MovieEntity t WHERE t.title LIKE :title";

		TypedQuery<MovieEntity> tq = em.createQuery(query, MovieEntity.class);
		tq.setParameter("title", "%" + title + "%");
		List<MovieEntity> list = new ArrayList<MovieEntity>();
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
