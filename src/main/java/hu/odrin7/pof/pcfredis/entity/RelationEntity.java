package hu.odrin7.pof.pcfredis.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("relation")
public class RelationEntity {

    @Id
    private Long relationId;

    private ObjectReference objectReference1;
    private ObjectReference objectReference2;

    private String recordDomain;
    private String transRef;
    private String recordedObjectNotes;

    public RelationEntity(Long relationId,
                          ObjectReference objectReference1,
                          ObjectReference objectReference2,
                          String recordDomain,
                          String transRef,
                          String recordedObjectNotes) {
        this.relationId = relationId;
        this.objectReference1 = objectReference1;
        this.objectReference2 = objectReference2;
        this.recordDomain = recordDomain;
        this.transRef = transRef;
        this.recordedObjectNotes = recordedObjectNotes;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public ObjectReference getObjectReference1() {
        return objectReference1;
    }

    public void setObjectReference1(ObjectReference objectReference1) {
        this.objectReference1 = objectReference1;
    }

    public ObjectReference getObjectReference2() {
        return objectReference2;
    }

    public void setObjectReference2(ObjectReference objectReference2) {
        this.objectReference2 = objectReference2;
    }

    public String getRecordDomain() {
        return recordDomain;
    }

    public void setRecordDomain(String recordDomain) {
        this.recordDomain = recordDomain;
    }

    public String getTransRef() {
        return transRef;
    }

    public void setTransRef(String transRef) {
        this.transRef = transRef;
    }

    public String getRecordedObjectNotes() {
        return recordedObjectNotes;
    }

    public void setRecordedObjectNotes(String recordedObjectNotes) {
        this.recordedObjectNotes = recordedObjectNotes;
    }

    @Override
    public String toString() {
        return "RelationEntity{" +
                "relationId=" + relationId +
                ", objectReference1=" + objectReference1 +
                ", objectReference2=" + objectReference2 +
                ", recordDomain='" + recordDomain + '\'' +
                ", transRef='" + transRef + '\'' +
                ", recordedObjectNotes='" + recordedObjectNotes + '\'' +
                '}';
    }
}
