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
public class MesDevice implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * id
     */
      @JsonSerialize(using = ToStringSerializer.class)
        private Long id;

      /**
     * 工位号
     */
      private String stationNum;

      /**
     * 设备编号
     */
      private String equipmentNum;

      /**
     * 设备名称
     */
      private String equipmentName;

      /**
     * 设备状态
     */
      private Integer equipmentStatus;

      /**
     * 备注
     */
      private String remark;

    private String status;

    private String createUser;

    private LocalDateTime createTime;

    private String modifyUser;

    private LocalDateTime modifyTime;


}
