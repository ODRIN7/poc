package hu.odrin7.pof.pcfredis.dao;

import hu.odrin7.pof.pcfredis.model.PaymentId;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PaymentIdRepository {

    void setPaymentIdAsString(String idKey, String text);

    String getProgrammerAsString(String idKey);

    ///// -------- LIST ------------/////////
    void addToPaymentAsList(PaymentId paymentId);

    List<PaymentId> getPaymentAsListMembers();

    Long getProgrammersListCount();

    ///// -------- Set ------------/////////
    void addToPaymentSet(PaymentId... paymentId);

    Set<PaymentId> getPaymentIdSetMembers();

    boolean isSetMember(PaymentId paymentId);

    ///// -------- HASH ------------/////////
    void saveHash(PaymentId paymentId);

    void updateHash(PaymentId paymentId);

    Map<Long, PaymentId> findAllHash();

    PaymentId findInHash(Long id);

    void deleteHash(Long id);
}
