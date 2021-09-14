package com.example.zsmes.config;

import com.example.zsmes.realm.AccountRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")
    DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager);
        //权限设置
        Map<String,String> map=new HashMap<>();
        map.put("/sysUser/main","authc");
        map.put("/sysUser/manage","perms[manage]");
        map.put("/sysUser/administrator","roles[administrator]");
        factoryBean.setFilterChainDefinitionMap(map);
        //设置登录页面
        factoryBean.setLoginUrl("/sysUser/login");
        //设置未授权页面
        factoryBean.setUnauthorizedUrl("/sysUser/unauth");
        return factoryBean;
    }

    /*
    * Qualifier:指定一个名字，通过IOC容器找到该名字的bean
    * */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("accountRealm") AccountRealm accountRealm){
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(accountRealm);
        return manager;
    }

    @Bean
    public AccountRealm accountRealm(){
        return new AccountRealm();
    }
}
