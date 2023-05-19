package dao.jimmy;

import java.util.List;

import vo.jimmy.TrainerCert;

public interface TrainerCertDao {

	public List<TrainerCert> getAll();
	public TrainerCert selectTrainerCertByname(String name);
	public int addTrainerCert(TrainerCert trainerCert);
	public int deleteTrainerCert(String abbr_name);
	public int updateTrainerCert(TrainerCert trainerCert);
}
