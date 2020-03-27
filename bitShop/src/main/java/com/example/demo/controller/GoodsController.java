package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.GoodsDao;
import com.example.demo.vo.GoodsVo;
import com.google.gson.Gson;

@RestController
public class GoodsController {
	@Autowired
	private GoodsDao dao;
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	@RequestMapping(value="/goodsList", produces="application/json; charset=utf-8")
	public String goodsList() {
		return (new Gson()).toJson(dao.listGoods());
	}
	@RequestMapping(value="/getGoods", produces="application/json; charset=utf-8")
	public String getGoods(GoodsVo g) {
		return (new Gson()).toJson(dao.getGoods(g));
	}
	@RequestMapping("/insertGoods")
	public String insertGoods(GoodsVo g) {
		String str = "no";
		int re = dao.insertGoods(g);
		if(re > 0)
			str = "ok";
		return str;
	}
	@RequestMapping("/updateGoods")
	public String updateGoods(GoodsVo g) {
		String str = "no";
		int re = dao.updateGoods(g);
		if(re > 0)
			str = "ok";
		return str;
	}
	@RequestMapping("/deleteGoods")
	public String deleteGoods(GoodsVo g) {
		String str = "no";
		int re = dao.deleteGoods(g);
		if(re > 0)
			str = "ok";
		return str;
	}
}
