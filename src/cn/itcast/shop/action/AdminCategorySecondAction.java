package cn.itcast.shop.action;

import java.util.List;

import cn.itcast.shop.model.Category;
import cn.itcast.shop.model.CategorySecond;
import cn.itcast.shop.service.CategorySecondService;
import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨��������Ĺ����Action.
 * 
 * @author LC
 * 
 */
public class AdminCategorySecondAction extends ActionSupport implements
		ModelDriven<CategorySecond> {
	// ģ������ʹ�õĶ���
	private CategorySecond categorySecond = new CategorySecond();

	public CategorySecond getModel() {
		return categorySecond;
	}

	// ����page����:
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// ע�����Service
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	// ע��һ�������Service
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// ���з�ҳ�Ĳ�ѯ���ж�������Ĳ���:
	public String findAll() {
		// ����Service���в�ѯ.
		PageBean<CategorySecond> pageBean = categorySecondService
				.findByPage(page);
		// ��pageBean�����ݴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// ��ת�����ҳ��ķ���:
	public String addPage() {
		// ��ѯ����һ������.
		List<Category> cList = categoryService.findAll();
		// �����ϴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("cList", cList);
		// ҳ����ת:
		return "addPage";
	}

	// ��Ӷ�������ķ���:
	public String save() {
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}

	// ɾ����������ķ���:
	public String delete() {
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}

	// �༭��������ķ���:
	public String edit() {
		// ����id��ѯ��������:
		categorySecond = categorySecondService.findByCsid(categorySecond
				.getCsid());
		// ��ѯ����һ������:
		List<Category> cList = categoryService.findAll();
		// �����ϴ��뵽ֵջ��.
		ActionContext.getContext().getValueStack().set("cList", cList);
		// ҳ����ת:
		return "editSuccess";
	}

	// �޸Ķ�������ķ���:
	public String update() {
		categorySecondService.update(categorySecond);
		return "updateSuccess";
	}

}
