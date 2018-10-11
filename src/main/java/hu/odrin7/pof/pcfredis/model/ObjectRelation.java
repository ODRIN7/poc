package hu.odrin7.pof.pcfredis.model;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ObjectRelation implements Serializable {
    private long id;
    private PaymentObjectReference objectReferenceFirst;
    private PaymentObjectReference objectReferenceSecond;

    private String recordedDomain;
    private String transactionReference;
    private List<String> recordedDomainNotes;

    public ObjectRelation(long id,
                          PaymentObjectReference objectReferenceFirst,
                          PaymentObjectReference objectReferenceSecond,
                          String recordedDomain,
                          String transactionReference,
                          List<String> recordedDomainNotes) {
        this.id = id;
        this.objectReferenceFirst = objectReferenceFirst;
        this.objectReferenceSecond = objectReferenceSecond;
        this.recordedDomain = recordedDomain;
        this.transactionReference = transactionReference;
        this.recordedDomainNotes = recordedDomainNotes;
    }

    public ObjectRelation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PaymentObjectReference getObjectReferenceFirst() {
        return objectReferenceFirst;
    }

    public void setObjectReferenceFirst(PaymentObjectReference objectReferenceFirst) {
        this.objectReferenceFirst = objectReferenceFirst;
    }

    public PaymentObjectReference getObjectReferenceSecond() {
        return objectReferenceSecond;
    }

    public void setObjectReferenceSecond(PaymentObjectReference objectReferenceSecond) {
        this.objectReferenceSecond = objectReferenceSecond;
    }

    public String getRecordedDomain() {
        return recordedDomain;
    }

    public void setRecordedDomain(String recordedDomain) {
        this.recordedDomain = recordedDomain;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public List<String> getRecordedDomainNotes() {
        return recordedDomainNotes;
    }

    public void setRecordedDomainNotes(List<String> recordedDomainNotes) {
        this.recordedDomainNotes = recordedDomainNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectRelation that = (ObjectRelation) o;
        return id == that.id &&
                Objects.equals(objectReferenceFirst, that.objectReferenceFirst) &&
                Objects.equals(objectReferenceSecond, that.objectReferenceSecond) &&
                Objects.equals(recordedDomain, that.recordedDomain) &&
                Objects.equals(transactionReference, that.transactionReference) &&
                Objects.equals(recordedDomainNotes, that.recordedDomainNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, objectReferenceFirst, objectReferenceSecond,
                recordedDomain, transactionReference, recordedDomainNotes);
    }
}
