package org.khalid.customerservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestRestController {
    @Autowired
    private GlobalConfig globalConfig;
    @Autowired
    private CustomerTestConfig customerTestConfig;
    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;
    @Value("${customer.params.x}")
    private String x;
    @Value("${customer.params.y}")
    private String y;
    @GetMapping("/testConfig1")
    public Map<String,String> configTest1(){
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y);
    }
    @GetMapping("/testConfig2")
    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }
    @GetMapping("/testConfig3")
    public CustomerTestConfig getCustomerTestConfig() {
        return customerTestConfig;
    }
}
