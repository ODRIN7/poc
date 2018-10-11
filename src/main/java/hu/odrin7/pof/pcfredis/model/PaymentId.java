package hu.odrin7.pof.pcfredis.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class PaymentId implements Serializable {

    private Long groupId;
    private PaymentObjectReference objectReference;
    private Set<Long> relationReferenceId;

    public PaymentId(Long groupId,
                     PaymentObjectReference objectReference,
                     Set<Long> relationReferenceId) {
        this.groupId = groupId;
        this.objectReference = objectReference;
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

    public Set<Long> getRelationReferenceId() {
        return relationReferenceId;
    }

    public void setRelationReferenceId(Set<Long> relationReferenceId) {
        this.relationReferenceId = relationReferenceId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentId paymentId = (PaymentId) o;
        return Objects.equals(groupId, paymentId.groupId) &&
                Objects.equals(objectReference, paymentId.objectReference) &&
                Objects.equals(relationReferenceId, paymentId.relationReferenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, objectReference, relationReferenceId);
    }
}
