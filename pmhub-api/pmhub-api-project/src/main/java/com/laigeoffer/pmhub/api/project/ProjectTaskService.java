package com.laigeoffer.pmhub.api.project;

import com.laigeoffer.pmhub.api.project.factory.ProjectTaskFallbackFactory;
import com.laigeoffer.pmhub.base.core.constant.SecurityConstants;
import com.laigeoffer.pmhub.base.core.constant.ServiceNameConstants;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.core.domain.entity.WfTaskProcess;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(contextId = "projectTaskProcessService", value = ServiceNameConstants.PROJECT_SERVICE, fallbackFactory = ProjectTaskFallbackFactory.class)
public interface ProjectTaskService {
    @PutMapping("/project/task/process")
    R<?> updateProjectTaskProcess(WfTaskProcess wfTaskProcess, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
