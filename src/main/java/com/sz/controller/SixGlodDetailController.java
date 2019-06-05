package com.sz.controller;

import com.alibaba.druid.util.StringUtils;
import com.sz.common.vo.JsonResult;
import com.sz.common.vo.PageObject;
import com.sz.pojo.SixGoldDetail;
import com.sz.service.SixGoldService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.DataFormatException;

@Controller
@RequestMapping("/sixGlodDetail")
public class SixGlodDetailController {

    @Autowired
    private SixGoldService sixGoldService;
    @RequestMapping("/doSixGlodDetailList")
    public String doSixGlodDetailList() {
        return "sixGoldDetail";
    }

    @RequestMapping("/doUpLoadFile")
    @ResponseBody
    public JsonResult doUpLoadFile(@RequestParam("file") MultipartFile file){
        try {
            sixGoldService.upLoadFile(file);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult("导入失败");
        }
        return new JsonResult("导入成功");
    }
    @RequestMapping("/doFindPageObject")
    @ResponseBody
    public JsonResult doFindPageObject(String workername, Integer pageCurrent, String month){
        PageObject<SixGoldDetail> pageObject= null;
        try {
            pageObject = sixGoldService.doFindPageObject(workername,pageCurrent,month);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult(pageObject);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpSession session) throws Exception {
        if(file.isEmpty()){
            throw new Exception("文件不存在");
        }
        String path = request.getSession().getServletContext().getRealPath("file");
        System.out.println("path:"+path);
        String fileName = file.getOriginalFilename();//获取到上传文件的名字
//System.out.println(file.getName()+"2222");获取到file
        //file.getSize();获取到上传文件的大小
        File dir = new File(path, fileName);
        System.out.println(file.getSize());
        if (!dir.exists()) {
            dir.mkdirs();
        }
//MultipartFile自带的解析方法  
        file.transferTo(dir);
        return "/file" + "/" + fileName;
    }
    @RequestMapping("/download")
    @ResponseBody
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, String filename) throws IOException {
//指定要下载的文件所在路径
        String path = request.getServletContext().getRealPath("/file/");
//创建该文件对象
        File file = new File(path+File.separator+filename);
//设置响应头
        HttpHeaders headers = new HttpHeaders();
//通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment",filename);
//定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//使用Spring MVC框架的ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);

    }



}


