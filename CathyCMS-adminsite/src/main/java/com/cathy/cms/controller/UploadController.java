package com.cathy.cms.controller;

import cms.cathy.common.utils.FileUtils;
import consts.FilePathConst;
import consts.SiteConst;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by 陈敬 on 17/9/29.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping(value = "/uploadCoverImage", method = RequestMethod.POST)
    @ResponseBody
    public String uploadCoverImage(@RequestParam("pic") CommonsMultipartFile pic, HttpServletRequest req, HttpServletResponse response) throws IOException {
        //上传文件信息
        String fileName = pic.getOriginalFilename();
        String fileType = fileName.split("[.]")[1];

        //生成文件信息
        String filePath = req.getSession().getServletContext().getRealPath(FilePathConst.COVER_IMAGE_UPLOAD);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String uuidFileName = uuid + fileName;

        //保存文件
        File f = new File(filePath + "/" + uuid + "." + fileType);
        FileUtils.uploadFile(pic.getInputStream(), uuidFileName, filePath);

        return SiteConst.SITE_DOMAIN + FilePathConst.COVER_IMAGE_UPLOAD + uuidFileName;
    }
}
