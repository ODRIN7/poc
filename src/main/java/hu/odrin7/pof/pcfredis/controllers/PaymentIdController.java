package hu.odrin7.pof.pcfredis.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.odrin7.pof.pcfredis.model.PaymentId;
import hu.odrin7.pof.pcfredis.services.PaymentIdService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentIdController {

    private final PaymentIdService paymentIdService;


    public PaymentIdController(PaymentIdService paymentIdService) {
        this.paymentIdService = paymentIdService;
    }

    @PostMapping(value = "/paymentIdAsString")
    public void addPaymentId(@RequestBody PaymentId paymentId) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        paymentIdService.setPaymentIdAsString(String.valueOf(paymentId.getId()),
                mapper.writeValueAsString(paymentId));
    }

    @GetMapping(value = "/paymentId-string/{id}")
    public String readString(@PathVariable String id) {
        return paymentIdService.getPaymentIDAsString(id);
    }

}
