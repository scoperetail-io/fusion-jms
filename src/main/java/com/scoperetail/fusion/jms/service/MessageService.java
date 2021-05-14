/* ScopeRetail (C)2021 */
package com.scoperetail.fusion.jms.service;

public interface MessageService {
  void sendMessage(String queue, final String msg);
}
