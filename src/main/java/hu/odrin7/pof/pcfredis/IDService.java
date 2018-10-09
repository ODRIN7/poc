package hu.odrin7.pof.pcfredis;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static hu.odrin7.pof.pcfredis.IDConverter.createPaymentId;

@Service
public class IDService {

    private final IDRepository idRepository;

    public IDService(IDRepository idRepository) {
        this.idRepository = idRepository;
    }

    public List<PaymentId> getAllPaymentId() {
        List<PaymentId> paymentIds = new ArrayList<>();
        idRepository.findAll().forEach(paymentIdEntity -> paymentIds.add(createPaymentId(paymentIdEntity)));
        return paymentIds;
    }


}
