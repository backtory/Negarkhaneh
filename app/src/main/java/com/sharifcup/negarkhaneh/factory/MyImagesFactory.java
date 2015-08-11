package com.sharifcup.negarkhaneh.factory;

import ir.pegahtech.saas.client.NegarKhane.models.imagelikes.ImageLikeEntity;
import ir.pegahtech.saas.client.NegarKhane.models.imagelikes.ImageLikeListResponse;
import ir.pegahtech.saas.client.NegarKhane.services.ImageLikesService;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.models.Exp;
import ir.pegahtech.saas.client.shared.models.ListRequest;
import ir.pegahtech.saas.client.shared.models.QueryObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.sharifcup.list.Factory;
import com.sharifcup.list.GetDataCallback;
import com.sharifcup.negarkhaneh.Image;
import com.sharifcup.negarkhaneh.UserInfo;
import com.sharifcup.negarkhaneh.UserInfo.UserCallback;

public class MyImagesFactory extends Factory<Image> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8651835583466719357L;

	public MyImagesFactory(Object extra) {
		super(extra);
	}

	@Override
	public void getData(final int start, final int count,
			final GetDataCallback<List<Image>> callback, Context context) {
		UserInfo.getInstance().getUserId(context, new UserCallback() {

			@Override
			public void done(String userid) {
				Log.d("userId" , "id is " + userid);
				ListRequest request = new ListRequest(start + 1, count, false,
						true, new QueryObject()).addCondition(Exp.equalsTo(ImageLikeEntity.COLUMN_UserId, userid))
						.includeObject(ImageLikeEntity.INCLUDE_RelatedImage);
				new ImageLikesService().list(request,
						new ServiceCallback<ImageLikeListResponse>() {
							@Override
							public void success(ImageLikeListResponse result) {
								List<Image> toReturn = new ArrayList<Image>();
								if (result != null && result.getData() != null) {
									for (ImageLikeEntity image : result
											.getData()) {
										Image toAdd = new Image();
										toAdd.setImageEntity(image
												.getRelatedImage());
										toAdd.setHasLiked(true);
										toReturn.add(toAdd);
									}
								}
								callback.success(toReturn);
							}

							@Override
							public void fail(int resultCode) {
								callback.failed(resultCode, "");
							}
						});
			}
		});
	}

}
