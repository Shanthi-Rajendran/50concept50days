package com.serversidefileupload.FileUploadDiskDatabase.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    void singleFileDiskUpload(MultipartFile file) throws IOException;
    void multiFileDiskUpload(MultipartFile[] file);
    void singleFileDBUpload(MultipartFile file) throws IOException;
}
