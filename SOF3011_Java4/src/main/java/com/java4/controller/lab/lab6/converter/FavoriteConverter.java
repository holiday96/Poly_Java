package com.java4.controller.lab.lab6.converter;

import com.java4.controller.lab.lab6.dto.FavoriteDTO;
import com.java4.controller.lab.lab6.entity.FavoriteeEntity;

public class FavoriteConverter {

	public static FavoriteDTO toDto(FavoriteeEntity entity) {
		FavoriteDTO result = new FavoriteDTO();
		result.setId(entity.getId());
		result.setVideo(entity.getVideo().getId());
		result.setUser(entity.getUser().getId());
		result.setLikedate(entity.getLikedate());
		return result;
	}
}
