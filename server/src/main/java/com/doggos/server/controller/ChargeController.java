package com.doggos.server.controller;

import com.doggos.server.data.ChargeRequest;
import com.doggos.server.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5000", maxAge = 3600)
@Controller
@RequestMapping("/api/")
public class ChargeController {

    @Autowired
    private StripeService stripeService;

    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model) throws StripeException {
        chargeRequest.setCurrency(ChargeRequest.Currency.INR);
        Charge charge = stripeService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }

    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException stripeException) {
        model.addAttribute("error", stripeException.getMessage());
        return "result";
    }
}
