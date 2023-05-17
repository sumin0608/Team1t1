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
	public Course selectByCreator(Integer creator) {
		String sql = "SELECT * FROM course WHERE creator = :creator";
		return session
				.createNativeQuery(sql,Course.class)
				.setParameter("creator", creator)
				.uniqueResult();
	}

	@Override
	public List<Course> selectAll() {
		final String sql = "SELECT * FROM course";
		return session.createNativeQuery(sql, Course.class).getResultList();
	}

}
