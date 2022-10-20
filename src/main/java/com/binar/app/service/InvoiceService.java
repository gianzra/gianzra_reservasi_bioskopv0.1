package com.binar.app.service;

import com.binar.app.model.Invoice;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface InvoiceService {

    void generateInvoice();
    String getDocumentName(Long invoiceId, String docType);
    Resource loadFileAsResource(String fileName) throws Exception;
    String storeFile(MultipartFile file, Long invoiceId, String docType);

}
