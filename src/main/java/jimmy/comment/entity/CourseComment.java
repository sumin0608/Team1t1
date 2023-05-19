package jimmy.comment.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

@Entity
@Table(name = "course_comment")
public class CourseComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	private Integer courseId;
	private Integer accountIdReviewed;
	private Integer accountIdReviewer;
	private String commentContent;
	private Integer commentRating;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public CourseComment() {
	}
}
