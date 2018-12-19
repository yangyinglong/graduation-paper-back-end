package cn.hdu.fragmentTax.dto.request;

import java.util.List;

public class ShowOrderBespeakRestDto {
    private String labId;
    private List<String> time;

    public ShowOrderBespeakRestDto() {
    }

    public ShowOrderBespeakRestDto(String labId, List<String> time) {
        this.labId = labId;
        this.time = time;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }
}
