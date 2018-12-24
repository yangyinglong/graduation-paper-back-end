package cn.hdu.fragmentTax.dto.request;

public class SendEmailRestDto {
    private String subject;
    private String content;
    private String to;

    public SendEmailRestDto(String subject, String content, String to) {
        this.subject = subject;
        this.content = content;
        this.to = to;
    }

    public SendEmailRestDto() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
