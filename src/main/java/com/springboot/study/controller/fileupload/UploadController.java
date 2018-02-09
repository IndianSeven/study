package com.springboot.study.controller.fileupload;

import com.springboot.study.service.fileupload.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 18:10
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@Controller
@RequestMapping(value = "/upload",produces = "application/json")
public class UploadController {

    /**
     * 初始化上传文件界面,跳转到index.jsp
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }


    /**
     * 上传文件方法
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody
    String upload(HttpServletRequest request, MultipartFile file){

        String uploadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
        //如果目录不存在，自动创建文件夹
        File dir = new File(uploadDir);
        if (!dir.exists()){
            dir.mkdir();
        }
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID()+suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir+filename);
        //将上传的文件写入到服务器端文件内
        try {
            file.transferTo(serverFile);
        } catch (IOException e) {
            //打印堆栈错误信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    public @ResponseBody String uploads(HttpServletRequest request,MultipartFile[] file){
        //上传目录地址
        String uploaadDir = request.getSession().getServletContext().getRealPath("/")+"upload/";
        //如果目录不存在 自动创建文件夹
        File dir = new File(uploaadDir);
        if(!dir.exists()){
            dir.mkdir();
        }
        //遍历文件数组 执行附件上传
        for (int i = 0; i <file.length ; i++) {
            if (file[i]!=null){
                //调用上传方法
                try {
                    UploadService.excuteUploads(uploaadDir,file[i]);
                } catch (Exception e) {
                    //打印错误的堆栈信息
                    e.printStackTrace();
                    return "上传失败";
                }
            }
        }
        return "上传成功";
    }
}
