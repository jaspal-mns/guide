package com.guide;

import com.guide.entity.Order;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
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
       var orderId =  orderHandler.createOrder(orderCreateCmd);
        var uri = UriBuilder.of("/orders/").path(orderId).build();
        return HttpResponse.created(uri);
    }

    @Post(uri="/{orderId}/lines")
    public HttpResponse<Void> addLine(String orderId, OrderCmd.AddLineCmd addLineCmd) {
        orderHandler.addLine(orderId , addLineCmd);
        var uri = UriBuilder.of("/orders/").path(orderId).build();
        return HttpResponse.created(uri);
    }

    @Delete(uri="/{orderId}/lines/{lineId}")
    public HttpResponse<Void> deleteLine(String orderId, String lineId) {
        orderHandler.deleteLine(orderId , lineId);
        return HttpResponse.noContent();
    }
}
