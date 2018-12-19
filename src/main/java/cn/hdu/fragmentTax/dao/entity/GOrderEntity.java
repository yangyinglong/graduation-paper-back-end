package cn.hdu.fragmentTax.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
public class GOrderEntity implements Serializable {

    @Id
    private String id;
    @Column
    private String userId;
    @Column
    private String userName;
    @Column
    private String laboratoryId;
    @Column
    private String laboratoryName;
    @Column
    private String laboratoryAddress;
    @Column
    private String bespeakStartTime;
    @Column
    private String bespeakEndTime;
    @Column
    private String usedTo;
    @Column
    private String remarks;
    @Column
    private Integer status;  // 0-删除，1-待审核，2-审核不通过，3-审核通过（预约成功）
    @Column
    private String adminRemarks;  // 管理员备注
    @Column
    private String createdTime;
    @Column
    private String changedTime;

    public GOrderEntity() {
    }

    public GOrderEntity(String id, String userId, String userName, String laboratoryId, String laboratoryName, String laboratoryAddress, String bespeakStartTime, String bespeakEndTime, String usedTo, String remarks, Integer status, String adminRemarks, String createdTime, String changedTime) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.laboratoryId = laboratoryId;
        this.laboratoryName = laboratoryName;
        this.laboratoryAddress = laboratoryAddress;
        this.bespeakStartTime = bespeakStartTime;
        this.bespeakEndTime = bespeakEndTime;
        this.usedTo = usedTo;
        this.remarks = remarks;
        this.status = status;
        this.adminRemarks = adminRemarks;
        this.createdTime = createdTime;
        this.changedTime = changedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(String laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public String getLaboratoryName() {
        return laboratoryName;
    }

    public void setLaboratoryName(String laboratoryName) {
        this.laboratoryName = laboratoryName;
    }

    public String getLaboratoryAddress() {
        return laboratoryAddress;
    }

    public void setLaboratoryAddress(String laboratoryAddress) {
        this.laboratoryAddress = laboratoryAddress;
    }

    public String getBespeakStartTime() {
        return bespeakStartTime;
    }

    public void setBespeakStartTime(String bespeakStartTime) {
        this.bespeakStartTime = bespeakStartTime;
    }

    public String getBespeakEndTime() {
        return bespeakEndTime;
    }

    public void setBespeakEndTime(String bespeakEndTime) {
        this.bespeakEndTime = bespeakEndTime;
    }

    public String getUsedTo() {
        return usedTo;
    }

    public void setUsedTo(String usedTo) {
        this.usedTo = usedTo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAdminRemarks() {
        return adminRemarks;
    }

    public void setAdminRemarks(String adminRemarks) {
        this.adminRemarks = adminRemarks;
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

}