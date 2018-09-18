package cn.itcast.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.model.User;
import cn.itcast.shop.service.UserService;
import cn.itcast.shop.utils.PageBean;

public class UserAdminAction extends ActionSupport implements ModelDriven<User> {
	// 模型驱动使用的对象
	private User user = new User();

	public User getModel() {
		return user;
	}

	// 注入ProductService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 接收page参数
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// 接受uid
	private Integer uid;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	// 查询所有的商品:
	public String findAll() {
		PageBean<User> pageBean = userService.findByPage(page);
		// 将PageBean数据存入到值栈中.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 页面跳转
		return "findAll";
	}

	// 编辑user的方法
	public String edit() {
		// 根据uid查询user信息
		user = userService.findByUid(user.getUid());
		ActionContext.getContext().getValueStack().set("csList", user);
		// 页面跳转到编辑页面:
		return "editSuccess";
	}
	//更新user
	public String update(){
		userService.update(user);
		return "updateSuccess";
			
	}
	public String delete(){
		user=userService.findByUid(user.getUid());
		userService.delete(user);
		return "deleteSuccess";
	}
	
}
