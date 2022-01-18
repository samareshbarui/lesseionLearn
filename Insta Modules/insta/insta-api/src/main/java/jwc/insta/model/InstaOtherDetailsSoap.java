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
public class InstaOtherDetailsSoap implements Serializable {

	public static InstaOtherDetailsSoap toSoapModel(InstaOtherDetails model) {
		InstaOtherDetailsSoap soapModel = new InstaOtherDetailsSoap();

		soapModel.setOtherDetid(model.getOtherDetid());
		soapModel.setInstaHandleName(model.getInstaHandleName());
		soapModel.setFollowUsLink(model.getFollowUsLink());

		return soapModel;
	}

	public static InstaOtherDetailsSoap[] toSoapModels(
		InstaOtherDetails[] models) {

		InstaOtherDetailsSoap[] soapModels =
			new InstaOtherDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InstaOtherDetailsSoap[][] toSoapModels(
		InstaOtherDetails[][] models) {

		InstaOtherDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new InstaOtherDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InstaOtherDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InstaOtherDetailsSoap[] toSoapModels(
		List<InstaOtherDetails> models) {

		List<InstaOtherDetailsSoap> soapModels =
			new ArrayList<InstaOtherDetailsSoap>(models.size());

		for (InstaOtherDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InstaOtherDetailsSoap[soapModels.size()]);
	}

	public InstaOtherDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _otherDetid;
	}

	public void setPrimaryKey(long pk) {
		setOtherDetid(pk);
	}

	public long getOtherDetid() {
		return _otherDetid;
	}

	public void setOtherDetid(long otherDetid) {
		_otherDetid = otherDetid;
	}

	public String getInstaHandleName() {
		return _instaHandleName;
	}

	public void setInstaHandleName(String instaHandleName) {
		_instaHandleName = instaHandleName;
	}

	public String getFollowUsLink() {
		return _followUsLink;
	}

	public void setFollowUsLink(String followUsLink) {
		_followUsLink = followUsLink;
	}

	private long _otherDetid;
	private String _instaHandleName;
	private String _followUsLink;

}