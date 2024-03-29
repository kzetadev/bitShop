package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.GoodsVo;

@Repository
public class GoodsDao {
	public List<GoodsVo> listGoods(){
		return DBManager.listGoods();
	}
	public GoodsVo getGoods(GoodsVo g){
		return DBManager.getGoods(g);
	}
	public int insertGoods(GoodsVo g){
		return DBManager.insertGoods(g);
	}
	public int updateGoods(GoodsVo g){
		return DBManager.updateGoods(g);
	}
	public int deleteGoods(GoodsVo g){
		return DBManager.deleteGoods(g);
	}
}
