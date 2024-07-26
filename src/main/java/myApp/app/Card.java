package myApp.app;

public class Card {
    private Long numCard;
    private String date;
    private Integer CVV;
    private Integer amount;

    public Long getNumCard() {
        return numCard;
    }

    public void setNumCard(Long numCard) {
        this.numCard = numCard;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCVV() {
        return CVV;
    }

    public void setCVV(Integer CVV) {
        this.CVV = CVV;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Card{" +
                "numCard=" + numCard +
                ", date='" + date + '\'' +
                ", CVV=" + CVV +
                ", amount=" + amount +
                '}';
    }
}
