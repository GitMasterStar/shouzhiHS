package com.sz.service;

import com.sz.common.vo.PageObject;
import com.sz.pojo.SixGoldDetail;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public interface SixGoldService {


    String upLoadFile(MultipartFile file) throws Exception;

    PageObject<SixGoldDetail> doFindPageObject(String workername, Integer pageCurrent, String month) throws Exception;
}
