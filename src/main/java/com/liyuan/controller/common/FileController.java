package com.liyuan.controller.common;

import com.liyuan.service.FileServiceImpl;
import com.liyuan.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/common/file")
public class FileController {

    @Autowired
    private FileServiceImpl fileService;

    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file,
                         @RequestParam(value = "type", defaultValue = "-1") Integer type) {

        fileService.upload();
        return ResponseUtils.build(HttpStatus.OK.value(), "上传文件成功！", "这是文件地址！");
    }
}
