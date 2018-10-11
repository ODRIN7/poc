package hu.odrin7.pof.pcfredis.services;


public interface PaymentIdService {

    void setPaymentIdAsString(String idKey, String text);

    String getPaymentIDAsString(String key);
}
