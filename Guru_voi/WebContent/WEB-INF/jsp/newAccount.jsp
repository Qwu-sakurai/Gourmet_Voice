<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ぐるぼい・新規登録</title>
<link rel="stylesheet" href="css/style.css">
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
<link rel="apple-touch-icon" sizes="180x180" href="img/apple-touch-icon-180x180.png">
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</header>
	<div class="newaccount">

	<c:if test="${param.eMsg != null}">
		指定したユーザー名はすでに存在します。別のユーザー名を指定してください。
	</c:if>
	<c:if test="${param.eMsg2 != null}">
		空入力は受け付けられません、内容を入力してください。
	</c:if>
	<form action="Gourmet_voice" method="post">
		<table class="newadd">
			<tr>
			<td colspan="2" class="newaddtitle">新規登録</td>
			</tr>
			<tr>
				<td class="newtd">ログインユーザー名:</td>
				<td><input type="text" name="user"></td>
			</tr>
			<tr>
				<td class="newtd">ログインパスワード：</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td class="newtd">表示名（レビュー時に表示されます）：</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><button class="btn btn--orange btn--cubic btn--shadow"
						name="act" value="newAdd">登録</button></td>
				<td><input class="btn btn--blue btn--cubic btn--shadow"
					type="reset" value="取り消し"></td>
			</tr>
			<tr>
				<td class="newtd" colspan="2"><a
					class="btn btn--orange btn--cubic btn--shadow" href="Gourmet_voice">トップへ</a></td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>