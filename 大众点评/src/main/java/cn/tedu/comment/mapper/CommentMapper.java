/**
 * 
 */
package cn.tedu.comment.mapper;

import java.util.List;

import cn.tedu.comment.pojo.VComment;

/**
 * @author lyh
 * @Date   2017年7月15日	
 */
public interface CommentMapper {

	/**
	 * @return
	 */
	public abstract List<VComment> findAllComments();

	/**
	 * @param commentId	评论id
	 * @return	评论
	 * 根据评论id查询评论
	 */
	public abstract VComment findCommentById(String commentId);

	/**
	 * @param commentIds
	 */
	public abstract void deleteCommentsByCommentId(String[] commentIds);

	/**
	 * @param vendorIds
	 */
	public abstract void deleteCommentByVendorId(String[] vendorIds);

}
