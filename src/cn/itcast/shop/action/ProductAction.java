package cn.itcast.shop.action;

import cn.itcast.shop.model.Product;
import cn.itcast.shop.service.CategoryService;
import cn.itcast.shop.service.ProductService;
import cn.itcast.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��Ʒ��Action����
 * 
 * @author LC
 * 
 */
public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	// ���ڽ������ݵ�ģ������.
	private Product product = new Product();

	public Product getModel() {
		return product;
	}

	// ע��һ�������Service
	private CategoryService categoryService;
	// ע����Ʒ��Service
	private ProductService productService;
	// ���յ�ǰҳ��:
	private int page;

	public void setPage(int page) {
		this.page = page;
	}

	// ���շ���cid
	private Integer cid;

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return cid;
	}

	// ���ն�������id
	private Integer csid;

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// ������Ʒ��ID���в�ѯ��Ʒ:ִ�з���:
	public String findByPid() {
		// ����Service�ķ�����ɲ�ѯ.
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}

	// ���ݷ����id��ѯ��Ʒ:
	public String findByCid() {
		System.out.println(cid);
		// List<Category> cList = categoryService.findAll();
		PageBean<Product> pageBean = productService.findByPageCid(cid, page);
		// ����һ�������ѯ��Ʒ,����ҳ��ѯ
		// ��PageBean���뵽ֵջ��:
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}

	// ���ݶ�������id��ѯ��Ʒ:
	public String findByCsid() {
		// ���ݶ��������ѯ��Ʒ
		PageBean<Product> pageBean = productService.findByPageCsid(csid, page);
		// ��PageBean���뵽ֵջ��:
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}
}