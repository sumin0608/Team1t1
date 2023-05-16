package jimmy.trainercert.service;

import java.util.List;

import jimmy.trainercert.vo.TrainerCert;

public interface TrainerCertService {

	TrainerCert addnew(TrainerCert trainerCert);

	List<TrainerCert> getall();

	boolean remove(Integer id);

	TrainerCert edit(TrainerCert trainerCert);

	TrainerCert get(String certName);
}
