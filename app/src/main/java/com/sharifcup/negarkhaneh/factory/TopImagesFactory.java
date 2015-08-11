package com.sharifcup.negarkhaneh.factory;

import ir.pegahtech.saas.client.NegarKhane.models.imageses.ImagesEntity;
import ir.pegahtech.saas.client.NegarKhane.models.imageses.ImagesListResponse;
import ir.pegahtech.saas.client.NegarKhane.services.ImagesesService;
import ir.pegahtech.saas.client.shared.http.ServiceCallback;
import ir.pegahtech.saas.client.shared.models.Exp;
import ir.pegahtech.saas.client.shared.models.ListRequest;
import ir.pegahtech.saas.client.shared.models.QueryObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.sharifcup.list.Factory;
import com.sharifcup.list.GetDataCallback;
import com.sharifcup.negarkhaneh.Image;

public class TopImagesFactory extends Factory<Image> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5537265321675749315L;

	public TopImagesFactory(Object extra) {
		super(extra);
	}

	@Override
	public void getData(final int start, final int count,
			final GetDataCallback<List<Image>> callback, Context context) {
		ListRequest request = new ListRequest(start + 1, count, false, true,
				new QueryObject()).addOrderBy(
				Exp.property(ImagesEntity.COLUMN_LikeCount), true);
		new ImagesesService().list(request,
				new ServiceCallback<ImagesListResponse>() {

					@Override
					public void success(ImagesListResponse result) {
						List<Image> toReturn = new ArrayList<Image>();
						if (result != null && result.getData() != null) {
							for (ImagesEntity image : result.getData()) {
								Image toAdd = new Image();
								toAdd.setImageEntity(image);
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

}
