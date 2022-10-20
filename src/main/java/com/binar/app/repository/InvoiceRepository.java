package com.binar.app.repository;

import com.binar.app.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query("Select a from Invoice a where invoiceId = ?1 and document_type = ?2")
    Invoice checkDocumentByInvoiceId(Long invoiceId, String docType);

    @Query("Select fileName from Invoice a where invoiceId = ?1 and document_type = ?2")
    String getUploadDocumentPath(Long invoiceId, String docType);

}
