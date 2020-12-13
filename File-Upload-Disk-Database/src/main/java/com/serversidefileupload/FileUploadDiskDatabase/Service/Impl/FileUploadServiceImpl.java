package com.serversidefileupload.FileUploadDiskDatabase.Service.Impl;

import com.serversidefileupload.FileUploadDiskDatabase.Exception.StorageException;
import com.serversidefileupload.FileUploadDiskDatabase.Model.UploadedFiles;
import com.serversidefileupload.FileUploadDiskDatabase.Repository.FileUploadRepository;
import com.serversidefileupload.FileUploadDiskDatabase.Service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    //uploaded-files
    @Value("${file.upload-directory}")
    private String directory;

    private FileUploadRepository repository;

    @Autowired
    public FileUploadServiceImpl(FileUploadRepository repository) {
        this.repository = repository;
    }

    @Override
    public void singleFileDiskUpload(MultipartFile file) throws IOException {
        try {
            String fileName = file.getOriginalFilename();
            File uploadedFile = new File(directory + fileName);
            uploadedFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(uploadedFile);
            fos.write(file.getBytes());
        }
        catch (IOException ex){
            throw new StorageException(String.format("Failed to store file %f", file.getName()));
        }
    }

    @Override
    public void multiFileDiskUpload(MultipartFile[] files) {
        Arrays.asList(files)
                .stream()
                .forEach(file -> {
                    try {
                        singleFileDiskUpload(file);
                    } catch (IOException e) {
                        throw new StorageException(String.format("Failed to store file %f", file.getName()));
                    }
        });
    }

    @Override
    public void singleFileDBUpload(MultipartFile file) throws IOException {
        UploadedFiles obj = new UploadedFiles();
        obj.setFile(file.getBytes());
        obj.setFileName(file.getOriginalFilename());
        repository.save(obj);
    }
}
