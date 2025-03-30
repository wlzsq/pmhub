package com.laigeoffer.pmhub.base.core.core.domain.dto;

import lombok.Data;

@Data
public class ProjectTaskProcessDTO {
    /**
     * 流程定义id
     */
    private String definitionId;
    /**
     * 原流程id
     */
    private String originDefinitionId;
    /**
     * 是否需要审批
     */
    private String approved;
    /**
     * 部署id
     */
    private String deploymentId;
}
