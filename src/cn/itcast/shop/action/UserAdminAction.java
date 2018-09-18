package cn.itcast.shop.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.shop.model.User;
import cn.itcast.shop.service.UserService;
import cn.itcast.shop.utils.PageBean;

public class UserAdminAction extends ActionSupport implements ModelDriven<User> {
	// ģ������ʹ�õĶ���
	private User user = new User();

	public User getModel() {
		return user;
	}

	// ע��ProductService
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// ����page����
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// ����uid
	private Integer uid;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	// ��ѯ���е���Ʒ:
	public String findAll() {
		PageBean<User> pageBean = userService.findByPage(page);
		// ��PageBean���ݴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ����ת
		return "findAll";
	}

	// �༭user�ķ���
	public String edit() {
		// ����uid��ѯuser��Ϣ
		user = userService.findByUid(user.getUid());
		ActionContext.getContext().getValueStack().set("csList", user);
		// ҳ����ת���༭ҳ��:
		return "editSuccess";
	}
	//����user
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
