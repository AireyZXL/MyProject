/**
 * 
 */
package cn.tedu.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tedu.comment.pojo.VComment;
import cn.tedu.comment.service.CommentService;

/**
 * @author lyh
 * @Date   2017年7月15日	
 * 评论管理
 */
@Controller
@RequestMapping("/backend/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	@RequestMapping("/list")
	public String findAllComments(Model model){
		List<VComment> cList=commentService.findAllComments();
		model.addAttribute("cList", cList);
		
		return "/backend/comment/CommentList";
	}
	@RequestMapping("/toview")
	public String viewComment(String commentId,Model model){
		VComment comment=commentService.findCommentById(commentId);
		model.addAttribute("comment", comment);
		return "/backend/comment/CommentView";
	}
	@RequestMapping("/delete")
	public String deleteComment(@RequestParam("commentId")String[] commentIds){
		commentService.deleteCommentsByCommentId(commentIds);
		return "redirect:/backend/comment/list";
	}
}
