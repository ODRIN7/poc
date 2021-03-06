package hu.odrin7.pof.pcfredis.model;

import java.io.Serializable;
import java.util.Objects;

public class PaymentObjectReference implements Serializable {
    private String dom;
    private String refId;

    public PaymentObjectReference(String dom, String refId) {
        this.dom = dom;
        this.refId = refId;
    }

    public PaymentObjectReference() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentObjectReference that = (PaymentObjectReference) o;
        return Objects.equals(dom, that.dom) &&
                Objects.equals(refId, that.refId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dom, refId);
    }
}
