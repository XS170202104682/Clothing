package com.yujuncheng.clothing.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yujuncheng.clothing.domain.Clothes;
import com.yujuncheng.clothing.domain.ProductVO;
import com.yujuncheng.clothing.service.ClothesService;
import com.yujuncheng.clothing.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    //返还服装数据
    @ResponseBody
    @RequestMapping("clothes")
    public HashMap<String, Object> clothes(
            @RequestParam(defaultValue = "1",required = false) int page,
            @RequestParam(defaultValue = "10",required = false) int limit,
            @RequestParam(value = "name",required = false) String name,
            Clothes clothes
    ) {
        if(name == null){
            PageHelper.startPage(page, limit);
            List<Clothes> list = clothesService.selectClothes();
            PageInfo pageInfo = new PageInfo(list);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("data",pageInfo.getList());
            hashMap.put("code",0);
            hashMap.put("msg","");
            hashMap.put("count",pageInfo.getTotal());
            return hashMap;
        }else {
            PageHelper.startPage(page, limit);
            List<Clothes> list = clothesService.findName(clothes);
            PageInfo pageInfo = new PageInfo(list);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("data",pageInfo.getList());
            hashMap.put("code",0);
            hashMap.put("msg","");
            hashMap.put("count",pageInfo.getTotal());
            return hashMap;
        }

    }

    //跳转到服装页面
    @RequestMapping("toClothes")
    public String toClothes(){
        return "clothes";
    }

    //返还鞋子数据
    @ResponseBody
    @RequestMapping("shoes")
    public HashMap<String, Object> shoe(
            @RequestParam(defaultValue = "1",required = false) int page,
            @RequestParam(defaultValue = "10",required = false) int limit,
            @RequestParam(value = "name",required = false) String name,
            Clothes clothes
    ) {
        if(name == null){
            PageHelper.startPage(page, limit);
            List<Clothes> list = clothesService.selectShoes();
            PageInfo pageInfo = new PageInfo(list);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("data",pageInfo.getList());
            hashMap.put("code",0);
            hashMap.put("msg","");
            hashMap.put("count",pageInfo.getTotal());
            return hashMap;
        }else {
            PageHelper.startPage(page, limit);
            List<Clothes> list = clothesService.findShoe(clothes);
            PageInfo pageInfo = new PageInfo(list);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("data",pageInfo.getList());
            hashMap.put("code",0);
            hashMap.put("msg","");
            hashMap.put("count",pageInfo.getTotal());
            return hashMap;
        }

    }

    //跳转到鞋子页面
    @RequestMapping("toShoes")
    public String toShoe(){
        return "shoe";
    }

    //返还内衣裤数据
    @ResponseBody
    @RequestMapping("underWear")
    public HashMap<String, Object> underWear(
            @RequestParam(defaultValue = "1",required = false) int page,
            @RequestParam(defaultValue = "10",required = false) int limit,
            @RequestParam(value = "name",required = false) String name,
            Clothes clothes
    ) {
        if(name == null){
            PageHelper.startPage(page, limit);
            List<Clothes> list = clothesService.selectUnderWear();
            PageInfo pageInfo = new PageInfo(list);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("data",pageInfo.getList());
            hashMap.put("code",0);
            hashMap.put("msg","");
            hashMap.put("count",pageInfo.getTotal());
            return hashMap;
        }else {
            PageHelper.startPage(page, limit);
            List<Clothes> list = clothesService.findUnderWear(clothes);
            PageInfo pageInfo = new PageInfo(list);
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("data",pageInfo.getList());
            hashMap.put("code",0);
            hashMap.put("msg","");
            hashMap.put("count",pageInfo.getTotal());
            return hashMap;
        }

    }

    //跳转到内衣裤页面
    @RequestMapping("toUnderWear")
    public String toUnderWear(){
        return "underWear";
    }

    //删除服装
    @RequestMapping("deleteClothes")
    @ResponseBody
    public String deleteClothes(@RequestParam("id") int id){
        clothesService.deleteClothes(id);
        return "删除成功";
    }

    //弹出层编辑服装
    @RequestMapping("modifiedClothe")
    public String modifiedClothe(Model model, int id){
        Clothes clothes =clothesService.selectById(id);
        model.addAttribute("clo",clothes);
        return "updateClothes";
    }
    //弹出层编辑鞋袜
    @RequestMapping("modifiedShoe")
    public String modifiedShoe(Model model, int id){
        Clothes clothes =clothesService.selectById(id);
        model.addAttribute("shoe",clothes);
        return "updateShoes";
    }
    //弹出层编辑内衣裤
    @RequestMapping("modifiedUnder")
    public String modifiedUnder(Model model, int id){
        Clothes clothes =clothesService.selectById(id);
        model.addAttribute("under",clothes);
        return "updateUnderWear";
    }

    //修改服装
    @RequestMapping("modifiedClothes")
    public String modifiedClothes(Clothes clothes, HttpSession session, UploadUtil upload) throws IOException {
        clothesService.updateClothes(clothes);
        if (upload != null) {
            String imageName = clothes.getId()+".jpg";
            System.out.println(imageName);
            File file = new File(session.getServletContext().getRealPath("images/"),imageName);
            file.getParentFile().mkdirs();
            upload.getImage().transferTo(file);
            ProductVO vo = new ProductVO();
            vo.setId(clothes.getId());
            vo.setImg_name("images/"+imageName);
            clothesService.setImageUrl(vo);
        }
        return "redirect:/clothes";
    }
    //修改鞋袜
    @RequestMapping("modifiedShoes")
    public String modifiedShoes(Clothes clothes, HttpSession session, UploadUtil upload) throws IOException {
        clothesService.updateClothes(clothes);
        if (upload != null) {
            String imageName = clothes.getId()+".jpg";
            System.out.println(imageName);
            File file = new File(session.getServletContext().getRealPath("images/"),imageName);
            file.getParentFile().mkdirs();
            upload.getImage().transferTo(file);
            ProductVO vo = new ProductVO();
            vo.setId(clothes.getId());
            vo.setImg_name("images/"+imageName);
            clothesService.setImageUrl(vo);
        }
        return "redirect:/shoe";
    }
    //修改内衣裤
    @RequestMapping("modifiedUnderWear")
    public String modifiedUnderWear(Clothes clothes, HttpSession session, UploadUtil upload) throws IOException {
        clothesService.updateClothes(clothes);
        if (upload != null) {
            String imageName = clothes.getId()+".jpg";
            System.out.println(imageName);
            File file = new File(session.getServletContext().getRealPath("images/"),imageName);
            file.getParentFile().mkdirs();
            upload.getImage().transferTo(file);
            ProductVO vo = new ProductVO();
            vo.setId(clothes.getId());
            vo.setImg_name("images/"+imageName);
            clothesService.setImageUrl(vo);
        }
        return "redirect:/underWear";
    }


    //跳转到新增服装页面
    @RequestMapping("toAdd")
    public String toAdd(){
        return "addClothes";
    }

    //新增服装
    @RequestMapping("addClothes")
    public String addClothes(Clothes clothes, HttpSession session, UploadUtil upload) throws IOException {
        clothesService.addClothes(clothes);
        if (upload != null) {
            System.out.println(clothes.getId());
            String imageName = clothes.getId()+".jpg";
            System.out.println(imageName);
            File file = new File(session.getServletContext().getRealPath("images/"),imageName);
            System.out.println(session.getServletContext().getRealPath("images/"));
            file.getParentFile().mkdirs();
            upload.getImage().transferTo(file);
            System.out.println("["+clothes.getId()+","+"images/"+imageName+"]");
            ProductVO vo = new ProductVO();
            vo.setId(clothes.getId());
            vo.setImg_name("images/"+imageName);
            clothesService.setImageUrl(vo);
        }
        return "redirect:/toClothes";
    }

    //跳转到新增鞋袜页面
    @RequestMapping("toAddShoes")
    public String toAddShoe(){
        return "addShoes";
    }

    //新增鞋袜
    @RequestMapping("addShoes")
    public String addShoes(Clothes clothes, HttpSession session, UploadUtil upload) throws IOException {
        clothesService.addShoes(clothes);
        if (upload != null) {
            System.out.println(clothes.getId());
            String imageName = clothes.getId()+".jpg";
            System.out.println(imageName);
            File file = new File(session.getServletContext().getRealPath("images/"),imageName);
            System.out.println(session.getServletContext().getRealPath("images/"));
            file.getParentFile().mkdirs();
            upload.getImage().transferTo(file);
            System.out.println("["+clothes.getId()+","+"images/"+imageName+"]");
            ProductVO vo = new ProductVO();
            vo.setId(clothes.getId());
            vo.setImg_name("images/"+imageName);
            clothesService.setImageUrl(vo);
        }
        return "redirect:/toShoes";
    }

    //跳转到新增内衣裤页面
    @RequestMapping("toAddUnderWear")
    public String toAddUnderWear(){
        return "addUnderWear";
    }

    //新增内衣裤
    @RequestMapping("addUnderWear")
    public String addUnderWear(Clothes clothes, HttpSession session, UploadUtil upload) throws IOException {
        clothesService.addUnderWear(clothes);
        if (upload != null) {
            System.out.println(clothes.getId());
            String imageName = clothes.getId()+".jpg";
            System.out.println(imageName);
            File file = new File(session.getServletContext().getRealPath("images/"),imageName);
            System.out.println(session.getServletContext().getRealPath("images/"));
            file.getParentFile().mkdirs();
            upload.getImage().transferTo(file);
            System.out.println("["+clothes.getId()+","+"images/"+imageName+"]");
            ProductVO vo = new ProductVO();
            vo.setId(clothes.getId());
            vo.setImg_name("images/"+imageName);
            clothesService.setImageUrl(vo);
        }
        return "redirect:/toUnderWear";
    }


    //返还内衣裤数据
    @ResponseBody
    @RequestMapping("find")
    public HashMap<String, Object> find(
            @RequestParam(defaultValue = "1",required = false) int page,
            @RequestParam(defaultValue = "10",required = false) int limit,
            Clothes clothes
    ) {
        PageHelper.startPage(page, limit);
        List<Clothes> list = clothesService.findName(clothes);
//        System.out.println(list);
        PageInfo pageInfo = new PageInfo(list);
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("data",pageInfo.getList());
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("count",pageInfo.getTotal());
        return hashMap;
    }
    


}
