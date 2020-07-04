package com.bolife.blogspringboot.controller.admin;

import com.bolife.blog.entity.Article;
import com.bolife.blog.entity.Comment;
import com.bolife.blog.service.ArticleService;
import com.bolife.blog.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/7 11:10
 * @Description:
 */
@Controller
@RequestMapping("/admin/comment")
public class AdminCommentController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("")
    public String commentListView(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                  Model model) {
        PageInfo<Comment> commentPageInfo = commentService.listCommentByPage(pageIndex, pageSize);
        model.addAttribute("pageInfo", commentPageInfo);
        model.addAttribute("pageUrlPrefix","/admin/comment?pageIndex");
        return "Admin/Comment/index";
    }
    @RequestMapping(value = "/delete/{cid}")
    public void deleteComment(@PathVariable("cid") Integer cid){
        Comment comment =  commentService.getCommentById(cid);
        commentService.deleteComment(cid);
        //删除其子评论
        List<Comment> childCommentList = commentService.listChildComment(cid);
        for (int i = 0; i < childCommentList.size(); i++) {
            commentService.deleteComment(childCommentList.get(i).getCommentId());
        }
        //更新文章的评论数
        Article article = articleService.getArticleByStatusAndId(null, comment.getCommentArticleId());
        articleService.updateCommentCount(article.getArticleId());
    }

    /**
     * 编辑评论页面显示
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit/{id}")
    public String editCommentView(@PathVariable("id") Integer id, Model model) {
        Comment comment = commentService.getCommentById(id);
        model.addAttribute("comment", comment);
        return "Admin/Comment/edit";
    }


    /**
     * 编辑评论提交
     *
     * @param comment
     * @return
     */
    @RequestMapping(value = "/editSubmit", method = RequestMethod.POST)
    public String editCommentSubmit(Comment comment) {
        commentService.updateComment(comment);
        return "redirect:/admin/comment";
    }
}
