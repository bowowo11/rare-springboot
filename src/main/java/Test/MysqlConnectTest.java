//package Test;
//
//import javax.persistence.Entity;
//
//import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "usr")
//public class MysqlConnectTest implements Serializable{
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue
//    private Long id;
//    @Column(name = "usrname")
//    private String userName;
//    @Column(name = "pwd")
//    private String passWord;
//
//    public MysqlConnectTest() {
//        super();
//    }
//
//    public MysqlConnectTest(String userName, String passWord) {
//        super();
//        this.userName = userName;
//        this.passWord = passWord;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassWord() {
//        return passWord;
//    }
//
//    public void setPassWord(String passWord) {
//        this.passWord = passWord;
//    }
//}
