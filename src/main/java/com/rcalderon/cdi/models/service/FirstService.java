package com.rcalderon.cdi.models.service;

import org.springframework.stereotype.Service;

///Un servicio trabaja directamente con los DAO o Repositorios p
///para hacer consultas a bases de datos

///La anotación @Component y @Service, son iguales, la diferencia es que semantica y es
/// para seguir el patrón de diseño y lógica del negocio
//@Service("myService")
public class FirstService implements IService {

    public FirstService() {
    }

    @Override
    public String operation() throws Exception {
        return "Con inyección de dependecias";
    }

}
