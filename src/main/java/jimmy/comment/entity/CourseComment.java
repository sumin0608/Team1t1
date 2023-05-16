package jimmy.comment.entity;

import java.sql.Timestamp;

public class CourseComment {
	private Integer commentId;
	private Integer courseId;

	private Integer accountIdReviewer;
	private Integer accountIdTrainer;
	private String commentContent;
	private Integer commentRating;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
