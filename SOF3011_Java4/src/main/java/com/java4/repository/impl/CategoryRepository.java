package com.java4.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.java4.entity.CategoryEntity;
import com.java4.repository.ICategoryRepository;

public class CategoryRepository implements ICategoryRepository {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-data-asm");

	@Override
	public List<CategoryEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT t FROM CategoryEntity t";

		TypedQuery<CategoryEntity> tq = em.createQuery(query, CategoryEntity.class);
		List<CategoryEntity> list = new ArrayList<CategoryEntity>();
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
	public Long save(CategoryEntity entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		Long id = null;
		try {
			et = em.getTransaction();
			et.begin();

			em.persist(entity);
			et.commit();

			id = em.find(CategoryEntity.class, entity.getId()).getId();
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
	public CategoryEntity findOne(Long id) {
		EntityManager em = emf.createEntityManager();
		CategoryEntity entity = new CategoryEntity();
		try {
			entity = em.find(CategoryEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return entity;
	}

	@Override
	public void update(CategoryEntity entity) {
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

			em.remove(em.find(CategoryEntity.class, id));
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
	public List<CategoryEntity> findByIds(String ids) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT t FROM CategoryEntity t WHERE t.id IN (:ids)";

		TypedQuery<CategoryEntity> tq = em.createQuery(query, CategoryEntity.class);
		tq.setParameter("ids", ids);
		List<CategoryEntity> list = new ArrayList<CategoryEntity>();
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
