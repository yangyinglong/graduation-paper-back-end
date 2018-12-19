package cn.hdu.fragmentTax.dto.request;

import java.util.List;

public class EditOrderRestDto {
    private String orderId;
    private String labBeSpeakName;
    private List<String> time;
    private String usedTo;
    private String remarks;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public EditOrderRestDto() {
    }

    public String getLabBeSpeakName() {
        return labBeSpeakName;
    }

    public void setLabBeSpeakName(String labBeSpeakName) {
        this.labBeSpeakName = labBeSpeakName;
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
