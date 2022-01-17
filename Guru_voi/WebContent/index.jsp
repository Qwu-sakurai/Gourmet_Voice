<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ぐるぼい</title>
<link rel="stylesheet" href="css/style.css">
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
<link rel="apple-touch-icon" sizes="180x180" href="img/apple-touch-icon-180x180.png">
<c:if test="${param.jikkou != null}">
	<script type="text/javascript">
		alert("登録処理に成功しました。");
	</script>
</c:if>
<c:if test="${param.logout != null}">
	<script type="text/javascript">
		alert("ログアウトしました。")
	</script>
</c:if>
<c:if test="${user != null}">
	<script type="text/javascript">
		window.onload=window.location.href = "Gourmet_voice";
	</script>
</c:if>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</header>

	<div class="login">
		<form action="Gourmet_voice" method="post">
			<table>
				<tr>
					<td colspan="3">
						<div class="loginE">
							<c:if test="${param.eMsg != null}">
								<c:out value="ログインに失敗しました。もう一度やり直してください。" />
							</c:if>
						</div>
					</td>
				<tr>
					<td rowspan="2"><button
							class="btn btn--orange btn--cubic btn--shadow" name="act"
							value="login">ログイン</button></td>
					<td class="login">ユーザー名：</td>
					<td><input type="text" name="user"></td>
				</tr>
				<tr>
					<td class="login">パスワード：</td>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<td class="login" colspan="3"><a
						class="btn btn--blue btn--cubic btn--shadow"
						href="Gourmet_voice?act=newAcnt">新規登録</a></td>
				<tr>
					<td class="login" colspan="3"><a
						class="btn btn--blue btn--cubic btn--shadow"
						href="Gourmet_voice?act=loginG">ゲストとしてログイン</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>