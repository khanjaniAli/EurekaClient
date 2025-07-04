package ir.sdoc.eurekaclient.controller;

import ir.sdoc.eurekaclient.dto.InstanceDto;
import ir.sdoc.eurekaclient.feign.FeignClientApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/request-builder")
public class RequestBuilderController {

    private final FeignClientApplication feignClientApplication;

    public RequestBuilderController(FeignClientApplication feignClientApplication) {
        this.feignClientApplication = feignClientApplication;
    }

    @GetMapping
    public InstanceDto createRequest() {
        return feignClientApplication.getInstance();
    }
}
