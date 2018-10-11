package hu.odrin7.pof.pcfredis.dao;

public interface PaymentIdRepository {

    void setPaymentIdAsString(String idKey, String text);

    String getProgrammerAsString(String idKey);
}
