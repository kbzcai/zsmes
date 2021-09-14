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
public class MesMaterialRequirePlan implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonSerialize(using = ToStringSerializer.class)
      private Long id;

    private String orderNo;

    private String planNo;

    private String productNo;

    private String materialNo;

    private String materialDesc;

      /**
     * 库存数量
     */
      private Integer productStockNum;

      /**
     * 总需求量
     */
      private Integer totalRequireNum;

      /**
     * 需采购量
     */
      private Integer requirePurchaseNum;

      /**
     * 采购状态
     */
      private String purchaseStatus;

      /**
     * 配送状态
     */
      private String deliveryStatus;

      /**
     * 提前配送量
     */
      private Integer deliveryEarly;

      /**
     * 工位号
     */
      private String stationNo;

      /**
     * 退回数量
     */
      private Integer backNum;

      /**
     * 实际配送数量
     */
      private Integer actualDeliveryNum;

    private String status;

    private String createUser;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private String modifyUser;


}
