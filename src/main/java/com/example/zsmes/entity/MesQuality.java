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
public class MesQuality implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonSerialize(using = ToStringSerializer.class)
      private Long id;

    private String productNo;

    private String planNo;

    private String orderNo;

      /**
     * 第几件
     */
      private String productNum;

    private String qualityPerson;

    private String problemDesc;

    private LocalDateTime createTime;

    private String createUser;

    private LocalDateTime modifyTime;

    private String modifyUser;

    private String status;

    private String remark;


}
