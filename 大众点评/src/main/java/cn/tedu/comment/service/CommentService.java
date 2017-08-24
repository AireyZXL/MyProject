/**
 * 
 */
package cn.tedu.comment.service;

import java.util.List;

import cn.tedu.comment.pojo.VComment;

/**
 * @author lyh
 * @Date   2017年7月15日	
 */
public interface CommentService {

	/**查询所有评论信息
	 * @return 评论集合
	 */
	public abstract List<VComment> findAllComments();

	/**
	 * @param commentId	评论id
	 * @return	评论
	 * 根据评论id查询评论
	 */
	public abstract VComment findCommentById(String commentId);

	/**
	 * @param commentIds	商户id数组
	 */
	public abstract void deleteCommentsByCommentId(String[] commentIds);

}
