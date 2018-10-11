package hu.odrin7.pof.pcfredis.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash("PaymentId")
public class PaymentIdEntity implements Serializable {

    @Id
    private Long id;
    @Indexed
    private Long groupId;
    @Indexed
    private ObjectReference objectReference;
    private Long relationId;

    public PaymentIdEntity(
            Long groupId,
                           ObjectReference objectReference,
                           Long relationId) {
        this.groupId = groupId;
        this.objectReference = objectReference;
        this.relationId = relationId;
    }

    @Override
    public String toString() {
        return "PaymentIdEntity{" +
                "groupId=" + groupId +
                ", objectReference=" + objectReference +
                ", relationId=" + relationId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public ObjectReference getObjectReference() {
        return objectReference;
    }

    public void setObjectReference(ObjectReference objectReference) {
        this.objectReference = objectReference;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }
}
