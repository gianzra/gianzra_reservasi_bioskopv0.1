package com.binar.app.service;

import net.sf.jasperreports.engine.JRException;
import com.binar.app.dto.FileDataDB;
import java.io.FileNotFoundException;
public interface InvoiceService {
    FileDataDB generateFileInvoice(String filename) throws JRException, FileNotFoundException;
}
