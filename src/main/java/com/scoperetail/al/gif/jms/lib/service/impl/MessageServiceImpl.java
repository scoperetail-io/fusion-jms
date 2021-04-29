/* ScopeRetail (C)2021 */
package com.scoperetail.al.gif.jms.lib.service.impl;

import com.scoperetail.al.gif.jms.lib.service.MessageService;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {
  private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

  @Autowired private JmsTemplate jmsTemplate;

  @Override
  public void sendMessage(String queue, String msg) {
    logger.info("Trying to send the msg:[{}] to the queue:[{}]", msg, queue);
    try {
      jmsTemplate.send(
          queue,
          new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
              return session.createObjectMessage(msg);
            }
          });
      logger.info("Msg sent successfully:[{}]", msg);
    } catch (Exception e) {
      logger.error(
          "Message:[{}] :: Queue:[{}] :: Wasn't send because the broker is down.", msg, queue);
      System.err.println(
          "Message:["
              + msg
              + "] :: Queue:["
              + queue
              + "] :: Wasn't send because the broker is down.");
    }
  }
}
