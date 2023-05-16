package jimmy.course.dao.impl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import jimmy.course.dao.CourseDao;
import jimmy.course.entity.Course;

public class CourseDaoImpl implements CourseDao {

	@PersistenceContext
	private Session session;

	@Override
	public Course selectByCreator(Integer creator) {
		return session.get(Course.class, creator);
	}

	@Override
	public List<Course> selectAll() {
		final String hql = "FROM course ORDER BY courseID";
		return session.createQuery(hql, Course.class).getResultList();
	}

}
