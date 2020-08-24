package com.health.api.healthapi.messaginstompwebsocket;

import com.health.api.healthapi.services.AppointmentService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final AppointmentService appointmentService;

    public WebSocketConfig(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new AppointmentHandler(appointmentService), "/appointments").setAllowedOrigins("*");
    }

}
