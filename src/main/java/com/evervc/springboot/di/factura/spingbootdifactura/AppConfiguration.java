package com.evervc.springboot.di.factura.spingbootdifactura;

import com.evervc.springboot.di.factura.spingbootdifactura.models.Item;
import com.evervc.springboot.di.factura.spingbootdifactura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:data.properties")
public class AppConfiguration {

    @Bean
    List<Item> itemsInvoice() {
        return Arrays.asList(
                new Item(new Product("Teclado Redragon", 49.95), 2),
                new Item(new Product("Laptop MSI", 750), 4)
        );
    }

    @Bean
    @Primary
    List<Item> itemsInvoiceOffice() {
        return Arrays.asList(
                new Item(new Product("Monitor ASUS", 187.95), 2),
                new Item(new Product("Escritorio AnyDesk", 140), 1),
                new Item(new Product("Silla de Oficina", 124.95), 4),
                new Item(new Product("Laptop MSI", 950), 1)
        );
    }
}
