package cn.hdu.fragmentTax.dto.request;

public class AddLabRestDto {
    private String adminId;
    private String name;
    private String address;

    public AddLabRestDto() {
    }

    public AddLabRestDto(String adminId, String name, String address) {
        this.adminId = adminId;
        this.name = name;
        this.address = address;
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
