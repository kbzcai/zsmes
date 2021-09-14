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
public class MesEquipmentFaultStatistics implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonSerialize(using = ToStringSerializer.class)
      private Long id;

    private String stationNo;

    private String equipmentNo;

    private String equipmentName;

    private Integer faultTimes;

      /**
     * 最近一次故障日期
     */
      private LocalDateTime lastFaultDate;

    private LocalDateTime modifyTime;

    private String faultReason;

    private String status;

    private String remark;

    private String modifyUser;

    private String createUser;

    private LocalDateTime createTime;


}
