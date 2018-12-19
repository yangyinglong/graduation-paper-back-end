package cn.hdu.fragmentTax.dto.request;

public class ShowOrderRestDto {
    private String userId;
    private String[] status;
    private int page;

    public ShowOrderRestDto() {
    }

    public ShowOrderRestDto(String userId, String[] status, int page) {
        this.userId = userId;
        this.status = status;
        this.page = page;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
