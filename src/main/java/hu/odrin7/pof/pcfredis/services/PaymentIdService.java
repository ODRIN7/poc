package hu.odrin7.pof.pcfredis.services;


import hu.odrin7.pof.pcfredis.model.PaymentTestData;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PaymentIdService {

    void setPaymentIdAsString(String idKey, String text);

    String getPaymentIDAsString(String key);


    ///// -------- LIST ------------/////////
    void addToPaymentsList(PaymentTestData paymentTestData);

    List<PaymentTestData> getPaymentAsListMembers();

    Long getProgrammersListCount();

    ///// -------- Set ------------/////////
    void addToPaymentSet(PaymentTestData... paymentTestData);

    Set<PaymentTestData> getPaymentIdSetMembers();

    boolean isSetMember(PaymentTestData paymentTestData);

    ///// -------- HASH ------------/////////
    void saveHash(PaymentTestData paymentTestData);

    void updateHash(PaymentTestData paymentTestData);

    Map<Long, PaymentTestData> findAllHash();

    PaymentTestData findInHash(Long id);

    void deleteHash(Long id);
}
