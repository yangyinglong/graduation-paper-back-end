package cn.hdu.fragmentTax.dto.request;

public class AdminShowLabRestDto {
    private String adminId;
    private int page;
    private String[] status;

    public AdminShowLabRestDto() {
    }

    public AdminShowLabRestDto(String adminId, int page) {
        this.adminId = adminId;
        this.page = page;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
