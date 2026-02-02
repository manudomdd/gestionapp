package com.example.gestionapp;

import com.example.gestionapp.service.PedidoService;
import com.example.gestionapp.view.VentanaPrincipal;
import com.example.gestionapp.service.PedidoService;
import com.example.gestionapp.view.VentanaPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import java.awt.EventQueue;

@SpringBootApplication
public class GestionappApplication implements CommandLineRunner {

    @Autowired
    private PedidoService pedidoService;

    public static void main(String[] args) {

        new SpringApplicationBuilder(GestionappApplication.class)
                .headless(false)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {      
        System.out.println("Spring Boot ha arrancado. Abriendo ventana...");
        EventQueue.invokeLater(() -> {
            VentanaPrincipal frame = new VentanaPrincipal(pedidoService);
            frame.setVisible(true);
        });
    }
}