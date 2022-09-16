package com.rcalderon.cdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rcalderon.cdi.models.service.IService;

///@Controller es de tipo componente
@Controller
public class IndexController {

    // Anotación para inyectar la dependencia
    @Autowired
    // @Qualifier("myServiceComplex")
    private IService servicio;

    @GetMapping({ "/index", "/", "" })
    public String index(Model model) {
        try {
            model.addAttribute("notInjection", servicio.operation());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
