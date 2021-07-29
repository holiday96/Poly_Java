package com.java4.controller.lab.lab6.service;

import java.util.ArrayList;
import java.util.List;

import com.java4.controller.lab.lab6.converter.FavoriteConverter;
import com.java4.controller.lab.lab6.dto.FavoriteDTO;
import com.java4.controller.lab.lab6.entity.FavoriteeEntity;
import com.java4.controller.lab.lab6.repository.FavoriteRepository;

public class FavoriteService {

	private FavoriteRepository favoriteRepository = new FavoriteRepository();
	
	public List<FavoriteDTO> findAll() {
		List<FavoriteDTO> list = new ArrayList<FavoriteDTO>();
		for (FavoriteeEntity i : favoriteRepository.findAll()) {
			list.add(FavoriteConverter.toDto(i));
		}
		return list;
	}
}
