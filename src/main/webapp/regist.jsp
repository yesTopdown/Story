<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>数据 - AdminLTE2定制版 | Log in</title>

<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="all-admin-index.html"><b>设交故事</b>后台管理系统</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">注册系统</p>

			<form action="${pageContext.request.contextPath}/user/register"
				method="post">
				<p ><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></p>
	               <div><p id="s_username"></p></div>
				<div class="form-group has-feedback">
					<input type="text" name="username" class="form-control"
						placeholder="用户名" id="username"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" class="form-control"
						placeholder="密码"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<input type="text" name="phoneNum" class="form-control" placeholder="电话号码"> <span
						class="glyphicon glyphicon-phone form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div>
							<a href="${pageContext.request.contextPath}/user/main">返回首页</a>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<a href="${pageContext.request.contextPath}/login.jsp">登录界面</a><br>


		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.2.3 -->
	<!-- Bootstrap 3.3.6 -->
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
	<script>
			$(function () {
			//给username绑定blur事件
			$("#username").blur(function () {
				//获取username文本输入框的值
				var username = $(this).val();
				//发送ajax请求
				$.ajax({
					url:"${pageContext.request.contextPath}/user/exist" , // 请求路径
					type:"POST" , //请求方式
					data:{"username":username},
					success:function (data) {
						var span = $("#s_username");
						if(data.userExsit){
							span.html(data.msg);
						}else {
							span.html(data.msg)
						}
					},//响应成功后的回调函数
					error:function () {
						alert("出错啦...")
					},//表示如果请求响应出现错误，会执行的回调函数
					dataType:"json",//设置接受到的响应数据的格式
					contentType:'application/json;charset=utf-8'
				});
			});
		});
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>

</html>