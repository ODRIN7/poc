package hu.odrin7.pof.pcfredis.tranings;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    ///// -------- LIST ------------/////////
    @Override
    public void addToPaymentsList(PaymentTestData paymentTestData) {
        paymentIdRepository.addToPaymentAsList(paymentTestData);
    }

    @Override
    public List<PaymentTestData> getPaymentAsListMembers() {
        return paymentIdRepository.getPaymentAsListMembers();
    }

    @Override
    public Long getProgrammersListCount() {
        return paymentIdRepository.getProgrammersListCount();
    }

    ///// -------- SET ------------/////////
    @Override
    public void addToPaymentSet(PaymentTestData... paymentTestData) {
        paymentIdRepository.addToPaymentSet(paymentTestData);
    }

    @Override
    public Set<PaymentTestData> getPaymentIdSetMembers() {
        return paymentIdRepository.getPaymentIdSetMembers();
    }

    @Override
    public boolean isSetMember(PaymentTestData paymentTestData) {
        return paymentIdRepository.isSetMember(paymentTestData);
    }

    ///// -------- HASH ------------/////////
    @Override
    public void saveHash(PaymentTestData paymentTestData) {
        paymentIdRepository.saveHash(paymentTestData);
    }

    @Override
    public void updateHash(PaymentTestData paymentTestData) {
        paymentIdRepository.updateHash(paymentTestData);
    }

    @Override
    public Map<Long, PaymentTestData> findAllHash() {
        return paymentIdRepository.findAllHash();
    }

    @Override
    public PaymentTestData findInHash(Long id) {
        return paymentIdRepository.findInHash(id);
    }

    @Override
    public void deleteHash(Long id) {
        paymentIdRepository.deleteHash(id);
    }
}
