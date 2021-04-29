/* ScopeRetail (C)2021 */
package com.scoperetail.al.gif.jms.lib;

import com.scoperetail.al.gif.jms.lib.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class JmsLibApplicationTests {
  @MockBean private JmsTemplate jmsTemplate;

  @Autowired private MessageService messageService;

  @Test
  void contextLoads() {}

  //	@Test
  //	void send_message_ok() throws Exception {
  //		messageService.sendMessage("TEST_QUEUE", "TEST_MSG");
  //	}
}
