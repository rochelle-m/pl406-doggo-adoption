package com.doggos.server.controller;

import com.doggos.server.data.ChargeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
@Controller
@RequestMapping("/api/")
public class CheckoutController {

    @Value("${stripe.public.key}")
    private String stripePublicKey;

    @RequestMapping("/checkout/299")
    public String checkout299(Model model) {
        model.addAttribute("amount", 299 * 100);
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.INR);
        return "checkout";
    }

    @RequestMapping("/checkout/499")
    public String checkout499(Model model) {
        model.addAttribute("amount", 499 * 100);
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.INR);
        return "checkout";
    }

    @RequestMapping("/checkout/{amount}")
    public String checkoutAmount(Model model, @PathVariable("amount") String amount) {
        model.addAttribute("amount", Integer.parseInt(amount) * 100);
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.INR);
        return "checkout";
    }
}
