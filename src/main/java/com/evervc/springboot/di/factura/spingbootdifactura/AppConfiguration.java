package com.evervc.springboot.di.factura.spingbootdifactura;

import com.evervc.springboot.di.factura.spingbootdifactura.models.Item;
import com.evervc.springboot.di.factura.spingbootdifactura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
}
