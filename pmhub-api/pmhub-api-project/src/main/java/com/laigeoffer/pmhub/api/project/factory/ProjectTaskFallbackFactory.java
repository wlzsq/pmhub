package com.laigeoffer.pmhub.api.project.factory;

import com.laigeoffer.pmhub.api.project.ProjectTaskService;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.core.domain.entity.WfTaskProcess;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProjectTaskFallbackFactory implements FallbackFactory<ProjectTaskService> {
    private static final Logger log = LoggerFactory.getLogger(ProjectTaskFallbackFactory.class);
    @Override
    public ProjectTaskService create(Throwable throwable) {
        log.error("项目服务调用失败:{}", throwable.getMessage());
        return new ProjectTaskService()
        {
            @Override
            public R<?> updateProjectTaskProcess(WfTaskProcess wfTaskProcess, String source) {
                return R.fail("项目任务流程更新失败:" + throwable.getMessage());
            }
        };
    }
}
