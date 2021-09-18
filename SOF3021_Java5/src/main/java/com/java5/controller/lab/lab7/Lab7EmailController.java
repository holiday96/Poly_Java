package com.java5.controller.lab.lab7;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.java5.controller.lab.lab4.part1.ParamService;

@Controller
public class Lab7EmailController {

	@Autowired
	private ParamService paramService;

	@Autowired
	private MailerService mailer;

	@GetMapping(path = { "/lab/lab7", "/lab/lab7/email" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("lab7email");
		return mav;
	}

	@PostMapping("/lab/lab7/email")
	public ModelAndView sendEmail(MailInfo mail,
			@RequestParam(name = "attachments", required = false) MultipartFile[] multipartFile) {
		ModelAndView mav = new ModelAndView("lab7email");
		List<String> paths = new ArrayList<>();
		if (multipartFile.length != 0) {
			Arrays.asList(multipartFile).stream().forEach(e -> {
				File file = paramService.save(e, "/files");
				if (file != null) {
					paths.add(file.getAbsolutePath());
				}
			});
			mail.setPaths(paths);
		}
		mailer.queue(mail);
		mav.addObject("message", "Please patient! Your Email will be sent in seconds!");
		return mav;
	}
}
