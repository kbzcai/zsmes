package com.example.zsmes.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class MesEquipment implements Serializable {

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
     * 安装日期
     */
      @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime installDate;

      /**
     * 试运行日期
     */
      @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime trialOperationDate;

      /**
     * 正式运行日期
     */
      @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime officialOperationDate;

      /**
     * 保养周期
     */
      private String maintenancePeriod;

      /**
     * 供应商
     */
      private String providerName;

      /**
     * 对接人
     */
      private String meetPerson;

      /**
     * -1：故障中   0：正常   1：维修完成
     */
      private String equipmentStatus;

      /**
     * 故障时间
     */
      @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime failTime;

      /**
     * 维修完成时间
     */
      @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime repairTime;

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
