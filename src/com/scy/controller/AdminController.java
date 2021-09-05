package com.scy.controller;


import com.scy.bean.AdminInfo;
import com.scy.bean.Dog;
import com.scy.bean.Lover;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/admin")
public class AdminController {
    //注册成功后,如果是单体项目---就要跳转到登录页,这个跳转是后台的转发,重定向
//总之是后台负责跳转,携带数据的跳转页面的
//如果是新型的项目,即前后端分离的,那么后台只负责返回给前端json数据
//跳转是前端处理的,前端根据后台返回code代码,进行跳转
//如果前端负责跳转,它会起一个好听的名字,叫做路由
//什么是前后端分离 即:项目上的分离 和 数据上的分离
//项目上的分离:前端一个项目,后台一个项目,2个项目,它们的认证是token/jwt+redis
//数据上的分离:还是一个项目,只不过前后端用json来交互数据
//很少用jstl/el表达式来写项目.它们的认证是session
//layui在ssm框架中的使用,其实就是数据上的分离,也可以项目上的分离
//那么它及时json交互的,哪门后台只需要给它返回json数据就可以了
// 以前在servlet中,resp.getWriter().print(new JSONObject.tostring(map)) 输出json
//现在mvc框架高级了...
//adminName: admin 以前收参数 req.getParamter("adminName)
//adminPwd: 123456
//adminPwdR: 123456
    //第一种收参方式:数据类型接收参数!!!!!!
    @RequestMapping("/regist")
    @ResponseBody //这个注解就是返回给前端的json数据
    public Map reg(String adminName, String adminPwd, String adminPwdR, String adminTime,
                   String sex, ArrayList<String> hobby, String jiuye, String zhuan){
        System.out.println("adminName = " + adminName);
        System.out.println("adminPwd = " + adminPwd);
        System.out.println("adminPwdR = " + adminPwdR);
        System.out.println("adminTime = " + adminTime);
        System.out.println("sex = " + sex);
        System.out.println("hobby = " + hobby);
        System.out.println("jiuye = " + jiuye);
        System.out.println("zhuan = " + zhuan);

        Map codeMap = new HashMap();
        if (!adminPwd.equals(adminPwdR)) {
            codeMap.put("code","4401");
            codeMap.put("msg","你输入的密码和重复密码不一致,注册失败");
            return codeMap;
        }
        if (adminName.length()<=0){
            codeMap.put("code","4402");
            codeMap.put("msg","adminName表单填写完整");
            return codeMap;
        }
        if (adminPwd.length()<=0){
            codeMap.put("code","4402");
            codeMap.put("msg","adminPwd表单填写完整");
            return codeMap;
        }
        if (adminPwdR.length()<=0){
            codeMap.put("code","4402");
            codeMap.put("msg","adminPwdR表单填写完整");
            return codeMap;
        }
        codeMap.put("code",0);
        codeMap.put("msg","注册成功");
        return codeMap;
    }

    //传统版本的不反悔json,跳转使用转发或者重定向
    @RequestMapping("/regForm")
    public String regForm(String adminName,String adminPwd){
        System.out.println("adminName = " + adminName);
        System.out.println("adminPwd = " + adminPwd);
        //注册成功跳转到登录页
        return "loginForm";
    }

    //springMVC第二种收参方式,实体类收参数
    @RequestMapping("/regByBean")
    @ResponseBody
    public Map regByBean(AdminInfo adminInfo){
        System.out.println("adminInfo = " + adminInfo);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","注册成功");
        return codeMap;
    }

    //ajax接收数组、集合
    @RequestMapping("/ajax03")
    @ResponseBody
    public Map ajax03(@RequestParam("ids[]") List<Integer> ids){
        //前端 ids[]  后台ids  当前后端参数不一致的时候，就需要注解调整@RequestParam("ids[]")
        for (Integer id : ids) {
            System.out.println("id = " + id);
        }
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data",ids);
        return codeMap;
    }

    //ajax 接收json对象
    @RequestMapping("/ajax04")
    @ResponseBody
    public Map ajax04(@RequestBody AdminInfo adminInfo){  //@RequestBody注解就是指前端json请求
        System.out.println("adminInfo = " + adminInfo);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data",adminInfo);
        return codeMap;
    }

    //ajax05接收前端传来的多个对象
    @RequestMapping("ajax05")
    @ResponseBody
    public Map ajax05(@ModelAttribute Lover lover, @ModelAttribute Dog dog){
        System.out.println("lover = " + lover);
        System.out.println("dog = " + dog);
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data1",lover);
        codeMap.put("data2",dog);
        return codeMap;
    }
    //接收前端传来的多个对象  需要根据请求的前端进行绑定
    @InitBinder("lover")
    public void binding01(WebDataBinder webDataBinder){//webDataBinder网络数据绑定
        webDataBinder.setFieldDefaultPrefix("lover.");
    }
    @InitBinder("dog")
    public void binding02(WebDataBinder webDataBinder){//webDataBinder网络数据绑定
        webDataBinder.setFieldDefaultPrefix("dog.");
    }


    //ajax06   json收取多个对象
    @RequestMapping("/ajax06")//GetMapping和RequestBody同时使用等着被开除，不可能同时使用，拿不到参数的
    @ResponseBody
    public Map ajax06(@RequestBody List<Lover> loverList){//RequestBody他是方法体中拿取的数据的，所以不能用Get清求!!!
        for (Lover lover : loverList){
            System.out.println("lover = " + lover);
        }
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data",loverList);
        return codeMap;
    }

    @RequestMapping("ajax07")
    @ResponseBody
    public Map ajax07(@RequestBody Map map){
        System.out.println("map的 = " + map.get("adminName"));
        Map codeMap = new HashMap();
        codeMap.put("code",0);
        codeMap.put("msg","请求访问成功");
        codeMap.put("data",map);
        return codeMap;
    }


    @RequestMapping("ajax08")
    @ResponseBody
    public Map ajax08(Lover lover ,@RequestParam(value = "limit" ,required = false,defaultValue = "6")Integer pageSize,Integer page){
        System.out.println("lover = " + lover);
        System.out.println("page = " + page);
        System.out.println("pageSize = " + pageSize);
        return null;
    }
}
