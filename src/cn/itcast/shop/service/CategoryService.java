package cn.itcast.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.dao.CategoryDao;
import cn.itcast.shop.model.Category;

@Transactional
public class CategoryService {
	// ע��CategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	// ҵ����ѯ����һ������ķ���
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	// ҵ��㱣��һ������Ĳ���
	public void save(Category category) {
		categoryDao.save(category);
	}

	// ҵ������һ������id��ѯһ������
	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}

	// ҵ���ɾ��һ������
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	// ҵ����޸�һ������
	public void update(Category category) {
		categoryDao.update(category);
	}
}