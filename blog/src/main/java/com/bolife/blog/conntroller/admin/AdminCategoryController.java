package com.bolife.blog.conntroller.admin;

import com.bolife.blog.entity.Category;
import com.bolife.blog.service.ArticleService;
import com.bolife.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.RegEx;
import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 12:36
 * @Description:
 */
@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {
    @Autowired(required = false)
    private CategoryService categoryService;

    @Autowired(required = false)
    private ArticleService articleService;


    @RequestMapping(value = "")
    public ModelAndView categoryList()  {
        ModelAndView modelandview = new ModelAndView();
        List<Category> categoryList = categoryService.listCategoryWithCount();
        modelandview.addObject("categoryList",categoryList);
        modelandview.addObject("listStatus",1);
        modelandview.setViewName("Admin/Category/index");
        return modelandview;
    }

    @RequestMapping(value = "/insertSubmit",method = RequestMethod.POST)
    public String insertCategory(Category category){
        categoryService.insert(category);
        return "redirect:/admin/category";
    }

    @RequestMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Integer id,Model model){
        Category categoryById = categoryService.getCategoryById(id);
        model.addAttribute("category",categoryById);
        List<Category> categories = categoryService.listCategoryWithCount();
        model.addAttribute("categoryList",categories);
        model.addAttribute("listStatus",1);
        return "Admin/Category/edit";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id){
        int count = articleService.countArticleByCategoryId(id);
        if (count == 0){
            categoryService.deleteCategory(id);
        }
        return "redirect:/admin/category";
    }

    @RequestMapping(value = "/editSubmit",method = RequestMethod.POST)
    public String editCategorySubmit(Category category)  {
        categoryService.updateCategory(category);
        return "redirect:/admin/category";
    }
}
