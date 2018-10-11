package hu.odrin7.pof.pcfredis.entity;

import org.springframework.data.redis.core.index.Indexed;

public class ObjectReference {

    private String dom;
    private String refId;

    public ObjectReference(String dom, String refId) {
        this.dom = dom;
        this.refId = refId;
    }

    public ObjectReference() {
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
}
