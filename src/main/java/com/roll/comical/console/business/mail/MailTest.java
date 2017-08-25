package com.roll.comical.console.business.mail;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author zongqiang.hao
 */
public class MailTest {
	public static void main(String args[]) throws Exception {
		// 1. 创建一封邮件
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("mx1.qq.com");
		mailSender.setUsername("472583006@qq.com");
		mailSender.setPassword("1256735256-----");
		mailSender.setDefaultEncoding("UTF-8");
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.from", "472583006@qq.com");
		mailSender.setJavaMailProperties(prop);

		SimpleMailMessage smm = new SimpleMailMessage();
		// 设定邮件参数
		smm.setFrom(mailSender.getUsername());
		smm.setTo("haozongqiang@foxmail.com");
		smm.setSubject("Hello world");
		smm.setText("Hello world via spring mail sender");
		// 发送邮件
		mailSender.send(smm);

	}
}
