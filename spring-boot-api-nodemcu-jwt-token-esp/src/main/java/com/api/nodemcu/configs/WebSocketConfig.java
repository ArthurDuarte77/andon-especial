package com.api.nodemcu.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic", "/user", "/amplificador", "/amplificador2", "/controle", "/inversor1", "/inversor2", "/gerenciaveis");
        config.setApplicationDestinationPrefixes("/app");
        config.setUserDestinationPrefix("/amplificador");
        config.setUserDestinationPrefix("/amplificador2");
        config.setUserDestinationPrefix("/controle");
        config.setUserDestinationPrefix("/inversor1");
        config.setUserDestinationPrefix("/inversor2");
        config.setUserDestinationPrefix("/gerenciaveis");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*");
                // .withSockJS();
    }
}