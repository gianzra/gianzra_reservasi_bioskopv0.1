package com.binar.app.controller;

import com.binar.app.dto.FileDataDB;
import com.binar.app.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@Slf4j
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @Operation(summary = "this is to Generate File Pdf from Database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "generate File Pdf into from Database User",
                    content = {@Content(mediaType="application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Request Not Avilable",
                    content = @Content)
    })
    @GetMapping("/downloadFile")
    public ResponseEntity<?> fileDownloadJasper(@RequestParam(value = "filename") String filename) throws IOException, JRException {
        try{
            FileDataDB fileDataDB = invoiceService.generateFileInvoice(filename);
            log.info(fileDataDB+"file available");
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileDataDB.getFileType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename\"" + filename + "\"")
                    .body(new ByteArrayResource(fileDataDB.getData()));
        }catch(JRException e){
            log.error("file not found" + e.getMessage());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }
}