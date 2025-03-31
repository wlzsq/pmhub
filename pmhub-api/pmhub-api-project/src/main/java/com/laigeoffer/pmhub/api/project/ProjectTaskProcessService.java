package com.laigeoffer.pmhub.api.project;

import com.laigeoffer.pmhub.api.project.factory.ProjectTaskProcessServiceFallbackFactory;
import com.laigeoffer.pmhub.base.core.constant.SecurityConstants;
import com.laigeoffer.pmhub.base.core.constant.ServiceNameConstants;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.core.domain.dto.ProjectTaskProcessDTO;
import com.laigeoffer.pmhub.base.core.core.domain.entity.WfTaskProcess;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(contextId = "projectTaskProcessService", value = ServiceNameConstants.PROJECT_SERVICE, fallbackFactory = ProjectTaskProcessServiceFallbackFactory.class)
public interface ProjectTaskProcessService {
    @PutMapping("/project/task/process")
    R<?> updateProjectTaskProcess(ProjectTaskProcessDTO projectTaskProcessDTO, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/project/task/process/selectOne")
    R<WfTaskProcess> selectOne(ProjectTaskProcessDTO projectTaskProcessDTO, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PutMapping("/project/task/process/updateById")
    R<?> updateById(ProjectTaskProcessDTO projectTaskProcessDTO, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PostMapping("/project/task/process/insert")
    R<?> insert(ProjectTaskProcessDTO projectTaskProcessDTO, String inner);
}
