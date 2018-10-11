package hu.odrin7.pof.pcfredis.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.odrin7.pof.pcfredis.model.PaymentId;
import hu.odrin7.pof.pcfredis.services.PaymentIdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class PaymentIdController {

    private final PaymentIdService paymentIdService;


    public PaymentIdController(PaymentIdService paymentIdService) {
        this.paymentIdService = paymentIdService;
    }

    @PostMapping(value = "/paymentId-string")
    public void addPaymentId(@RequestBody PaymentId paymentId) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        paymentIdService.setPaymentIdAsString(String.valueOf(paymentId.getId()),
                mapper.writeValueAsString(paymentId));
    }

    @GetMapping(value = "/paymentId-string/{id}")
    public String readString(@PathVariable String id) {
        return paymentIdService.getPaymentIDAsString(id);
    }

    ///// -------- LIST ------------/////////
    @PostMapping(value = "/paymentId-list")
    public void addPaymentIdToList(@RequestBody PaymentId paymentId) {
        paymentIdService.addToPaymentsList(paymentId);
    }

    @GetMapping(value = "/paymentId-list")
    public List<PaymentId> readString() {
        return paymentIdService.getPaymentAsListMembers();
    }

    @GetMapping(value = "/paymentId-list/count")
    public Long getPaymentListCount() {
        return paymentIdService.getProgrammersListCount();
    }

    ///// -------- SET ------------/////////
    @PostMapping(value = "/paymentId-set")
    public void addPaymentIdToSet(@RequestBody PaymentId... paymentId) {
        paymentIdService.addToPaymentSet(paymentId);
    }

    @GetMapping(value = "/paymentId-set")
    public Set<PaymentId> readSet() {
        return paymentIdService.getPaymentIdSetMembers();
    }

    @PostMapping(value = "/paymentId-set/member")
    public boolean isSetMember(@RequestBody PaymentId paymentId) {
        return paymentIdService.isSetMember(paymentId);
    }

    ///// -------- HASH ------------/////////
    @PostMapping(value = "/paymentId-hash")
    public void saveHash(@RequestBody PaymentId paymentId) {
        paymentIdService.saveHash(paymentId);
    }

    @PutMapping(value = "/paymentId-hash")
    public void updateHash(@RequestBody PaymentId paymentId) {
        paymentIdService.updateHash(paymentId);
    }

    @GetMapping(value = "/paymentId-hash")
    public Map<Long, PaymentId> findAllInHash() {
        return paymentIdService.findAllHash();
    }

    @GetMapping(value = "/paymentId-hash/{id}")
    public PaymentId findOneInHash(@PathVariable Long id) {
        return paymentIdService.findInHash(id);
    }

    @DeleteMapping(value = "/paymentId-hash/{id}")
    public void deleteFromHash(@PathVariable Long id) {
        paymentIdService.deleteHash(id);
    }

}
