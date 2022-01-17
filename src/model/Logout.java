package model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Logout {

	public static String logout (HttpServletRequest request) {

		// セッションスコープ削除
		HttpSession session = request.getSession();
		session.invalidate();

		return "?logout=do";
	}
}
