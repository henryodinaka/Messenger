package com.leo.henry.messenger.jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class MessageReceiver {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.SerialInitContextFactory");
        properties.put(Context.STATE_FACTORIES,"com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        properties.put(Context.URL_PKG_PREFIXES,"com.sun.enterprise.naming");
        System.setProperties(properties);
        Connection connection =null;
        try {
            InitialContext initialContext = new InitialContext();
            Queue queue =(Queue)initialContext.lookup("jms/P2PQueue");
            ConnectionFactory connectionFactory = (QueueConnectionFactory)initialContext.lookup("jms/_defaultConnectionFactory");
            connection = connectionFactory.createConnection();
            Session session =connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            connection.start();
            MessageConsumer messageConsumer =session.createConsumer(queue);
            TextMessage textMessage =(TextMessage)
            messageConsumer.receive();
            String body = textMessage.getText();
            System.out.println("Mesage receieved "+body);

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
