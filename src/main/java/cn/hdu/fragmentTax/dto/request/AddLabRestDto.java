package cn.hdu.fragmentTax.dto.request;

public class AddLabRestDto {
    private String adminId;
    private String name;
    private String address;
    private String desc;
    private String openTime;

    public AddLabRestDto() {
    }

    public AddLabRestDto(String adminId, String name, String address) {
        this.adminId = adminId;
        this.name = name;
        this.address = address;
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

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
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
}
