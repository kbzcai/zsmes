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
public class MesEquipmentMaintainRecord implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * id
     */
      @JsonSerialize(using = ToStringSerializer.class)
        private Long id;

      /**
     * 工位号
     */
      private String stationNo;

      /**
     * 设备编号
     */
      private String equipmentNo;

      /**
     * 设备名称
     */
      private String equipmentName;

      /**
     * 更换日期
     */
      private LocalDateTime replaceDate;

      /**
     * 更换编号
     */
      private String replaceNum;

      /**
     * 更换内容
     */
      private String replaceContent;

      /**
     * 更换人
     */
      private String replacePerson;

      /**
     * 上次更换日期
     */
      private LocalDateTime lastReplaceDate;

      /**
     * 更换说明
     */
      private String replaceDirection;

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
