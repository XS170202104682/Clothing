package com.yujuncheng.clothing.controller;

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
        model.addAttribute("list",list);
        model.addAttribute("shoes",shoe);

        return "nozari/index";
    }

    @RequestMapping("sortClothes")
    public String sortClothes(Model model){
        List<Clothes> clothes = clothesMainService.selectClothes();
        model.addAttribute("clothes",clothes);
        return "nozari/gridproducts";
    }
    @RequestMapping("sortClothes1")
    public String sortClothes1(Model model){
        List<Clothes> clothes1 = clothesMainService.selectClothes();
        model.addAttribute("clothes1",clothes1);
        return "nozari/listproducts";
    }

    @RequestMapping("sortShoe")
    public String sortShoe(Model model){
        List<Clothes> shoe = clothesMainService.selectShoes();
        model.addAttribute("shoe",shoe);
        return "nozari/gridShoe";
    }

    @RequestMapping("sortShoe1")
    public String sortShoe1(Model model){
        List<Clothes> shoe1 = clothesMainService.selectShoes();
        model.addAttribute("shoe1",shoe1);
        return "nozari/listShoes";
    }

    @RequestMapping("sortUnderWear")
    public String sortUnderWear(Model model){
        List<Clothes> underWear = clothesMainService.selectUnderWear();
        model.addAttribute("underWear",underWear);
        return "nozari/gridUnderWear";
    }

    @RequestMapping("sortUnderWear1")
    public String sortUnderWear1(Model model){
        List<Clothes> underWear1 = clothesMainService.selectUnderWear();
        model.addAttribute("underWear1",underWear1);
        return "nozari/listUnderWear";
    }

    @RequestMapping("addToCart")
    @ResponseBody
    public String addToCart(@RequestParam("id") Integer id, HttpSession session){
        Customer ctr = (Customer) session.getAttribute("ctr");
        System.out.println(ctr.getId());
        Clothes cloth = clothesMainService.selectClotheById(id);
        cloth.setCId(ctr.getId());
        clothesMainService.addShopping(cloth);
        return "添加成功";
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
    public String sortByName(Model model, String cName){
        List<Clothes> clothes = clothesMainService.selectByName(cName);
        model.addAttribute("sortByName",clothes);
        return "nozari/selectClothes";
    }


}
