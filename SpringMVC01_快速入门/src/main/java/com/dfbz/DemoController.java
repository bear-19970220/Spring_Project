package com.dfbz;

import com.dfbz.domain.User;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/17 17:58
 */
@Controller
@RequestMapping("/demo")
public class DemoController {


    @RequestMapping("/sayHi.smvc")
    public ModelAndView sayHi() {
        System.out.println("来啦，老弟！");
        ModelAndView mav = new ModelAndView("forward:/index.jsp");
        mav.addObject("message", "Hi~");
        return mav;
    }


    @RequestMapping("/ctrl01.smvc")
    public String ctrl01_string() {
        System.out.println("进来了");
        return "index.jsp";
    }


    @RequestMapping("/ctrl_void.smvc")
    public void ctrl_void(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().append("你好呀！");
    }


    @RequestMapping("/ctrl_forward.smvc")
    public ModelAndView ctrl_forward() {
//    public String ctrl_forward(Model model) {
        ModelAndView mav = new ModelAndView("redirect:/index.jsp");
        mav.addObject("message", "你好骚啊");
        return mav;
//        model.addAttribute("message", "你好啊");
//        return "forward:/index.jsp";
    }

    /**
     * 重定向
     *
     * @param session
     * @return
     */
    @RequestMapping("/ctrl_redirect.smvc")
    public String ctrl_redirect(HttpSession session) {
        session.setAttribute("message", "你好呀！");
        return "redirect:/index.jsp";
    }


    /**
     * 注解 @RequestMapping 属性测试
     *
     * @return
     */
    @RequestMapping(value = "/ctrl_rm.smvc", params = {"!a", "!b"})
    public String ctrl_rm() {
        System.out.println("哈哈哈");
        return null;
    }



    @RequestMapping("/bang01.smvc")
    public void bang01(Integer username){
        System.out.println(username);
    }


    @RequestMapping("/bang02")
    public void bang02(User user) {
        System.out.println(user);
    }

    @RequestMapping("/bang03")
    public void bang03(int[] id){
        System.out.println(Arrays.toString(id));
    }


    public void bang04(){
        
    }





























































}
