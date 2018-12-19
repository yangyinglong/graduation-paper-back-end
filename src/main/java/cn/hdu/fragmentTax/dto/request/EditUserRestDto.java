package cn.hdu.fragmentTax.dto.request;

public class EditUserRestDto {
    private String id;
    private String name;
    private String phone;
    private String eMail;
    private String password;

    public EditUserRestDto() {
    }

    public EditUserRestDto(String id, String name, String phone, String eMail, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.eMail = eMail;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
