package com.luqtta.controller;

import com.luqtta.dto.CreateOrderRequest;
import com.luqtta.entity.Order;
import com.luqtta.service.OrderService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/orders")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderController {

    @Inject
    OrderService orderService;

    @POST
    public Response createOrder(@Valid CreateOrderRequest request) {
        Order order = orderService.createOrder(request);

        return Response.created(URI.create("/orders/" + order.id))
                .entity(order)
                .build();
    }

    @GET
    @Path("/{id}")
    public Order findById(@PathParam("id") Long id) {
        return orderService.findById(id);
    }

    @GET
    public List<Order> findAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("10") int size
    ) {
        return orderService.findAll(page, size);
    }
}