package com.yujuncheng.clothing.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.service.ClothesService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private ClothesService clothesService;

    @RequestMapping({"/"})
    public String index2(){
        return "index";
    }

    @RequestMapping("aaa")
    public String index(){
        return "nozari/index";
    }

    @RequestMapping("bbb")
    public String toList(){
        return "list";
    }

    @RequestMapping("ccc")
    public String toRegist(){
        return "nozari/login";
    }

    @RequestMapping("ddd")
    public String toLogin(){
        return "nozari/login";
    }

    @RequestMapping("clothes")
    @ResponseBody
    public HashMap<String, Object> clothes(
//            @RequestParam(defaultValue = "1",required = false) int page,
//            @RequestParam(defaultValue = "10",required = false) int limit
    ) {
        List<Clothes> list = clothesService.selectAll();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("data",list);
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("count",list.size());
//        System.out.println(page);
//        System.out.println(limit);
        return hashMap;
    }
    @RequestMapping("toClothes")
    public String toClothes(){

        return "clothes";
    }
}
