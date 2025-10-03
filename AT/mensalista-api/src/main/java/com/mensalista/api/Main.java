package com.mensalista.api;

import com.mensalista.api.controller.Controller;
import com.mensalista.api.controller.MensalistaController;
import com.mensalista.api.service.Service;
import com.mensalista.api.service.MensalistaService;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        Service service = new Service();
        MensalistaService mensalistaService = new MensalistaService();

        Controller controller = new Controller(service);
        MensalistaController mensalistaController = new MensalistaController(mensalistaService);

        controller.registerRoutes(app);
        mensalistaController.registerRoutes(app);
    }
}
