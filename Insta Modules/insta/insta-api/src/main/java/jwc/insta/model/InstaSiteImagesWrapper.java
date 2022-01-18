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
 * This class is a wrapper for {@link InstaSiteImages}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InstaSiteImages
 * @generated
 */
public class InstaSiteImagesWrapper
	extends BaseModelWrapper<InstaSiteImages>
	implements InstaSiteImages, ModelWrapper<InstaSiteImages> {

	public InstaSiteImagesWrapper(InstaSiteImages instaSiteImages) {
		super(instaSiteImages);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("instaSiteImageId", getInstaSiteImageId());
		attributes.put("pageKey", getPageKey());
		attributes.put("mediaUrl", getMediaUrl());
		attributes.put("instaimageUrl", getInstaimageUrl());
		attributes.put("timestamp", getTimestamp());
		attributes.put("otherDetid", getOtherDetid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long instaSiteImageId = (Long)attributes.get("instaSiteImageId");

		if (instaSiteImageId != null) {
			setInstaSiteImageId(instaSiteImageId);
		}

		String pageKey = (String)attributes.get("pageKey");

		if (pageKey != null) {
			setPageKey(pageKey);
		}

		String mediaUrl = (String)attributes.get("mediaUrl");

		if (mediaUrl != null) {
			setMediaUrl(mediaUrl);
		}

		String instaimageUrl = (String)attributes.get("instaimageUrl");

		if (instaimageUrl != null) {
			setInstaimageUrl(instaimageUrl);
		}

		String timestamp = (String)attributes.get("timestamp");

		if (timestamp != null) {
			setTimestamp(timestamp);
		}

		Long otherDetid = (Long)attributes.get("otherDetid");

		if (otherDetid != null) {
			setOtherDetid(otherDetid);
		}
	}

	/**
	 * Returns the instaimage url of this insta site images.
	 *
	 * @return the instaimage url of this insta site images
	 */
	@Override
	public String getInstaimageUrl() {
		return model.getInstaimageUrl();
	}

	/**
	 * Returns the insta site image ID of this insta site images.
	 *
	 * @return the insta site image ID of this insta site images
	 */
	@Override
	public long getInstaSiteImageId() {
		return model.getInstaSiteImageId();
	}

	/**
	 * Returns the media url of this insta site images.
	 *
	 * @return the media url of this insta site images
	 */
	@Override
	public String getMediaUrl() {
		return model.getMediaUrl();
	}

	/**
	 * Returns the other detid of this insta site images.
	 *
	 * @return the other detid of this insta site images
	 */
	@Override
	public long getOtherDetid() {
		return model.getOtherDetid();
	}

	/**
	 * Returns the page key of this insta site images.
	 *
	 * @return the page key of this insta site images
	 */
	@Override
	public String getPageKey() {
		return model.getPageKey();
	}

	/**
	 * Returns the primary key of this insta site images.
	 *
	 * @return the primary key of this insta site images
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the timestamp of this insta site images.
	 *
	 * @return the timestamp of this insta site images
	 */
	@Override
	public String getTimestamp() {
		return model.getTimestamp();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the instaimage url of this insta site images.
	 *
	 * @param instaimageUrl the instaimage url of this insta site images
	 */
	@Override
	public void setInstaimageUrl(String instaimageUrl) {
		model.setInstaimageUrl(instaimageUrl);
	}

	/**
	 * Sets the insta site image ID of this insta site images.
	 *
	 * @param instaSiteImageId the insta site image ID of this insta site images
	 */
	@Override
	public void setInstaSiteImageId(long instaSiteImageId) {
		model.setInstaSiteImageId(instaSiteImageId);
	}

	/**
	 * Sets the media url of this insta site images.
	 *
	 * @param mediaUrl the media url of this insta site images
	 */
	@Override
	public void setMediaUrl(String mediaUrl) {
		model.setMediaUrl(mediaUrl);
	}

	/**
	 * Sets the other detid of this insta site images.
	 *
	 * @param otherDetid the other detid of this insta site images
	 */
	@Override
	public void setOtherDetid(long otherDetid) {
		model.setOtherDetid(otherDetid);
	}

	/**
	 * Sets the page key of this insta site images.
	 *
	 * @param pageKey the page key of this insta site images
	 */
	@Override
	public void setPageKey(String pageKey) {
		model.setPageKey(pageKey);
	}

	/**
	 * Sets the primary key of this insta site images.
	 *
	 * @param primaryKey the primary key of this insta site images
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the timestamp of this insta site images.
	 *
	 * @param timestamp the timestamp of this insta site images
	 */
	@Override
	public void setTimestamp(String timestamp) {
		model.setTimestamp(timestamp);
	}

	@Override
	protected InstaSiteImagesWrapper wrap(InstaSiteImages instaSiteImages) {
		return new InstaSiteImagesWrapper(instaSiteImages);
	}

}