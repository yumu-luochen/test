/**
 * 
 */
package com.rechen.hotelsys.utils;

import java.util.Collection;

import com.rechen.hotelsys.domain.ValueObject;

/**
 * @author Re.chen
 *
 */
public class Page extends ValueObject{
	
	private Integer pageNo;//当前页号
	private Integer pageSize;//每页记录条数
	private Boolean nextPage;//是否有下一页
	private Boolean prePage;//是否有上一页
	private Long totalRecNum;//总共有多少条记录(页面相关联的查询,总共有多少条记录)
	private Integer totalPageNum;//总共有多少页
	private Collection pageContent;//该页的数据(记录明细)
	private Integer startIndex;//记录开始的位置
	private Integer endIndex;//记录结束的位置
	
	public Page(){
		this.pageNo=1;
		this.pageSize=6;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalRecNum() {
		return totalRecNum;
	}

	public void setTotalRecNum(Long totalRecNum) {
		this.totalRecNum = totalRecNum;
	}

	public Collection getPageContent() {
		return pageContent;
	}

	public void setPageContent(Collection pageContent) {
			this.pageContent = pageContent;
	}

	public void setNextPage(Boolean nextPage) {
		this.nextPage = nextPage;
	}

	public void setPrePage(Boolean prePage) {
		this.prePage = prePage;
	}

	public void setTotalPageNum(Integer totalPageNum) {
		this.totalPageNum = totalPageNum;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	//--------------------
	public Boolean getNextPage() {
		return pageNo<getTotalPageNum()?true:false;
	}

	public Boolean getPrePage() {
		return pageNo>1?true:false;
	}

	public Integer getTotalPageNum() {
		return totalRecNum%pageSize>0?(int)(totalRecNum/pageSize+1):(int)(totalRecNum/pageSize);
	}

	public Integer getStartIndex() {
		return pageSize*(pageNo-1);
	}

	public Integer getEndIndex() {
		return (pageSize*pageNo>this.totalRecNum)?(int)(this.totalRecNum.longValue()):(pageSize*pageNo);
	}

	
}
