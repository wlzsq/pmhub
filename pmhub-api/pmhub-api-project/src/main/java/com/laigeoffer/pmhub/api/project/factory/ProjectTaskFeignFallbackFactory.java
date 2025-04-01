package com.laigeoffer.pmhub.api.project.factory;

import com.laigeoffer.pmhub.api.project.ProjectTaskService;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProjectTaskFeignFallbackFactory implements FallbackFactory<ProjectTaskService> {
    @Override
    public ProjectTaskService create(Throwable throwable) {
        return new ProjectTaskService() {

            @Override
            public R<Integer> selectStatusByTaskId(String taskId, String type, String source) {
                return R.fail("查询任务状态失败:" + throwable.getMessage());
            }

            @Override
            public R<?> updateTaskStatus3(String extraId, String source) {
                return R.fail("任务状态更新失败:" + throwable.getMessage());
            }
        };
    }
}
