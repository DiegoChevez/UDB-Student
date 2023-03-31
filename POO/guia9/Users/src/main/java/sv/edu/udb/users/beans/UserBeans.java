package sv.edu.udb.users.beans;
public class UserBeans {

    int idUser;
    int fkEmployee;
    String userName;
    String passwordUser;
    String statusUser;

    public UserBeans(int fkEmployee, String userName, String passwordUser, String statusUser) {
        this.fkEmployee = fkEmployee;
        this.userName = userName;
        this.passwordUser = passwordUser;
        this.statusUser = statusUser;
    }

    public UserBeans(int idUser, int fkEmployee, String userName, String passwordUser, String statusUser) {
        this.idUser = idUser;
        this.fkEmployee = fkEmployee;
        this.userName = userName;
        this.passwordUser = passwordUser;
        this.statusUser = statusUser;
    }

    public UserBeans() {

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getFkEmployee() {
        return fkEmployee;
    }

    public void setFkEmployee(int fkEmployee) {
        this.fkEmployee = fkEmployee;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(String statusUser) {
        this.statusUser = statusUser;
    }
}
