package com.tianjian.factory.img.controller;

import com.tianjian.factory.img.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Controller
public class GetImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping(value = "/getImage",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public BufferedImage getImage(@RequestParam String fileName) throws IOException,
            InvalidKeyException, NoSuchAlgorithmException {
        return ImageIO.read(imageService.getInputStream(fileName));
    }
}
