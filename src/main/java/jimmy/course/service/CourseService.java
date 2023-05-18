package jimmy.course.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jimmy.course.entity.Course;
@Transactional
public interface CourseService {
	List<Course> findAll();

	List<Course> find(Integer creator);
}
