package ir.pegahtech.saas.client.NegarKhane.models.imageses;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Date;

import ir.pegahtech.saas.client.shared.models.*;
import ir.pegahtech.saas.client.NegarKhane.models.mobileusers.*;
import ir.pegahtech.saas.client.NegarKhane.models.imagelikes.*;
import ir.pegahtech.saas.client.NegarKhane.models.imageses.*;


import ir.pegahtech.saas.client.shared.enums.*;


public class ImagesListResponse extends BaseModel {







	@SerializedName("totalCount")
	private Integer totalCount;

	@SerializedName("data")
	private List<ImagesEntity> data;


	
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		notifyChange("TotalCount", totalCount);
	}
	public List<ImagesEntity> getData() {
		return data;
	}
	public void setData(List<ImagesEntity> data) {
		this.data = data;
		notifyChange("Data", data);
	}

}
