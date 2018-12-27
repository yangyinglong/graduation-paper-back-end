package cn.hdu.fragmentTax.dto.response;

public class LabRespDto {
    private String id;
    private String name;
    private String address;
    private String adminId;
    private String adminName;
    private String status;
    private String openTime;
    private String desc;

    public LabRespDto() {
    }

    public LabRespDto(String id, String name, String address, String adminId, String adminName, String openTime, String desc) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.adminId = adminId;
        this.adminName = adminName;
        this.openTime = openTime;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
