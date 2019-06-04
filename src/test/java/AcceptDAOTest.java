
import cn.edu.fudan.selab.DAO.AcceptDAO;
import cn.edu.fudan.selab.pojo.Accept;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AcceptDAOTest extends BaseTest {

    @Autowired
    AcceptDAO acceptDAO;

    @Test
    public void testQueryAcceptedSimpleTaskByTaskId() {
        int taskId = 1;
//        acceptDAO.addAcceptSimpleTask(2, 79);
//        Accept accept = acceptDAO.queryAcceptedSimpleTaskByTaskId(taskId);
//        System.out.println(accept.toString());
    }

    @Test
    public void testAddAcceptSimpleTask() {
        Accept accept = new Accept();
        accept.setTaskId(4);
        accept.setWorkerId(88);
        acceptDAO.addAcceptSimpleTask(accept);
        System.out.println(accept.getAcceptId());
    }


}
