package com.liyuan.controller.common;

import com.liyuan.component.cos.COSProperties;
import com.liyuan.model.MallAdmin;
import com.liyuan.model.MallUser;
import com.liyuan.service.AdministratorServiceImpl;
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
    private AdministratorServiceImpl administratorService;
    @Autowired
    private StorageServiceImpl storageService;
    @Autowired
    private COSProperties cosProperties;

    @PostMapping("/upload")
    @PreAuthorize("hasAnyRole('USER','STORE')")
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

    @PostMapping("/uploadAdminAvatar")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Object uploadAdminAvatar(@RequestParam("file") MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        String format = name.substring(name.lastIndexOf("."));
        String fileName = "/avatar/" + UUID.randomUUID().toString() + format;
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MallAdmin admin = new MallAdmin();
        admin.setUsername(user.getUsername());
        admin.setAvatar(fileName);
        administratorService.updateSelectiveByUsername(admin);
        MallAdmin a = administratorService.queryByUsername(user.getUsername(), MallAdmin.Column.id);
        fileService.putObject(file, FileEnum.AVATAR.value(), fileName, a.getId());
        return ResponseUtils.build(HttpStatus.OK.value(), "上传文件成功！");
    }


    @PostMapping("/image")
//    @PreAuthorize("hasAnyRole('USER','STORE')")
    public Object uploadImage(@RequestParam("file") MultipartFile file,
                              @RequestParam(value = "locationPrefix", required = false) String locationPrefix,
                              @RequestParam(value = "type", required = false) Integer type) throws IOException {
        Map<String, String> map = new HashMap<>();
        String name = file.getOriginalFilename();
        String format = name.substring(name.lastIndexOf("."));
        String fileName = locationPrefix + UUID.randomUUID().toString() + format;
        map.put("location", fileName);
        fileService.putObject(file, type, fileName, -1);
        return map;
    }

    @PostMapping("/adminUpload")
    @PreAuthorize("hasAnyRole('USER','STORE','ADMIN')")
    public Object simpleUpload(@RequestParam("file") MultipartFile file,
                               @RequestParam("locationPrefix") String prefix) throws IOException {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MallAdmin mallUser = administratorService.queryByUsername(principal.getUsername(), MallAdmin.Column.id);
        Map<String, String> map = new HashMap<>();
        String name = file.getOriginalFilename();
        String format = name.substring(name.lastIndexOf("."));
        String fileName = prefix + UUID.randomUUID().toString() + format;
        map.put("location", cosProperties.getBaseUrl() + fileName);
        fileService.putObject(file, -1, fileName, mallUser.getId());
        return ResponseUtils.build(HttpStatus.OK.value(), "管理员上传一张图片成功！", map);
    }
}
