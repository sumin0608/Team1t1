package jimmy.vo;

public class TrainerCert {

	private int number;
	private String certName;
	private String englishCertName;
	private String abbrName;

	// Constructor
	public TrainerCert(int number, String certName, String englishCertName, String abbrName) {
		this.number = number;
		this.certName = certName;
		this.englishCertName = englishCertName;
		this.abbrName = abbrName;
	}

	public TrainerCert(String certName, String englishCertName, String abbrName) {
		this.certName = certName;
		this.englishCertName = englishCertName;
		this.abbrName = abbrName;
	}

	public int getNumber() {
		return number;
	}

	public String getCertName() {
		return certName;
	}

	public String getEnglishCertName() {
		return englishCertName;
	}

	public String getAbbrName() {
		return abbrName;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public void setEnglishCertName(String englishCertName) {
		this.englishCertName = englishCertName;
	}

	public void setAbbrName(String abbrName) {
		this.abbrName = abbrName;
	}

	@Override
	public String toString() {
		return "TrainerCert資料{" + "number=" + number + ", certName='" + certName + '\'' + ", englishCertName='"
				+ englishCertName + '\'' + ", abbrName='" + abbrName + '\'' + '}';
	}

}
