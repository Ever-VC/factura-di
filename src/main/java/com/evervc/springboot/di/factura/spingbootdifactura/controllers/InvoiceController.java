package com.evervc.springboot.di.factura.spingbootdifactura.controllers;

import com.evervc.springboot.di.factura.spingbootdifactura.models.Client;
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
        // Creando cliente a partir del cliente proxy
        Client c = new Client();
        c.setName(invoice.getClient().getName());
        c.setLastname(invoice.getClient().getLastname());

        // Creando factura a partir de la factura proxy (De ese modo se envian objetos reales y no copias creadas por Spring)
        Invoice i = new Invoice(c, invoice.getItems());
        i.setDescription(invoice.getDescription());
        return i;
    }
}
