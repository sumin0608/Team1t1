package jimmy.course.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import core.pojo.Core;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

@Entity
@Table(name = "course")
public class Course extends Core {

	private static final long serialVersionUID = -6150184187450772744L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "courseID")
	private Integer courseId;
	private Integer creator;
	private String eventName;
	private Integer expectedPrice;
	private Date courseStartDate;
	private Timestamp courseStartTime; //
	private LocalTime courseDuration;
	private Timestamp registrationDeadline; //
	private Timestamp courseCreationDate;
	private Integer maximumCapacity;
	private String description;
	private String photo;
	private String location;
	private String city;
	private String district;
	private String detailedAddress;
	@Column(name = "categoryID")
	private String categoryId;
	@Column(insertable = false)
	private Integer currentEnrolment;
	@Column(insertable = false)
	private Integer courseStatus;
	@Column(insertable = false)
	private Integer paidAdvertising;
	@Column(insertable = false)
	private Timestamp paidAdvertisingTime;

	public Course() {
	}

//	public TrainerCourse(Integer courseId, Integer memberId, String eventName, Integer expectedPrice, Date courseStartDate, Timestamp courseStartTime, Timestamp courseDuration, Timestamp registrationDeadline, Timestamp courseCreationDate, Integer maximumCapacity, String description, byte[] photo, String location, String city, String district, String detailedAddress, Integer categoryId, Integer currentEnrolment, Integer courseStatus, Integer paidAdvertising, Timestamp paidAdvertisingTime) {
//	        this.courseId = courseId;
//	        this.memberId = memberId;
//	        this.eventName = eventName;
//	        this.expectedPrice = expectedPrice;
//	        this.courseStartDate = courseStartDate;
//	        this.courseStartTime = courseStartTime;
//	        this.courseDuration = courseDuration;
//	        this.registrationDeadline = registrationDeadline;
//	        this.courseCreationDate = courseCreationDate;
//	        this.maximumCapacity = maximumCapacity;
//	        this.description = description;
//	        this.photo = photo;
//	        this.location = location;
//	        this.city = city;
//	        this.district = district;
//	        this.detailedAddress = detailedAddress;
//	        this.categoryId = categoryId;
//	        this.currentEnrolment = currentEnrolment;
//	        this.courseStatus = courseStatus;
//	        this.paidAdvertising = paidAdvertising;
//	        this.paidAdvertisingTime = paidAdvertisingTime;
//	    }
//
//	public Integer getCourseId() {
//		return courseId;
//	}
//
//	public Integer getMemberId() {
//		return memberId;
//	}
//
//	public String getEventName() {
//		return eventName;
//	}
//
//	public Integer getExpectedPrice() {
//		return expectedPrice;
//	}
//
//	public Date getCourseStartDate() {
//		return courseStartDate;
//	}
//
//	public Timestamp getCourseStartTime() {
//		return courseStartTime;
//	}
//
//	public Timestamp getCourseDuration() {
//		return courseDuration;
//	}
//
//	public Timestamp getRegistrationDeadline() {
//		return registrationDeadline;
//	}
//
//	public Timestamp getCourseCreationDate() {
//		return courseCreationDate;
//	}
//
//	public Integer getMaximumCapacity() {
//		return maximumCapacity;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public byte[] getPhoto() {
//		return photo;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public String getDistrict() {
//		return district;
//	}
//
//	public String getDetailedAddress() {
//		return detailedAddress;
//	}
//
//	public Integer getCategoryId() {
//		return categoryId;
//	}
//
//	public Integer getCurrentEnrolment() {
//		return currentEnrolment;
//	}
//
//	public Integer getCourseStatus() {
//		return courseStatus;
//	}
//
//	public Integer getPaidAdvertising() {
//		return paidAdvertising;
//	}
//
//	public Timestamp getPaidAdvertisingTime() {
//		return paidAdvertisingTime;
//	}
//
//	public void setCourseId(Integer courseId) {
//		this.courseId = courseId;
//	}
//
//	public void setMemberId(Integer memberId) {
//		this.memberId = memberId;
//	}
//
//	public void setEventName(String eventName) {
//		this.eventName = eventName;
//	}
//
//	public void setExpectedPrice(Integer expectedPrice) {
//		this.expectedPrice = expectedPrice;
//	}
//
//	public void setCourseStartDate(Date courseStartDate) {
//		this.courseStartDate = courseStartDate;
//	}
//
//	public void setCourseStartTime(Timestamp courseStartTime) {
//		this.courseStartTime = courseStartTime;
//	}
//
//	public void setCourseDuration(Timestamp courseDuration) {
//		this.courseDuration = courseDuration;
//	}
//
//	public void setRegistrationDeadline(Timestamp registrationDeadline) {
//		this.registrationDeadline = registrationDeadline;
//	}
//
//	public void setCourseCreationDate(Timestamp courseCreationDate) {
//		this.courseCreationDate = courseCreationDate;
//	}
//
//	public void setMaximumCapacity(Integer maximumCapacity) {
//		this.maximumCapacity = maximumCapacity;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public void setPhoto(byte[] photo) {
//		this.photo = photo;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public void setDistrict(String district) {
//		this.district = district;
//	}
//
//	public void setDetailedAddress(String detailedAddress) {
//		this.detailedAddress = detailedAddress;
//	}
//
//	public void setCategoryId(Integer categoryId) {
//		this.categoryId = categoryId;
//	}
//
//	public void setCurrentEnrolment(Integer currentEnrolment) {
//		this.currentEnrolment = currentEnrolment;
//	}
//
//	public void setCourseStatus(Integer courseStatus) {
//		this.courseStatus = courseStatus;
//	}
//
//	public void setPaidAdvertising(Integer paidAdvertising) {
//		this.paidAdvertising = paidAdvertising;
//	}
//
//	public void setPaidAdvertisingTime(Timestamp paidAdvertisingTime) {
//		this.paidAdvertisingTime = paidAdvertisingTime;
//	}
}
