/* ScopeRetail (C)2021 */
package com.scoperetail.al.gif.jms.lib.properties;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "port.retry")
public class Config {
  private List<String> queues = new ArrayList<>();
  private List<String> classes = new ArrayList<>();
  private List<String> methods = new ArrayList<>();
  private List<String> bean = new ArrayList<>();

  public List<String> getQueues() {
    return this.queues;
  }

  public List<String> getClasses() {
    return this.classes;
  }

  public List<String> getMethods() {
    return this.methods;
  }

  public List<String> getBean() {
    return this.bean;
  }
}
