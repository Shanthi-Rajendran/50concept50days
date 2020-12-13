package com.serversidefileupload.FileUploadDiskDatabase.Repository;

import com.serversidefileupload.FileUploadDiskDatabase.Model.UploadedFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends JpaRepository<UploadedFiles, Long> {
}
