package com.yujuncheng.clothing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.domain.Customer;
import com.yujuncheng.clothing.service.ClothesMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ClothesMainController {

    @Autowired
    private ClothesMainService clothesMainService;

    @RequestMapping("showClothes")
    public String showClothes(Model model){
        List<Clothes> list = clothesMainService.selectClothes();
        List<Clothes> shoe = clothesMainService.selectShoes();
        List<Clothes> underWear = clothesMainService.selectUnderWear();
        model.addAttribute("list",list);
        model.addAttribute("shoes",shoe);
        model.addAttribute("underWear",underWear);

        return "nozari/index";
    }

    @RequestMapping("sortClothes")
    public String sortClothes(@RequestParam(defaultValue = "1",value="page") Integer page,Model model){
        PageHelper.startPage(page, 8);
        List<Clothes> clothes = clothesMainService.selectClothes();
        PageInfo pageInfo = new PageInfo(clothes);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("clothes",clothes);
        return "nozari/gridproducts";
    }
    @RequestMapping("sortClothes1")
    public String sortClothes1(@RequestParam(defaultValue = "1",value="page") Integer page,Model model){
        PageHelper.startPage(page, 3);
        List<Clothes> clothes1 = clothesMainService.selectClothes();
        PageInfo pageInfo = new PageInfo(clothes1);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("clothes1",clothes1);
        return "nozari/listproducts";
    }

    @RequestMapping("sortShoe")
    public String sortShoe(@RequestParam(defaultValue = "1",value="page") Integer page,Model model){
        PageHelper.startPage(page, 8);
        List<Clothes> shoe = clothesMainService.selectShoes();
        PageInfo pageInfo = new PageInfo(shoe);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("shoe",shoe);
        return "nozari/gridShoe";
    }

    @RequestMapping("sortShoe1")
    public String sortShoe1(@RequestParam(defaultValue = "1",value="page") Integer page,Model model){
        PageHelper.startPage(page, 3);
        List<Clothes> shoe1 = clothesMainService.selectShoes();
        PageInfo pageInfo = new PageInfo(shoe1);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("shoe1",shoe1);
        return "nozari/listShoes";
    }

    @RequestMapping("sortUnderWear")
    public String sortUnderWear(@RequestParam(defaultValue = "1",value="page") Integer page,Model model){
        PageHelper.startPage(page, 8);
        List<Clothes> underWear = clothesMainService.selectUnderWear();
        PageInfo pageInfo = new PageInfo(underWear);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("underWear",underWear);
        return "nozari/gridUnderWear";
    }

    @RequestMapping("sortUnderWear1")
    public String sortUnderWear1(@RequestParam(defaultValue = "1",value="page") Integer page,Model model){
        PageHelper.startPage(page, 3);
        List<Clothes> underWear1 = clothesMainService.selectUnderWear();
        PageInfo pageInfo = new PageInfo(underWear1);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("underWear1",underWear1);
        return "nozari/listUnderWear";
    }

    @RequestMapping("addToCart")
    @ResponseBody
    public String addToCart(@RequestParam("id") Integer id, HttpSession session){
        Customer ctr = (Customer) session.getAttribute("ctr");
        if(ctr == null){
            return "请您先登录";
        }else {
            System.out.println(ctr.getId());
            Clothes cloth = clothesMainService.selectClotheById(id);
            cloth.setCId(ctr.getId());
            cloth.setQuantity(1);
            clothesMainService.addShopping(cloth);
            return "添加成功";
        }
    }

    @RequestMapping("detailClothes")
    public String detailClothes(@RequestParam("id") int id,Model model){
        System.out.println(id);
        Clothes cloth = clothesMainService.selectClotheById(id);
        System.out.println(cloth);
        model.addAttribute("clot",cloth);
        return "nozari/productdetails-fullwidth";
    }

    @RequestMapping("sortByName")
    public String sortByName(@RequestParam(defaultValue = "1",value="page") Integer page,Model model, String cName){
        PageHelper.startPage(page, 4);
        List<Clothes> clothes = clothesMainService.selectByName(cName);
        PageInfo pageInfo = new PageInfo(clothes);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("sortByName",clothes);
        return "nozari/selectClothes";
    }


}
