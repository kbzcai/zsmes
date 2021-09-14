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
public class MesQualityList implements Serializable {

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
     * 质检人员
     */
      private String qualityPerson;

      /**
     * 订单号
     */
      private String orderNo;

      /**
     * 完成数
     */
      private Integer completeNum;

      /**
     * 返工数
     */
      private Integer reworkNum;

      /**
     * 报废数
     */
      private Integer scrapNum;

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
