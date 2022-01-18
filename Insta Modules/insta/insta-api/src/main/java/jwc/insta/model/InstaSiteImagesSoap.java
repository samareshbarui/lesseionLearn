/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package jwc.insta.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class InstaSiteImagesSoap implements Serializable {

	public static InstaSiteImagesSoap toSoapModel(InstaSiteImages model) {
		InstaSiteImagesSoap soapModel = new InstaSiteImagesSoap();

		soapModel.setInstaSiteImageId(model.getInstaSiteImageId());
		soapModel.setPageKey(model.getPageKey());
		soapModel.setMediaUrl(model.getMediaUrl());
		soapModel.setInstaimageUrl(model.getInstaimageUrl());
		soapModel.setTimestamp(model.getTimestamp());
		soapModel.setOtherDetid(model.getOtherDetid());

		return soapModel;
	}

	public static InstaSiteImagesSoap[] toSoapModels(InstaSiteImages[] models) {
		InstaSiteImagesSoap[] soapModels =
			new InstaSiteImagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InstaSiteImagesSoap[][] toSoapModels(
		InstaSiteImages[][] models) {

		InstaSiteImagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new InstaSiteImagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InstaSiteImagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InstaSiteImagesSoap[] toSoapModels(
		List<InstaSiteImages> models) {

		List<InstaSiteImagesSoap> soapModels =
			new ArrayList<InstaSiteImagesSoap>(models.size());

		for (InstaSiteImages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InstaSiteImagesSoap[soapModels.size()]);
	}

	public InstaSiteImagesSoap() {
	}

	public long getPrimaryKey() {
		return _instaSiteImageId;
	}

	public void setPrimaryKey(long pk) {
		setInstaSiteImageId(pk);
	}

	public long getInstaSiteImageId() {
		return _instaSiteImageId;
	}

	public void setInstaSiteImageId(long instaSiteImageId) {
		_instaSiteImageId = instaSiteImageId;
	}

	public String getPageKey() {
		return _pageKey;
	}

	public void setPageKey(String pageKey) {
		_pageKey = pageKey;
	}

	public String getMediaUrl() {
		return _mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		_mediaUrl = mediaUrl;
	}

	public String getInstaimageUrl() {
		return _instaimageUrl;
	}

	public void setInstaimageUrl(String instaimageUrl) {
		_instaimageUrl = instaimageUrl;
	}

	public String getTimestamp() {
		return _timestamp;
	}

	public void setTimestamp(String timestamp) {
		_timestamp = timestamp;
	}

	public long getOtherDetid() {
		return _otherDetid;
	}

	public void setOtherDetid(long otherDetid) {
		_otherDetid = otherDetid;
	}

	private long _instaSiteImageId;
	private String _pageKey;
	private String _mediaUrl;
	private String _instaimageUrl;
	private String _timestamp;
	private long _otherDetid;

}