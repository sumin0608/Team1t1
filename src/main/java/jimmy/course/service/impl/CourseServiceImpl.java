package jimmy.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jimmy.course.dao.CourseDao;
import jimmy.course.dao.impl.CourseDaoImpl;
import jimmy.course.entity.Course;
import jimmy.course.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao dao;

	@Override
	public List<Course> findAll() {
		return dao.selectAll();
	}

	@Override
	public Course find(Integer creator) {
		return dao.selectByCreator(creator);
	}

}
