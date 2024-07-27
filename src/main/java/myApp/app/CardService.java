package myApp.app;

import org.springframework.stereotype.Component;

import java.sql.*;

import static myApp.database.Connect.getInstance;

@Component
public class CardService {

    Connection connection = getInstance().getConnect();

    public CardService() throws SQLException {
    }

    public boolean getInfoAboutUser(Integer id, Account account) throws SQLException {
        if (id == null) return false;
        getUserInfoByID(id, account);
        return true;
    }


    public boolean transferAmount(Card cardTo, int sumOfTransfer, Account accountFrom) throws SQLException {
        if (sumOfTransfer <= 0) return false;

        try {


            connection.setAutoCommit(false);

            int amountTo = getAmountDB(cardTo);
            int amountFrom = getAmountDB(accountFrom.getCard());

            if (amountTo == -1 || amountFrom == -1) return false;
            if (amountFrom - sumOfTransfer < 0L) return false;

            updateAmountDB(cardTo, sumOfTransfer, amountTo, true);
            updateAmountDB(accountFrom.getCard(), sumOfTransfer, amountFrom, false);
            accountFrom.getCard().setAmount(amountFrom + sumOfTransfer);
            connection.commit();
            connection.setAutoCommit(true);

            return true;
        } catch (SQLException e) {
            connection.rollback();
            return false;
        } finally {
            connection.close();

        }

    }

    private Integer getAmountDB(Card card) throws SQLException {
        PreparedStatement amountToTransfer = connection.prepareStatement("SELECT amount FROM mycards WHERE numcard = ?");
        amountToTransfer.setLong(1, card.getNumCard());
        ResultSet resultSet = amountToTransfer.executeQuery();
        while (resultSet.next()) return resultSet.getInt("amount");
        return -1;
    }

    private Integer getCVVDB(Card card) throws SQLException {
        int cvv = 0;
        PreparedStatement getCVV = connection.prepareStatement("SELECT CVV FROM MYCARDS WHERE NUMCARD = ?");
        getCVV.setLong(1, card.getNumCard());
        ResultSet resultSet = getCVV.executeQuery();
        while (resultSet.next()) cvv = resultSet.getInt("cvv");
        return cvv;
    }

    private String getDateDB(Card card) throws SQLException {
        String date = "";
        PreparedStatement getDate = connection.prepareStatement("SELECT DATE_CARD FROM MYCARDS WHERE NUMCARD = ?");
        getDate.setLong(1, card.getNumCard());
        ResultSet resultSet = getDate.executeQuery();
        while (resultSet.next()) date = resultSet.getString("date_card");
        return date;
    }

    private void updateAmountDB(Card card, int sumOfTransfer, int amount, boolean flag) throws SQLException {

        PreparedStatement updateCard = connection.prepareStatement("UPDATE myCards SET AMOUNT = ? WHERE NUMCARD = ? AND cvv = ? AND date_card = ?");

        if (flag) { //accTo
            updateCard.setInt(1, amount + sumOfTransfer);
            updateCard.setInt(3, getCVVDB(card));
            updateCard.setString(4, getDateDB(card));
        } else { //auth acc
            updateCard.setInt(1, amount - sumOfTransfer);
            updateCard.setInt(3, card.getCVV());
            updateCard.setString(4, card.getDate());
        }
        updateCard.setLong(2, card.getNumCard());

        updateCard.executeUpdate();
    }

    private void getUserInfoByID(Integer id, Account account) throws SQLException {
        User user = new User();
        PreparedStatement getUserInfo = connection.prepareStatement("SELECT firstnameuser, lastnameuser FROM myCards WHERE ID = ?");
        getUserInfo.setInt(1,id);
        ResultSet resultSet = getUserInfo.executeQuery();
        while(resultSet.next()){
            user.setFirstNameUser(resultSet.getString("firstnameuser"));
            user.setLastNameUser(resultSet.getString("lastnameuser"));
        }
        account.setUser(user);
    }

}
