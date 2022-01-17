package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.ReviewBean;

public class ReviewDao {

	public List<ReviewBean> getReview(int id) {

		// 戻り値用のリスト作成
		List<ReviewBean> list = new ArrayList<>();

		// SQL文作成
		String sql = "SELECT * FROM review WHERE shop_id = ?";

		// データベース接続
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pStmt = conn.prepareStatement(sql)) {

			// SQL文の完成
			pStmt.setInt(1, id);

			// SELECTを実行
			ResultSet res = pStmt.executeQuery();


			if (res == null) {
				return null;
			}
			// SELECTの結果をリストに格納
			while (res.next()) {
				ReviewBean reRview = new ReviewBean();
				reRview.setId(res.getInt("id"));
				reRview.setReview_num(res.getInt("review_num"));
				reRview.setShop_id(res.getInt("shop_id"));
				reRview.setReview_name(res.getString("review_name"));
				reRview.setReview_point(res.getInt("review_point"));
				reRview.setReview_text(res.getString("review_text"));
				reRview.setReview_day(res.getString("review_day"));
				list.add(reRview);
			}

			return list;



		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addReview(ReviewBean re) {

		// SQL文作成
		String sql = "INSERT INTO review (review_num,shop_id,review_name,review_point,review_text,review_day)" +
				"VALUES (?,?,?,?,?,?)";

		// データベース接続
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pStmt = conn.prepareStatement(sql)) {

			// SQL文の完成
			pStmt.setInt(2, re.getShop_id());
			pStmt.setString(3, re.getReview_name());
			pStmt.setInt(4, re.getReview_point());
			pStmt.setString(5, re.getReview_text());
			pStmt.setString(6, re.getReview_day());

			// 何番目のレビューなのか取得してSQL文へ追記
			// 戻り値用のリスト作成
			List<ReviewBean> list = this.getReview(re.getShop_id());
			pStmt.setInt(1, (list.size()+1));



			// SELECTを実行
			int res = pStmt.executeUpdate();

			// SELECTの結果をリストに格納
			if (res == 1) {
				return true;
			}

			return false;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getReviewPoint(int id) {

		// SQL文作成
		String sql = "SELECT AVG (review_point) AS avepoint FROM review WHERE shop_id = ?";

		// データベース接続
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pStmt = conn.prepareStatement(sql)) {

			// SQL文の完成
			pStmt.setInt(1, id);

			// SELECTを実行
			ResultSet res = pStmt.executeQuery();

			// 格納用変数
			double ave=0;

			// SELECTの結果を変数に格納
			if (res.next()) {
				ave += res.getDouble("avepoint");
			}

			return String.format("%.1f", ave);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "0";
		}
	}

	public int getReviewSum(int id) {

		// 格納用変数
		int sum = 0;

		// SQL文作成
		String sql = "SELECT * FROM review WHERE shop_id = ?";

		// データベース接続
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pStmt = conn.prepareStatement(sql)) {

			// SQL文の完成
			pStmt.setInt(1, id);

			// SELECTを実行
			ResultSet res = pStmt.executeQuery();

			// SELECTの結果を変数に格納
			while (res.next()) {
				sum ++;
			}

			return sum;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return sum;
		}
	}
}
