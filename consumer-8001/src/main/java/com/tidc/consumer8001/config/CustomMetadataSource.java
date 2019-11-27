//package com.tidc.consumer8001.config;
//
//import com.tidc.api.pojo.Menu;
//import com.tidc.api.pojo.Role;
//import com.tidc.consumer8001.mapper.MenuMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.AntPathMatcher;
//
//import java.util.Collection;
//import java.util.List;
//
///**
// * Created by sang on 2017/12/28.
// * 访问资源（即授权管理），访问url时，会通过AbstractSecurityInterceptor拦截器拦截
// * ，其中会调用FilterInvocationSecurityMetadataSource的方法来获取被拦截url所需的全部权限，在调用授权管理器AccessDecisionManager
// * ，这个授权管理器会通过spring的全局缓存SecurityContextHolder获取用户的权限信息，还会获取被拦截的url和被拦截url所需的全部权限
// * ，然后根据所配的策略（有：一票决定，一票否定，少数服从多数等），如果权限足够，则返回，权限不够则报错并调用权限不足页面。
// *
//
// */
////其中会调用FilterInvocationSecurityMetadataSource的方法来获取被拦截url所需的全部权限
//@Component
//public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {
//    @Autowired
//    MenuMapper menuMapper;
//    //uri的匹配工具类
//    AntPathMatcher antPathMatcher = new AntPathMatcher();
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object o) {
////        这个类的作用本身很简单，就是把doFilter传进来的request,response和FilterChain对象保存起来，供FilterSecurityInterceptor的处理代码调用
//        String requestUrl = ((FilterInvocation) o).getRequestUrl();
////        资源表
//        List<Menu> allMenu = menuMapper.getAllMenu();
//        for (Menu menu : allMenu) {
////            匹配资源表和请求uri
//            if (antPathMatcher.match(menu.getUrl(), requestUrl)
//                    /*&&menu.getRoles().size()>0*/) {
////                查询当前账号的角色信息
//                List<Role> roles = menu.getRoles();
//                int size = roles.size();
//                String[] values = new String[size];
//                for (int i = 0; i < size; i++) {
//                    values[i] = roles.get(i).getName();
//                }
//                //返回一個訪問這個url所需要的角色
//                return SecurityConfig.createList(values);
//            }
//        }
//        //没有匹配上的资源，都是登录访问
//        return SecurityConfig.createList("ROLE_LOGIN");
//    }
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return FilterInvocation.class.isAssignableFrom(aClass);
//    }
//}
