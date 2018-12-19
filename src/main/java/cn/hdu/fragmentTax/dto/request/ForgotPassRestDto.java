package cn.hdu.fragmentTax.dto.request;

public class ForgotPassRestDto {
    private String phone;
    private String password;
    private String validateCode;
    private String validateCodeId;

    public ForgotPassRestDto() {
    }

    public ForgotPassRestDto(String phone, String password, String validateCode, String validateCodeId) {
        this.phone = phone;
        this.password = password;
        this.validateCode = validateCode;
        this.validateCodeId = validateCodeId;
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

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getValidateCodeId() {
        return validateCodeId;
    }

    public void setValidateCodeId(String validateCodeId) {
        this.validateCodeId = validateCodeId;
    }
}
