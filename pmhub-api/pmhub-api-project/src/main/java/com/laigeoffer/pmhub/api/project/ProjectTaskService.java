package com.laigeoffer.pmhub.api.project;

import com.laigeoffer.pmhub.api.project.factory.ProjectTaskFeignFallbackFactory;
import com.laigeoffer.pmhub.base.core.constant.SecurityConstants;
import com.laigeoffer.pmhub.base.core.constant.ServiceNameConstants;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "projectTaskService", value = ServiceNameConstants.PROJECT_SERVICE, fallbackFactory = ProjectTaskFeignFallbackFactory.class)
public interface ProjectTaskService {
    @GetMapping("/task/status")
    R<Integer> selectStatusByTaskId(String taskId, @RequestParam(value = "type") String type, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PutMapping("/task/status")
    R<?> updateTaskStatus3(String extraId, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
