package com.lening.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    /**
     * 跳转查询全部商品页面
     */
    @RequestMapping("/togoodslist")
    public String togoodslist(){
        return "goods_list";
    }
}