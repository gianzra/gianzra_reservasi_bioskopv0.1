package com.binar.app.service;

import com.binar.app.exceptions.InvoiceException;
import com.binar.app.model.Invoice;
import com.binar.app.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class InvoiceServiceImpl implements InvoiceService {

    private Path invoiceStorageLocation;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Autowired
    public void InvoiceService(Invoice invoiceStorageProperties) {
        this.invoiceStorageLocation = Paths.get(invoiceStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.invoiceStorageLocation);
        } catch (Exception ex) {
            throw new InvoiceException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @Override
    public void generateInvoice() {

    }

    @Override
    public String getDocumentName(Long invoiceId, String docType) {
        return invoiceRepository.getUploadDocumentPath(invoiceId, docType);
    }

    @Override
    public Resource loadFileAsResource(String fileName) throws Exception {
        try {
            Path filePath = this.invoiceStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + fileName);
        }
    }

    @Override
    public String storeFile(MultipartFile file, Long invoiceId, String docType) {
        // Normalize file name
        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileName = "";
        try {
            // Check if the file's name contains invalid characters
            if(originalFileName.contains("..")) {
                throw new InvoiceException("Sorry! Filename contains invalid path sequence " + originalFileName);
            }
            String fileExtension = "";
            try {
                fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            } catch(Exception e) {
                fileExtension = "";
            }
            fileName = invoiceId + "_" + docType + fileExtension;
            Path targetLocation = this.invoiceStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            Invoice doc = invoiceRepository.checkDocumentByInvoiceId(invoiceId, docType);
            if(doc != null) {
                doc.setDocumentFormat(file.getContentType());
                doc.setFileName(fileName);
                invoiceRepository.save(doc);
            } else {
                Invoice newDoc = new Invoice();
                newDoc.setInvoiceId(invoiceId);
                newDoc.setDocumentFormat(file.getContentType());
                newDoc.setFileName(fileName);
                newDoc.setDocumentType(docType);
                invoiceRepository.save(newDoc);
            }
            return fileName;
        } catch (IOException ex) {
            throw new InvoiceException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

}
