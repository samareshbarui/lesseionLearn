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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link HandleAPIKeys}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HandleAPIKeys
 * @generated
 */
public class HandleAPIKeysWrapper
	extends BaseModelWrapper<HandleAPIKeys>
	implements HandleAPIKeys, ModelWrapper<HandleAPIKeys> {

	public HandleAPIKeysWrapper(HandleAPIKeys handleAPIKeys) {
		super(handleAPIKeys);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("handleAPIKeyId", getHandleAPIKeyId());
		attributes.put("handleName", getHandleName());
		attributes.put("pageKey", getPageKey());
		attributes.put("apiKey", getApiKey());
		attributes.put("instagramWidgetFlag", isInstagramWidgetFlag());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long handleAPIKeyId = (Long)attributes.get("handleAPIKeyId");

		if (handleAPIKeyId != null) {
			setHandleAPIKeyId(handleAPIKeyId);
		}

		String handleName = (String)attributes.get("handleName");

		if (handleName != null) {
			setHandleName(handleName);
		}

		String pageKey = (String)attributes.get("pageKey");

		if (pageKey != null) {
			setPageKey(pageKey);
		}

		String apiKey = (String)attributes.get("apiKey");

		if (apiKey != null) {
			setApiKey(apiKey);
		}

		Boolean instagramWidgetFlag = (Boolean)attributes.get(
			"instagramWidgetFlag");

		if (instagramWidgetFlag != null) {
			setInstagramWidgetFlag(instagramWidgetFlag);
		}
	}

	/**
	 * Returns the api key of this handle api keys.
	 *
	 * @return the api key of this handle api keys
	 */
	@Override
	public String getApiKey() {
		return model.getApiKey();
	}

	/**
	 * Returns the handle api key ID of this handle api keys.
	 *
	 * @return the handle api key ID of this handle api keys
	 */
	@Override
	public long getHandleAPIKeyId() {
		return model.getHandleAPIKeyId();
	}

	/**
	 * Returns the handle name of this handle api keys.
	 *
	 * @return the handle name of this handle api keys
	 */
	@Override
	public String getHandleName() {
		return model.getHandleName();
	}

	/**
	 * Returns the instagram widget flag of this handle api keys.
	 *
	 * @return the instagram widget flag of this handle api keys
	 */
	@Override
	public boolean getInstagramWidgetFlag() {
		return model.getInstagramWidgetFlag();
	}

	/**
	 * Returns the page key of this handle api keys.
	 *
	 * @return the page key of this handle api keys
	 */
	@Override
	public String getPageKey() {
		return model.getPageKey();
	}

	/**
	 * Returns the primary key of this handle api keys.
	 *
	 * @return the primary key of this handle api keys
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this handle api keys is instagram widget flag.
	 *
	 * @return <code>true</code> if this handle api keys is instagram widget flag; <code>false</code> otherwise
	 */
	@Override
	public boolean isInstagramWidgetFlag() {
		return model.isInstagramWidgetFlag();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the api key of this handle api keys.
	 *
	 * @param apiKey the api key of this handle api keys
	 */
	@Override
	public void setApiKey(String apiKey) {
		model.setApiKey(apiKey);
	}

	/**
	 * Sets the handle api key ID of this handle api keys.
	 *
	 * @param handleAPIKeyId the handle api key ID of this handle api keys
	 */
	@Override
	public void setHandleAPIKeyId(long handleAPIKeyId) {
		model.setHandleAPIKeyId(handleAPIKeyId);
	}

	/**
	 * Sets the handle name of this handle api keys.
	 *
	 * @param handleName the handle name of this handle api keys
	 */
	@Override
	public void setHandleName(String handleName) {
		model.setHandleName(handleName);
	}

	/**
	 * Sets whether this handle api keys is instagram widget flag.
	 *
	 * @param instagramWidgetFlag the instagram widget flag of this handle api keys
	 */
	@Override
	public void setInstagramWidgetFlag(boolean instagramWidgetFlag) {
		model.setInstagramWidgetFlag(instagramWidgetFlag);
	}

	/**
	 * Sets the page key of this handle api keys.
	 *
	 * @param pageKey the page key of this handle api keys
	 */
	@Override
	public void setPageKey(String pageKey) {
		model.setPageKey(pageKey);
	}

	/**
	 * Sets the primary key of this handle api keys.
	 *
	 * @param primaryKey the primary key of this handle api keys
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected HandleAPIKeysWrapper wrap(HandleAPIKeys handleAPIKeys) {
		return new HandleAPIKeysWrapper(handleAPIKeys);
	}

}