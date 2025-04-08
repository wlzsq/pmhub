package com.laigeoffer.pmhub.api.project;

import com.laigeoffer.pmhub.api.project.factory.ProjectTaskFallbackFactory;
import com.laigeoffer.pmhub.base.core.constant.SecurityConstants;
import com.laigeoffer.pmhub.base.core.constant.ServiceNameConstants;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.core.domain.entity.WfTaskProcess;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(contextId = "projectTaskProcessService", value = ServiceNameConstants.PROJECT_SERVICE, fallbackFactory = ProjectTaskFallbackFactory.class)
public interface ProjectTaskService {
    @PutMapping("/project/task/process")
    R<?> updateProjectTaskProcess(WfTaskProcess wfTaskProcess, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/project/task/status")
    R<Integer> selectStatusByTaskId(@RequestParam("taskId") String taskId, @RequestParam(value = "type") String type, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PutMapping("/project/task/updateTaskStatus3")
    R<?> updateTaskStatus3(String extraId, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @GetMapping("/project/task/selectTaskProcess")
    R<WfTaskProcess> selectTaskProcess(@RequestParam("extraId") String extraId, @RequestParam("type") String type, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PutMapping("/project/task/updateTaskProcessById")
    R<?> updateTaskProcessById(WfTaskProcess wfTaskProcess, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    @PostMapping("/project/task/insertTaskProcess")
    R<String> insertTaskProcess(WfTaskProcess wfTaskProcess, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
