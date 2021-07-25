package com.java4.controller.lab.lab6.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.java4.controller.lab.lab6.converter.VideoConverter;
import com.java4.controller.lab.lab6.dto.VideoDTO;
import com.java4.controller.lab.lab6.entity.VideoEntity;
import com.java4.controller.lab.lab6.repository.VideoRepository;

public class VideoService {
	
	private VideoRepository videoRepository = new VideoRepository();
	
	public List<VideoDTO> findAll(){
		List<VideoDTO> list = new ArrayList<VideoDTO>();
		for (VideoEntity i : videoRepository.findAll()) {
			list.add(VideoConverter.toDto(i));
		}
		return list;
	}
	
	public List<VideoDTO> findAllByFavor() {
		List<VideoDTO> list = new ArrayList<VideoDTO>();
		for (VideoEntity i : videoRepository.findAllByFavor()) {
			list.add(VideoConverter.toDto(i));
		}
		return list;
	}
	
	public List<VideoDTO> findByUser(String user) {
		List<VideoDTO> list = new ArrayList<>();
		for (VideoEntity i : videoRepository.findByUser(user)) {
			list.add(VideoConverter.toDto(i));
		}
		return list;
	}
	
	public List<VideoDTO> findByKeyword(String keyword) {
		List<VideoDTO> list = new ArrayList<>();
		for (VideoEntity i : videoRepository.findByKeyword(keyword)) {
			list.add(VideoConverter.toDto(i));
		}
		return list;
	}
	
	public List<VideoDTO> findAllNotLike() {
		List<VideoDTO> list = new ArrayList<>();
		for (VideoEntity i : videoRepository.findAllNotLike()) {
			list.add(VideoConverter.toDto(i));
		}
		return list;
	}
	
	public List<VideoDTO> findAllLike() {
		List<VideoDTO> list = new ArrayList<>();
		for (VideoEntity i : videoRepository.findAllLike()) {
			list.add(VideoConverter.toDto(i));
		}
		return list;
	}
	
	public List<VideoDTO> findRangeLikeDate(Date minDate, Date maxDate) {
		List<VideoDTO> list = new ArrayList<>();
		for (VideoEntity i : videoRepository.findRangeLikeDate(minDate, maxDate)) {
			list.add(VideoConverter.toDto(i));
		}
		return list;
	}
	
	public List<VideoDTO> findFavorByMonth(List<Integer> ints) {
		List<VideoDTO> list = new ArrayList<>();
		for (VideoEntity i : videoRepository.findFavorByMonth(ints)) {
			list.add(VideoConverter.toDto(i));
		}
		return list;
	}
	
	public List<VideoDTO> random10() {
		List<VideoDTO> list = new ArrayList<>();
		for (VideoEntity i : videoRepository.random10()) {
			list.add(VideoConverter.toDto(i));
		}
		return list;
	}
}
