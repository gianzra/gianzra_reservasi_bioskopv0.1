package com.binar.app.controller;

import com.binar.app.dto.InvoiceDTO;
import com.binar.app.response.UploadFileResponse;
import com.binar.app.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

   // @Autowired
    // InvoiceService invoiceService;

//    @PostMapping("/uploadInvoice")
//    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
//                                         @RequestParam("invoiceId") Long invoiceId,
//                                         @RequestParam("docType") String docType) {
//        String fileName = invoiceService.storeFile(file, invoiceId, docType);
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//
//        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
//
//    }
//
//    @GetMapping("/downloadInvoice")
//    public ResponseEntity<Resource> getInvoice(@RequestParam("invoiceId") Long invoiceId,
//                                               @RequestParam("docType") String docType,
//                                               HttpServletRequest request) {
//
//        String fileName = invoiceService.getDocumentName(invoiceId, docType);
//        Resource resource = null;
//        if(fileName != null && !fileName.isEmpty()) {
//            try {
//                resource = invoiceService.loadFileAsResource(fileName);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            String contentType = null;
//            try {
//                contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//            } catch (IOException ex) {
//                // logger.info("Could not determine file type.");
//            }
//
//            // Fallback to the default content type if type could not be determined
//            if(contentType == null) {
//                contentType = "application/octet-stream";
//            }
//
//            return ResponseEntity.ok()
//                    .contentType(MediaType.parseMediaType(contentType))
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                    .body(resource);
//        } else {
//            return ResponseEntity.notFound().build();
//        }

   // }

}
