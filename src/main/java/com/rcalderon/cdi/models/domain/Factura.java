package com.rcalderon.cdi.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope // Por cada request, se va crear una nueva instancia
// @SessionScope // Para carros de compra, solo se destruye cuando se cierra la
// pestaña
// @ApplicationScope // se guarda en el servlet, es singleton
public class Factura implements Serializable {

    // serialVersionUid, sirve como identificador para la serialización de
    // un objeto

    @Autowired
    private Cliente cliente;
    @Value("${factura.descripcion}")
    private String descripcion;
    @Autowired
    @Qualifier("itemsFacturaParaOficina")
    private List<ItemFactura> items;

    // Notación de Javax para ejecutar metodo y modificar datos del componente,
    // justo después de cuando sea construido.

    @PostConstruct
    public void initConstructor() {
        cliente.setNombre(cliente.getNombre().concat(" ").concat("de Jesús"));
    }

    // Notación para cuando se desea ejecutar un proceso
    // cuando se vaya a detener la aplicación
    @PreDestroy
    public void initDestruct() {

        cliente.setNombre("Default");
        System.out.println(cliente.getNombre());

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }

}
