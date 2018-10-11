package hu.odrin7.pof.pcfredis.dao;

import hu.odrin7.pof.pcfredis.model.ObjectRelation;
import hu.odrin7.pof.pcfredis.model.PaymentId;
import hu.odrin7.pof.pcfredis.model.paymentText;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PaymentIdRepository {

    void setPaymentIdAsString(String idKey, String text);

    String getProgrammerAsString(String idKey);

    ///// -------- LIST ------------/////////
    void addToPaymentAsList(paymentText paymentText);

    List<paymentText> getPaymentAsListMembers();

    Long getProgrammersListCount();

    ///// -------- Set ------------/////////
    void addToPaymentSet(paymentText... paymentText);

    Set<paymentText> getPaymentIdSetMembers();

    boolean isSetMember(paymentText paymentText);

    ///// -------- HASH ------------/////////
    void saveHash(paymentText paymentText);

    void updateHash(paymentText paymentText);

    Map<Long, paymentText> findAllHash();

    paymentText findInHash(Long id);

    void deleteHash(Long id);
}
