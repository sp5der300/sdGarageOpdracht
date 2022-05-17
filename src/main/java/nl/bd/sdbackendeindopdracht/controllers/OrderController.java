package nl.bd.sdbackendeindopdracht.controllers;

import nl.bd.sdbackendeindopdracht.models.Order;
import nl.bd.sdbackendeindopdracht.models.requestModels.OrderRequest;
import nl.bd.sdbackendeindopdracht.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("API/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PostMapping("/newOrder")
    public Order newOrder(@RequestBody OrderRequest order){
        return orderService.addNewOrder(order);
    }

    @PutMapping("/editOrder/order={orderId}")
    public Order editOrder(@RequestBody OrderRequest order, @PathVariable("orderId") Long orderId){
        return orderService.editOrder(order, orderId);
    }

    @DeleteMapping
    public void deleteOrder(Long id){
        orderService.deleteOrder(id);
    }

}
