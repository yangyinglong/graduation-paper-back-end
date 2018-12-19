package cn.hdu.fragmentTax.dto.response;

import javax.persistence.criteria.CriteriaBuilder;

public class UserRespDto {
    private String id;
    private String name;
    private Integer status;
    private String phone;
    private String eMail;

    public UserRespDto() {
    }

    public UserRespDto(String id, String name, Integer status, String phone, String eMail) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.phone = phone;
        this.eMail = eMail;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
