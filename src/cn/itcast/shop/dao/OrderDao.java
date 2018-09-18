package cn.itcast.shop.dao;

import java.util.List;

import org.n3r.idworker.Sid;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.shop.model.Order;
import cn.itcast.shop.model.OrderItem;
import cn.itcast.shop.utils.PageHibernateCallback;

public class OrderDao extends HibernateDaoSupport {
	// Dao��ı��涩�������
	public void save(Order order) {
		//���ù��ﵥ��
				Sid sid=new Sid();
				String oid = sid.nextShort();
				order.setOid(oid);
		System.out.println(order);
		this.getHibernateTemplate().save(order);
	}

	// Dao���ѯ�ҵĶ�����ҳ��ѯ:ͳ�Ƹ���
	public int findCountByUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// Dao���ѯ�ҵĶ�����ҳ��ѯ:��ѯ����
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		String hql = "from Order o where o.user.uid = ? order by o.ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Order>(hql, new Object[] { uid },
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// DAO����ݶ���id��ѯ����
	public Order findByOid(String oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	// DAO���޸Ķ����ķ���:
	public void update(Order currOrder) {
		this.getHibernateTemplate().update(currOrder);
	}
	
	/////////����Ա///////
	// DAO��ͳ�ƶ��������ķ���
		public int findCount() {
			String hql = "select count(*) from Order";
			List<Long> list = this.getHibernateTemplate().find(hql);
			if (list != null && list.size() > 0) {
				return list.get(0).intValue();
			}
			return 0;
		}

		// DAO�з�ҳ��ѯ�����ķ���
		public List<Order> findByPage(int begin, int limit) {
			String hql = "from Order order by ordertime desc";
			List<Order> list = this.getHibernateTemplate().execute(
					new PageHibernateCallback<Order>(hql, null, begin, limit));
			return list;
		}

		// DAo�и��ݶ���id��ѯ������
		public List<OrderItem> findOrderItem(String oid) {
			String hql = "from OrderItem oi where oi.order.oid = ?";
			List<OrderItem> list = this.getHibernateTemplate().find(hql, oid);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		}

}
