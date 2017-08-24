/**
 * 
 */
package cn.tedu.comment.pojo;

import java.util.List;

/**
 * @author wzw
 * @Date   2017年7月14日
 */
public class VendorInfo {
	private Vendor vendor;
	private double avgScore;//平均总分
	private double avgEnviromentScore; //环境平均分
	private double avgTasteScore;//口味平均分
	private double avgServiceScore;//服务平均分
	
	private List<Comment> commentList; //评论list

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public double getAvgEnviromentScore() {
		return avgEnviromentScore;
	}

	public void setAvgEnviromentScore(double avgEnviromentScore) {
		this.avgEnviromentScore = avgEnviromentScore;
	}

	public double getAvgTasteScore() {
		return avgTasteScore;
	}

	public void setAvgTasteScore(double avgTasteScore) {
		this.avgTasteScore = avgTasteScore;
	}

	public double getAvgServiceScore() {
		return avgServiceScore;
	}

	public void setAvgServiceScore(double avgServiceScore) {
		this.avgServiceScore = avgServiceScore;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "VendorInfo [vendor=" + vendor + ", avgScore=" + avgScore + ", avgEnviromentScore=" + avgEnviromentScore
				+ ", avgTasteScore=" + avgTasteScore + ", avgServiceScore=" + avgServiceScore + ", commentList="
				+ commentList + "]";
	}

	
	
}
