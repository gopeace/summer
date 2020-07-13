package com.season.service.impl;

import com.season.entity.UserInfoAO;
import com.season.service.LoginService;
import org.springframework.stereotype.Service;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

/**
 * @decription:
 * @author: season
 * @date: 2020/7/13 9:52
 */
@Service
public class LoginServiceImpl implements LoginService {
    /**
     * 此处以163邮箱为例，请更改为公司邮箱
     */
    private static final String EMAIL_163 = "163";

    @Override
    public Boolean loginCheck(UserInfoAO userInfoAO) {
        return check163(userInfoAO);
    }

    private boolean check163(UserInfoAO userInfoAO) {
        String username = userInfoAO.getUserName();
        String password = userInfoAO.getPassword();

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        // 请替换公司邮箱的地址及相应配置(以下地址错误，如要验证请替换)
        env.put(Context.PROVIDER_URL, "ldap://10.2.108.21");
        env.put(Context.SECURITY_PRINCIPAL, "dc=163,dc=com");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "163\\"+username);
        env.put(Context.SECURITY_CREDENTIALS, password);

        return basePasspoertCheck(env);
    }

    public static boolean basePasspoertCheck(Hashtable<String, String> env){
        DirContext ctx = null;
        try {
            ctx = new InitialDirContext(env);
            if (ctx != null) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("登录认证失败 username="+env.get(Context.SECURITY_PRINCIPAL)+",password="+env.get(Context.SECURITY_CREDENTIALS));
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e) {
                    System.out.println("登录认证失败 " + e);
                }
            }
        }
        return false;
    }

}
