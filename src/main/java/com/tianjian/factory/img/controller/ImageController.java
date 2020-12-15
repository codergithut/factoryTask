package com.tianjian.factory.img.controller;

import com.tianjian.factory.img.service.ImageService;
import com.tianjian.factory.model.common.RestModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@RestController
@RequestMapping("/img")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("saveImage")
    @ApiOperation(value = "保存图片", notes = "保存图片", httpMethod = "POST")
    public RestModel<String> handleFileUpload(@RequestParam("file") MultipartFile file)
            throws IOException, NoSuchAlgorithmException, InvalidKeyException,
            XmlPullParserException {
        String fileName = UUID.randomUUID().toString();
        String s = file.getOriginalFilename().split("\\.")[1];
        System.out.println(s);
        imageService.fileUploader(file.getInputStream(), fileName + "." + s);
        return RestModel.success(fileName + "." + s);
    }


    @ApiOperation(value = "获取图片", notes = "获取图片", httpMethod = "GET")
    @GetMapping(value = "getImage", produces = MediaType.IMAGE_JPEG_VALUE)
    public BufferedImage getImage(@RequestParam String fileName) throws IOException,
            InvalidKeyException, NoSuchAlgorithmException {
        return ImageIO.read(imageService.getInputStream(fileName));
    }
}
