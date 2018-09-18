<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<table width="100%" border="1">
	<s:iterator var="orderItem" value="list">
	<tr>
	<td>商品概览</td>
	<td>商品简介</td>
	<td>购买数量</td>
	<td>商品总价</td>
	</tr>
	<tr>
		<td>
		<a href="${ pageContext.request.contextPath }/product_findByPid.action?pid=<s:property value="#orderItem.product.pid"/>" target="_blank">
		<img width="40" height="45" src="${ pageContext.request.contextPath }/<s:property value="#orderItem.product.image"/>">
		</a>
		</td>
		<td><s:property value="#orderItem.product.pname"/></td>
		<td><s:property value="#orderItem.count"/></td>
		<td><s:property value="#orderItem.subtotal"/>元</td>
	</tr>
	</s:iterator>
</table>