package com.laigeoffer.pmhub.api.system.factory;

import com.laigeoffer.pmhub.api.system.RoleFeignService;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.core.domain.entity.SysRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class RoleFeignFallbackFactory implements FallbackFactory<RoleFeignService> {

    private static final Logger log = LoggerFactory.getLogger(RoleFeignFallbackFactory.class);

    @Override
    public RoleFeignService create(Throwable throwable) {
        log.error("角色服务调用失败:{}", throwable.getMessage());
        return new RoleFeignService() {

            @Override
            public R<SysRole> getRoleById(Long roleId, String source) {
                return R.fail("获取角色信息失败");
            }
        };
    }
}
