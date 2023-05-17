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
		Course  course = dao.selectByCreator(creator);
		if (course != null) {
			course.setSuccessful(true);
			course.setMessage("搜尋成功!");

			System.out.println(course);
		} else {
			course = new Course(); //要new新的，因回傳null
			course.setCourseId(0);
			course.setCreator(0);
			course.setSuccessful(false);
			course.setMessage("搜尋失敗?");
			
			System.out.println(course);
		}
		return course;
	}

}
