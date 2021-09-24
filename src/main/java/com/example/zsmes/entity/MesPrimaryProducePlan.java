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
public class MesPrimaryProducePlan implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonSerialize(using = ToStringSerializer.class)
      private Long id;

      /**
     * 产品型号
     */
      private String productNo;

    private String orderNo;

      /**
     * 计划号
     */
      private String planNo;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planDate;

      /**
     * 计划班次
     */
      private String planSchedule;

      /**
     * 计划数量
     */
      private Integer planNum;

      /**
     * 实际数量
     */
      private Integer actualNum;

      /**
     * 合格数量
     */
      private Integer passNum;

      /**
     * 焊接完成数量
     */
      private Integer weldingFinishNum;

      /**
     * 不合格数量
     */
      private Integer failNum;

      /**
     * 0:未生产  1：已生产   2：生产中
     */
      private String planStatus;

    private String productBom;

      /**
     * 是否导入bom
     */
      private String bomImport;

    private Integer orderSort;

    private String status;

    private LocalDateTime createTime;

    private String createUser;

    private String modifyUser;

    private LocalDateTime modifyTime;


}
