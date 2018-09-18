package cn.itcast.shop.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.model.User;
import cn.itcast.shop.utils.PageHibernateCallback;

/**
 * �û�ģ��־ò����:
 * 
 * @author LC
 *
 */
public class UserDao extends HibernateDaoSupport {

	// �����β�ѯ�Ƿ��и��û�:
	public User findByUsername(String username) {
		String hql = "from User where username = ?";
		List<User> list = this.getHibernateTemplate().find(hql, username);
		System.out.println(list);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// ע���û��������ݿ����ʵ��
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	// ���ݼ������ѯ�û�
	public User findByCode(String code) {
		String hql = "from User where code = ?";
		List<User> list = this.getHibernateTemplate().find(hql, code);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// �޸��û�״̬�ķ���
	public void update(User existUser) {
		this.getHibernateTemplate().update(existUser);
	}

	// �û���¼�ķ���
	public User login(User user) {
		//��֤�û��������롢����״̬
		String hql = "from User where username = ? and password = ? and state = ?";
		List<User> list = this.getHibernateTemplate().find(hql,
				user.getUsername(), user.getPassword(), 1);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	////////��̨����/////////////
	// ��̨ͳ��user�����ķ���
		public int findCount() {
			String hql = "select count(*) from User";
			List<Long> list = this.getHibernateTemplate().find(hql);
			if (list != null && list.size() > 0) {
				return list.get(0).intValue();
			}
			return 0;
		}

		// ��̨��ѯ����user�ķ���
		public List<User> findByPage(int begin, int limit) {
			String hql = "from User";
			List<User> list = this.getHibernateTemplate().execute(
					new PageHibernateCallback<User>(hql, null, begin, limit));
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		}
		// DAO�е�ɾ����Ʒ�ķ���
		public void delete(User user) {
			this.getHibernateTemplate().delete(user);
		}
		// ������ƷID��ѯ��Ʒ
		public User findByUid(Integer uid) {
			return this.getHibernateTemplate().get(User.class, uid);
		}
}
