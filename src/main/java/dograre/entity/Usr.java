package dograre.entity;

public class Usr {
    private int ID;
    private String usrname;
    private String pwd;
    private int crystal;
    private String nickname;
    private String cardlist;

    public int getID() {
        return ID;
    }

    public String getUsrname() {
        return usrname;
    }

    public String getPwd() {
        return pwd;
    }

    public int getCrystal() {
        return crystal;
    }

    public void setCrystal(int crystal) {
        this.crystal = crystal;
    }


    public void setID(int ID) {
        this.ID = ID;
    }


    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }


    public String getCardlist() {
        return cardlist;
    }

    public void setCardlist(String cardlist) {
        this.cardlist = cardlist;
    }
}