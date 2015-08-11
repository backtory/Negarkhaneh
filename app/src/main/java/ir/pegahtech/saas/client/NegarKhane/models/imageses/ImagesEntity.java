package ir.pegahtech.saas.client.NegarKhane.models.imageses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import ir.pegahtech.saas.client.shared.models.*;
import ir.pegahtech.saas.client.NegarKhane.models.mobileusers.*;
import ir.pegahtech.saas.client.NegarKhane.models.imagelikes.*;
import ir.pegahtech.saas.client.NegarKhane.models.imageses.*;


import ir.pegahtech.saas.client.shared.enums.*;


public class ImagesEntity extends BaseModel implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 8244947865994659289L;
	public static final String COLUMN_Guid = "Guid";
	public static final String COLUMN_CreationDate = "CreationDate";
	public static final String COLUMN_IsDeleted = "IsDeleted";
	public static final String COLUMN_LastModifiedDate = "LastModifiedDate";
	public static final String COLUMN_Owner_ID = "Owner_ID";
	public static final String COLUMN_Background = "Background";
	public static final String COLUMN_LikeCount = "LikeCount";
	public static final String COLUMN_Thumbnail = "Thumbnail";
	public static final String COLUMN_Title = "Title";


	public static final String INCLUDE_Likes = "Likes";


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

	@SerializedName("Background")
	private String Background;

	@SerializedName("LikeCount")
	private Integer LikeCount;

	@SerializedName("Thumbnail")
	private String Thumbnail;

	@SerializedName("Title")
	private String Title;

	@SerializedName("Likes")
	private List<ImageLikeEntity> Likes;


	
	
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
	public String getBackground() {
		return Background;
	}
	public void setBackground(String Background) {
		this.Background = Background;
		notifyChange("Background", Background);
	}
	public Integer getLikeCount() {
		return LikeCount;
	}
	public void setLikeCount(Integer LikeCount) {
		this.LikeCount = LikeCount;
		notifyChange("LikeCount", LikeCount);
	}
	public String getThumbnail() {
		return Thumbnail;
	}
	public void setThumbnail(String Thumbnail) {
		this.Thumbnail = Thumbnail;
		notifyChange("Thumbnail", Thumbnail);
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String Title) {
		this.Title = Title;
		notifyChange("Title", Title);
	}
	public List<ImageLikeEntity> getLikes() {
		return Likes;
	}
	public void setLikes(List<ImageLikeEntity> Likes) {
		this.Likes = Likes;
		notifyChange("Likes", Likes);
	}

}
