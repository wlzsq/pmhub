package com.laigeoffer.pmhub.api.system;

import com.laigeoffer.pmhub.api.system.factory.DeptFeignFallbackFactory;
import com.laigeoffer.pmhub.base.core.constant.SecurityConstants;
import com.laigeoffer.pmhub.base.core.constant.ServiceNameConstants;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.core.domain.entity.SysDept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "deptFeignService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = DeptFeignFallbackFactory.class)
public interface DeptFeignService {
    @GetMapping("system/dept/getDeptNameById")
    R<SysDept> getDeptNameById(@RequestParam("deptId") Long deptId, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
