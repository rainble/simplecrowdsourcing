
import cn.edu.fudan.selab.DAO.SimpleTaskDAO;
import cn.edu.fudan.selab.pojo.SimpleTask;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SimpleTaskDAOTest extends BaseTest{

    @Autowired
    private SimpleTaskDAO simpleTaskDAO;

    @Test
    public void testAddSimpleTask() {
        SimpleTask simpleTask = new SimpleTask();
        simpleTask.setTaskDesc("my dear Holmes");
        simpleTask.setLocationDesc("Baker Street");
        simpleTask.setBonus(4);
        simpleTask.setDuration(30);
        int num = simpleTaskDAO.addSimpleTask(simpleTask);
        System.out.println("the num is: " + num);
        System.out.println("the id is: " + simpleTask.getTaskId());
    }


    @Test
    public void testQuerySimpleTaskByTaskId() {
        int taskId = 9;
        SimpleTask simpleTask = simpleTaskDAO.querySimpleTaskByTaskId(taskId);
        System.out.println(simpleTask.toString());
    }
}
