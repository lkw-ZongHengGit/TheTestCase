package com.atguigu.gmall.user.controller;


import com.alibaba.fastjson.JSON;
import com.atguigu.gmall.user.bean.JsonResult;
import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.User;
import com.atguigu.gmall.user.retention.UnInterception;

import com.atguigu.gmall.user.service.RedisService;
import com.sun.deploy.net.HttpResponse;
import com.sun.deploy.net.URLEncoder;
import jdk.nashorn.internal.ir.CallNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;


@RestController
@RequestMapping("/TestDemo")
public class TestController {

    @Autowired
    private RedisService redisService;

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/simmpleDemo")
    @UnInterception
    public String simmpleDemo(){
        logger.debug("====测试日志debug级别打印====");
        logger.info("====测试日志info级别打印====");
        logger.error("====测试日志error级别打印====");
        logger.warn("====测试日志warn级别打印====");

        String str = "www.jiujiure.com";
        String str1 = "www.baidu.com";

        logger.info("======最好看的网站：{}；最博学的网站：{}",str,str1);

        return "你好，刘sir";
    }

    /*
    * 实验servlet上下文的缓存效果，Attribute的效果果然挺好用
    * 监听 servlet 上下文对象可以用来初始化数据，用于缓存。
    * */
    @RequestMapping("/getServletContextCach")
    public JsonResult getServletContextCach(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
       List<UmsMember>  list= (List<UmsMember>) servletContext.getAttribute("umsMemberList");

        return new JsonResult(list);
    }

    /*
    * 获取当前在线人数,登录人数从httpSession当中获取 count
    * 下面写的是有缺陷的，关闭浏览器，在开浏览器，记录人数会不停上升，所有要把seesion存在cookie里
    * */
    @GetMapping("/total")
    public String getTotalUser(HttpServletRequest httpServletRequest){
        logger.info("===测试===");
        //HttpSessionListener 其实我们在获取session的时候，才会被它监听到，然后进入我们自定义的session监听器。
        //这样的话，那么统计人数可以在生成session时，我们给它做统计；
        //httpServletRequest.getSession()  这个方法有session则跳过，没有seession则创建
        HttpSession session = httpServletRequest.getSession();
        ServletContext servletContext = session.getServletContext();
        Integer totalUser = (Integer)   servletContext.getAttribute("count");
        return "当前在线人数为：" + totalUser;
    }
    /*
    改造后的方法
    * */
    @GetMapping("/totalByCookie")
    public String totalByCookie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Cookie cookie;
        try {
            //设置cookie，避免我们关闭浏览器，在开浏览器，记录人数会不停上升，所有要把seesion存在cookie里；
            Cookie[] cookies = httpServletRequest.getCookies();
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(httpServletRequest.getSession().getId(),"utf-8"));
            cookie.setPath("/");//可在同一应用服务器内共享方法：设置cookie.setPath("/");
            //设置cookie有效期为2天，设置长一点
            cookie.setMaxAge(48*60*60);
            httpServletResponse.addCookie(cookie);//把cookie塞回去
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        logger.info("===测试===");
        //HttpSessionListener 其实我们在获取session的时候，才会被它监听到，然后进入我们自定义的session监听器。
        //这样的话，那么统计人数可以在生成session时，我们给它做统计；
        //httpServletRequest.getSession()  这个方法有session则跳过，没有seession则创建
        HttpSession session = httpServletRequest.getSession();
        ServletContext servletContext = session.getServletContext();
        Integer totalUser = (Integer)   servletContext.getAttribute("count");
        return "当前在线人数为：" + totalUser;
    }

    @RequestMapping("getRequestInfo")
    public String getRequestInfo(HttpServletRequest request){
        logger.info("requestListener中的初始化的name数据：{}", request.getAttribute("name"));
        return "SUSSESS";

    }


    @RequestMapping("getRequestInfos")
    @UnInterception
    public JsonResult getRequestInfos(HttpServletRequest request){
        //操作String类型
        redisService.setString("weichat","程序员私房菜");
        System.out.println("我的公众号："+redisService.getString("weichat"));
        //如果是实体，试着用json工具转成json字符串
        User user = new User(1, "张飞", "法外狂徒");
        redisService.setString("UserInfo", JSON.toJSONString(user));
        System.out.println("用户信息：{}"+redisService.getString("UserInfo"));

        //操作Hash类型
        redisService.setHash("user","name",JSON.toJSONString(user));
        logger.info("用户姓名：{}",redisService.getHash("user","name"));

        //操作List类型
        redisService.setList("list","football");
        redisService.setList("list","basketball");
        List<String> list = redisService.getList("list", 0, -1);
        for(String value:list){
            logger.info("list中有：{}",value);
        }
        return new JsonResult(redisService.getString("UserInfo"));
    }

}
