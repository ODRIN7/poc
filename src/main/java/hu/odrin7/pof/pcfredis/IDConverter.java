package hu.odrin7.pof.pcfredis;

public class IDConverter {
    public static PaymentId createPaymentId(PaymentIdEntity paymentIdEntity) {
        return new PaymentId(paymentIdEntity.getGroupId(),
                paymentIdEntity.getDom(),
                paymentIdEntity.getRefId(),
                paymentIdEntity.getArea(),
                paymentIdEntity.getCreatedBy(),
                paymentIdEntity.getTimestamp());
    }
}
