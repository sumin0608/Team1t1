package jimmy.course.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import jimmy.course.dao.CourseDao;
import jimmy.course.entity.Course;

@Repository
public class CourseDaoImpl implements CourseDao {

	@PersistenceContext
	private Session session;

	@Override
	public int insertCourse(Course course) {
				session.persist(course);
				return 1;
	}

	@Override
	public int deleteByCourseId(Integer courseId) {
		Course course = session.load(Course.class, courseId);
		session.remove(course);
		return 1;
	}

	@Override
	public int upateByCourseId(Integer courseId) {
		final StringBuilder hql = new StringBuilder()
				.append("UPDATE course SET ");
//		
		hql.append("eventName = :eventName,")
			.append("courseStartDate = :courseStartDate,")
			.append("courseStartTime = :courseStartTime,")
			.append("registrationDeadline = :registrationDeadline,")
			
//			.append("lastUpdatedDate = NOW() ")
			.append("WHERE courseId = :courseId");
//		Query query = session.createQuery(hql.toString());
//		
//		return query.setParameter("nickname", member.getNickname())
//				.setParameter("pass", member.getPass())
//				.setParameter("roleId", member.getRoleId())
//				.setParameter("updater", member.getUpdater())
//				.setParameter("username", member.getUsername())
//				.executeUpdate();
		return 0;
	}

	@Override
	public Course selectByName(String eventName) {
		String sql = "SELECT * FROM course WHERE eventName = :eventName";
		return session
				.createNativeQuery(sql,Course.class)
				.setParameter("eventName", eventName)
				.uniqueResult();
	}

	@Override
	public List<Course> selectBycategoryId(String categoryId) {
		String sql = "SELECT * FROM course WHERE categoryID = :categoryId";
		return session
				.createNativeQuery(sql,Course.class)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}
	
	@Override
	public List<Course> selectByCity(String city) {
		String sql = "SELECT * FROM course WHERE city = :city";
		return session
				.createNativeQuery(sql,Course.class)
				.setParameter("city", city)
				.getResultList();
	}
	
	@Override
	public List<Course> selectByCreator(Integer creator) {
		String sql = "SELECT * FROM course WHERE creator = :creator";
		return session
				.createNativeQuery(sql,Course.class)
				.setParameter("creator", creator)
				.getResultList();
	}

	@Override
	public List<Course> selectAll() {
		final String sql = "SELECT * FROM course";
		return session.createNativeQuery(sql, Course.class).getResultList();
	}


}
