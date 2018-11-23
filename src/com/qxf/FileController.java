package com.qxf;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.UUID;


@Controller
public class FileController {

    @Value("/data/images/")
    private String filePath;

    @RequestMapping(value="/testUpload",method=RequestMethod.POST)
    public String testFileUpload(@RequestParam("filename") MultipartFile multipartFile, @RequestParam("desc") String desc){
        System.out.println("name:"+desc);
        upload(multipartFile);
        return "success";
    }

    public String upload(MultipartFile file) {

        String fileName = file.getOriginalFilename();
        String originalName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());
        originalName = originalName.substring(originalName.lastIndexOf("/") + 1, originalName.length());
        String key = UUID.randomUUID().toString();
        String ext = originalName.substring(originalName.lastIndexOf(".") + 1, originalName.length());

        /*if(!StringUtils.upperCase(ext).equals("PNG") && !StringUtils.upperCase(ext).equals("JPG")) {
            throw new BizException("file.format.is.not.supported");
        }*/

        int width = 0;
        int height = 0;
        Long size = file.getSize();

        BufferedImage image = null;
        try {
            image = ImageIO.read(file.getInputStream());
        } catch (Exception e) {

        }
        // image=null 表示上传的不是图片格式
        if (image != null) {
            width = image.getWidth();
            height = image.getHeight();
        }

        System.out.printf(filePath);

        //文件存储到本地
        try {
            FileUtil.writeFile(file.getBytes(),filePath, fileName);
        } catch (Exception e) {
        }

        return key;
    }
}
