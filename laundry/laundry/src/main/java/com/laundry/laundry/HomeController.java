package com.laundry.laundry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final LaundryOrderRepository repository;

    public HomeController(LaundryOrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {

        long totalOrders = repository.count();
        long washingOrders = repository.countByStatus("Washing");
        long readyOrders = repository.countByStatus("Ready");
        long receivedOrders = repository.countByStatus("Received");

        model.addAttribute("totalOrders", totalOrders);
        model.addAttribute("washingOrders", washingOrders);
        model.addAttribute("readyOrders", readyOrders);
        model.addAttribute("receivedOrders", receivedOrders);

        return "index";
    }
}
