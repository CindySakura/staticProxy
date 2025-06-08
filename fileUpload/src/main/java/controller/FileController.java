package controller;

import common.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/file")
public class FileController {

    @RequestMapping
    public String hello(){
        return "hello";
    }

    @PostMapping("/upload")
    public Result upload(MultipartFile file){
        return null;
    }
}
