package com.javainuse.producer;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer implements Runnable {

    public void run() {
        try { // Create a connection factory.
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            //Create connection.
            Connection connection = factory.createConnection();

            // Start the connection
            connection.start();

            // Create a session which is non transactional
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create Destination queue
            Destination queue = session.createQueue("Queue");

            // Create a producer
            MessageProducer producer = session.createProducer(queue);

            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            String msg = "Hello World";

            // insert message
            TextMessage message = session.createTextMessage(msg);
            System.out.println("Producer Sent: " + msg);
            producer.send(message);

            session.close();
            connection.close();
        }
        catch (Exception ex) {
            System.out.println("Exception Occured");
        }
    }
}