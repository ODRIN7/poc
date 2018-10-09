package hu.odrin7.pof.pcfredis;

import java.time.LocalDate;

public class PaymentId {

    private Long groupId;
    private String dom;
    private String refId;

    private String Area;
    private String createdBy;
    private String  timestamp;

    public PaymentId(Long groupId,
                     String dom,
                     String refId,
                     String area,
                     String createdBy,
                     LocalDate timestamp) {
        this.groupId = groupId;
        this.dom = dom;
        this.refId = refId;
        Area = area;
        this.createdBy = createdBy;
        this.timestamp = timestamp.toString();
    }
}
