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
 * This class is a wrapper for {@link InstaOtherDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InstaOtherDetails
 * @generated
 */
public class InstaOtherDetailsWrapper
	extends BaseModelWrapper<InstaOtherDetails>
	implements InstaOtherDetails, ModelWrapper<InstaOtherDetails> {

	public InstaOtherDetailsWrapper(InstaOtherDetails instaOtherDetails) {
		super(instaOtherDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("otherDetid", getOtherDetid());
		attributes.put("instaHandleName", getInstaHandleName());
		attributes.put("followUsLink", getFollowUsLink());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long otherDetid = (Long)attributes.get("otherDetid");

		if (otherDetid != null) {
			setOtherDetid(otherDetid);
		}

		String instaHandleName = (String)attributes.get("instaHandleName");

		if (instaHandleName != null) {
			setInstaHandleName(instaHandleName);
		}

		String followUsLink = (String)attributes.get("followUsLink");

		if (followUsLink != null) {
			setFollowUsLink(followUsLink);
		}
	}

	/**
	 * Returns the follow us link of this insta other details.
	 *
	 * @return the follow us link of this insta other details
	 */
	@Override
	public String getFollowUsLink() {
		return model.getFollowUsLink();
	}

	/**
	 * Returns the insta handle name of this insta other details.
	 *
	 * @return the insta handle name of this insta other details
	 */
	@Override
	public String getInstaHandleName() {
		return model.getInstaHandleName();
	}

	/**
	 * Returns the other detid of this insta other details.
	 *
	 * @return the other detid of this insta other details
	 */
	@Override
	public long getOtherDetid() {
		return model.getOtherDetid();
	}

	/**
	 * Returns the primary key of this insta other details.
	 *
	 * @return the primary key of this insta other details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the follow us link of this insta other details.
	 *
	 * @param followUsLink the follow us link of this insta other details
	 */
	@Override
	public void setFollowUsLink(String followUsLink) {
		model.setFollowUsLink(followUsLink);
	}

	/**
	 * Sets the insta handle name of this insta other details.
	 *
	 * @param instaHandleName the insta handle name of this insta other details
	 */
	@Override
	public void setInstaHandleName(String instaHandleName) {
		model.setInstaHandleName(instaHandleName);
	}

	/**
	 * Sets the other detid of this insta other details.
	 *
	 * @param otherDetid the other detid of this insta other details
	 */
	@Override
	public void setOtherDetid(long otherDetid) {
		model.setOtherDetid(otherDetid);
	}

	/**
	 * Sets the primary key of this insta other details.
	 *
	 * @param primaryKey the primary key of this insta other details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected InstaOtherDetailsWrapper wrap(
		InstaOtherDetails instaOtherDetails) {

		return new InstaOtherDetailsWrapper(instaOtherDetails);
	}

}