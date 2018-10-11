package hu.odrin7.pof.pcfredis.model;

import java.io.Serializable;
import java.util.Objects;

public class PaymentId implements Serializable {
    private Long Id;
    private String text;

    public PaymentId(Long id, String text) {
        Id = id;
        this.text = text;
    }

    public PaymentId() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentId paymentId = (PaymentId) o;
        return Objects.equals(Id, paymentId.Id) &&
                Objects.equals(text, paymentId.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, text);
    }
}
