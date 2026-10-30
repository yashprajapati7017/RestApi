package com.springboot.fileupload.MainController;

import com.springboot.fileupload.Helper.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Controller01 {

    @Autowired
    UploadFile uploadFile;

    @PostMapping("/image")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {

        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());

        try{
            if(uploadFile.upload(file)){
                return ResponseEntity.ok("successfuly upload");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok("working");
    }

}
