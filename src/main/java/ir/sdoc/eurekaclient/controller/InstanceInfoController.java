package ir.sdoc.eurekaclient.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import ir.sdoc.eurekaclient.dto.InstanceDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/instance-info")
public class InstanceInfoController {

    @Value("${spring.application.name}")
    private String applicationName;

    private final EurekaClient eurekaClient;

    public InstanceInfoController(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @GetMapping
    public InstanceDto getInstance() {
        System.out.println("Received Instance Request");

        //current instance id
        String instanceId = eurekaClient.getApplicationInfoManager()
                .getInfo().getInstanceId();

        InstanceInfo service = eurekaClient
                .getApplication(applicationName)
                .getByInstanceId(instanceId);

        String hostName = service.getHostName();
        int port = service.getPort();

        return new InstanceDto(applicationName, instanceId, hostName, port);
    }
}
