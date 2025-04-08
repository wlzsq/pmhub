package com.laigeoffer.pmhub.api.project.factory;

import com.laigeoffer.pmhub.api.project.ProjectTaskService;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.core.domain.entity.WfTaskProcess;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

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

            @Override
            public R<Integer> selectStatusByTaskId(String taskId, String type, String source) {
                return R.fail("项目任务状态查询失败:" + throwable.getMessage());
            }

            @Override
            public R<?> updateTaskStatus3(String extraId, String source) {
                return R.fail("项目任务状态更新失败:" + throwable.getMessage());
            }

            @Override
            public R<WfTaskProcess> selectTaskProcess(String extraId, String type, String source) {
                return R.fail("项目任务审批查询失败:" + throwable.getMessage());
            }

            @Override
            public R<?> updateTaskProcessById(WfTaskProcess wfTaskProcess, String source) {
                return R.fail("项目任务审批更新失败:" + throwable.getMessage());
            }

            @Override
            public R<String> insertTaskProcess(WfTaskProcess wfTaskProcess, String source) {
                return R.fail("项目任务审批添加失败:" + throwable.getMessage());
            }
        };
    }
}
