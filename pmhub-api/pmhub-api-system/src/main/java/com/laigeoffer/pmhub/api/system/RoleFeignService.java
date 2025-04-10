package com.laigeoffer.pmhub.api.system;

import com.laigeoffer.pmhub.api.system.factory.RoleFeignFallbackFactory;
import com.laigeoffer.pmhub.base.core.constant.SecurityConstants;
import com.laigeoffer.pmhub.base.core.constant.ServiceNameConstants;
import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.core.domain.entity.SysRole;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "roleFeignService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RoleFeignFallbackFactory.class)
public interface RoleFeignService {
    @GetMapping("system/role/getRoleById")
    R<SysRole> getRoleById(@RequestParam("roleId") Long roleId, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
