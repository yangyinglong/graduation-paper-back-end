package cn.hdu.fragmentTax.dto.request;

import org.springframework.scheduling.support.SimpleTriggerContext;

public class ShowLabRestDto {
    private String labName;
    private String labAddress;
    private String adminName;
    private int page;

    public ShowLabRestDto() {
    }

    public ShowLabRestDto(String labName, String labAddress, String adminName, int page) {
        this.labName = labName;
        this.labAddress = labAddress;
        this.adminName = adminName;
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
