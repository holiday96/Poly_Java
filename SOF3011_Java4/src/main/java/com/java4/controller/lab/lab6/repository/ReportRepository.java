package com.java4.controller.lab.lab6.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.java4.controller.lab.lab6.entity.ReportEntity;

public class ReportRepository {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-data");

	public List<ReportEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		StringBuilder query = new StringBuilder("SELECT new ReportEntity(f.video.title, count(f), ");
		query.append("max(f.likeDate), min(f.likeDate)) ");
		query.append("FROM FavoriteEntity f ");
		query.append("GROUP BY f.video.title ");

		TypedQuery<ReportEntity> tq = em.createQuery(query.toString(), ReportEntity.class);
		List<ReportEntity> list = new ArrayList<>();
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}
	
	public List<ReportEntity> findFavorByYear(Integer year) {
		EntityManager em = emf.createEntityManager();
		
		StringBuilder query = new StringBuilder("SELECT new ReportEntity(f.video.title, count(f), ");
		query.append("max(f.likeDate), min(f.likeDate)) ");
		query.append("FROM FavoriteEntity f ");
		query.append("WHERE year(f.likeDate)=:year ");
		query.append("GROUP BY f.video.title ");

		TypedQuery<ReportEntity> tq = em.createQuery(query.toString(), ReportEntity.class);
		tq.setParameter("year", year);
		List<ReportEntity> list = null;
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
