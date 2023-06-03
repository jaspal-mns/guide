package com.guide;

import com.guide.entity.Order;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.uri.UriBuilder;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller("/orders")
public class OrderController {

    private final OrderHandler orderHandler;
    private final QueryHandler queryHandler;

    @Get(uri="/{orderId}")
    @Produces(value = {"application/json"})
    public Order getOrder(String orderId) {
        return queryHandler.handle(orderId);
    }

    @Post(uri="/")
    public HttpResponse<Void> createOrder(OrderCmd.OrderCreateCmd orderCreateCmd) {
       var orderId =  orderHandler.handle(orderCreateCmd);
        var uri = UriBuilder.of("/orders/").path(orderId).build();
        MutableHttpResponse<Void> httpResponse = HttpResponse.created(uri);
        httpResponse.header(HttpHeaders.LOCATION, uri.toString());
        return httpResponse;
    }
}
