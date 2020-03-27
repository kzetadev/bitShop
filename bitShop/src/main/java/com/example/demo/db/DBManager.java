package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.GoodsVo;

public class DBManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static List<GoodsVo> listGoods(){
		SqlSession session = factory.openSession();
		List<GoodsVo> list = session.selectList("goods.selectAll");
		session.close();
		return list;
	}
	public static int insertGoods(GoodsVo g) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.insert("goods.insert", g);
		session.close();
		return re;
	}
	public static int deleteGoods(GoodsVo g) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.delete("goods.delete", g);
		session.close();
		return re;
	}
	public static int updateGoods(GoodsVo g) {
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("goods.update", g);
		session.close();
		return re;
	}
	public static GoodsVo getGoods(GoodsVo g) {
		SqlSession session = factory.openSession(true);
		GoodsVo goods = session.selectOne("goods.select", g);
		session.close();
		return goods;
	}
	
}
