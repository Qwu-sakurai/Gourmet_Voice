package model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.dao.ReviewDao;
import model.dao.ShopDao;
import model.entity.Shop;

public class Search {

	public static String search(HttpServletRequest request) { // 全検索

		// 入力値取り出しとセット
		String area = request.getParameter("area");
		if (area == null) {
			area = "指定なし";
		}


		if (area.equals("指定なし")) {
			area = "";
		}

		String aveprice = request.getParameter("aveprice");
		if (aveprice == null) {
			aveprice = "指定なし";
		}


		if (aveprice.equals("指定なし")) {
			aveprice = "";
		}

		System.out.println(area+aveprice);

		// 戻り値用リスト作成
		List<Shop> list = new ArrayList<Shop>();

		// daoインスタンス化
		ShopDao sDao = new ShopDao();

		// 入力内容によって実行daoを分岐
		if (area.length() == 0 && aveprice.length() == 0) {	// 指定なし（全検索）
			list = sDao.selectSeach();
		} else if (area.length() == 0) {					// エリア指定のみ（エリア検索）
			list = sDao.selectSeachAve(aveprice);

		} else if (aveprice.length() == 0) {				// 目安予算指定のみ（予算検索）
			list = sDao.selectSeachArea(area);

		} else {											// 両方指定あり（エリア・予算検索）
			list = sDao.selectSeach(area, aveprice);
		}

		// 検索結果にレビュー平均点数を追加
		ReviewDao rDao = new ReviewDao();
		for (Shop shop : list) {
			shop.setAvereview(rDao.getReviewPoint(shop.getId()));
		}

		// 検索結果にレビュー件数を追加
		for (Shop shop : list) {
			shop.setReview_sum(rDao.getReviewSum(shop.getId()));
		}

		// 検索結果をセッションスコープとリクエストスコープへ保存
		HttpSession session = request.getSession();
		session.setAttribute("reshoplist", list);
		request.setAttribute("shoplist", list);


		return "/WEB-INF/jsp/menu.jsp";
	}
}
