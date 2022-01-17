package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.dao.ReviewDao;
import model.dao.ShopDao;
import model.entity.ReviewBean;
import model.entity.Shop;
import model.entity.User;

public class Review {

	@SuppressWarnings("unchecked")
	public static String check(HttpServletRequest request) {

		// ゲストかどうか確認
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// ゲストのIDは１なので一致すればエラーメッセージのトリガーを含んでメニュー画面へ
		if (user.getId() == 1) {
			return "/WEB-INF/jsp/menu.jsp?eMsg2=do";
		}

		// レビューが押されたお店の情報取り出し
		int sId;
		String reId = request.getParameter("id");
		if (reId == null) {
			Shop rShop = (Shop)session.getAttribute("reviewshop");
			sId = rShop.getId();
		}else {
			sId = Integer.parseInt(reId);
		}
		List<Shop> sList = (List<Shop>)session.getAttribute("reshoplist");

		for (Shop shop : sList) {
			if (shop.getId() == sId) {
				session.setAttribute("reviewshop", shop);
				ReviewDao rDao = new ReviewDao();
				List<ReviewBean> rList = rDao.getReview(sId);
				session.setAttribute("reviewlist", rList);

				for (ReviewBean shop2 : rList) {
					System.out.println(shop2.getId());
				}
				System.out.println();
			}
		}


		return "/WEB-INF/jsp/review.jsp";
	}

	public static String addReview(HttpServletRequest request) {

		// 入力値取り出し
		String text = request.getParameter("text");
		int point = Integer.parseInt(request.getParameter("point"));

		// 入力値が空ならエラー判定
		if (text == null || text.length() == 0) {
			return "/WEB-INF/jsp/review.jsp?eMsg1=do";
		}

		// reviewbeanに必要な要素を集める
		// レビュー対象のshop_id
		HttpSession session = request.getSession();
		Shop reviewShop =(Shop)session.getAttribute("reviewshop");
		int reid = reviewShop.getId();

		// レビューナンバー
		ReviewDao rDao = new ReviewDao();
		List<ReviewBean> rlist = rDao.getReview(reid);
		int i = rlist.size();

		// レビュー者氏名
		User reuser = (User)session.getAttribute("user");
		String rename = reuser.getName();

		// レビューした日
		Date now = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		String reday = df.format(now);

		// reviewbeanの作成
		ReviewBean rb = new ReviewBean(i,reid, rename, point, text, reday);

		// 書き込み処理
		boolean res = rDao.addReview(rb);

		// レビューリスト再取得用にshop_idをリクエストスコープへ保存
		request.setAttribute("id", reid);

		// 平均満足度をショップデータへ反映
		String ave = rDao.getReviewPoint(reid);
		ShopDao sDao = new ShopDao();
		sDao.addAvepoint(ave, reid);


		if (res) {
			return "/WEB-INF/jsp/review.jsp?Msg=do";
		}

		return "/WEB-INF/jsp/review.jsp?eMsg2=do";
	}
}
