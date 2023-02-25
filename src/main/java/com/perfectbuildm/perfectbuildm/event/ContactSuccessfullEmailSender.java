package com.perfectbuildm.perfectbuildm.event;

import com.perfectbuildm.perfectbuildm.config.JavaMailSender;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;


@Component
public class ContactSuccessfullEmailSender {

    private final JavaMailSender javaMailSender;

    public ContactSuccessfullEmailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @EventListener(ContactSuccessfullEventImpl.class)
    public void sendContactEmail(ContactSuccessfullEventImpl contactSuccessfullEvent) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(contactSuccessfullEvent.getEmail());

        mail.setSubject("Запитване от : " + contactSuccessfullEvent.getCustomerEmail());
        mail.setText("Съобщение от клиент : -> \n " + contactSuccessfullEvent.getMessage()
                + "\n име:" + contactSuccessfullEvent.getName()
                + "\n телефон: " + contactSuccessfullEvent.getPhone());

        javaMailSender.getJavaMailSender().send(mail);

    }
}
