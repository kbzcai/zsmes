package com.example.zsmes.controller;


import com.example.zsmes.utils.Md5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cyj
 * @since 2021-05-19
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url) {
        System.out.println(url);
        return url;
    }

    @PostMapping("/login/{username}/{password}")
    public String login(@PathVariable("username") String username,@PathVariable("password") String password) {
        System.out.println(username+password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, Md5Util.Md5Code(password));
        try {
            subject.login(token);
            return "登录成功";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "用户名错误";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return "密码错误";
        }
    }

    @GetMapping("/unauth")
    @ResponseBody
    public String unauth(){
        return "未授权，无法访问";
    }
}

