package hu.odrin7.pof.pcfredis.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class PaymentId implements Serializable {

    private PaymentObjectReference objectReference;
    private Long groupId;
    private Set<Long> relationReferenceId;

    public PaymentId(PaymentObjectReference objectReference,
                     Long groupId,
                     Set<Long> relationReferenceId) {
        this.objectReference = objectReference;
        this.groupId = groupId;
        this.relationReferenceId = relationReferenceId;
    }

    public PaymentId() {
    }

    public PaymentObjectReference getObjectReference() {
        return objectReference;
    }

    public void setObjectReference(PaymentObjectReference objectReference) {
        this.objectReference = objectReference;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Set<Long> getRelationReferenceId() {
        return relationReferenceId;
    }

    public void setRelationReferenceId(Set<Long> relationReferenceId) {
        this.relationReferenceId = relationReferenceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentId paymentId = (PaymentId) o;
        return Objects.equals(objectReference, paymentId.objectReference) &&
                Objects.equals(groupId, paymentId.groupId) &&
                Objects.equals(relationReferenceId, paymentId.relationReferenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objectReference, groupId, relationReferenceId);
    }
}
