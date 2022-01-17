package model;

import javax.servlet.http.HttpServletRequest;

import model.dao.UserDao;
import model.entity.User;

public class AddAccount {

	public static String addAcount(HttpServletRequest request) {

		// 入力値取り出し
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");

		if (user.equals("")||pass.equals("")||name.equals("")) {
			return "/WEB-INF/jsp/newAccount.jsp?eMsg2=do";
		}

		User userbean = new User(user, pass, name);

		// daoのインスタンス化
		UserDao uDao = new UserDao();
		boolean res = uDao.addUser(userbean);

		// 結果によって戻り値を振り分ける
		if (res) {
			return "index.jsp?jikkou=alert";
		}

		return "/WEB-INF/jsp/newAccount.jsp?eMsg=do";

	}
}
