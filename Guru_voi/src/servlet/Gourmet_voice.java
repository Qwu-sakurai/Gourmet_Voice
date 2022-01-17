package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AddAccount;
import model.Login;
import model.Logout;
import model.Review;
import model.Search;
import model.entity.User;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Gourmet_voice")
public class Gourmet_voice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Gourmet_voice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 処理振り分け用文字列取り出し（nullならnonを代入）
		String act = request.getParameter("act");
		if (act == null) {
			act = "non";
		}

		// ログイン済み判定用文字列取り出し

		// 転送先指定用文字列
		String url = null;

		// 処理分岐
		switch (act) {
		case "newAcnt": // 新規登録ページへ転送

			// 転送先指定
			url = "/WEB-INF/jsp/newAccount.jsp";

			break;

		case "loginG": // ゲストとしてログイン

			// 閲覧のみできるUserを発行
			User gUser = new User("guest", "guest1122");


			// ログイン処理実行
			url = Login.login(gUser, request);
			Search.search(request);

			break;

		case "logout":	// ログアウト処理

			// ログアウト処理
			url = Logout.logout(request);

			break;

		case "review": // review画面転送（ゲスト以外利用可能）

			// ゲストかどうか確認
			url = Review.check(request);
			Search.search(request);

			break;

		default: // act未指定につきログイン済みならメニュー、してなければトップページへ

			// 転送先指定
			HttpSession session = request.getSession();
			User chUser = (User)session.getAttribute("user");

			if (chUser == null) {
				url = "index.jsp";
			}else {

				Search.search(request);
				url = "/WEB-INF/jsp/menu.jsp";
			}

			break;
		}

		// 転送処理
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 処理振り分け用文字列取り出し
		String act = request.getParameter("act");

		// 転送先指定用文字列
		String url = null;

		// 処理分岐
		switch (act) {
		case "login": // ログイン処理

			// ログイン処理

			url = Login.login(request);		// 処理内容によって転送先が決まる
			Search.search(request);

			break;

		case "newAdd":	// 新規登録処理

			// 新規登録処理
			url = AddAccount.addAcount(request);

			break;


		case "search": // 検索

			// 検索処理実行
			url = Search.search(request);

			break;

		case "review":	// レビュー送信

			// レビュー送信実行
			url = Review.addReview(request);

			// レビューリスト再登録
			Review.check(request);

			break;

		default: // act未指定につきトップページへ

			// 転送先指定
			url = "index.jsp";

			break;

		}

		// 転送処理
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}


}
