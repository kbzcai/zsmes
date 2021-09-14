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
public class MesOrder implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * id
     */
      @JsonSerialize(using = ToStringSerializer.class)
        private Long id;

      /**
     * 订单号
     */
      private String orderNo;

      /**
     * 名称
     */
      private String orderName;

      /**
     * 型号
     */
      private String orderType;

      /**
     * 产品编号
     */
      private String productNo;

      /**
     * 数量
     */
      private Integer orderNum;

      /**
     * 外部交期
     */
      private LocalDateTime externalDeliveryDate;

      /**
     * 状态
     */
      private String orderStatus;

      /**
     * 客户
     */
      private String customer;

      /**
     * 开始时间
     */
      private LocalDateTime startTime;

      /**
     * 内部交期
     */
      private LocalDateTime insideDeliveryDate;

      /**
     * 数量
     */
      private Integer num;

      /**
     * 完成率
     */
      private String completionRate;

      /**
     * 是否导入bom
     */
      private String bomImport;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private String createUser;

    private String modifyUser;

    private String status;


}
