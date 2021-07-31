package com.java4.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.java4.entity.EpisodeEntity;
import com.java4.repository.IEpisodeRepository;

public class EpisodeRepository implements IEpisodeRepository {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-data-asm");

	@Override
	public List<EpisodeEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT t FROM EpisodeEntity t";

		TypedQuery<EpisodeEntity> tq = em.createQuery(query, EpisodeEntity.class);
		List<EpisodeEntity> list = new ArrayList<EpisodeEntity>();
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
	public Long save(EpisodeEntity entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		Long id = null;
		try {
			et = em.getTransaction();
			et.begin();

			em.persist(entity);
			et.commit();

			id = em.find(EpisodeEntity.class, entity.getId()).getId();
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
	public EpisodeEntity findOne(Long id) {
		EntityManager em = emf.createEntityManager();
		EpisodeEntity entity = new EpisodeEntity();
		try {
			entity = em.find(EpisodeEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return entity;
	}

	@Override
	public void update(EpisodeEntity entity) {
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

			em.remove(em.find(EpisodeEntity.class, id));
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
}
