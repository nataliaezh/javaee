import geekbrains.persist.Product;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.print.attribute.standard.Destination;
import javax.resource.cci.ConnectionFactory;
import java.io.IOException;
import java.math.BigDecimal;

import static ru.geekbrains.EjbClient.createInitialContext;

public class JmsClient {

    public static void main(String[] args) throws IOException, NamingException {
        Context context = createInitialContext();

        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
        JMSContext jmsContext = connectionFactory.createContext("jmsuser", "123");

        Destination destination = (Destination) context.lookup("jms/queue/productQueue");

        JMSProducer producer = jmsContext.createProducer();

        ObjectMessage message = jmsContext.createObjectMessage(new Product(null, "JmsProduct", "JMS Product", new BigDecimal(1111)));
        producer.setProperty("action", "new").send(destination, message);
    }
}
