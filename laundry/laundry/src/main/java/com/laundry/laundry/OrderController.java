package com.laundry.laundry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    private final LaundryOrderRepository repository;

    public OrderController(LaundryOrderRepository repository) {
        this.repository = repository;
    }

    // Display Add Order Page
    @GetMapping("/add-order")
    public String addOrder(Model model) {
        model.addAttribute("order", new LaundryOrder());
        return "add-order";
    }

    // Save New Order
    @PostMapping("/save-order")
    public String saveOrder(LaundryOrder order) {

        double rate = 20;

        if ("Express".equals(order.getServiceType())) {
            rate += 50;
        }

        order.setPrice(order.getClothesCount() * rate);
        order.setStatus("Received");

        repository.save(order);

        return "redirect:/orders";
    }

    // Display All Orders
    @GetMapping("/orders")
    public String viewOrders(Model model) {
        model.addAttribute("orders", repository.findAll());
        return "orders";
    }

    // Update Order Status
    @PostMapping("/update-status/{id}")
    public String updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        LaundryOrder order = repository.findById(id).orElseThrow();

        order.setStatus(status);

        repository.save(order);

        return "redirect:/orders";
    }
}
