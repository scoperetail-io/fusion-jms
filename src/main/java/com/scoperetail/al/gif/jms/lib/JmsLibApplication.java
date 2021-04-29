/* ScopeRetail (C)2021 */
package com.scoperetail.al.gif.jms.lib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.scoperetail.al.gif.jms.lib"})
public class JmsLibApplication {

  public static void main(String[] args) {
    SpringApplication.run(JmsLibApplication.class, args);
  }
}
