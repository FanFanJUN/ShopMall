package cn.itcast.shop.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ����ʵ��
 * 
 * @author LC CREATE TABLE `orders` ( `oid` int(11) NOT NULL AUTO_INCREMENT,
 *         `total` double DEFAULT NULL, `ordertime` datetime DEFAULT NULL,
 *         `state` int(11) DEFAULT NULL, `name` varchar(20) DEFAULT NULL,
 *         `phone` varchar(20) DEFAULT NULL, `addr` varchar(50) DEFAULT NULL,
 *         `uid` int(11) DEFAULT NULL, PRIMARY KEY (`oid`), KEY
 *         `FKC3DF62E5AA3D9C7` (`uid`), CONSTRAINT `FKC3DF62E5AA3D9C7` FOREIGN
 *         KEY (`uid`) REFERENCES `user` (`uid`) ) ENGINE=InnoDB
 *         AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 */
public class Order implements Serializable{
	private String oid;
	private Double total;
	private Date ordertime;
	private Integer state;// 1:δ���� 2:�����Ѿ����� 3:�Ѿ����� 4:��������
	private String name;
	private String phone;
	private String addr;
	// �û������:����
	private User user;
	// ���ö�����ļ���
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", total=" + total + ", ordertime=" + ordertime + ", state=" + state + ", name="
				+ name + ", phone=" + phone + ", addr=" + addr + ", user=" + user + ", orderItems=" + orderItems + "]";
	}

}