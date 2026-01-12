package com.evervc.springboot.di.factura.spingbootdifactura.controllers;

import com.evervc.springboot.di.factura.spingbootdifactura.models.Invoice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final Invoice invoice;
    private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);

    @GetMapping("/show")
    public Invoice show() {
        log.info("---------------------------");
        log.info("ANTES DE MOSTRAR");
        log.info("---------------------------");
        log.info(invoice.getItems().getFirst().getProduct().getName());
        log.info("---------------------------");
        return invoice;
    }
}
