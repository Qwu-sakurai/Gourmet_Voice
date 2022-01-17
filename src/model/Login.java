package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.dao.UserDao;
import model.entity.User;

public class Login {

	public static String login(HttpServletRequest request) {

		// 入力値取り出し
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		User userbean = new User(user, pass);

		// Daoを使ってlogin処理実施
		UserDao uDao = new UserDao();
		User reUser = uDao.login(userbean);

		// 処理の結果によって戻り値をわける
		if (reUser != null) {

			// ユーザー情報をセッションスコープへ格納
			HttpSession session = request.getSession();
			session.setAttribute("user", reUser);

			// 転送先指定（alertを出すためのパラメータ付）
			return "/WEB-INF/jsp/menu.jsp?login=do";
		}

		// 失敗したのでindex.jspに戻りエラーメッセージを出すようにする
		return "index.jsp?eMsg=do";
	}

	public static String login(User user, HttpServletRequest request) {


		// Daoを使ってlogin処理実施
		UserDao uDao = new UserDao();
		User reUser = uDao.login(user);

		// 処理の結果によって戻り値をわける
		if (reUser != null) {

			// ユーザー情報をセッションスコープへ格納
			HttpSession session = request.getSession();
			session.setAttribute("user", reUser);

			// 転送先指定（alertを出すためのパラメータ付）
			return "/WEB-INF/jsp/menu.jsp?login=do";
		}

		// 失敗したのでindex.jspに戻りエラーメッセージを出すようにする
		return "?eMsg=do";
	}
}
