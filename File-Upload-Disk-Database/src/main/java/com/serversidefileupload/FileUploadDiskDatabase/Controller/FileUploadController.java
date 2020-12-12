package com.serversidefileupload.FileUploadDiskDatabase.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("file-upload")
public class FileUploadController {
    //uploaded-files
    @Value("${file.upload-directory}")
    private String directory;

    @PostMapping(value = "/single-file")
    public ResponseEntity<String> uploadFileToDisk(@RequestParam("File") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        File uploadedFile = new File(directory+fileName);
        uploadedFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(uploadedFile);
        fos.write(file.getBytes());
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }
}
