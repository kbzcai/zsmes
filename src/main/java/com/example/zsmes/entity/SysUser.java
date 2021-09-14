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
public class SysUser implements Serializable {

    private static final long serialVersionUID=1L;

    @JsonSerialize(using = ToStringSerializer.class)
      private Long id;

    private String userName;

    private String password;

      /**
     * 全名
     */
      private String fullName;

    private String tel;

    private Long dept;

    private Integer status;

    private String remark;

    private String portrait;

    private LocalDateTime createTime;

    private String createUser;

    private LocalDateTime modifyTime;

    private String modifyUser;

    private String btnFlag;

    private String menuFlag;

    private String perms;

    private String role;


}
