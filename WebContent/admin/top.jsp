<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type="text/css">
BODY {
	MARGIN: 0px;
	BACKGROUND-COLOR: #ffffff
}

BODY {
	FONT-SIZE: 12px;
	COLOR: #000000
}

TD {
	FONT-SIZE: 12px;
	COLOR: #000000
}

TH {
	FONT-SIZE: 12px;
	COLOR: #000000
}
</style>
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css">
	</HEAD>
	<body>
		<table width="100%" height="70%"  border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="100%" background="${pageContext.request.contextPath}/images/top_h.jpg">
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30" valign="bottom" background="${pageContext.request.contextPath}/images/mis_001.jpg">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="85%" align="left">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<font color="#000000"> 
								<span id="showCurrentTime"></span>
									<script language="JavaScript">
								<!--这个cg就是span的id，初始化Date时间并转化为字符string类型,每1000毫秒，setInterval() 就会调用函数，直到被关闭。
								https://zhidao.baidu.com/question/256138185.html-->
								/* setInterval("showCurrentTime.innerHTML=new Date().toLocaleString()",1000); */
								/* https://blog.csdn.net/lsq_java_4/article/details/51490652 */
								function getCurrentTime(){  
								    var date = new Date();  
								    var year = date.getFullYear();  
								    var month = (date.getMonth()+1);  
								    if(month<10){  
								        month = "0" + month;  
								    }  
								    var day = date.getDate();  
								    var weekday = date.getDay();  
								    var week = new Array(7);  
								    week[0] = "日";  
								    week[1] = "一";  
								    week[2] = "二";  
								    week[3] = "三";  
								    week[4] = "四";  
								    week[5] = "五";  
								    week[6] = "六";  
								    var currentTime = "您好，今天是" + year + "年" + month + "月" + day + "日，星期" + week[weekday];  
								    showCurrentTime.innerHTML = currentTime;  
								    window.setTimeout("getCurrentTime();",1000);  
								}  
								window.onload = getCurrentTime; 
									</script> 
								</font>
							</td>
							<td width="15%">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="16"
											background="${pageContext.request.contextPath}/images/mis_05b.jpg">
											<img
												src="${pageContext.request.contextPath}/images/mis_05a.jpg"
												width="6" height="18">
										</td>
										<td width="155" valign="bottom"
											background="${pageContext.request.contextPath}/images/mis_05b.jpg">
											用户名：
											<font color="blue"><s:property value="#session.existAdminUser.username" /></font>
										</td>
										<td width="10" align="right"
											background="${pageContext.request.contextPath}/images/mis_05b.jpg">
											<img src="${pageContext.request.contextPath}/images/mis_05c.jpg" width="6" height="18">
										</td>
									</tr>
								</table>
							</td>
							<td align="right" width="5%">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</HTML>
