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
public class HandleAPIKeysSoap implements Serializable {

	public static HandleAPIKeysSoap toSoapModel(HandleAPIKeys model) {
		HandleAPIKeysSoap soapModel = new HandleAPIKeysSoap();

		soapModel.setHandleAPIKeyId(model.getHandleAPIKeyId());
		soapModel.setHandleName(model.getHandleName());
		soapModel.setPageKey(model.getPageKey());
		soapModel.setApiKey(model.getApiKey());
		soapModel.setInstagramWidgetFlag(model.isInstagramWidgetFlag());

		return soapModel;
	}

	public static HandleAPIKeysSoap[] toSoapModels(HandleAPIKeys[] models) {
		HandleAPIKeysSoap[] soapModels = new HandleAPIKeysSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HandleAPIKeysSoap[][] toSoapModels(HandleAPIKeys[][] models) {
		HandleAPIKeysSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HandleAPIKeysSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HandleAPIKeysSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HandleAPIKeysSoap[] toSoapModels(List<HandleAPIKeys> models) {
		List<HandleAPIKeysSoap> soapModels = new ArrayList<HandleAPIKeysSoap>(
			models.size());

		for (HandleAPIKeys model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HandleAPIKeysSoap[soapModels.size()]);
	}

	public HandleAPIKeysSoap() {
	}

	public long getPrimaryKey() {
		return _handleAPIKeyId;
	}

	public void setPrimaryKey(long pk) {
		setHandleAPIKeyId(pk);
	}

	public long getHandleAPIKeyId() {
		return _handleAPIKeyId;
	}

	public void setHandleAPIKeyId(long handleAPIKeyId) {
		_handleAPIKeyId = handleAPIKeyId;
	}

	public String getHandleName() {
		return _handleName;
	}

	public void setHandleName(String handleName) {
		_handleName = handleName;
	}

	public String getPageKey() {
		return _pageKey;
	}

	public void setPageKey(String pageKey) {
		_pageKey = pageKey;
	}

	public String getApiKey() {
		return _apiKey;
	}

	public void setApiKey(String apiKey) {
		_apiKey = apiKey;
	}

	public boolean getInstagramWidgetFlag() {
		return _instagramWidgetFlag;
	}

	public boolean isInstagramWidgetFlag() {
		return _instagramWidgetFlag;
	}

	public void setInstagramWidgetFlag(boolean instagramWidgetFlag) {
		_instagramWidgetFlag = instagramWidgetFlag;
	}

	private long _handleAPIKeyId;
	private String _handleName;
	private String _pageKey;
	private String _apiKey;
	private boolean _instagramWidgetFlag;

}