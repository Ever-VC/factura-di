package com.evervc.springboot.di.factura.spingbootdifactura.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Component
@RequiredArgsConstructor
public class Invoice {
    // Detalle de la factura

    private final Client client;

    @Value("${invoice.description}")
    private String description;

    private final List<Item> items; // Cada item tiene la relación a los productos
}
