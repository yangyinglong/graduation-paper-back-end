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
    private String laboratoryId;
    @Column
    private String bespeakStartTime;
    @Column
    private String bespeakEndTime;
    @Column
    private Integer status;  // 0-删除，1-待审核，2-审核不通过，3-审核通过（预约成功）
    @Column
    private String createdTime;
    @Column
    private String changedTime;

    public GOrderEntity() {
    }

    public GOrderEntity(String id, String userId, String laboratoryId, String bespeakStartTime, String bespeakEndTime, Integer status, String createdTime, String changedTime) {
        this.id = id;
        this.userId = userId;
        this.laboratoryId = laboratoryId;
        this.bespeakStartTime = bespeakStartTime;
        this.bespeakEndTime = bespeakEndTime;
        this.status = status;
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

    public String getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(String laboratoryId) {
        this.laboratoryId = laboratoryId;
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

}