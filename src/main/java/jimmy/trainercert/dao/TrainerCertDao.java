package jimmy.trainercert.dao;

import java.util.List;

import jimmy.trainercert.entity.TrainerCert;

public interface TrainerCertDao {

	public List<TrainerCert> getAll();
	public List<TrainerCert> selectTrainerCertByName(String cert_name);
	public TrainerCert ckeckTrainerCertByName(String cert_name);
//	public TrainerCert selectTrainerCertById(Integer id);
	
	public int addTrainerCert(TrainerCert trainerCert);
	public int deleteTrainerCert(Integer id);
	public int updateTrainerCert(TrainerCert trainerCert);
}
