package com.polyweb.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polyweb.constant.SystemConstant;
import com.polyweb.model.LoaiSanPhamModel;
import com.polyweb.model.SanPhamModel;
import com.polyweb.service.IAnhSanPhamService;
import com.polyweb.service.IChiTietSanPhamService;
import com.polyweb.service.ILoaiSanPhamService;
import com.polyweb.service.ISanPhamService;
import com.polyweb.service.impl.AnhSanPhamService;
import com.polyweb.service.impl.ChiTietSanPhamService;
import com.polyweb.service.impl.LoaiSanPhamService;
import com.polyweb.service.impl.SanPhamService;

@WebServlet(urlPatterns = { "/trang-chu", "/home-page" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = -4995370094396622869L;

	private ISanPhamService sanPhamService = new SanPhamService();
	private ILoaiSanPhamService loaiSanPhamService = new LoaiSanPhamService();
	private IChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
	private IAnhSanPhamService anhSanPhamService = new AnhSanPhamService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SanPhamModel model = new SanPhamModel();
		model.setListResult(sanPhamService.findAll());
		model.getListResult().forEach(e-> {
			e.setMinPrice(chiTietSanPhamService.findMinPriceByIdSanPham(e.getId()));
			e.setMaxPrice(chiTietSanPhamService.findMaxPriceByIdSanPham(e.getId()));
			e.setImages(anhSanPhamService.findByIdSP(e.getId()));
		});
		request.setAttribute(SystemConstant.MODEL, model);
		
		LoaiSanPhamModel loaiSanPhamModel = new LoaiSanPhamModel();
		loaiSanPhamModel.setListResult(loaiSanPhamService.findAll());
		request.setAttribute(SystemConstant.LOAI, loaiSanPhamModel);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}
}
