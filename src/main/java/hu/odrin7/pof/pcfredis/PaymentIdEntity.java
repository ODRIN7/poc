package hu.odrin7.pof.pcfredis;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDate;

@RedisHash("PaymentId")
public class PaymentIdEntity implements Serializable {

    @Id
    private Long groupId;
    // @Indexed
    private String dom;
    //@Indexed
    private String refId;
    private String Area;
    private String createdBy;
    private LocalDate timestamp;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getDom() {
        return dom;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public PaymentIdEntity(Long groupId,
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
        this.timestamp = timestamp;
    }

    public PaymentIdEntity() {
    }
}
