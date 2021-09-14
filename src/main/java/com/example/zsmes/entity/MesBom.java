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
public class MesBom implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonSerialize(using = ToStringSerializer.class)
      private Long id;

    private String orderNo;

    private String materialLevel;

    private String stationNo;

    private String productNo;

    private String productName;

    private String materialNo;

    private String materialDesc;

    private Integer productNum;

    private String productUnit;

      /**
     * 工时
     */
      private String workingHours;

      /**
     * 生产厂家，供应商
     */
      private String manufacturer;

    private String productWeight;

    private String department;

    private String remark;

    private String status;

    private String createUser;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private String modifyUser;


}
