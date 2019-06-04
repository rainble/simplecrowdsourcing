import cn.edu.fudan.selab.service.AcceptService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AcceptServiceTest extends BaseTest{

    @Autowired
    AcceptService acceptService;

    @Test
    public void testAcceptSimpleTaskService() {
        int taskId = 8, workerId = 6;
        acceptService.acceptSimpleTaskService(taskId,workerId);
//        System.out.println(acceptService.acceptSimpleTaskService(taskId, workerId).toString());
    }

}
