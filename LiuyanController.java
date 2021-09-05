package com.hp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hp.entity.Liuyan;
import com.hp.service.LiuyanService;

@Controller
@RequestMapping("/liuyan")
public class LiuyanController {
@Autowired
	private LiuyanService liuyanService;
	@RequestMapping("/add")
	public String add(Liuyan liuyan){
		int i = liuyanService.add(liuyan);
		if(i>0){
			System.out.println("添加成功");
			return "redirect:/liuyan/selectAll";
		}else{
			System.out.println("添加失败");
			return "select";
		}
	}
	@RequestMapping("/selectAll")
	public String selectAll(HttpSession session){
		ArrayList<Liuyan> liuyans = liuyanService.selectAll();
		session.setAttribute("liuyans", liuyans);
		return "select";
	}
}
