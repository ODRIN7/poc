package hu.odrin7.pof.pcfredis.services;

import hu.odrin7.pof.pcfredis.dao.PaymentIdRepository;
import hu.odrin7.pof.pcfredis.model.paymentText;
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
    public void addToPaymentsList(paymentText paymentText) {
        paymentIdRepository.addToPaymentAsList(paymentText);
    }

    @Override
    public List<paymentText> getPaymentAsListMembers() {
        return paymentIdRepository.getPaymentAsListMembers();
    }

    @Override
    public Long getProgrammersListCount() {
        return paymentIdRepository.getProgrammersListCount();
    }

    ///// -------- SET ------------/////////
    @Override
    public void addToPaymentSet(paymentText... paymentText) {
        paymentIdRepository.addToPaymentSet(paymentText);
    }

    @Override
    public Set<paymentText> getPaymentIdSetMembers() {
        return paymentIdRepository.getPaymentIdSetMembers();
    }

    @Override
    public boolean isSetMember(paymentText paymentText) {
        return paymentIdRepository.isSetMember(paymentText);
    }

    ///// -------- HASH ------------/////////
    @Override
    public void saveHash(paymentText paymentText) {
        paymentIdRepository.saveHash(paymentText);
    }

    @Override
    public void updateHash(paymentText paymentText) {
        paymentIdRepository.updateHash(paymentText);
    }

    @Override
    public Map<Long, paymentText> findAllHash() {
        return paymentIdRepository.findAllHash();
    }

    @Override
    public paymentText findInHash(Long id) {
        return paymentIdRepository.findInHash(id);
    }

    @Override
    public void deleteHash(Long id) {
        paymentIdRepository.deleteHash(id);
    }
}
