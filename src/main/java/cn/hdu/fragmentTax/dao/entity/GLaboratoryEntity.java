package cn.hdu.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class GLaboratoryEntity implements Serializable {

    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String adress;
    @Column
    private String adminId;  // 管理者的id
    @Column
    private Integer status;  // 0-删除，1-可使用
    @Column
    private String createdTime;
    @Column
    private String changedTime;
    @Column
    private String openTim;  // 开放时间
    @Column
    private String intr;  // 描述信息

    public GLaboratoryEntity() {
    }

    public GLaboratoryEntity(String id, String name, String adress, String adminId, Integer status, String createdTime, String changedTime, String openTim, String intr) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.adminId = adminId;
        this.status = status;
        this.createdTime = createdTime;
        this.changedTime = changedTime;
        this.openTim = openTim;
        this.intr = intr;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getChangedTime() {
        return changedTime;
    }

    public void setChangedTime(String changedTime) {
        this.changedTime = changedTime;
    }

    public String getOpenTim() {
        return openTim;
    }

    public void setOpenTim(String openTim) {
        this.openTim = openTim;
    }

    public String getIntr() {
        return intr;
    }

    public void setIntr(String intr) {
        this.intr = intr;
    }

}