package hu.odrin7.pof.pcfredis.controllers;


import hu.odrin7.pof.pcfredis.model.ObjectRelation;
import hu.odrin7.pof.pcfredis.model.PaymentId;
import hu.odrin7.pof.pcfredis.services.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
public class PaymentController {
    private final PaymentService paymentIdService;

    public PaymentController(PaymentService paymentIdService) {
        this.paymentIdService = paymentIdService;
    }

    @PostMapping(value = "/payment-set")
    public void addPaymentIdToSet(@RequestBody PaymentId... paymentIds) {
        paymentIdService.savePaymentId(paymentIds);
    }

    @PostMapping(value = "/payment-hash")
    public void addPaymentIdToSet(@RequestBody ObjectRelation objectRelation) {
        paymentIdService.saveRelation(objectRelation);
    }

    @GetMapping(value = "/payment-set")
    public Set<PaymentId> getAllPaymentIds() {
        return paymentIdService.getAllPaymentId();
    }

    @GetMapping(value = "/payment-hash")
    public Map<Long, ObjectRelation> getAllObjectRelation() {
        return paymentIdService.getAllObjectReletion();
    }

}
