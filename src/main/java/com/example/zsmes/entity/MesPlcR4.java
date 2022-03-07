package com.example.zsmes.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class MesPlcR4 implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Long id;

      /**
     * 产品型号
     */
      private String productType;

      /**
     * r1设备状态
     */
      private String r1EquipmentStatus;

      /**
     * r2设备状态
     */
      private String r2EquipmentStatus;

      /**
     * 故障代码
     */
      private String failCode;

      /**
     * 当前生成记数
     */
      private Integer prodNum;

      /**
     * r1程序号
     */
      private String r1RobNo;

      /**
     * 枪1当前焊缝号
     */
      private String r1WeldLineNo;

      /**
     * 枪1电流
     */
      private String r1Electric;

      /**
     * 枪1电压
     */
      private String r1Voltage;

      /**
     * 枪1焊缝速度
     */
      private String r1Speed;

      /**
     * 枪1JOB号
     */
      private String r1Job;

      /**
     * r2程序号
     */
      private String r2RobNo;

      /**
     * 枪2当前焊缝号
     */
      private String r2WeldLineNo;

      /**
     * 枪2电流
     */
      private String r2Electric;

      /**
     * 枪2电压
     */
      private String r2Voltage;

      /**
     * 枪2焊缝速度
     */
      private String r2Speed;

      /**
     * 枪2JOB号
     */
      private String r2Job;

      /**
     * 更换状态
     */
      private String replaceStatus;

      /**
     * 枪1保护用气量
     */
      private String r1ProtectiveGas;

      /**
     * 枪2保护用气量
     */
      private String r2ProtectiveGas;

      /**
     * 枪一焊丝用量
     */
      private String r1WeldingWire;

      /**
     * 枪2焊丝用量
     */
      private String r2WeldingWire;

    private String loginId;

    private String loginPassword;

      /**
     * 零件状态
     */
      private String partStatus;

      /**
     * 预留
     */
      private String recerve;

      /**
     * 生成时间
     */
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime createTime;

      /**
     * 产品型号2
     */
      private String productType2;

    @TableField("prod_numB")
    private Integer prodNumb;

    private String qualifed;

    private String unaccepted;

    private String switchBut;

    private String player;


}
