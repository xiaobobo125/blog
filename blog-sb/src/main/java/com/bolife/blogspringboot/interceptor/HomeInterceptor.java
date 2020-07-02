package com.bolife.blogspringboot.interceptor;

import com.bolife.blogspringboot.entity.Article;
import com.bolife.blogspringboot.entity.Category;
import com.bolife.blogspringboot.entity.Menu;
import com.bolife.blogspringboot.entity.Options;
import com.bolife.blogspringboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/2 13:45
 * @Description:
 */
@Component
public class HomeInterceptor implements HandlerInterceptor {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private OptionService optionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<Menu> allMenu = menuService.getAllMenu();
        request.setAttribute("menuList",allMenu);

        List<Category> allCategory = categoryService.getAllCategory();
        request.setAttribute("allCategoryList",allCategory);
        Integer countArticle = articleService.getCountArticle();
        Integer countComment = commentService.getCountComment();
        Integer countCategory = categoryService.getCountCategory();
        Integer countTag = tagService.getCountTag();
        Integer countLink = linkService.getCountLink();
        Integer viewCount = articleService.getViewCount();
        List<Integer> siteBasicInfo = new ArrayList<>();
        siteBasicInfo.add(countArticle);
        siteBasicInfo.add(countComment);
        siteBasicInfo.add(countCategory);
        siteBasicInfo.add(countTag);
        siteBasicInfo.add(countLink);
        siteBasicInfo.add(viewCount);
        request.setAttribute("siteBasicStatistics",siteBasicInfo);
        Article articleLastUpdate = articleService.getArticleLastUpdate();
        request.setAttribute("lastUpdateArticle",articleLastUpdate);

        Options options = optionService.getOptions();
        request.setAttribute("options",options);

        return true;
    }
}

