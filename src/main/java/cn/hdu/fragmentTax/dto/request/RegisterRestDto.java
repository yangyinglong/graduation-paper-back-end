package cn.hdu.fragmentTax.dto.request;

public class RegisterRestDto {
    private String name;
    private String id;
    private String phone;
    private String eMail;
    private String password;
    private String validateCode;
    private String validateCodeId;

    public RegisterRestDto() {
    }

    public RegisterRestDto(String name, String id, String phone, String eMail, String password, String validateCode, String validateCodeId) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.eMail = eMail;
        this.password = password;
        this.validateCode = validateCode;
        this.validateCodeId = validateCodeId;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidateCodeId() {
        return validateCodeId;
    }

    public void setValidateCodeId(String validateCodeId) {
        this.validateCodeId = validateCodeId;
    }
}
