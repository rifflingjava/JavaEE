/**
 * The file org.ejbtest.jms.service.JmsService.java was created by yongjie.gong on 2008-7-1
 */
package org.ejbtest.jms.service;

import java.io.ByteArrayOutputStream;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.BytesMessage;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import org.ejbtest.jms.bean.Man;

/**
 * @author feiye
 * 
 */
@MessageDriven(/* mappedName = "jms/testBean ", */activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/A1"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")/*,
        @ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = "QueueConnectionFactory"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "RECIPIENT = 'MDB'"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")*/ })
public class JmsServiceBean implements javax.jms.MessageListener {

    //
    // @Resource(mappedName = "ConnectionFactory")
    // private ConnectionFactory connectionFactory;
    // @Resource(mappedName = "queue/A")
    // private Queue queueA;

    public void onMessage(Message msg) {

        try {
            if (msg instanceof TextMessage) {
                TextMessage tmsg = (TextMessage) msg;
                String content = tmsg.getText();
                this.print(content);
            } else if (msg instanceof ObjectMessage) {
                ObjectMessage omsg = (ObjectMessage) msg;
                Man man = (Man) omsg.getObject();
                String content = man.getName() + ",address=" + man.getAddress();
                this.print(content);
            } else if (msg instanceof MapMessage) {
                MapMessage map = (MapMessage) msg;
                String content = map.getString("no1");
                this.print(content);
            } else if (msg instanceof BytesMessage) {
                BytesMessage bmsg = (BytesMessage) msg;
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[256];
                int length = 0;
                while ((length = bmsg.readBytes(buffer)) != -1) {
                    byteStream.write(buffer, 0, length);
                }
                String content = new String(byteStream.toByteArray());
                byteStream.close();
                this.print(content);
            } else if (msg instanceof StreamMessage) {
                StreamMessage smsg = (StreamMessage) msg;
                String content = smsg.readString();
                this.print(content);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void print(String content) {

        System.out.println(content);
    }
}