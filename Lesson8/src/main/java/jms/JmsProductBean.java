package jms;

import antlr.debug.MessageEvent;
import antlr.debug.MessageListener;
import antlr.debug.TraceEvent;
import geekbrains.persist.Product;
import geekbrains.persist.ProductRepository;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationContent", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jboss/exported/jms/queue/productQueue"),
        @ActivationConfigProperty(propertyName = "messageSort", propertyValue = "action = 'new'")
})
public class JmsProductBean implements MessageListener {

    @EJB
    private ProductRepository productRepository;

  //  @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            try {
                Product product = (Product) ((ObjectMessage) message).getObject();
                productRepository.insert(product);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void reportError(MessageEvent messageEvent) {

    }

    @Override
    public void reportWarning(MessageEvent messageEvent) {

    }

    @Override
    public void doneParsing(TraceEvent traceEvent) {

    }

    @Override
    public void refresh() {

    }
}