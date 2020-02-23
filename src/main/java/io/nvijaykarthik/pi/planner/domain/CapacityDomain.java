package io.nvijaykarthik.pi.planner.domain;

public class CapacityDomain {

	Integer itrNo;
	Long itrId;
	Integer capacity;
	Integer load;
	
	public Integer getItrNo() {
		return itrNo;
	}
	public void setItrNo(Integer itrNo) {
		this.itrNo = itrNo;
	}
	public Long getItrId() {
		return itrId;
	}
	public void setItrId(Long itrId) {
		this.itrId = itrId;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getLoad() {
		return load;
	}
	public void setLoad(Integer load) {
		this.load = load;
	}
}
