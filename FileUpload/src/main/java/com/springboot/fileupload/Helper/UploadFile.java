package com.springboot.fileupload.Helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class UploadFile {

    private final String UPLOAR_DIR="D:\\REST_API\\FileUpload\\src\\main\\resources\\static\\image";

    public boolean  upload(MultipartFile file) {
        boolean f=false;
        try {
            Files.copy(file.getInputStream(), Paths.get(UPLOAR_DIR+ File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
            f=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

}
