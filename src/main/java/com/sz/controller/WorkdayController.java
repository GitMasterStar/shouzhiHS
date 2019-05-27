package com.sz.controller;

import com.sz.common.vo.JsonResult;
import com.sz.common.vo.PageObject;
import com.sz.pojo.WorkDay;
import com.sz.service.WorkDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/workday")
public class WorkdayController {

    @Autowired
    private WorkDayService workDayService;

    @RequestMapping("/doWorkdayList")
    public String doWorkdayList() {
        return "workday";
    }

    @RequestMapping("/doWorkdayEditUI")
    public String doWorkdayEditUI() {
        return "workdayEditUI";
    }

    /**
     * 分页查询工作日信息
     * @param pageCurrent
     * @return
     */
    @RequestMapping("/doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(Integer pageCurrent) {
        PageObject<WorkDay> pageObject = workDayService.findPageObjects(pageCurrent);
        return new JsonResult(pageObject);
    }

    /**
     * 新增工作日信息
     * @param entity 保存对象
     * @return
     */
    @RequestMapping("/doAddObject")
    @ResponseBody
    public JsonResult doAddObject(WorkDay entity) {
        workDayService.addObject(entity);
        return new JsonResult("工作日信息添加成功");
    }

    /**
     * 修改工作日信息
     * @param entity 修改对象
     * @return
     */
    @RequestMapping("/doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(WorkDay entity) {
        workDayService.updateObject(entity);
        return new JsonResult("工作日信息修改成功");
    }

    /**
     * 删除工作日信息(可批量删除)
     * @param ids id集合
     * @return
     */
    @RequestMapping("/doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(Integer... ids) {
        workDayService.deleteObjects(ids);
        return new JsonResult("工作日信息删除成功");
    }

}
