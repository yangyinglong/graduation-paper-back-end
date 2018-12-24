package cn.hdu.fragmentTax.util;

import java.io.FileOutputStream;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;

/**
 * @ClassName: SendMailUtil
 * @Description: 发送Email
 *
 */
public class SendMailUtil {

    @Autowired
    public static TemplateEngine templateEngine;

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.163.com");
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        ts.connect("smtp.163.com", "15968161237", "WAng1996yang.");
        //4、创建邮件
        Message message = createTemplateMail(session, "15968161237@163.com", "15968161237@163.com", "带图片的邮件", "你好，这是我和我家大人\n");
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

    public static Session createSession() {
        Properties prop = new Properties();
        Session session = Session.getInstance(prop);
        try {
            prop.setProperty("mail.host", "smtp.163.com");
            prop.setProperty("mail.transport.protocol", "smtp");
            prop.setProperty("mail.smtp.auth", "true");
            //使用JavaMail发送邮件的5个步骤
            //1、创建session
            //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
            session.setDebug(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }


    /**
     * todo
     * 模板邮件，有问题
     * @param session
     * @param from
     * @param to
     * @param subject
     * @param content
     * @return
     * @throws Exception
     */
    public static MimeMessage createTemplateMail(Session session, String from, String to, String subject, String content)
            throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress(from));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

        Context context = new Context();
        context.setVariable("id", "006");
        //邮件的标题
        message.setSubject(subject);
        //邮件的文本内容
        String emailContent = templateEngine.process("emailTemplate.html", context);
        System.out.println(emailContent);
        message.setContent(emailContent, "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }

    /**
     *
     * @param session
     * @param from 发送人
     * @param to 接收人
     * @param subject  标题
     * @param content 正文
     * @return message
     * @throws Exception
     */
    public static MimeMessage createSimpleMail(Session session, String from, String to, String subject, String content)
            throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress(from));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //邮件的标题
        message.setSubject(subject);
        //邮件的文本内容
        message.setContent(content, "text/html;charset=UTF-8");
        //返回创建好的邮件对象
        return message;
    }

    /**
     * @Description 创建包含图片的邮件
     * @param session
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param imagePath
     * @return
     * @throws Exception
     */
    public static MimeMessage createImageMail(Session session, String from, String to, String subject, String content, String imagePath) throws Exception {
        //创建邮件
        MimeMessage message = new MimeMessage(session);
        // 设置邮件的基本信息
        //发件人
        message.setFrom(new InternetAddress(from));
        //收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //邮件标题
        message.setSubject(subject);

        // 准备邮件数据
        // 准备邮件正文数据
        MimeBodyPart text = new MimeBodyPart();
        text.setContent(content + "<br><img src='cid:xxx.jpg'>", "text/html;charset=UTF-8");
        // 准备图片数据
        MimeBodyPart image = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource(imagePath));
        image.setDataHandler(dh);
        image.setContentID("xxx.jpg");
        // 描述数据关系
        MimeMultipart mm = new MimeMultipart();
        mm.addBodyPart(text);
        mm.addBodyPart(image);
        mm.setSubType("related");

        message.setContent(mm);
        message.saveChanges();
        //将创建好的邮件写入到E盘以文件的形式进行保存
        message.writeTo(new FileOutputStream("D:\\imageMail.eml"));
        //返回创建好的邮件
        return message;
    }

    /**
     * @Method: createAttachMail
     * @Description: 创建一封带附件的邮件
     *
     * @param session
     * @return
     * @throws Exception
     */
    public static MimeMessage createAttachMail(Session session, String from, String to, String subject, String content, String attachPath) throws Exception{
        MimeMessage message = new MimeMessage(session);

        //设置邮件的基本信息
        //发件人
        message.setFrom(new InternetAddress(from));
        //收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //邮件标题
        message.setSubject(subject);

        //创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码
        MimeBodyPart text = new MimeBodyPart();
        text.setContent(content, "text/html;charset=UTF-8");

        //创建邮件附件
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource(attachPath));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());  //

        //创建容器描述数据关系
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(text);
        mp.addBodyPart(attach);
        mp.setSubType("mixed");

        message.setContent(mp);
        message.saveChanges();
        //将创建的Email写入到E盘存储
        message.writeTo(new FileOutputStream("D:\\attachMail.eml"));
        //返回生成的邮件
        return message;
    }

    /**
     * @Method: createMixedMail
     * @Description: 生成一封带附件和带图片的邮件
     *
     * @param session
     * @return
     * @throws Exception
     */
    public static MimeMessage createMixedMail(Session session, String from, String to, String subject, String content, String imagePath, String attachPath) throws Exception {
        //创建邮件
        MimeMessage message = new MimeMessage(session);

        //设置邮件的基本信息
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("带附件和带图片的的邮件");

        //正文
        MimeBodyPart text = new MimeBodyPart();
        text.setContent(content + "<br/><img src='cid:aaa.jpg'>","text/html;charset=UTF-8");

        //图片
        MimeBodyPart image = new MimeBodyPart();
        image.setDataHandler(new DataHandler(new FileDataSource(imagePath)));
        image.setContentID("aaa.jpg");

        //附件1
        MimeBodyPart attach = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource(attachPath));
        attach.setDataHandler(dh);
        attach.setFileName(dh.getName());

        //附件2
        MimeBodyPart attach2 = new MimeBodyPart();
        DataHandler dh2 = new DataHandler(new FileDataSource(attachPath));
        attach2.setDataHandler(dh2);
        attach2.setFileName(MimeUtility.encodeText(dh2.getName()));

        //描述关系:正文和图片
        MimeMultipart mp1 = new MimeMultipart();
        mp1.addBodyPart(text);
        mp1.addBodyPart(image);
        mp1.setSubType("related");

        //描述关系:正文和附件
        MimeMultipart mp2 = new MimeMultipart();
        mp2.addBodyPart(attach);
        mp2.addBodyPart(attach2);

        //代表正文的bodypart
        MimeBodyPart part = new MimeBodyPart();
        part.setContent(mp1);
        mp2.addBodyPart(part);
        mp2.setSubType("mixed");

        message.setContent(mp2);
        message.saveChanges();

        message.writeTo(new FileOutputStream("D:\\MixedMail.eml"));
        //返回创建好的的邮件
        return message;
    }
}
