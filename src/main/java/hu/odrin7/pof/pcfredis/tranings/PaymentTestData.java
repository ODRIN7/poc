package hu.odrin7.pof.pcfredis.tranings;

import java.io.Serializable;
import java.util.Objects;

public class PaymentTestData implements Serializable {
    private Long Id;
    private String text;

    public PaymentTestData(Long id, String text) {
        Id = id;
        this.text = text;
    }

    public PaymentTestData() {
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
        PaymentTestData paymentTestData = (PaymentTestData) o;
        return Objects.equals(Id, paymentTestData.Id) &&
                Objects.equals(text, paymentTestData.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, text);
    }
}
