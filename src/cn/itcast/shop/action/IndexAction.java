package cn.itcast.shop.action;

import java.util.List;

import cn.itcast.shop.model.Category;
import cn.itcast.shop.model.Product;
import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.service.ProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ҳ���ʵ�Action
 * 
 * @author LC
 *
 */
public class IndexAction extends ActionSupport {
	// ע��һ�������Service:
	private CategoryService categoryService;

	// ע����Ʒ��Service
	private ProductService productService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	/**
	 * ִ�еķ�����ҳ�ķ���:
	 */
	public String execute() {
		// ��ѯ����һ�����༯��
		List<Category> cList = categoryService.findAll();
		// ��һ��������뵽Session�ķ�Χ:
		ActionContext.getContext().getSession().put("cList", cList);
		// ��ѯ������Ʒ:
		List<Product> hList = productService.findHot();
		// ���浽ֵջ��:
		ActionContext.getContext().getValueStack().set("hList", hList);
		// ��ѯ������Ʒ:
		List<Product> nList = productService.findNew();
		// ���浽ֵջ��:
		ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}

}
