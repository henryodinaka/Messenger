package com.leo.henry.messenger.jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class MsgProducer {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.SerialInitContextFactory");
        properties.put(Context.STATE_FACTORIES,"com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        properties.put(Context.URL_PKG_PREFIXES,"com.sun.enterprise.naming");
        Connection connection =null;
        InitialContext initialContext =null;
        ConnectionFactory connectionFactory =null;
                Queue queue=null;
        try {
            initialContext = new InitialContext(properties);
             queue =(Queue)initialContext.lookup("jms/P2PQueue");
            connectionFactory = (QueueConnectionFactory)initialContext.lookup("jms/_defaultConnectionFactory");
             connection = connectionFactory.createConnection();
            Session session =connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer =session.createProducer(queue);
            TextMessage textMessage =session.createTextMessage(args[0]);
            messageProducer.send(textMessage);
            System.out.println("My message produced");

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (connection !=null)
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
        }
    }
}
