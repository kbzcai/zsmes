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
public class MesProdReportStatistical implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonSerialize(using = ToStringSerializer.class)
      private Long id;

    private Long orderNo;

    private Integer orderNum;

    private Integer finishedNum;

    private Integer unfinishNum;

    private String dataSynchro;

    private String status;

    private LocalDateTime createTime;

    private String createUser;

    private LocalDateTime modifyTime;

    private String modifyUser;


}
