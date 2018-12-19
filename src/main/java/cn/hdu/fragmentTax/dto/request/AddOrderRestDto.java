package cn.hdu.fragmentTax.dto.request;

import java.util.List;

public class AddOrderRestDto {
    private String labId;
    private String labName;
    private String labAdminId;
    private String labAdmin;
    private String labAddress;
    private String labBeSpeakName;
    private String labBeSpeakId;
    private List<String> time;
    private String usedTo;
    private String remarks;

    public AddOrderRestDto() {
    }

    public AddOrderRestDto(String labId, String labName, String labAdminId, String labAdmin, String labAddress, String labBeSpeakName, String labBeSpeakId, List<String> time, String usedTo, String remarks) {
        this.labId = labId;
        this.labName = labName;
        this.labAdminId = labAdminId;
        this.labAdmin = labAdmin;
        this.labAddress = labAddress;
        this.labBeSpeakName = labBeSpeakName;
        this.labBeSpeakId = labBeSpeakId;
        this.time = time;
        this.usedTo = usedTo;
        this.remarks = remarks;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getLabAdminId() {
        return labAdminId;
    }

    public void setLabAdminId(String labAdminId) {
        this.labAdminId = labAdminId;
    }

    public String getLabAdmin() {
        return labAdmin;
    }

    public void setLabAdmin(String labAdmin) {
        this.labAdmin = labAdmin;
    }

    public String getLabAddress() {
        return labAddress;
    }

    public void setLabAddress(String labAddress) {
        this.labAddress = labAddress;
    }

    public String getLabBeSpeakName() {
        return labBeSpeakName;
    }

    public void setLabBeSpeakName(String labBeSpeakName) {
        this.labBeSpeakName = labBeSpeakName;
    }

    public String getLabBeSpeakId() {
        return labBeSpeakId;
    }

    public void setLabBeSpeakId(String labBeSpeakId) {
        this.labBeSpeakId = labBeSpeakId;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
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
}
