package cn.hdu.fragmentTax.dto.request;

public class EditLabRestDto {
    private String labId;
    private String labName;
    private String labAddress;
    private String labAdminId;
    private String desc;
    private String openTime;
    private String openStatus;

    public EditLabRestDto() {
    }

    public EditLabRestDto(String labId, String labName, String labAddress, String labAdminId, String desc, String openTime, String openStatus) {
        this.labId = labId;
        this.labName = labName;
        this.labAddress = labAddress;
        this.labAdminId = labAdminId;
        this.desc = desc;
        this.openTime = openTime;
        this.openStatus = openStatus;
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

    public String getLabAddress() {
        return labAddress;
    }

    public void setLabAddress(String labAddress) {
        this.labAddress = labAddress;
    }

    public String getLabAdminId() {
        return labAdminId;
    }

    public void setLabAdminId(String labAdminId) {
        this.labAdminId = labAdminId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getOpenStatus() {
        return openStatus;
    }

    public void setOpenStatus(String openStatus) {
        this.openStatus = openStatus;
    }
}
