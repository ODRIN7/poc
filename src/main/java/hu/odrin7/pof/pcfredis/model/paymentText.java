package hu.odrin7.pof.pcfredis.model;

import java.io.Serializable;
import java.util.Objects;

public class paymentText implements Serializable {
    private Long Id;
    private String text;

    public paymentText(Long id, String text) {
        Id = id;
        this.text = text;
    }

    public paymentText() {
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
        paymentText paymentText = (paymentText) o;
        return Objects.equals(Id, paymentText.Id) &&
                Objects.equals(text, paymentText.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, text);
    }
}
