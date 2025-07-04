package ir.sdoc.eurekaclient.feign;

import ir.sdoc.eurekaclient.dto.InstanceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("EurekaClient")
public interface FeignClientApplication {

    @GetMapping("/v1/api/instance-info")
    InstanceDto getInstance();
}
