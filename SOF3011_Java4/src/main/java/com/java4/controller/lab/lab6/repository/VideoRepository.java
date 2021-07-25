package com.java4.controller.lab.lab6.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.java4.controller.lab.lab6.entity.VideoEntity;

public class VideoRepository {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-data");

	public String save(VideoEntity entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		String id = null;
		try {
			et = em.getTransaction();
			et.begin();

			em.persist(entity);
			et.commit();

			id = em.find(VideoEntity.class, entity.getId()).getId();
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

	public void update(VideoEntity entity) {
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

			em.remove(em.find(VideoEntity.class, id));
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

	public List<VideoEntity> findAll() {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT v FROM VideoEntity v";

		TypedQuery<VideoEntity> tq = em.createQuery(query, VideoEntity.class);
		List<VideoEntity> list = new ArrayList<VideoEntity>();
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}
	
	public List<VideoEntity> findAllByFavor() {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT f.video FROM FavoriteEntity f";

		TypedQuery<VideoEntity> tq = em.createQuery(query, VideoEntity.class);
		List<VideoEntity> list = new ArrayList<VideoEntity>();
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

	public VideoEntity findById(String id) {
		EntityManager em = emf.createEntityManager();
		VideoEntity user = null;
		try {
			user = em.find(VideoEntity.class, "id");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}

	public List<VideoEntity> findByUser(String user) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT f.video FROM FavoriteEntity f WHERE f.user.id=:uid";

		TypedQuery<VideoEntity> tq = em.createQuery(query, VideoEntity.class);
		tq.setParameter("uid", user);
		List<VideoEntity> list = null;
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

	public List<VideoEntity> findByKeyword(String keyword) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT DISTINCT f.video FROM FavoriteEntity f WHERE f.video.title LIKE :keyword";

		TypedQuery<VideoEntity> tq = em.createQuery(query, VideoEntity.class);
		tq.setParameter("keyword", "%" + keyword + "%");
		List<VideoEntity> list = null;
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}
	
	public List<VideoEntity> findAllNotLike() {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT v FROM VideoEntity v WHERE v.favorites IS EMPTY";

		TypedQuery<VideoEntity> tq = em.createQuery(query, VideoEntity.class);
		List<VideoEntity> list = null;
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}
	
	public List<VideoEntity> findAllLike() {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT v FROM VideoEntity v WHERE v.favorites IS NOT EMPTY";

		TypedQuery<VideoEntity> tq = em.createQuery(query, VideoEntity.class);
		List<VideoEntity> list = null;
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}
	
	public List<VideoEntity> findRangeLikeDate(Date minDate, Date maxDate) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT f.video FROM FavoriteEntity f WHERE f.likeDate BETWEEN :minDate AND :maxDate";

		TypedQuery<VideoEntity> tq = em.createQuery(query, VideoEntity.class);
		tq.setParameter("minDate", minDate);
		tq.setParameter("maxDate", maxDate);
		List<VideoEntity> list = null;
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}
	
	public List<VideoEntity> findFavorByMonth(List<Integer> ints) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT DISTINCT f.video FROM FavoriteEntity f WHERE month(f.likeDate) IN (:months)";

		TypedQuery<VideoEntity> tq = em.createQuery(query, VideoEntity.class);
		tq.setParameter("months", ints);
		List<VideoEntity> list = null;
		try {
			list = tq.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}
	
	public List<VideoEntity> random10() {
		EntityManager em = emf.createEntityManager();

		TypedQuery<VideoEntity> tq = em.createNamedQuery("Report.random10", VideoEntity.class);
		List<VideoEntity> list = new ArrayList<VideoEntity>();
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
