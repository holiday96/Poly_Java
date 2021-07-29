package com.java4.controller.lab.lab6.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.java4.controller.lab.lab6.entity.FavoriteeEntity;

public class FavoriteRepository {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-data");

	public List<FavoriteeEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT f FROM FavoriteEntity f";

		TypedQuery<FavoriteeEntity> tq = em.createQuery(query, FavoriteeEntity.class);
		List<FavoriteeEntity> list = new ArrayList<FavoriteeEntity>();
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
