package com.lzf.greatme.utils;

import com.lzf.greatme.config.EmailConfig;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import java.io.File;
import java.util.Date;

public class CommonsEmail
{
    /**
     * 发送文本邮件
     *
     * @throws Exception
     */
    public void sendTextMail(EmailConfig emailConfig,String title,String content,String emailTo) throws Exception
    {
        SimpleEmail mail = new SimpleEmail();
        // 设置邮箱服务器信息
        mail.setSmtpPort(emailConfig.getPort());
        mail.setSSLOnConnect(true);
        mail.setHostName(emailConfig.getHost());
        // 设置密码验证器
        mail.setAuthentication(emailConfig.getUserName(), emailConfig.getPassword());
        // 设置邮件发送者
        mail.setFrom(emailConfig.getUserName(),emailConfig.getPickName());
        // 设置邮件接收者
        mail.addTo(emailTo);
        // 设置邮件编码
        mail.setCharset(emailConfig.getCharset());
        // 设置邮件主题
        mail.setSubject(title);
        // 设置邮件内容
        mail.setMsg(content);
        // 设置邮件发送时间
        mail.setSentDate(new Date());
        // 发送邮件
        mail.send();
    }

    /**
     * 发送Html邮件
     *
     * @throws Exception
     */
    public void sendHtmlMail(EmailConfig emailConfig) throws Exception
    {
        HtmlEmail mail = new HtmlEmail();
        // 设置邮箱服务器信息
        mail.setSmtpPort(emailConfig.getPort());
        mail.setHostName(emailConfig.getHost());
        // 设置密码验证器
        mail.setAuthentication(emailConfig.getUserName(), emailConfig.getPassword());
        // 设置邮件发送者
        mail.setFrom(emailConfig.getUserName(),emailConfig.getPickName());
        // 设置邮件接收者
        mail.addTo();
        // 设置邮件编码
        mail.setCharset(emailConfig.getCharset());
        // 设置邮件主题
        mail.setSubject("Test Email");
        // 设置邮件内容
        mail.setHtmlMsg(
                "<html><body><img src='http://avatar.csdn.net/A/C/A/1_jianggujin.jpg'/><div>this is a HTML email.</div></body></html>");
        // 设置邮件发送时间
        mail.setSentDate(new Date());
        // 发送邮件
        mail.send();
    }

    /**
     * 发送内嵌图片邮件
     *
     * @throws Exception
     */
    public void sendImageMail(EmailConfig emailConfig) throws Exception
    {
        HtmlEmail mail = new HtmlEmail();
        // 设置邮箱服务器信息
        mail.setSmtpPort(emailConfig.getPort());
        mail.setHostName(emailConfig.getHost());
        // 设置密码验证器
        mail.setAuthentication(emailConfig.getUserName(), emailConfig.getPassword());
        // 设置邮件发送者
        mail.setFrom(emailConfig.getUserName(),emailConfig.getPickName());
        // 设置邮件接收者
        mail.addTo();
        // 设置邮件编码
        mail.setCharset(emailConfig.getCharset());
        // 设置邮件主题
        mail.setSubject("Test Email");
        mail.embed(new File("1_jianggujin.jpg"), "image");
        // 设置邮件内容
        String htmlText = "<html><body><img src='cid:image'/><div>this is a HTML email.</div></body></html>";
        mail.setHtmlMsg(htmlText);
        // 设置邮件发送时间
        mail.setSentDate(new Date());
        // 发送邮件
        mail.send();
    }

    /**
     * 发送附件邮件
     *
     * @throws Exception
     */
    public void sendAttachmentMail(EmailConfig emailConfig) throws Exception
    {
        MultiPartEmail mail = new MultiPartEmail();
        // 设置邮箱服务器信息
        mail.setSmtpPort(emailConfig.getPort());
        mail.setHostName(emailConfig.getHost());
        // 设置密码验证器
        mail.setAuthentication(emailConfig.getUserName(), emailConfig.getPassword());
        // 设置邮件发送者
        mail.setFrom(emailConfig.getUserName(),emailConfig.getPickName());
        // 设置邮件接收者
        mail.addTo();
        // 设置邮件编码
        mail.setCharset(emailConfig.getCharset());
        // 设置邮件主题
        mail.setSubject("Test Email");

        mail.setMsg("this is a Attachment email.this email has a attachment!");
        // 创建附件
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("1_jianggujin.jpg");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setName("1_jianggujin.jpg");
        mail.attach(attachment);

        // 设置邮件发送时间
        mail.setSentDate(new Date());
        // 发送邮件
        mail.send();
    }

    /**
     * 发送内嵌图片和附件邮件
     *
     * @throws Exception
     */
    public void sendImageAndAttachmentMail(EmailConfig emailConfig) throws Exception
    {
        HtmlEmail mail = new HtmlEmail();
        // 设置邮箱服务器信息
        mail.setSmtpPort(emailConfig.getPort());
        mail.setHostName(emailConfig.getHost());
        // 设置密码验证器
        mail.setAuthentication(emailConfig.getUserName(), emailConfig.getPassword());
        // 设置邮件发送者
        mail.setFrom(emailConfig.getUserName(),emailConfig.getPickName());
        // 设置邮件接收者
        mail.addTo();
        // 设置邮件编码
        mail.setCharset(emailConfig.getCharset());
        // 设置邮件主题
        mail.setSubject("Test Email");
        mail.embed(new File("1_jianggujin.jpg"), "image");
        // 设置邮件内容
        String htmlText = "<html><body><img src='cid:image'/><div>this is a HTML email.</div></body></html>";
        mail.setHtmlMsg(htmlText);
        // 创建附件
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("1_jianggujin.jpg");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setName("1_jianggujin.jpg");
        mail.attach(attachment);
        // 设置邮件发送时间
        mail.setSentDate(new Date());
        // 发送邮件
        mail.send();
    }
}
