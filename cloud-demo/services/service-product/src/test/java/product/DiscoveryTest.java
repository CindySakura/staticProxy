package product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

/**
 * 功能：
 * 作者：Cindy
 * 日期：25/04/2025 00:33
 */
@SpringBootTest
public class DiscoveryTest {

    @Autowired
    DiscoveryClient discoveryClient;

    @Test
    void discoveryClientTest(){
        for(String service : discoveryClient.getServices()){
            System.out.println("service = " + service);
            //获取IP+port
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for(ServiceInstance instance : instances){
                System.out.println("ip: " + instance.getHost() + " port: " + instance.getPort());
            }
        }
    }
}
