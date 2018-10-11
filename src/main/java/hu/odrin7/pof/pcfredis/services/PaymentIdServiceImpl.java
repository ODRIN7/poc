package hu.odrin7.pof.pcfredis.services;

import hu.odrin7.pof.pcfredis.dao.PaymentIdRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentIdServiceImpl implements PaymentIdService {

    private final PaymentIdRepository paymentIdRepository;

    public PaymentIdServiceImpl(PaymentIdRepository paymentIdRepository) {
        this.paymentIdRepository = paymentIdRepository;
    }

    @Override
    public void setPaymentIdAsString(String idKey, String text) {
        paymentIdRepository.setPaymentIdAsString(idKey, text);
    }

    @Override
    public String getPaymentIDAsString(String idKey) {
        return paymentIdRepository.getProgrammerAsString(idKey);
    }
}
