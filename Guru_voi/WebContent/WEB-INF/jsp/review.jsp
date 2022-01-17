<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="icon" type="image/x-icon" href="img/favicon.ico">
<link rel="apple-touch-icon" sizes="180x180"
	href="img/apple-touch-icon-180x180.png">
<meta charset="UTF-8">
<title>ぐるぼい・レビュー</title>
<c:if test="${param.eMsg1 != null}">
	<script type="text/javascript">
		alert("レビュー内容を入力してください");
	</script>
</c:if>
<c:if test="${param.eMsg2 != null}">
	<script type="text/javascript">
		alert("レビューの書き込みに失敗しました");
	</script>
</c:if>
<c:if test="${param.Msg != null}">
	<script type="text/javascript">
		alert("レビューを投稿しました！");
	</script>
</c:if>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/jsp/header.jsp"%>
	</header>
	<div class="shoptable">
		<table class="top">
			<tr>
				<td><a class="btn btn--orange btn--cubic btn--shadow top"
					href="Gourmet_voice">トップへ</a></td>
			</tr>
		</table>
		<table class="searchtable">
			<tr>
				<td class="res">店舗名：</td>
				<td class="shopname"><c:out value="${reviewshop.shop_name}" /></td>
			</tr>
			<tr>
				<td class="res">住所：</td>
				<td><c:out value="${reviewshop.shop_map}" /></td>
			</tr>
			<tr>
				<td class="res">電話番号：</td>
				<td><c:choose>
						<c:when test="${reviewshop.shop_num == 0}">
								未登録
							</c:when>
						<c:otherwise>
							<c:out value="${reviewshop.shop_num}" />
						</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<td class="res">目安予算：</td>
				<td><c:out value="${reviewshop.aveprice}" /></td>
			</tr>
			<tr>
				<td class="res">詳細情報：</td>
				<td><c:choose>
						<c:when test="${reviewshop.shop_text == null}">
								未登録
							</c:when>
						<c:otherwise>
							<c:out value="${reviewshop.shop_text}" />
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</div>
	<hr color="orange">
	<div class="reviewpage">
		<div class="reviewbox">
			<form action="Gourmet_voice" method="post">
				<table class="review">
					<tr>
						<td>レビュー内容（２００文字以内）</td>
						<td>満足度：</td>
						<td><select name="point">
								<%
									for (int i = 1; i <= 5; i++) {
								%>
								<option><%=i%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td><textarea rows="4" cols="50" name="text"></textarea></td>
						<td colspan="2">
							<button class="btn-r btn--orange btn--cubic btn--shadow"
								name="act" value="review">レビューを送信する</button>
						</td>
					</tr>
				</table>
			</form>
		</div>

		<div class="reviews">


					<c:forEach var="review" items="${reviewlist}">
					<c:choose>
				<c:when test="${review != null}">
						<table class="retable" border="1">
							<tr>
								<td class="renum" rowspan="3"><c:out
										value="${review.review_num}" /></td>
								<td class="res name">レビュー者名</td>
								<td class="henname"><c:out value="${review.review_name}" /></td>
								<td class="res point">満足度</td>
								<td class="henpoint"><c:out value="${review.review_point}" /></td>
							</tr>
							<tr>
								<td class="res info">レビュー内容</td>
								<td class="heninfo" colspan="3"><c:out
										value="${review.review_text}" /></td>
							</tr>
							<tr>
								<td class="res day">レビューした日</td>
								<td class="henday" colspan="3"><c:out
										value="${review.review_day}" /></td>
							</tr>
						</table>
						</c:when>
						<c:when test="${review == null }">テスト
						</c:when>
				<c:otherwise>
					<div class="reviewnontext">まだレビューがありません。</div>
				</c:otherwise>
			</c:choose>
					</c:forEach>


		</div>
		<footer class="logout">
			<%@ include file="/WEB-INF/jsp/footer.jsp"%>
		</footer>
	</div>
</body>
</html>