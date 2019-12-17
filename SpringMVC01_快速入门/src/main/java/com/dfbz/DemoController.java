package com.dfbz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/17 17:58
 */
@Controller
public class DemoController{

    @RequestMapping
    public ModelAndView sayHi(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        System.out.println("来啦，老弟！");

        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "你好呀！");
        mav.setViewName("index.jsp");

        return mav;
    }
}
