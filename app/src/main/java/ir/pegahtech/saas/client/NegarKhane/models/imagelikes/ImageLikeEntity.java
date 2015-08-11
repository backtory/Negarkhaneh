package ir.pegahtech.saas.client.NegarKhane.models.imagelikes;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Date;

import ir.pegahtech.saas.client.shared.models.*;
import ir.pegahtech.saas.client.NegarKhane.models.mobileusers.*;
import ir.pegahtech.saas.client.NegarKhane.models.imagelikes.*;
import ir.pegahtech.saas.client.NegarKhane.models.imageses.*;


import ir.pegahtech.saas.client.shared.enums.*;


public class ImageLikeEntity extends BaseModel {



	public static final String COLUMN_Guid = "Guid";
	public static final String COLUMN_CreationDate = "CreationDate";
	public static final String COLUMN_IsDeleted = "IsDeleted";
	public static final String COLUMN_LastModifiedDate = "LastModifiedDate";
	public static final String COLUMN_Owner_ID = "Owner_ID";
	public static final String COLUMN_Image = "Image";
	public static final String COLUMN_UserId = "UserId";


	public static final String INCLUDE_RelatedImage = "RelatedImage";


	@SerializedName("Guid")
	private String Guid;

	@SerializedName("CreationDate")
	private Date CreationDate;

	@SerializedName("IsDeleted")
	private Boolean IsDeleted;

	@SerializedName("LastModifiedDate")
	private Date LastModifiedDate;

	@SerializedName("Owner_ID")
	private String Owner_ID;

	@SerializedName("Image")
	private String Image;

	@SerializedName("UserId")
	private String UserId;

	@SerializedName("RelatedImage")
	private ImagesEntity RelatedImage;


	
	
	public String getGuid() {
		return Guid;
	}
	public void setGuid(String Guid) {
		this.Guid = Guid;
		notifyChange("Guid", Guid);
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date CreationDate) {
		this.CreationDate = CreationDate;
		notifyChange("CreationDate", CreationDate);
	}
	public Boolean getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(Boolean IsDeleted) {
		this.IsDeleted = IsDeleted;
		notifyChange("IsDeleted", IsDeleted);
	}
	public Date getLastModifiedDate() {
		return LastModifiedDate;
	}
	public void setLastModifiedDate(Date LastModifiedDate) {
		this.LastModifiedDate = LastModifiedDate;
		notifyChange("LastModifiedDate", LastModifiedDate);
	}
	public String getOwner_ID() {
		return Owner_ID;
	}
	public void setOwner_ID(String Owner_ID) {
		this.Owner_ID = Owner_ID;
		notifyChange("Owner_ID", Owner_ID);
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String Image) {
		this.Image = Image;
		notifyChange("Image", Image);
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String UserId) {
		this.UserId = UserId;
		notifyChange("UserId", UserId);
	}
	public ImagesEntity getRelatedImage() {
		return RelatedImage;
	}
	public void setRelatedImage(ImagesEntity RelatedImage) {
		this.RelatedImage = RelatedImage;
		notifyChange("RelatedImage", RelatedImage);
	}

}
