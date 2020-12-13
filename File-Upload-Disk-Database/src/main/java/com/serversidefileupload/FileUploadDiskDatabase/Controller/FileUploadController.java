package com.serversidefileupload.FileUploadDiskDatabase.Controller;

import com.serversidefileupload.FileUploadDiskDatabase.Service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequestMapping("file-upload")
public class FileUploadController {
    private FileUploadService service;

    @Autowired
    public FileUploadController(FileUploadService service) {
        this.service = service;
    }

    @PostMapping(value = "/single-file", consumes = {"multipart/form-data"})
    public ResponseEntity<String> uploadFileToDisk(@RequestParam("File") MultipartFile file) throws IOException {
        System.out.println("accepting");
        service.singleFileDiskUpload(file);
        return new ResponseEntity<>("File uploaded successfully", HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/multiple-file", consumes = {"multipart/form-data"})
    public ResponseEntity<String> uploadMultipleFileToDisk(@RequestParam("File") MultipartFile[] files) throws IOException {
        service.multiFileDiskUpload(files);
        return new ResponseEntity<>("File uploaded successfully", HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/database", consumes = {"multipart/form-data"})
    public ResponseEntity<String> uploadFileToDB(@RequestParam("File")MultipartFile file) throws IOException {
        service.singleFileDBUpload(file);
        return new ResponseEntity<>("File upload to db successfully", HttpStatus.ACCEPTED);
    }

}
