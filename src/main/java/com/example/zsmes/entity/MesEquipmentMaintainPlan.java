package com.example.zsmes.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@Data
  @EqualsAndHashCode(callSuper = false)
  @Accessors(chain = true)
public class MesEquipmentMaintainPlan implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * id
     */
      @JsonSerialize(using = ToStringSerializer.class)
        private Long id;

      /**
     * 设备编号
     */
      private String equipmentNo;

      /**
     * 检查项目
     */
      private String inspectionItemName;

      /**
     * 维保周期
     */
      private String maintainCycle;

      /**
     * 维保内容
     */
      private String maintainContent;

      /**
     * 改善内容
     */
      private String improveContent;

      /**
     * 问题说明
     */
      private String problemDescription;

      /**
     * 完成情况
     */
      private String taskResponse;

      /**
     * 备注
     */
      private String remark;

    private String status;

    private String createUser;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private String modifyUser;


}
