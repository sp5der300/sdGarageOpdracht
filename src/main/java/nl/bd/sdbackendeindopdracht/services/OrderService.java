package nl.bd.sdbackendeindopdracht.services;


import nl.bd.sdbackendeindopdracht.models.Order;
import nl.bd.sdbackendeindopdracht.models.Parts;
import nl.bd.sdbackendeindopdracht.models.requestModels.OrderRequest;
import nl.bd.sdbackendeindopdracht.models.requestModels.PartsRequest;
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

    public Order editOrder(OrderRequest order, Long orderId) {
        Order orderFromDatabase = null;
        if (orderRepository.findById(orderId).isEmpty()) {
            throw new RuntimeException("Order is empty or does not exist.");
        }
        else{
            orderFromDatabase = orderRepository.findById(orderId).get();
            orderFromDatabase.setName(order.getName());
            orderFromDatabase.setCarBrand(order.getCarBrand());
            orderFromDatabase.setDate(order.getDate());
            orderFromDatabase.setOrderNr(order.getOrderNr());
            orderFromDatabase.setTotalPrice(order.getTotalPrice());
        }
        return orderRepository.save(orderFromDatabase);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order addPartsToOder(Long orderId, PartsRequest partsRequest) {
        Order orderFromDatabase;
        if (orderRepository.findById(orderId).isEmpty()){
            throw new RuntimeException("Order is empty or does not exist.");
        }
        orderFromDatabase = orderRepository.findById(orderId).get();
        Parts newParts = Parts.builder()
                .partName(partsRequest.getPartName())
                .partPrice(partsRequest.getPartPrice())
                .build();
        orderFromDatabase.addPartToOrder(newParts);
        return orderRepository.save(orderFromDatabase);

    }
}
