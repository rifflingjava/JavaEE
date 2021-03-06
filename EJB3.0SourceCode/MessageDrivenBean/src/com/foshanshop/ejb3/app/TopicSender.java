package com.foshanshop.ejb3.app;

import java.util.Properties;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.naming.InitialContext;

import com.foshanshop.ejb3.bean.Man;

public class TopicSender {

    public static void main(String[] args) {
        TopicConnection conn = null;
        TopicSession session = null;
        try {
            Properties props = new Properties();
            props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
            props.setProperty("java.naming.provider.url", "localhost:1099");
            props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming:org.jnp.interfaces");
            InitialContext ctx = new InitialContext(props);
            
            TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup("ConnectionFactory");
            conn = factory.createTopicConnection();
            session = conn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
            Destination destination = (Topic) ctx.lookup("topic/student");
            MessageProducer producer = session.createProducer(destination);
            //发送文本
            TextMessage msg = session.createTextMessage("您好，这是我的第一个消息驱动Bean");
            producer.send(msg);

            //发送Ojbect(对像必须实现序列化,否则等着出错吧)
            producer.send(session.createObjectMessage(new Man("美女", "北京和平里一号")));
            
            //发送MapMessage
            MapMessage mapmsg = session.createMapMessage();
            mapmsg.setObject("no1", "北京和平里一号");
            producer.send(mapmsg);
            
            //发送BytesMessage
            BytesMessage bmsg = session.createBytesMessage();
            bmsg.writeBytes("我是一个兵,来自老百姓".getBytes());
            producer.send(bmsg);
            
            
            //发送StreamMessage
            StreamMessage smsg = session.createStreamMessage();
            smsg.writeString("我就爱流读写");
            producer.send(smsg);

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            try {
                session.close ();
                conn.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
