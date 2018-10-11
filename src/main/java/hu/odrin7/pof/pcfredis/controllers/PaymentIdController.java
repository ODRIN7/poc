package hu.odrin7.pof.pcfredis.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.odrin7.pof.pcfredis.model.paymentText;
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
    public void addPaymentId(@RequestBody paymentText paymentText) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        paymentIdService.setPaymentIdAsString(String.valueOf(paymentText.getId()),
                mapper.writeValueAsString(paymentText));
    }

    @GetMapping(value = "/paymentId-string/{id}")
    public String readString(@PathVariable String id) {
        return paymentIdService.getPaymentIDAsString(id);
    }

    ///// -------- LIST ------------/////////
    @PostMapping(value = "/paymentId-list")
    public void addPaymentIdToList(@RequestBody paymentText paymentText) {
        paymentIdService.addToPaymentsList(paymentText);
    }

    @GetMapping(value = "/paymentId-list")
    public List<paymentText> readString() {
        return paymentIdService.getPaymentAsListMembers();
    }

    @GetMapping(value = "/paymentId-list/count")
    public Long getPaymentListCount() {
        return paymentIdService.getProgrammersListCount();
    }

    ///// -------- SET ------------/////////
    @PostMapping(value = "/paymentId-set")
    public void addPaymentIdToSet(@RequestBody paymentText... paymentText) {
        paymentIdService.addToPaymentSet(paymentText);
    }

    @GetMapping(value = "/paymentId-set")
    public Set<paymentText> readSet() {
        return paymentIdService.getPaymentIdSetMembers();
    }

    @PostMapping(value = "/paymentId-set/member")
    public boolean isSetMember(@RequestBody paymentText paymentText) {
        return paymentIdService.isSetMember(paymentText);
    }

    ///// -------- HASH ------------/////////
    @PostMapping(value = "/paymentId-hash")
    public void saveHash(@RequestBody paymentText paymentText) {
        paymentIdService.saveHash(paymentText);
    }

    @PutMapping(value = "/paymentId-hash")
    public void updateHash(@RequestBody paymentText paymentText) {
        paymentIdService.updateHash(paymentText);
    }

    @GetMapping(value = "/paymentId-hash")
    public Map<Long, paymentText> findAllInHash() {
        return paymentIdService.findAllHash();
    }

    @GetMapping(value = "/paymentId-hash/{id}")
    public paymentText findOneInHash(@PathVariable Long id) {
        return paymentIdService.findInHash(id);
    }

    @DeleteMapping(value = "/paymentId-hash/{id}")
    public void deleteFromHash(@PathVariable Long id) {
        paymentIdService.deleteHash(id);
    }

}
