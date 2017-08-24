/**
 * 
 */
package cn.tedu.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.comment.mapper.CommentMapper;
import cn.tedu.comment.pojo.VComment;

/**
 * @author lyh
 * @Date   2017年7月15日	
 */
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper commentMapper;
	@Override
	public List<VComment> findAllComments() {
		
		return commentMapper.findAllComments();
	}
	
	@Override
	public VComment findCommentById(String commentId) {
		
		return commentMapper.findCommentById(commentId);
	}

	
	@Override
	public void deleteCommentsByCommentId(String[] commentIds) {
		commentMapper.deleteCommentsByCommentId(commentIds);
	}

}
