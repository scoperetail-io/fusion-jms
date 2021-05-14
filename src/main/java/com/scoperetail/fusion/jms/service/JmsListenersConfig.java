/* ScopeRetail (C)2021 */
package com.scoperetail.fusion.jms.service;

import com.scoperetail.fusion.jms.properties.Config;
import javax.jms.JMSException;
import javax.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;

@EnableJms
@Configuration
public class JmsListenersConfig implements JmsListenerConfigurer, ApplicationContextAware {
  private static final Logger logger = LoggerFactory.getLogger(JmsListenersConfig.class);
  private static ApplicationContext applicationContext;

  @Autowired private Config config;

  @Override
  public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
    logger.info("configQueues to register :[{}] ", config.getQueues());
    for (int i = 0; i < config.getQueues().size(); i++) {
      String queue = config.getQueues().get(i);
      SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
      endpoint.setId(queue);
      endpoint.setDestination(queue);
      int finalI = i;
      endpoint.setMessageListener(
          message -> {
            // With Spring
            try {
              ListenerJmsService service =
                  applicationContext.getBean(
                      config.getBean().get(finalI), ListenerJmsService.class);
              logger.info("Related service:[{}]", service);
              service.process(((TextMessage) message).getText());
              logger.info("Service called successfully");
            } catch (JMSException e) {
              logger.error("JMSException found: ", e);
            }
          });
      registrar.registerEndpoint(endpoint);
    }
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    JmsListenersConfig.applicationContext = applicationContext;
  }
}
