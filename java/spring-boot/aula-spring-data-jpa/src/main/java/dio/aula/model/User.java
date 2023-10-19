package dio.aula.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "tab_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id" )
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String userName;

    @Column(length = 100, nullable = false)
    private String password;
    
    public void setName(String name) {
        this.name = name;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ",\n name=" + name + ", \nuserName=" + userName + ", \npassword=" + password + "]";
    }

    
}
