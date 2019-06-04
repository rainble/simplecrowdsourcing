package cn.edu.fudan.selab.DAO;


import cn.edu.fudan.selab.pojo.Publish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishDAO {

    /**
     * publish crowd task
     * @param publish
     * @return int
     * @create 2019-03-15 10:16
     **/
    int addPublishSimpleTask(Publish publish);

    /**
     * query task detail by taskId
     * @param taskId
     * @return com.selab.simplecrowd.pojo.SimpleTask
     * @create  20:06
     **/
    Publish queryPublishedSimpleByTaskId(@Param("taskId")int taskId);

    /**
     * list all of the tasks published by one publisher
     * @param publisherId
     * @return java.util.List<com.selab.simplecrowd.pojo.SimpleTask>
     * @create  20:23
     **/
    List<Publish> listPublishedSimpleTaskByUserId(@Param("publisherId")int publisherId);

    /**
     * query all task publihed to let user choose which to accept
     * @return java.util.List<com.selab.simplecrowd.pojo.Publish>
     * @create 2019-03-19 15:57
     **/
    List<Publish> listAllPublishedSimpleTask();

    /**
     * query the callbackUrl bu taskId for callback when the task is completed
     * @param taskId
     * @return java.lang.String
     * @create 2019-03-15 10:18
     **/
    String queryCallbackUrlByTaskId(@Param("taskId")int taskId);

    /**
     * delete the task
     * @param publishId
     * @return int
     * @create  20:35
     **/
    int deletePublishedSimpleTask(@Param("publishid")int publishId);
}
