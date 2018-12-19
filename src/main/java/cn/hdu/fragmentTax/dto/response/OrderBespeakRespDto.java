package cn.hdu.fragmentTax.dto.response;

public class OrderBespeakRespDto {
    private String startTime;
    private String endTime;
    private String bespeakName;

    public OrderBespeakRespDto() {
    }

    public OrderBespeakRespDto(String startTime, String endTime, String bespeakName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.bespeakName = bespeakName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBespeakName() {
        return bespeakName;
    }

    public void setBespeakName(String bespeakName) {
        this.bespeakName = bespeakName;
    }
}
