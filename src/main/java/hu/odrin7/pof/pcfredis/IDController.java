package hu.odrin7.pof.pcfredis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IDController {

    private final IDService idService;

    public IDController(IDService idService) {
        this.idService = idService;
    }

    @GetMapping
    public List<PaymentId> getAllPaymentIds() {
  //      return idService.getAllPaymentId();
        return new ArrayList<>();
    }
}
