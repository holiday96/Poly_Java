package com.java5.controller.lab.lab3;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lab/lab3")
public class Lab3Controller {

	@Autowired
	private ServletContext application;

	@GetMapping
	public ModelAndView showLab(Model model) {
		ModelAndView mav = new ModelAndView("lab3");
		model.addAttribute("student", new Student());
		return mav;
	}

	@PostMapping
	public ModelAndView method1(@Validated @ModelAttribute Student student, BindingResult result,
			@RequestParam(name = "photo") MultipartFile multipartFile) {
		ModelAndView mav = new ModelAndView("lab3");

		List<String> newHobbies = new ArrayList<>();
		if (!result.hasErrors()) {
			mav.addObject("message", "OK");
			for (String i : student.getHobbies()) {
				newHobbies.add(getHobbies().get(i));
			}
			student.setHobbies(newHobbies);

			if (!multipartFile.isEmpty()) {
				try {
					String path = application.getRealPath("/");
					String filePath = path + "/files/" + multipartFile.getOriginalFilename();
					multipartFile.transferTo(Path.of(filePath));
					student.setImage("/files/" + multipartFile.getOriginalFilename());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return mav;
	}

//	@ModelAttribute("genders")
//	public Map<Boolean, String> getGenders() {
//		Map<Boolean, String> genders = new HashMap<>();
//		genders.put(true, "Male");
//		genders.put(false, "Female");
//		return genders;
//	}

	@ModelAttribute("faculties")
	public List<String> getFaculties() {
		return Arrays.asList("Mathematic", "Biologie", "Physic");
	}

	@ModelAttribute("hobbies")
	public Map<String, String> getHobbies() {
		Map<String, String> map = new HashMap<>();
		map.put("T", "Travelling");
		map.put("M", "Music");
		map.put("F", "Food");
		map.put("O", "Other");
		return map;
	}

}
