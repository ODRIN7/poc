package hu.odrin7.pof.pcfredis.tranings;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.odrin7.pof.pcfredis.tranings.PaymentTestData;
import hu.odrin7.pof.pcfredis.tranings.PaymentIdService;
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
    public void addPaymentId(@RequestBody PaymentTestData paymentTestData) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        paymentIdService.setPaymentIdAsString(String.valueOf(paymentTestData.getId()),
                mapper.writeValueAsString(paymentTestData));
    }

    @GetMapping(value = "/paymentId-string/{id}")
    public String readString(@PathVariable String id) {
        return paymentIdService.getPaymentIDAsString(id);
    }

    ///// -------- LIST ------------/////////
    @PostMapping(value = "/paymentId-list")
    public void addPaymentIdToList(@RequestBody PaymentTestData paymentTestData) {
        paymentIdService.addToPaymentsList(paymentTestData);
    }

    @GetMapping(value = "/paymentId-list")
    public List<PaymentTestData> readString() {
        return paymentIdService.getPaymentAsListMembers();
    }

    @GetMapping(value = "/paymentId-list/count")
    public Long getPaymentListCount() {
        return paymentIdService.getProgrammersListCount();
    }

    ///// -------- SET ------------/////////
    @PostMapping(value = "/paymentId-set")
    public void addPaymentIdToSet(@RequestBody PaymentTestData... paymentTestData) {
        paymentIdService.addToPaymentSet(paymentTestData);
    }

    @GetMapping(value = "/paymentId-set")
    public Set<PaymentTestData> readSet() {
        return paymentIdService.getPaymentIdSetMembers();
    }

    @PostMapping(value = "/paymentId-set/member")
    public boolean isSetMember(@RequestBody PaymentTestData paymentTestData) {
        return paymentIdService.isSetMember(paymentTestData);
    }

    ///// -------- HASH ------------/////////
    @PostMapping(value = "/paymentId-hash")
    public void saveHash(@RequestBody PaymentTestData paymentTestData) {
        paymentIdService.saveHash(paymentTestData);
    }

    @PutMapping(value = "/paymentId-hash")
    public void updateHash(@RequestBody PaymentTestData paymentTestData) {
        paymentIdService.updateHash(paymentTestData);
    }

    @GetMapping(value = "/paymentId-hash")
    public Map<Long, PaymentTestData> findAllInHash() {
        return paymentIdService.findAllHash();
    }

    @GetMapping(value = "/paymentId-hash/{id}")
    public PaymentTestData findOneInHash(@PathVariable Long id) {
        return paymentIdService.findInHash(id);
    }

    @DeleteMapping(value = "/paymentId-hash/{id}")
    public void deleteFromHash(@PathVariable Long id) {
        paymentIdService.deleteHash(id);
    }

}
