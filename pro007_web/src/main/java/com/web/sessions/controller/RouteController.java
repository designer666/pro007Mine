package com.web.sessions.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {

    /*@RequestMapping - позволяет указать путь к странице или функции на backend
    * RequestMethod   - позволяет указать тип запроса:
    * -GET    - чаще всего используется для получения данных от сервера
    * -POST   - используется когда необходимо создать какие-либо данные на сервере
    * -PUT    - используется для модификации данных на сервере
    * -DELETE - для удаления данных на сервере*/
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/js_example.html", method = RequestMethod.GET)
    public String jsExamplePage() {
        return "js_example";
    }

    @RequestMapping(value = "/form_example.html", method = RequestMethod.GET)
    public String formExamplePage() {
        return "form_example";
    }
}
