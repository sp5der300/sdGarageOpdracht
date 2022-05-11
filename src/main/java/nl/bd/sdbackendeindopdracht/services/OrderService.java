package nl.bd.sdbackendeindopdracht.services;


import nl.bd.sdbackendeindopdracht.models.Order;
import nl.bd.sdbackendeindopdracht.models.requestModels.OrderRequest;
import nl.bd.sdbackendeindopdracht.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    public final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order addNewOrder(OrderRequest order){
        Order order1 = Order.builder()
                .name(order.getName())
                .carBrand(order.getCarBrand())
                .build();
        return orderRepository.save(order1);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
