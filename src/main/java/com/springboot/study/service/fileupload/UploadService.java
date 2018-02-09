package com.springboot.study.service.fileupload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Copyright © 2018 宫宇祁. All rights reserved.
 * <p>
 * ${DESCRIPTION}
 *
 * @create 2018-01-16 18:12
 * @author: 宫宇祁
 * @ModificationHistory Who     When      What
 */
@Service
public class UploadService {
    public static void excuteUploads(String uploadDir, MultipartFile file) throws Exception{
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = System.nanoTime()+suffix;
        //服务器端保存的对象
        File serverFile = new File(uploadDir+filename);
        //将上传的文件写入到服务端文件内
        file.transferTo(serverFile);
    }
}
