package myApp.app;


public class Account {

    private Card card;
    private User user;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "card=" + card +
                ", user=" + user +
                '}';
    }
}
