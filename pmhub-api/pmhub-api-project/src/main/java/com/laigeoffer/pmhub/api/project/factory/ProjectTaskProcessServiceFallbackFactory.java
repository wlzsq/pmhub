package com.laigeoffer.pmhub.api.project.factory;

import com.laigeoffer.pmhub.api.project.ProjectTaskProcessService;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.core.domain.dto.ProjectTaskProcessDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProjectTaskProcessServiceFallbackFactory implements FallbackFactory<ProjectTaskProcessService> {
    private static final Logger log = LoggerFactory.getLogger(ProjectTaskProcessServiceFallbackFactory.class);
    @Override
    public ProjectTaskProcessService create(Throwable throwable) {
        log.error("项目服务调用失败:{}", throwable.getMessage());
        return new ProjectTaskProcessService()
        {
            @Override
            public R<?> updateProjectTaskProcess(ProjectTaskProcessDTO projectTaskProcessDTO, String source) {
                return R.fail("项目任务流程更新失败:" + throwable.getMessage());
            }
        };
    }
}
