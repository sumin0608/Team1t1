package jimmy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import core.config.AppConfig;
import jimmy.course.entity.Course;
import jimmy.course.service.CourseService;

public class Test {

	public static void main(String[] args) {
		// 創建Spring應用程序上下文，以便獲取配置的Hibernate相關Bean
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // 獲取名為"CourseService"的Bean實例
        CourseService courseService = context.getBean(CourseService.class);
        
        System.out.println("course資料: " + courseService.find(1235));
        ((ConfigurableApplicationContext) context).close();
        
	}
}
