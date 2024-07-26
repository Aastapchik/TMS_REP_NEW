package myApp.app;

public class DTOForTransfer {

    Card cardTo;
    Account accountFrom;
    Integer sumOfTransfer;

    public Card getCardTo() {
        return cardTo;
    }

    public void setCardTo(Card cardTo) {
        this.cardTo = cardTo;
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Integer getSumOfTransfer() {
        return sumOfTransfer;
    }

    public void setSumOfTransfer(Integer sumOfTransfer) {
        this.sumOfTransfer = sumOfTransfer;
    }
}
