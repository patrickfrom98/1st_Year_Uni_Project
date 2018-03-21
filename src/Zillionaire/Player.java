package Zillionaire;

/**
 * Created by u1756102 on 14/02/2018.
 */

public class Player {
    private String name;
    private int cashWon;
    private boolean askTheAudience;
    private boolean phoneAFriend;
    private boolean halfAndHalf;
    private int questionComplexity;


    public Player(String name) {
        this.name = name;
        this.cashWon = 0;
        this.askTheAudience = true;
        this.phoneAFriend = true;
        this.halfAndHalf = true;
        this.questionComplexity = 1;
    }


    public String getName() {
        return name;
    }

    public int getCashWon() {
        return cashWon;
    }

    public void setCashWon(int cashWon) {
        this.cashWon = cashWon;
    }

    public boolean getAskTheAudience() {
        return askTheAudience;
    }

    public void setAskTheAudience(boolean askTheAudience) {
        this.askTheAudience = askTheAudience;
    }

    public boolean getPhoneAFriend() {
        return phoneAFriend;
    }

    public void setPhoneAFriend(boolean phoneAFriend) {
        this.phoneAFriend = phoneAFriend;
    }

    public boolean getHalfAndHalf() {
        return halfAndHalf;
    }

    public void setHalfAndHalf(boolean halfAndHalf) {
        this.halfAndHalf = halfAndHalf;
    }

    public int getQuestionComplexity() {
        return questionComplexity;
    }

    public void setQuestionComplexity(int questionComplexity) {
        this.questionComplexity = questionComplexity;
    }
}
