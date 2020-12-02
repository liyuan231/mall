package com.liyuan.controller.common;

import com.liyuan.model.MallUser;
import com.liyuan.service.FileServiceImpl;
import com.liyuan.service.StorageServiceImpl;
import com.liyuan.service.UserServiceImpl;
import com.liyuan.utils.FileEnum;
import com.liyuan.utils.ResponseUtils;
import com.qcloud.cos.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/common/file")
public class FileController {

    @Autowired
    private FileServiceImpl fileService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private StorageServiceImpl storageService;

    @PostMapping("/upload")
    @PreAuthorize("hasAnyRole('USER','ADMINISTRATOR')")
    public Object uploadAvatar(@RequestParam("file") MultipartFile file,
                               @RequestParam(value = "type", defaultValue = "-1") Integer type) throws IOException {

        String name = file.getOriginalFilename();
        String format = name.substring(name.lastIndexOf("."));
        String fileName = "/avatar/" + UUID.randomUUID().toString() + format;
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MallUser mallUser = new MallUser();
        if (type.equals(FileEnum.AVATAR.value())) {
            mallUser.setUsername(user.getUsername());
            mallUser.setAvatar(fileName);
            userService.updateSelectiveByUsername(mallUser);
        }
        PutObjectResult putObjectResult = fileService.putObject(file, type, fileName, -1);
        return ResponseUtils.build(HttpStatus.OK.value(), "上传文件成功！");
    }

    @PostMapping("/image")
//    @PreAuthorize("hasAnyRole('USER','STORE')")
    public Object uploadImage(@RequestParam("file") MultipartFile file,
                              @RequestParam(value = "locationPrefix",required = false) String locationPrefix,
                              @RequestParam(value = "type",required = false) Integer type) throws IOException {
        Map<String, String> map = new HashMap<>();
        String name = file.getOriginalFilename();
        String format = name.substring(name.lastIndexOf("."));
        String fileName = locationPrefix + UUID.randomUUID().toString() + format;
        map.put("location", fileName);
        fileService.putObject(file, type, fileName, -1);
        return map;
    }
}
