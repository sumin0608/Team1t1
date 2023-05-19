package jimmy.trainercert.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jimmy.trainercert.dao.TrainerCertDao;
import jimmy.trainercert.entity.TrainerCert;

@Repository
public class TrainerCertDaoImpl implements TrainerCertDao {
	
	@PersistenceContext
	private Session session;

//	private static DataSource dataSource;
//	static {
//		InitialContext initContext;
//		try {
//			initContext = new InitialContext();
//			dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/trainer_course");
//		} catch (NamingException e) {
//			System.out.println("Error: " + e.getMessage());
//			e.printStackTrace();
//		}
//	}

	@Override
	public List<TrainerCert> getAll() {
		final String sql = "FROM TrainerCert";
		return session.createQuery(sql, TrainerCert.class).getResultList();

//		List<TrainerCert> trainerCerts = new ArrayList<>();
//		String sql = "SELECT * FROM trainer_cert";
//		try (Connection connection = dataSource.getConnection(); // JNDI
//				PreparedStatement st = connection.prepareStatement(sql)) {
//			ResultSet resultSet = st.executeQuery();
//			while (resultSet.next()) {
//				int number = resultSet.getInt("number");
//				String certName = resultSet.getString("cert_name");
//				String englishCertName = resultSet.getString("english_cert_name");
//				String abbrName = resultSet.getString("abbr_name");
//
//				TrainerCert trainerCert = new TrainerCert(number, certName, englishCertName, abbrName);
//				trainerCerts.add(trainerCert);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return trainerCerts;
	}

	@Override
	public int addTrainerCert(TrainerCert trainerCert) {
		String sql = "INSERT INTO trainer_cert (cert_name, english_cert_name, abbr_name) VALUES (?, ?, ?)";
        int result = session.createNativeQuery(sql)
                .setParameter(1, trainerCert.getCertName())
                .setParameter(2, trainerCert.getEnglishCertName())
                .setParameter(3, trainerCert.getAbbrName())
                .executeUpdate();
        return result;
        
//		String sql = "INSERT INTO trainer_cert (cert_name, english_cert_name, abbr_name) VALUES (?, ?, ?)";
//		try (Connection connection = dataSource.getConnection();
//				PreparedStatement st = connection.prepareStatement(sql)) {
//			// 設參數
//  		//st.setInt(1, trainerCert.getNumber());
//			st.setString(1, trainerCert.getCertName());
//			st.setString(2, trainerCert.getEnglishCertName());
//			st.setString(3, trainerCert.getAbbrName());
//
//			return st.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
	}

	@Override
	public int deleteTrainerCert(Integer id) {
		TrainerCert trainerCert = session.load(TrainerCert.class, id);
		session.remove(trainerCert);
		return 1;

//		String sql = "delete from trainer_cert where number = ? ";
//		try (Connection connection = dataSource.getConnection();
//				PreparedStatement st = connection.prepareStatement(sql)) {
//
//			st.setInt(1, id);
//			return st.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return -1;
	}

	@Override
	public int updateTrainerCert(TrainerCert trainerCert) {
		 String sql = "update trainer_cert set cert_name = ?, english_cert_name = ?, abbr_name = ? where number = ?";
	     int result = session.createNativeQuery(sql)
	                .setParameter(1, trainerCert.getCertName())
	                .setParameter(2, trainerCert.getEnglishCertName())
	                .setParameter(3, trainerCert.getAbbrName())
	                .setParameter(4, trainerCert.getNumber())
	                .executeUpdate();
	     return result;
		
//		String sql = "update trainer_cert " + "set " + "cert_name = ?, " + "english_cert_name = ?, " + "abbr_name = ? "
//				+ "where number = ? ";
//		try (Connection connection = dataSource.getConnection();
//				PreparedStatement st = connection.prepareStatement(sql);) {
//			st.setString(1, trainerCert.getCertName());
//			st.setString(2, trainerCert.getEnglishCertName());
//			st.setString(3, trainerCert.getAbbrName());
//			st.setInt(4, trainerCert.getNumber());
//			return st.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return -1;
	}

	// select
	@Override
	public List<TrainerCert> selectTrainerCertByName(String cert_name) {
		 String pattern = "%" + cert_name + "%";
	     String hql = "from TrainerCert tc where tc.certName like :pattern";
	     List<TrainerCert> trainerCerts = session.createQuery(hql, TrainerCert.class)
	                .setParameter("pattern", pattern)
	                .getResultList();
	     return trainerCerts;
	}

	@Override
	public TrainerCert ckeckTrainerCertByName(String cert_name) {
		String sql = "FROM TrainerCert WHERE certName = :certName";
		return session.createQuery(sql, TrainerCert.class)
	                 .setParameter("certName", cert_name)
	                 .uniqueResult();
		
//		String sql = "select * from trainer_cert where cert_name = ? ";
//		TrainerCert trainerCert = null;
//		try (Connection connection = dataSource.getConnection();
//				PreparedStatement st = connection.prepareStatement(sql);) {
//			st.setString(1, cert_name);
//
//			ResultSet resultSet = st.executeQuery();
//			if (resultSet.next()) {
//				int number = resultSet.getInt("number");
//				String certName = resultSet.getString("cert_name");
//				String englishCertName = resultSet.getString("english_cert_name");
//				String abbrName = resultSet.getString("abbr_name");
//				trainerCert = new TrainerCert(number, certName, englishCertName, abbrName);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return trainerCert;
	}


	// 測試
//	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainer_course?serverTimezone=Asia/Taipei", "root", "password");
//	public static void main(String[] args) {
//		TrainerCertDaoImpl app = new TrainerCertDaoImpl();
//		app.getAll();
//		for (TrainerCert cert : app.getAll()) {
//			System.out.println(cert); // toString()已override
//		}
//	}

}
