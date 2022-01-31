package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.User;

public class UserDao {

	public boolean addUser(User user) {

		// INSERT文の準備
		String sql = "INSERT INTO m_user(username,pass,name) VALUES (?,?,?)";

		// データベース接続
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pStmt = conn.prepareStatement(sql)) {

			// INSERT文を完成させる
			pStmt.setString(1, user.getUser());
			pStmt.setString(2, user.getPass());
			pStmt.setString(3, user.getName());

			// INSERTを実行
			int reselt = pStmt.executeUpdate();

			// INSERTの成否を確認
			if (reselt == 1) {
				return true;
			}

			return false;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public User login(User user) {

		// SELECT文の準備
		String sql = "SELECT * FROM m_user WHERE username = ? AND pass = ?";

		// データベース接続
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pStmt = conn.prepareStatement(sql)) {

			// SELECT文を完成させる
			pStmt.setString(1, user.getUser());
			pStmt.setString(2, user.getPass());

			// SELECTを実行
			ResultSet res = pStmt.executeQuery();

			// SELECTの結果をリストに保存
			if (res.next()) {
				User resUser = new User();
				resUser.setId(res.getInt("id"));
				resUser.setUser(res.getString("username"));
				resUser.setPass(res.getString("pass"));
				resUser.setName(res.getString("name"));
				return resUser;
			}

			return null;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
