
import cn.edu.fudan.selab.pojo.SimpleTask;
import cn.edu.fudan.selab.service.PublishService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PublishServiceTest extends BaseTest {

    @Autowired
    PublishService publishService;

    @Test
    public void testPublishSimpleTask() {
        SimpleTask simpleTask = new SimpleTask();
        simpleTask.setTaskDesc("simada soji");
        simpleTask.setLocationDesc("Japan");
        simpleTask.setDuration(30);
        simpleTask.setBonus(10);
        int publisherId = 80;
        String callbackUrl = "mail.fudan.edu.cn";
        String res = publishService.publishSimpleTask(simpleTask, publisherId, callbackUrl).toString();
        System.out.println(res);
    }

}
