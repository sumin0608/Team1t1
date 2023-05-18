package jimmy.trainercert.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jimmy.trainercert.dao.TrainerCertDao;
import jimmy.trainercert.dao.impl.TrainerCertDaoImpl;
import jimmy.trainercert.entity.TrainerCert;
import jimmy.trainercert.service.TrainerCertService;

@Service
public class TrainerCertServiceImpl implements TrainerCertService {

	@Autowired
	private TrainerCertDao dao;

//	public TrainerCertServiceImpl() {
//		dao = new TrainerCertDaoImpl();
//	}
	
	@Override
	public List<TrainerCert> getall() {
		System.out.println("到service成功");
		if (dao.getAll() != null) {
			return dao.getAll();
		} else {
			return null;
		}
	}
	
	@Transactional
	@Override
	public TrainerCert addnew(TrainerCert trainerCert) {
		if (trainerCert.getCertName() == null || trainerCert.getCertName() == "") {
			trainerCert.setSuccessful(false);
			trainerCert.setMessage("新增失敗，中文名未輸入");
			return trainerCert;
		}
		if (trainerCert.getEnglishCertName() == null || trainerCert.getEnglishCertName() == "") {
			trainerCert.setSuccessful(false);
			trainerCert.setMessage("新增失敗，英文名未輸入");
			return trainerCert;
		}
		if (trainerCert.getAbbrName() == null || trainerCert.getAbbrName() == "") {
			trainerCert.setSuccessful(false);
			trainerCert.setMessage("新增失敗，縮寫名未輸入");
			return trainerCert;
		}
		if (dao.ckeckTrainerCertByName(trainerCert.getCertName()) != null) {
			trainerCert.setSuccessful(false);
			trainerCert.setMessage("新增失敗，已存在此名稱");
			System.out.println(dao.selectTrainerCertByName(trainerCert.getCertName()));
			return trainerCert;
		}
		dao.addTrainerCert(trainerCert);
		trainerCert.setSuccessful(true);
		trainerCert.setMessage("新增成功!");
		System.out.println(trainerCert);
		return trainerCert;
	}


	@Transactional
	@Override
	public boolean remove(Integer id) {
		if (dao.deleteTrainerCert(id) > 0) {
			return true;
		}
		return false;
	}
	
	@Transactional
	@Override
	public TrainerCert edit(TrainerCert trainerCert) {
		if (trainerCert.getCertName() == null || trainerCert.getCertName() == "") {
			trainerCert.setSuccessful(false);
			trainerCert.setMessage("修改失敗，中文名未輸入");
			return trainerCert;
		}
		if (trainerCert.getEnglishCertName() == null || trainerCert.getEnglishCertName() == "") {
			trainerCert.setSuccessful(false);
			trainerCert.setMessage("修改失敗，英文名未輸入");
			return trainerCert;
		}
		if (trainerCert.getAbbrName() == null || trainerCert.getAbbrName() == "") {
			trainerCert.setSuccessful(false);
			trainerCert.setMessage("修改失敗，縮寫名未輸入");
			return trainerCert;
		}
		TrainerCert selectout = dao.ckeckTrainerCertByName(trainerCert.getCertName());
		if (selectout.getCertName() == trainerCert.getCertName()
				&& selectout.getEnglishCertName() == trainerCert.getEnglishCertName()) {
			trainerCert.setSuccessful(false);
			trainerCert.setMessage("修改失敗，已存在此名稱");
			return trainerCert;
		}

		if (dao.updateTrainerCert(trainerCert) > 0) {
			trainerCert.setSuccessful(true);
			trainerCert.setMessage("修改成功!");
			System.out.println(trainerCert);
		}
		return trainerCert;
	}

	public List<TrainerCert> get(String certName) {
		List<TrainerCert> trainerCerts = dao.selectTrainerCertByName(certName);
		if (trainerCerts != null) {
			for (TrainerCert trainerCert : trainerCerts) {
				trainerCert.setSuccessful(true);
				trainerCert.setMessage("搜尋成功!");
				System.out.println("service印出"+trainerCert);				
			}
		} else {
			List<TrainerCert> emptylist = Collections.emptyList();		
			TrainerCert trainerCert = new TrainerCert(); // 要new新的，因trainerCert回傳null
			trainerCert.setNumber(0);
			trainerCert.setCertName("none");
			trainerCert.setEnglishCertName("none");
			trainerCert.setAbbrName("none");
			trainerCert.setSuccessful(false);
			trainerCert.setMessage("搜尋失敗?");
			emptylist.add(trainerCert);
			System.out.println("service印出搜尋失敗");	
			return emptylist;
		}
		return trainerCerts;
	}

}
