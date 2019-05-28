package com.sz.service;

import com.sz.common.vo.PageObject;
import com.sz.pojo.Worker;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WorkerService {

    /**
     * 用户分页查询
     * @param workername
     * @param pageCurrent
     * @return
     */
    PageObject<Worker> findPageObjects(String workername, Integer pageCurrent);

    Worker doFindWorkerById(String id);

    int doAddObject(Worker entity);

    int doUpdateObject(Worker entity);

    int doDeleteObjects(Integer... ids);

    int doFindByWorker(Worker entity);

    int parseAndSava(HttpServletRequest request, HttpServletResponse response, MultipartFile file);

}
