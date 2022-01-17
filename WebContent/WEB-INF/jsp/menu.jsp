<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
<link rel="apple-touch-icon" sizes="180x180"
	href="img/apple-touch-icon-180x180.png">
<title>ぐるぼい・メニュー</title>

</head>
<body class="menu">
	<div>

		<c:if test="${param.login != null}">
			<script type="text/javascript">
				alert("ログインしました！ようこそ" + "${user.name}" + "さん");
			</script>
		</c:if>
		<c:if test="${param.eMsg2 != null }">
			<script type="text/javascript">
				alert("この機能はユーザー登録者のみ利用できます。")
			</script>
		</c:if>

	</div>

	<header>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</header>

	<div class="split">
		<div class="split-item-search">
			<div class="split-inner-search">
				<div class="sample1"><p class="username">
					<c:if test="${user != null}">
						<c:out value="${user.name}" />さん、ログイン中
					</c:if>
				</p></div>
				<h2>検索項目</h2>
				<p>
					指定したい項目を選び検索ボタンを押してください。<br> （指定のない場合登録店舗がすべて表示されます。）
				</p>
				<form action="Gourmet_voice" method="post">
					<table>
						<tr>
							<td>エリア指定：</td>
							<td><select name="area">

									<c:if test="${param.area != null}">
										<option><c:out value="${param.area}" /></option>
									</c:if>

									<option>指定なし</option>
									<option value="東京都">東京都</option>
									<option value="東京都新宿区">-新宿区</option>
									<option value="東京都豊島区">-豊島区</option>
									<option value="東京都渋谷区">-渋谷区</option>
							</select></td>
						</tr>
						<tr>
							<td>目安予算指定（一人当たり)：</td>
							<td><select name="aveprice">

									<c:if test="${param.aveprice != null}">
										<option><c:out value="${param.aveprice}" /></option>
									</c:if>

									<option>指定なし</option>
									<option>1000円未満</option>
									<option>1000～2000円</option>
									<option>2000円以上</option>
							</select></td>
						</tr>
					</table>
					<button class="btn btn--orange btn--cubic btn--shadow" name="act"
						value="search">検索</button>
				</form>
				<footer>
					<%@ include file="/WEB-INF/jsp/footer.jsp"%>
				</footer>
			</div>
		</div>
		<div class="split-item-SearchResult">
			<div class="split-inner-SearchResult">
				<div class="box">
					<!-- <div class="bgImg src1"></div>
					<div class="bgImg src2"></div>
					<div class="bgImg src3"></div>
					<div class="bgImg src4"></div>
					<div class="bgImg src5"></div> -->
				</div>
				<div>
					<c:forEach var="shop" items="${shoplist}">
						<table class="searchtable" border="1">
							<tr>
								<td class="res">店舗名</td>
								<td class="shopname" colspan="3"><c:out
										value="${shop.shop_name}" /></td>
							</tr>
							<tr>
								<td class="res">住所</td>
								<td colspan="3"><c:out value="${shop.shop_map}" /></td>
							</tr>
							<tr>
								<td class="res">電話番号</td>
								<td colspan="3"><c:choose>
										<c:when test="${shop.shop_num == 0}">
								未登録
							</c:when>
										<c:otherwise>
											<c:out value="${shop.shop_num}" />
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<td class="res">目安予算</td>
								<td colspan="3"><c:out value="${shop.aveprice}" /></td>
							</tr>
							<tr>
								<td class="res">平均満足度</td>
								<td class="ele"><c:out value="${shop.avereview}" /></td>
								<td class="res">レビュー件数</td>
								<td class="ele"><c:out value="${shop.review_sum}" /></td>
							</tr>
							<tr>
								<td class="res">詳細情報</td>
								<td colspan="3"><c:choose>
										<c:when test="${shop.shop_text == null}">
								未登録
							</c:when>
										<c:otherwise>
											<c:out value="${shop.shop_text}" />
										</c:otherwise>
									</c:choose></td>
							</tr>
							<tr>
								<td class="btnr" colspan="4"><a
									class="btn-r btn--orange btn--cubic btn--shadow"
									href="Gourmet_voice?act=review&id=${shop.id}">レビューを見る・書き込む</a></td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>



</body>
</html>