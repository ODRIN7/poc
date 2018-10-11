package hu.odrin7.pof.pcfredis.services;

import hu.odrin7.pof.pcfredis.dao.PaymentIdRepository;
import hu.odrin7.pof.pcfredis.model.PaymentId;
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
    public void addToPaymentsList(PaymentId paymentId) {
        paymentIdRepository.addToPaymentAsList(paymentId);
    }

    @Override
    public List<PaymentId> getPaymentAsListMembers() {
        return paymentIdRepository.getPaymentAsListMembers();
    }

    @Override
    public Long getProgrammersListCount() {
        return paymentIdRepository.getProgrammersListCount();
    }

    ///// -------- SET ------------/////////
    @Override
    public void addToPaymentSet(PaymentId... paymentId) {
        paymentIdRepository.addToPaymentSet(paymentId);
    }

    @Override
    public Set<PaymentId> getPaymentIdSetMembers() {
        return paymentIdRepository.getPaymentIdSetMembers();
    }

    @Override
    public boolean isSetMember(PaymentId paymentId) {
        return paymentIdRepository.isSetMember(paymentId);
    }

    ///// -------- HASH ------------/////////
    @Override
    public void saveHash(PaymentId paymentId) {
        paymentIdRepository.saveHash(paymentId);
    }

    @Override
    public void updateHash(PaymentId paymentId) {
        paymentIdRepository.updateHash(paymentId);
    }

    @Override
    public Map<Long, PaymentId> findAllHash() {
        return paymentIdRepository.findAllHash();
    }

    @Override
    public PaymentId findInHash(Long id) {
        return paymentIdRepository.findInHash(id);
    }

    @Override
    public void deleteHash(Long id) {
        paymentIdRepository.deleteHash(id);
    }
}
