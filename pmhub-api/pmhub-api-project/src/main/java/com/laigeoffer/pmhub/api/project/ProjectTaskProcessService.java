package com.laigeoffer.pmhub.api.project;

import com.laigeoffer.pmhub.api.project.factory.ProjectTaskProcessServiceFallbackFactory;
import com.laigeoffer.pmhub.base.core.constant.SecurityConstants;
import com.laigeoffer.pmhub.base.core.constant.ServiceNameConstants;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.core.domain.dto.ProjectTaskProcessDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(contextId = "projectTaskProcessService", value = ServiceNameConstants.PROJECT_SERVICE, fallbackFactory = ProjectTaskProcessServiceFallbackFactory.class)
public interface ProjectTaskProcessService {
    @PutMapping("/project/task/process")
    R<?> updateProjectTaskProcess(ProjectTaskProcessDTO projectTaskProcessDTO, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
