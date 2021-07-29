package com.java4.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.java4.entity.ThemeEntity;
import com.java4.repository.IThemeRepository;

public class ThemeRepository implements IThemeRepository {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-data-asm");

	@Override
	public List<ThemeEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT t FROM ThemeEntity t";

		TypedQuery<ThemeEntity> tq = em.createQuery(query, ThemeEntity.class);
		List<ThemeEntity> list = new ArrayList<ThemeEntity>();
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
	public Long save(ThemeEntity entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		Long id = null;
		try {
			et = em.getTransaction();
			et.begin();

			em.persist(entity);
			et.commit();

			id = em.find(ThemeEntity.class, entity.getId()).getId();
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
	public ThemeEntity findOne(Long id) {
		EntityManager em = emf.createEntityManager();
		ThemeEntity entity = new ThemeEntity();
		try {
			entity = em.find(ThemeEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return entity;
	}

}
