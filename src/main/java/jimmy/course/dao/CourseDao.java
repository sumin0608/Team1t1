package jimmy.course.dao;

import java.util.List;

import jimmy.course.entity.Course;

public interface CourseDao {

	public Course selectByCreator(Integer creator);

	public List<Course> selectAll();
}
