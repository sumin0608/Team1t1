package jimmy.trainercert.dao.impl;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import jimmy.trainercert.dao.TrainerCertDao;
import jimmy.trainercert.vo.TrainerCert;

public class TrainerCertDaoImpl implements TrainerCertDao {
	private static DataSource dataSource;
//
	static {
		InitialContext initContext;
		try {
			initContext = new InitialContext();
			dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/trainer_course");
		} catch (NamingException e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// Get all
	@Override
	public List<TrainerCert> getAll() {
		//
		List<TrainerCert> trainerCerts = new ArrayList<>();

		String sql = "SELECT * FROM trainer_cert";
		try (
//				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainer_course?serverTimezone=Asia/Taipei", "root", "password");
				Connection connection = dataSource.getConnection(); // JNDI
				PreparedStatement st = connection.prepareStatement(sql)) {
			ResultSet resultSet = st.executeQuery();
			while (resultSet.next()) {
				int number = resultSet.getInt("number");
				String certName = resultSet.getString("cert_name");
				String englishCertName = resultSet.getString("english_cert_name");
				String abbrName = resultSet.getString("abbr_name");

				TrainerCert trainerCert = new TrainerCert(number, certName, englishCertName, abbrName);
				trainerCerts.add(trainerCert);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainerCerts;
	}

	// Add
	@Override
	public int addTrainerCert(TrainerCert trainerCert) {

		String sql = "INSERT INTO trainer_cert (cert_name, english_cert_name, abbr_name) VALUES (?, ?, ?)";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement st = connection.prepareStatement(sql)) {
			// 設參數
//			st.setInt(1, trainerCert.getNumber());
			st.setString(1, trainerCert.getCertName());
			st.setString(2, trainerCert.getEnglishCertName());
			st.setString(3, trainerCert.getAbbrName());

			return st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// delete
	@Override
	public int deleteTrainerCert(Integer id) {
		String sql = "delete from trainer_cert where number = ? ";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement st = connection.prepareStatement(sql)) {

			st.setInt(1, id);
			return st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// select
	@Override
	public TrainerCert selectTrainerCertByName(String cert_name) {
		String sql = "select * from trainer_cert where cert_name like ? ";
		String pattern = "%" + cert_name + "%";
		TrainerCert trainerCert = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement st = connection.prepareStatement(sql);) {
			st.setString(1, pattern);

			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {
				int number = resultSet.getInt("number");
				String certName = resultSet.getString("cert_name");
				String englishCertName = resultSet.getString("english_cert_name");
				String abbrName = resultSet.getString("abbr_name");
				trainerCert = new TrainerCert(number, certName, englishCertName, abbrName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainerCert;
	}

	@Override
	public TrainerCert ckeckTrainerCertByName(String cert_name) {
		String sql = "select * from trainer_cert where cert_name = ? ";
		TrainerCert trainerCert = null;
		try (Connection connection = dataSource.getConnection();
				PreparedStatement st = connection.prepareStatement(sql);) {
			st.setString(1, cert_name);

			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {
				int number = resultSet.getInt("number");
				String certName = resultSet.getString("cert_name");
				String englishCertName = resultSet.getString("english_cert_name");
				String abbrName = resultSet.getString("abbr_name");
				trainerCert = new TrainerCert(number, certName, englishCertName, abbrName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainerCert;
	}

	// update
	@Override
	public int updateTrainerCert(TrainerCert trainerCert) {
		String sql = "update trainer_cert " + "set " + "cert_name = ?, " + "english_cert_name = ?, " + "abbr_name = ? "
				+ "where number = ? ";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement st = connection.prepareStatement(sql);) {
			st.setString(1, trainerCert.getCertName());
			st.setString(2, trainerCert.getEnglishCertName());
			st.setString(3, trainerCert.getAbbrName());
			st.setInt(4, trainerCert.getNumber());
			return st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

//	public static void main(String[] args) {
//		TrainerCertDaoImpl app = new TrainerCertDaoImpl();
//		app.getAll();
//		for (TrainerCert cert : app.getAll()) {
//			System.out.println(cert); // toString()已override
//		}
//	}

}
