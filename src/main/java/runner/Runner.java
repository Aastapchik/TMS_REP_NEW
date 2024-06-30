package runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tasks.Task;

public class Runner {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        Task task = ac.getBean("taskWithList", Task.class);
        task.getMessage();

        Task task1 = ac.getBean("task1", Task.class);
        task1.getMessage();

    }
}
