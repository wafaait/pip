package org.sid.lightecomv1.web;

import org.sid.lightecomv1.dao.ArticlRepository;
import org.sid.lightecomv1.dao.BeneciaireRepository;

import org.sid.lightecomv1.dao.OrderItemRepository;
import org.sid.lightecomv1.dao.OrderRepository;

import org.sid.lightecomv1.entities.Articl;
import org.sid.lightecomv1.entities.Beneficiaire;

import org.sid.lightecomv1.entities.Order;
import org.sid.lightecomv1.entities.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

@CrossOrigin("*")
@RestController
public class OrderController {
    @Autowired
    private ArticlRepository articlRepository;
    @Autowired
    private BeneciaireRepository beneciaireRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @PostMapping("/orders")
    public Order saveOrder(@RequestBody OrderForm orderForm) {
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setName(orderForm.getBeneficiaire().getName());
        beneficiaire.setEmail(orderForm.getBeneficiaire().getEmail());
        beneficiaire.setAddress(orderForm.getBeneficiaire().getAddress());
        beneficiaire.setPhoneNumber(orderForm.getBeneficiaire().getPhoneNumber());
        beneficiaire.setUsername(orderForm.getBeneficiaire().getUsername());
        beneficiaire = beneciaireRepository.save(beneficiaire);
        System.out.println(beneficiaire.getId());

        Order order = new Order();
        order.setBeneficiaire(beneficiaire);
        order.setDate(new Date());
        order = orderRepository.save(order);
        double total = 0;
        for (OrderProduct p : orderForm.getProducts()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            Articl articl = articlRepository.findById(p.getId()).get();
            orderItem.setArticl(articl);
            /*orderItem.set(product.getCurrentPrice());
            orderItem.setQuantity(p.getQuantity());*/
            orderItemRepository.save(orderItem);
            /*total+=p.getQuantity()*product.getCurrentPrice();*/
        }
        //order.setTotalAmount(total);
        return orderRepository.save(order);
    }


}
