package com.laigeoffer.pmhub.api.system.factory;

import com.laigeoffer.pmhub.api.system.DeptFeignService;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.core.domain.entity.SysDept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class DeptFeignFallbackFactory implements FallbackFactory<DeptFeignService> {
    private static final Logger log = LoggerFactory.getLogger(DeptFeignFallbackFactory.class);
    @Override
    public DeptFeignService create(Throwable throwable) {
        log.error("部门服务调用失败:{}", throwable.getMessage());
        return new DeptFeignService() {
            @Override
            public R<SysDept> getDeptNameById(Long deptId, String source) {
                return R.fail("获取部门信息失败");
            }
        };
    }
}
