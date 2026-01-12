package com.evervc.springboot.di.factura.spingbootdifactura.models;

import com.evervc.springboot.di.factura.spingbootdifactura.controllers.InvoiceController;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Setter
@Getter
@Component
@RequestScope
@RequiredArgsConstructor
public class Invoice {
    // Detalle de la factura

    private final Client client;

    @Value("${invoice.description}")
    private String description;

    private final List<Item> items; // Cada item tiene la relación a los productos

    private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);

    @PostConstruct
    public void init() {
        // Se pueden modificar los datos (Cosa que si se hace en el constructor falla porque los objetos siguen siendo null)
        //ya que el contenedor de Spring Boot ya ha inyectado cada elemento (y cuando internamente crea la nueva instancia no lo hace aún)
        log.warn("OJITO EH: CREANDO EL COMPONENTE DE LA FACTURA");
        log.info(client.getName());
        client.setLastname(client.getLastname().concat(" Canales"));
    }

    @PreDestroy
    public void destroy() {
        log.info("Destruyendo el componente invoice");
    }

    public double getTotal() {
        return items.stream().reduce(0.0, (subtotal, item) -> subtotal + item.getAmount(), Double::sum);
    }
}
