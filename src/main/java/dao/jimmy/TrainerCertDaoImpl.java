package dao.jimmy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import vo.jimmy.TrainerCert;

public class TrainerCertDaoImpl implements TrainerCertDao {
	private static DataSource dataSource;

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
		try (Connection connection = dataSource.getConnection(); // JNDI
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

		String sql = "INSERT INTO trainer_cert (number, cert_name, english_cert_name, abbr_name) VALUES (?, ?, ?, ?)";
		try (Connection connection = dataSource.getConnection();
		PreparedStatement st = connection.prepareStatement(sql)) {
			// 設參數
			st.setInt(1, trainerCert.getNumber());
			st.setString(2, trainerCert.getCertName());
			st.setString(3, trainerCert.getEnglishCertName());
			st.setString(4, trainerCert.getAbbrName());

			return st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	// delete
	@Override
	public int deleteTrainerCert(String name) {
		
		return -1;
	}

	@Override
	public TrainerCert selectTrainerCertByname(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateTrainerCert(TrainerCert trainerCert) {
		// TODO Auto-generated method stub
		return 0;
	}

}
