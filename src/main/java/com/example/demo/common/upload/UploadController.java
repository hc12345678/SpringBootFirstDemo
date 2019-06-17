package com.example.demo.common.upload;


import com.example.demo.common.HttpResp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
@RequestMapping("upload")
@CrossOrigin
public class UploadController {



    @PostMapping("/addImage")
    @ResponseBody
    public Object addImage(@RequestParam(name = "image_data", required = false) MultipartFile file) {

        System.out.println();
        //文件上传
        if (!file.isEmpty()) {
            try {
                //图片命名
                String newCompanyImageName = "newPIC";
                String newCompanyImagepath = "D:\\img\\"+file.getOriginalFilename();
                File newFile = new File(newCompanyImagepath);
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(newFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                return HttpResp.fail();
            }
        }
        return HttpResp.success("上传成功");
    }



}
