package com.empresa.folha;

import com.empresa.folha.controller.Controller;
import com.empresa.folha.service.Service;
import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        Controller controller = new Controller(service);

        Javalin app = Javalin.create(config -> {
            config.jsonMapper(new JavalinJackson());
        });

        controller.registerRoutes(app);

        app.start(7000);
    }
}