/* ScopeRetail (C)2021 */
package com.scoperetail.al.gif.jms.lib.service;

public interface MessageService {
  void sendMessage(String queue, final String msg);
}
