package cn.itcast.shop.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.shop.dao.UserDao;
import cn.itcast.shop.model.User;
import cn.itcast.shop.utils.MailUitls;
import cn.itcast.shop.utils.PageBean;
import cn.itcast.shop.utils.UUIDUtils;

/**
 * 用户名模块业务层代码
 * 
 * @author LC
 *
 */
@Transactional
public class UserService {
	// 注入UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 按用户名查询用户的方法:
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	// 业务层完成用户注册代码:
	public void save(User user) {
		// 将数据存入到数据库
		user.setState(0); // 0:代表用户未激活. 1:代表用户已经激活.
		String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		// 发送激活邮件;
		MailUitls.sendMail(user.getEmail(), code);
	}

	// 业务层根据激活码查询用户
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	// 修改用户的状态的方法
	public void update(User existUser) {
		userDao.update(existUser);
	}

	// 用户登录的方法
	public User login(User user) {
		return userDao.login(user);
	}
	// //////后台管理员////////////////////////////
		// 后台查询所有user带分页
		public PageBean<User> findByPage(Integer page) {
			PageBean<User> pageBean = new PageBean<User>();
			// 设置当前页数:
			pageBean.setPage(page);
			// 设置每页显示记录数:
			int limit = 10;
			pageBean.setLimit(limit);
			// 设置总记录数:
			int totalCount = 0;
			totalCount = userDao.findCount();
			pageBean.setTotalCount(totalCount);
			// 设置总页数:
			int totalPage = 0;
			// Math.ceil(totalCount / limit);
			if (totalCount % limit == 0) {
				totalPage = totalCount / limit;
			} else {
				totalPage = totalCount / limit + 1;
			}
			pageBean.setTotalPage(totalPage);
			// 每页显示的数据集合:
			// 从哪开始:
			int begin = (page - 1) * limit;
			List<User> list = userDao.findByPage(begin, limit);
			pageBean.setList(list);
			return pageBean;
		}
		// 业务层保存user方法:
		public void saveUser(User user) {
			userDao.save(user);
		}
		// 根据uid查询user
		public User findByUid(Integer uid) {
			return userDao.findByUid(uid);
		}
		// 管理员删除user
		public void delete(User user) {
			userDao.delete(user);
		}
}
