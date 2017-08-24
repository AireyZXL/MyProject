/**
 * 
 */
package cn.tedu.comment.pojo;

import java.util.Date;

/**
 * @author wzw
 * @Date   2017年7月14日
 */
public class Comment{
	// 环境分
	private Integer enviromentScore;
	// 口味分
	private Integer tasteScore;
	// 服务分
	private Integer serviceScore;
	// 评价信息
	private String commentMessage;
	// 评价时间
	private Date commentTime;
	//顾客姓名
	private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getEnviromentScore() {
		return enviromentScore;
	}
	public void setEnviromentScore(Integer enviromentScore) {
		this.enviromentScore = enviromentScore;
	}
	public Integer getTasteScore() {
		return tasteScore;
	}
	public void setTasteScore(Integer tasteScore) {
		this.tasteScore = tasteScore;
	}
	public Integer getServiceScore() {
		return serviceScore;
	}
	public void setServiceScore(Integer serviceScore) {
		this.serviceScore = serviceScore;
	}
	public String getCommentMessage() {
		return commentMessage;
	}
	public void setCommentMessage(String commentMessage) {
		this.commentMessage = commentMessage;
	}
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	@Override
	public String toString() {
		return "Comment [enviromentScore=" + enviromentScore + ", tasteScore=" + tasteScore + ", serviceScore="
				+ serviceScore + ", commentMessage=" + commentMessage + ", commentTime=" + commentTime + ", username="
				+ username + "]";
	}

	
}
