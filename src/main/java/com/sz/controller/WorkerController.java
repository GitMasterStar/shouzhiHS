package com.sz.controller;

import com.sz.common.vo.JsonResult;
import com.sz.common.vo.PageObject;
import com.sz.pojo.Worker;
import com.sz.service.WorkerService;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
@RequestMapping("/worker")
public class WorkerController {


    @Autowired
    private WorkerService workerService;

    /**
     * 员工申报页面
     * @return
     */
    @RequestMapping("/doDeclareWorkerList")
    public String doDeclareWorkerList(){
        return "declareWorker";
    }

    /**
     * 员工申报修改页面
     * @return
     */
    @RequestMapping("/doWorkerUI")
    public String doWorkerUI(){
        return "workerUI";
    }

    @RequestMapping("/doAuditWorkerList")
    public String doAuditWorkerList() {
        return "auditWorker";
    }

    /**
     * 员工信息页面
     * @return
     */
    @RequestMapping("/doWorkerList")
    public String doWorkerList(){
        return "worker";
    }

    /**
     * 分页查询用户信息
     * @param workername 用户名称
     * @param pageCurrent 具体页数
     * @return
     */
    @RequestMapping("/doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String workername, Integer pageCurrent){
        PageObject<Worker> pageObject = workerService.findPageObjects(workername, pageCurrent);
        return new JsonResult(pageObject);
    }
    /**
     * 基于用户id查询用户信息
     * @param id 用户id
     * @return
     */
    @RequestMapping("/doFindWorkerById")
    @ResponseBody
    public JsonResult doFindWorkerById(String id) {
        Worker worker= workerService.doFindWorkerById(id);
        return new JsonResult(worker);
    }
    @RequestMapping("/doAddObject")
    @ResponseBody
    public JsonResult doAddObject(Worker entity){
        workerService.doAddObject(entity);
        return new JsonResult("员工添加成功");
    }

    @RequestMapping("/doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(Worker entity){
        workerService.doUpdateObject(entity);
        return new JsonResult("员工修改成功");
    }
    @RequestMapping("/doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(Integer... ids){
        workerService.doDeleteObjects(ids);
        return new JsonResult("员工删除成功");
    }
    @RequestMapping("/doFindByWorker")
    @ResponseBody
    public JsonResult doFindByWorker(Worker entity){
         workerService.doFindByWorker(entity);
         return new JsonResult("查不到信息");
    }

    /*@RequestMapping(value = "/uploadAuditWorker",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public JsonResult uploadAuditWorker(){
        return new JsonResult("home");
    }*/

    /**
     * 导入模板解析
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/uploadAuditWorker",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadAuditWorker(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) {

        System.out.println(file.getOriginalFilename());
        /*System.out.println("上传文件："+file.getName());
        if (file.isEmpty()) {
            System.out.println("上传文件："+file.getName());
        }*/
        workerService.parseAndSava(request,response,file);
        return new JsonResult("上传文件成功");
    }

}
