package com.rcalderon.cdi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rcalderon.cdi.models.domain.ItemFactura;
import com.rcalderon.cdi.models.domain.Producto;
import com.rcalderon.cdi.models.service.FirstServiceComplex;
import com.rcalderon.cdi.models.service.IService;

@Configuration
public class AppConfig {

    @Bean("myServiceComplex")
    public IService registrarMIService() {
        return new FirstServiceComplex();
    }

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems() {
        Producto productUno = new Producto("Rigoberto", new BigDecimal(0));
        Producto productoDos = new Producto("Rigoberto Test", new BigDecimal(12));

        ItemFactura nItemFactura = new ItemFactura(productUno, 2);
        ItemFactura nItemFactura2 = new ItemFactura(productoDos, 3);

        List<ItemFactura> items = new ArrayList<>();
        items.add(nItemFactura);
        items.add(nItemFactura2);

        return Arrays.asList(nItemFactura, nItemFactura2);
    }

    @Bean("itemsFacturaParaOficina")
    public List<ItemFactura> registrarItemsParaOficina() {
        Producto productUno = new Producto("Camara Sony", new BigDecimal(200.0));
        Producto productoDos = new Producto("Producto oficina", new BigDecimal(122.55));

        ItemFactura nItemFactura = new ItemFactura(productUno, 4);
        ItemFactura nItemFactura2 = new ItemFactura(productoDos, 12);

        List<ItemFactura> items = new ArrayList<>();
        items.add(nItemFactura);
        items.add(nItemFactura2);

        return Arrays.asList(nItemFactura, nItemFactura2);
    }

}
