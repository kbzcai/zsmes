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
public class MesEquipmentRepairRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonSerialize(using = ToStringSerializer.class)
      private Long id;

    private String stationNo;

    private String equipmentNo;

    private String stationName;

      /**
     * 负责人
     */
      private String leader;

      /**
     * 最近一次维修日期
     */
      private LocalDateTime lastRepairDate;

    private String remark;

    private String status;

    private LocalDateTime modifyTime;

    private String modifyUser;

    private String createUser;

    private LocalDateTime createTime;


}
