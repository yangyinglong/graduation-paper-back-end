package cn.hdu.fragmentTax.dto.request;

public class ReviewOrderRestDto {
    private String orderId;
    private String review;
    private String adminRemarks;

    public ReviewOrderRestDto() {
    }

    public ReviewOrderRestDto(String orderId, String review, String adminRemarks) {
        this.orderId = orderId;
        this.review = review;
        this.adminRemarks = adminRemarks;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getAdminRemarks() {
        return adminRemarks;
    }

    public void setAdminRemarks(String adminRemarks) {
        this.adminRemarks = adminRemarks;
    }
}
