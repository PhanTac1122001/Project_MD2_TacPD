package business.entity;

import java.util.Date;

public class User {
    private int user_id;
    private String username;
    private String email;
    private String fullname;
    private Byte status;
    private String password;
    private String avatar;
    private String phone;
    private String address;
    private Date created_at;
    private Date updated_at;
    private Byte is_deleted;

    public User() {
    }

    public User(int user_id, String username, String email, String fullname, Byte status, String password, String avatar, String phone, String address, Date created_at, Date updated_at, Byte is_deleted) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.status = status;
        this.password = password;
        this.avatar = avatar;
        this.phone = phone;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.is_deleted = is_deleted;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Byte getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Byte is_deleted) {
        this.is_deleted = is_deleted;
    }


}
