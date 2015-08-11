package com.sharifcup.negarkhaneh;

import ir.pegahtech.saas.client.NegarKhane.models.imagelikes.ImageLikeEntity;
import ir.pegahtech.saas.client.NegarKhane.models.imageses.ImagesEntity;
import ir.pegahtech.saas.client.NegarKhane.services.ImageLikesService;
import ir.pegahtech.saas.client.NegarKhane.services.ImagesesService;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.models.InsertUpdateResponse;

import java.io.Serializable;

import android.content.Context;

import com.sharifcup.negarkhaneh.UserInfo.UserCallback;

public class Image implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1895589265782793706L;
	private ImagesEntity imageEntity;
    private boolean hasLiked = false;
	
    public void setImageEntity(ImagesEntity entity){
    	this.imageEntity = entity;
    }
    
    public String getImageTitle() {
        return imageEntity.getTitle();
    }

    public String getImageAddress() {
        return imageEntity.getBackground();
    }

	public String getImageThumbnail() {
		return imageEntity.getThumbnail();
	}
	
	public void Like(Context context){
		if(!this.hasLiked){
			this.hasLiked = true;
			UserInfo.getInstance().getUserId(context, new UserCallback() {
				
				@Override
				public void done(String userid) {
					ImageLikeEntity entity = new ImageLikeEntity();
					entity.setImage(imageEntity.getGuid());
					entity.setUserId(userid);
					new ImageLikesService().create(entity, new ServiceCallback<InsertUpdateResponse>() {
						
						@Override
						public void success(InsertUpdateResponse result) {
						}
						
						@Override
						public void fail(int resultCode) {
							
						}
					});
					imageEntity.setLikeCount(imageEntity.getLikeCount() + 1);
					new ImagesesService().update(imageEntity, new ServiceCallback<InsertUpdateResponse>() {
						
						@Override
						public void success(InsertUpdateResponse result) {
							
						}
						
						@Override
						public void fail(int resultCode) {
						}
					});
				}
			});
		}
	}

	public boolean hasLiked() {
		return hasLiked;
	}

	public void setHasLiked(boolean hasLiked) {
		this.hasLiked = hasLiked;
	}


}
