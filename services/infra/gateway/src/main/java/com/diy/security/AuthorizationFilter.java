package com.diy.security;

import com.diy.exception.ExceptionHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.Objects;

@Log4j2
@Component
public class AuthorizationFilter extends AbstractGatewayFilterFactory<AuthorizationFilter.Config> {

    private final String uri = "http://localhost:8000/authentication/api/v1/role";
    private final RestTemplate restTemplate = new RestTemplate();

    public AuthorizationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        JwtChecks checks = new JwtChecks();

        return (exchange, chain) -> {

            String APITargeted = String.valueOf(exchange.getRequest().getURI());
            log.info("target: {}", APITargeted);

            // If we want a public api, we don't do any check
            if (getPublicPaths().contains(APITargeted)) {
                log.info("public path");
                return chain.filter(exchange);
            }

            checks.setToken(exchange.getRequest().getHeaders().getFirst("Authorization"));
            String role;
            if (checks.getToken() != null) {
                role = restTemplate.postForObject(uri, checks.getToken(), String.class);
            } else {
                log.info("no token");
                throw  new RuntimeException("You need to sign in");
            }

            if (Objects.equals(role, "authNeeded")) {
                throw  new RuntimeException("You need to sign in");
            }

            if (Objects.equals(role, "ADMIN") && getAdminPermission().contains(APITargeted)) {
                return chain.filter(exchange);
            } else if (Objects.equals(role, "OWNER") && getOwnerPermission().contains(APITargeted)) {
                return chain.filter(exchange);
            } else if (Objects.equals(role, "HANDLER") && getHandlerPermission().contains(APITargeted)) {
                return chain.filter(exchange);
            } else if (Objects.equals(role, "WORKER") && getWorkerPermission().contains(APITargeted)) {
                return chain.filter(exchange);
            } else if (Objects.equals(role, "USER") && getUserPermission().contains(APITargeted)) {
                return chain.filter(exchange);
            } else {
                throw new RuntimeException("Not enough privilege to do this.");
            }
        };

    }

    public static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;
    }

    /*
     * Admin users are basically allowed everywhere
     */
    private ArrayList<String> getAdminPermission() {
        ArrayList<String> permission = new ArrayList<>();
        permission.add("api/v1/customisation");
        permission.add("api/v1/subscription");
        permission.add("api/v1/ticket");
        permission.add("api/v1/authentication");
        permission.add("api/v1/customer");
        permission.add("api/v1/notification");
        permission.add("api/v1/order");
        permission.add("api/v1/product");
        permission.add("api/v1/store");

        return permission;
    }

    private ArrayList<String> getOwnerPermission() {
        ArrayList<String> permission = new ArrayList<>();
        permission.add("api/v1/customisation");
        permission.add("api/v1/subscription");
        permission.add("api/v1/ticket");
        permission.add("api/v1/authentication");
        permission.add("api/v1/customer");
        permission.add("api/v1/notification");
        permission.add("api/v1/order");
        permission.add("api/v1/product");
        permission.add("api/v1/store");

        return permission;
    }

    private ArrayList<String> getHandlerPermission() {
        ArrayList<String> permission = new ArrayList<>();
        permission.add("api/v1/ticket");
        permission.add("api/v1/authentication");
        permission.add("api/v1/customer");
        permission.add("api/v1/order");
        permission.add("api/v1/product");
        permission.add("api/v1/store");

        return permission;
    }

    private ArrayList<String> getWorkerPermission() {
        ArrayList<String> permission = new ArrayList<>();
        permission.add("api/v1/ticket");
        permission.add("api/v1/authentication");
        permission.add("api/v1/customer");
        permission.add("api/v1/order");
        permission.add("api/v1/product");
        permission.add("api/v1/store");

        return permission;
    }

    private ArrayList<String> getUserPermission() {
        ArrayList<String> permission = new ArrayList<>();
        permission.add("api/v1/ticket");
        permission.add("api/v1/authentication");
        permission.add("api/v1/customer");
        permission.add("api/v1/order");
        permission.add("api/v1/product");
        permission.add("api/v1/store");

        return permission;
    }


    private ArrayList<String> getPublicPaths() {
        ArrayList<String> permission = new ArrayList<>();
//        permission.add("api/v1/customisation");
        permission.add("api/v1/subscription");
        permission.add("api/v1/ticket");
        permission.add("api/v1/customer");
        permission.add("api/v1/order");
        permission.add("api/v1/product");
        permission.add("api/v1/store");

        return permission;
    }
}

