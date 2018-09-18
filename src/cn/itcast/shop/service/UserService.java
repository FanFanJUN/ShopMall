package cn.itcast.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.dao.UserDao;
import cn.itcast.shop.model.User;
import cn.itcast.shop.utils.MailUitls;
import cn.itcast.shop.utils.PageBean;
import cn.itcast.shop.utils.UUIDUtils;

/**
 * �û���ģ��ҵ������
 * 
 * @author LC
 *
 */
@Transactional
public class UserService {
	// ע��UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// ���û�����ѯ�û��ķ���:
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	// ҵ�������û�ע�����:
	public void save(User user) {
		// �����ݴ��뵽���ݿ�
		user.setState(0); // 0:�����û�δ����. 1:�����û��Ѿ�����.
		String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		// ���ͼ����ʼ�;
		MailUitls.sendMail(user.getEmail(), code);
	}

	// ҵ�����ݼ������ѯ�û�
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	// �޸��û���״̬�ķ���
	public void update(User existUser) {
		userDao.update(existUser);
	}

	// �û���¼�ķ���
	public User login(User user) {
		return userDao.login(user);
	}
	// //////��̨����Ա////////////////////////////
		// ��̨��ѯ����user����ҳ
		public PageBean<User> findByPage(Integer page) {
			PageBean<User> pageBean = new PageBean<User>();
			// ���õ�ǰҳ��:
			pageBean.setPage(page);
			// ����ÿҳ��ʾ��¼��:
			int limit = 10;
			pageBean.setLimit(limit);
			// �����ܼ�¼��:
			int totalCount = 0;
			totalCount = userDao.findCount();
			pageBean.setTotalCount(totalCount);
			// ������ҳ��:
			int totalPage = 0;
			// Math.ceil(totalCount / limit);
			if (totalCount % limit == 0) {
				totalPage = totalCount / limit;
			} else {
				totalPage = totalCount / limit + 1;
			}
			pageBean.setTotalPage(totalPage);
			// ÿҳ��ʾ�����ݼ���:
			// ���Ŀ�ʼ:
			int begin = (page - 1) * limit;
			List<User> list = userDao.findByPage(begin, limit);
			pageBean.setList(list);
			return pageBean;
		}
		// ҵ��㱣��user����:
		public void saveUser(User user) {
			userDao.save(user);
		}
		// ����uid��ѯuser
		public User findByUid(Integer uid) {
			return userDao.findByUid(uid);
		}
		// ����Աɾ��user
		public void delete(User user) {
			userDao.delete(user);
		}
}
