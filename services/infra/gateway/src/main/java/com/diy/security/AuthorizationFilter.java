package com.diy.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@Log4j2
@Component
public class AuthorizationFilter extends AbstractGatewayFilterFactory<AuthorizationFilter.Config> {

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private DiscoveryClient discoveryClient;

    public AuthorizationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        JwtChecks checks = new JwtChecks();

        return (exchange, chain) -> {
            String uri = "/api/v1/authentication/role";
            uri = "http://" + discoveryClient.getInstances("AUTHENTICATION").get(0).getInstanceId() + uri;
            uri = uri.replace("authentication:", "");
//            String[] target = String.valueOf(exchange.getRequest().getPath()).split("/");
//            log.warn(Arrays.toString(target));
//            String APITargeted = "";
//            for (int i = 3; i < target.length; i++) {
//                APITargeted = APITargeted + target[i] + "/";
//            }
//            log.warn("api target: {}", APITargeted);

            String APITargeted = String.valueOf(exchange.getRequest().getPath());
            log.warn("api target: {}", APITargeted);
            // If we want a public api, we don't do any check
            for (Authorization authorization : getPublicPaths()) {
                if (APITargeted.contains(authorization.getPath()) && exchange.getRequest().getMethod() == authorization.getMethod()) {
                    return chain.filter(exchange);
                }
            }

            checks.setToken(exchange.getRequest().getHeaders().getFirst("Authorization"));
            String role;
            if (checks.getToken() != null) {
                role = restTemplate.postForObject(uri, checks, String.class);
            } else {
                throw  new RuntimeException("You need to sign in");
            }
            if (Objects.equals(role, "authNeeded")) {
                throw  new RuntimeException("You need to sign in");
            }

            if (Objects.equals(role, "ADMIN")) {
                return chain.filter(exchange);
            } else if (Objects.equals(role, "OWNER") && getOwnerPermission().toString()
                    .contains(new Authorization(exchange.getRequest().getMethod(), APITargeted).toString())) {
                return chain.filter(exchange);
            } else if (Objects.equals(role, "HANDLER") && getHandlerPermission().toString()
                    .contains(new Authorization(exchange.getRequest().getMethod(), APITargeted).toString())) {
                return chain.filter(exchange);
            } else if (Objects.equals(role, "WORKER") && getWorkerPermission().toString()
                    .contains(new Authorization(exchange.getRequest().getMethod(), APITargeted).toString())) {
                return chain.filter(exchange);
            } else if (Objects.equals(role, "USER") && getUserPermission().toString()
                    .contains(new Authorization(exchange.getRequest().getMethod(), APITargeted).toString())) {
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
     * Owner of a store can manage their store and do everything normal user and employees can do.
     */
    private ArrayList<Authorization> getOwnerPermission() {
        ArrayList<Authorization> permission = new ArrayList<>();
        permission.add(new Authorization(HttpMethod.GET, "api/v1/customisation/all"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/customisation"));
        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/customisation"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/customisation"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/customisation"));

        permission.add(new Authorization(HttpMethod.GET, "api/v1/subscription"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/subscription"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/subscription"));
        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/subscription"));

        permission.add(new Authorization(HttpMethod.GET, "api/v1/ticket/customer/all"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/ticket/store/all"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/ticket"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/ticket/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/ticket/save"));

        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/authentication/all"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/authentication/all"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/authentication/create/handler"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/authentication/create/worker"));
        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/authentication"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/authentication/save"));


        permission.add(new Authorization(HttpMethod.GET, "api/v1/customer"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/customer/all"));
        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/customer"));
        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/customer/all"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/customer/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/customer/save"));

        permission.add(new Authorization(HttpMethod.GET, "api/v1/order/all/store"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/order/all/customer"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/order"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/order/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/order/save"));
        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/order"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/order/status"));

        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/product/product"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/product/product/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/product/product/save"));

        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/product/category"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/product/category/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/product/category/save"));

        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/store"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/store/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/store/save"));

        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/store/address/id"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/store/address/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/store/address/save"));

        return permission;
    }

    private ArrayList<Authorization> getHandlerPermission() {
        ArrayList<Authorization> permission = new ArrayList<>();

        permission.add(new Authorization(HttpMethod.GET, "api/v1/ticket/customer/all"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/ticket/store/all"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/ticket"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/ticket/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/ticket/save"));

        permission.add(new Authorization(HttpMethod.POST, "api/v1/authentication/save"));


        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/product/product"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/product/product/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/product/product/save"));

        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/product/category"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/product/category/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/product/category/save"));

        permission.add(new Authorization(HttpMethod.GET, "api/v1/order/all/store"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/order/all/customer"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/order"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/order/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/order/save"));
        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/order"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/order/status"));

        return permission;
    }

    private ArrayList<Authorization> getWorkerPermission() {
        ArrayList<Authorization> permission = new ArrayList<>();

        permission.add(new Authorization(HttpMethod.GET, "api/v1/ticket/customer/all"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/ticket/store/all"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/ticket"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/ticket/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/ticket/save"));

        permission.add(new Authorization(HttpMethod.POST, "api/v1/authentication/save"));

        permission.add(new Authorization(HttpMethod.GET, "api/v1/order/all/store"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/order/all/customer"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/order"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/order/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/order/save"));
        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/order"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/order/status"));

        return permission;
    }

    private ArrayList<Authorization> getUserPermission() {
        ArrayList<Authorization> permission = new ArrayList<>();

        permission.add(new Authorization(HttpMethod.GET, "api/v1/customer"));
        permission.add(new Authorization(HttpMethod.DELETE, "api/v1/customer"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/customer/save"));

        permission.add(new Authorization(HttpMethod.GET, "api/v1/ticket/customer/all"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/authentication/save"));

        permission.add(new Authorization(HttpMethod.GET, "api/v1/ticket"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/ticket/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/ticket/save"));

        permission.add(new Authorization(HttpMethod.GET, "api/v1/order/all/customer"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/order"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/order/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/order/save"));

        return permission;
    }

    private ArrayList<Authorization> getPublicPaths() {
        ArrayList<Authorization> permission = new ArrayList<>();

        permission.add(new Authorization(HttpMethod.POST, "api/v1/authentication/login"));
        permission.add(new Authorization(HttpMethod.POST, "api/v1/authentication/save"));
        permission.add(new Authorization(HttpMethod.PUT, "api/v1/authentication/save"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/product/product"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/product/product/all"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/product/categories"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/product/category"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/store/all"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/store"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/store/name"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/store/address"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/store/address"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/subscription"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/customisation/all"));
        permission.add(new Authorization(HttpMethod.GET, "api/v1/customisation"));

        return permission;
    }
}

