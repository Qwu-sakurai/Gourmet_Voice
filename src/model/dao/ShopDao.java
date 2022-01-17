package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Shop;

public class ShopDao {

	public List<Shop> selectSeach() {

		// 戻り値用のリスト作成
		List<Shop> list = new ArrayList<Shop>();

		// SQL文作成
		String sql = "SELECT * FROM shop";

		// データベース接続
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pStmt = conn.prepareStatement(sql)) {

			// SELECTを実行
			ResultSet res = pStmt.executeQuery();

			// SELECTの結果をリストに格納
			while (res.next()) {
				Shop shop = new Shop();
				shop.setId(res.getInt("shop_id"));
				shop.setShop_name(res.getString("shop_name"));
				shop.setShop_map(res.getString("shop_map"));
				shop.setShop_num(res.getString("shop_num"));
				shop.setAveprice(res.getString("shop_aveprice"));
				shop.setShop_text(res.getString("shop_text"));
				list.add(shop);
			}

			return list;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Shop> selectSeachArea(String area) {

		// 戻り値用のリスト作成
		List<Shop> list = new ArrayList<Shop>();

		// SQL文作成
		String sql = "SELECT (shop_name,shop_map,shop_num,shop_aveprice,shop_text) FROM shop WHERE shop_map LIKE ?";

		// データベース接続
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pStmt = conn.prepareStatement(sql)) {

			// SQL文完成
			pStmt.setString(1, area +"%");

			// SELECTを実行
			ResultSet res = pStmt.executeQuery();

			// SELECTの結果をリストに格納
			while (res.next()) {
				Shop shop = new Shop();
				shop.setId(res.getInt("shop_id"));
				shop.setShop_name(res.getString("shop_name"));
				shop.setShop_map(res.getString("shop_map"));
				shop.setShop_num(res.getString("shop_num"));
				shop.setAveprice(res.getString("shop_aveprice"));
				shop.setShop_text(res.getString("shop_text"));
				list.add(shop);
			}

			return list;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Shop> selectSeachAve(String aveprice) {

		// 戻り値用のリスト作成
		List<Shop> list = new ArrayList<Shop>();

		// SQL文作成
		String sql = "SELECT (shop_name,shop_map,shop_num,shop_aveprice,shop_text) FROM shop WHERE shop_aveprice LIKE ?";

		// データベース接続
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pStmt = conn.prepareStatement(sql)) {

			// SQL文完成
			pStmt.setString(1, aveprice);

			// SELECTを実行
			ResultSet res = pStmt.executeQuery();

			// SELECTの結果をリストに格納
			while (res.next()) {
				Shop shop = new Shop();
				shop.setId(res.getInt("shop_id"));
				shop.setShop_name(res.getString("shop_name"));
				shop.setShop_map(res.getString("shop_map"));
				shop.setShop_num(res.getString("shop_num"));
				shop.setAveprice(res.getString("shop_aveprice"));
				shop.setShop_text(res.getString("shop_text"));
				list.add(shop);
			}

			return list;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Shop> selectSeach(String area,String aveprice) {

		// 戻り値用のリスト作成
		List<Shop> list = new ArrayList<Shop>();

		// SQL文作成
		String sql = "SELECT (shop_name,shop_map,shop_num,shop_aveprice,shop_text) FROM shop WHERE shop_aveprice LIKE ? AND shop_map LIKE ?";

		// データベース接続
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pStmt = conn.prepareStatement(sql)) {

			// SQL文完成
			pStmt.setString(1, aveprice);
			pStmt.setString(2, area +"%");

			// SELECTを実行
			ResultSet res = pStmt.executeQuery();

			// SELECTの結果をリストに格納
			while (res.next()) {
				Shop shop = new Shop();
				shop.setId(res.getInt("shop_id"));
				shop.setShop_name(res.getString("shop_name"));
				shop.setShop_map(res.getString("shop_map"));
				shop.setShop_num(res.getString("shop_num"));
				shop.setAveprice(res.getString("shop_aveprice"));
				shop.setShop_text(res.getString("shop_text"));
				list.add(shop);
			}

			return list;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addAvepoint(String ave,int id) {

		// SQL文作成
		String sql = "UPDATE shop SET review_point = ? WHERE shop_id = ?";

		// データベース接続
		try (Connection conn = ConnectionManager.getConnection();
			PreparedStatement pStmt = conn.prepareStatement(sql)) {

			// SQL文完成
			double point = Double.parseDouble(ave);
			pStmt.setDouble(1, point);
			pStmt.setInt(2, id);

			pStmt.executeUpdate();

		} catch (ClassNotFoundException |SQLException  e ) {
			e.printStackTrace();
		}

	}
}
