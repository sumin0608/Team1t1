package jimmy.course.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jimmy.course.dao.CourseDao;
//import jimmy.course.dao.impl.CourseDaoImpl;
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
	public List<Course> find(Integer creator) {
		 List<Course>  courselist = dao.selectByCreator(creator);
		if (courselist != null) {
			for(Course course:courselist) {
			course.setSuccessful(true);
			course.setMessage("搜尋成功!");
			System.out.println(course);
			}
		} else {
			List<Course> emptylist = Collections.emptyList(); //要new新的，因回傳null
			Course course = new Course();
			course.setCourseId(0);
			course.setCreator(0);
			course.setSuccessful(false);
			course.setMessage("搜尋失敗?");
			System.out.println(course);
			emptylist.add(course);
			return emptylist;
		}
		return courselist;
	}

}
