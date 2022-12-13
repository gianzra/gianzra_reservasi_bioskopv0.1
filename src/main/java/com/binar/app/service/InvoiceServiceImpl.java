package com.binar.app.service;

import com.binar.app.dto.FileDataDB;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public FileDataDB generateFileInvoice(String filename) throws JRException {

        HashMap<String, Object> map = new HashMap<>();
        map.put("pName", "Andelle Gianzra Basae");
        map.put("pFilmName", "Spider-Man: No Way Home\n");
        map.put("pSeat", "A31");
        map.put("pFilmSchedule", "2023-01-01");

        InputStream employeeReportStream = getClass().getResourceAsStream("/gianzrareservasibioskop.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map);
        byte[] pdfFile = JasperExportManager.exportReportToPdf(jasperPrint);
        FileDataDB fileDataDB = new FileDataDB();
        fileDataDB.setData(pdfFile);
        fileDataDB.setFilename(filename);
        fileDataDB.setFileType("application/pdf");
        return fileDataDB;
    }
}