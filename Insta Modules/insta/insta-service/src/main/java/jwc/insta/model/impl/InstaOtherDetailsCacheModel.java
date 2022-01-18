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

package jwc.insta.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import jwc.insta.model.InstaOtherDetails;

/**
 * The cache model class for representing InstaOtherDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class InstaOtherDetailsCacheModel
	implements CacheModel<InstaOtherDetails>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InstaOtherDetailsCacheModel)) {
			return false;
		}

		InstaOtherDetailsCacheModel instaOtherDetailsCacheModel =
			(InstaOtherDetailsCacheModel)obj;

		if (otherDetid == instaOtherDetailsCacheModel.otherDetid) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, otherDetid);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{otherDetid=");
		sb.append(otherDetid);
		sb.append(", instaHandleName=");
		sb.append(instaHandleName);
		sb.append(", followUsLink=");
		sb.append(followUsLink);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InstaOtherDetails toEntityModel() {
		InstaOtherDetailsImpl instaOtherDetailsImpl =
			new InstaOtherDetailsImpl();

		instaOtherDetailsImpl.setOtherDetid(otherDetid);

		if (instaHandleName == null) {
			instaOtherDetailsImpl.setInstaHandleName("");
		}
		else {
			instaOtherDetailsImpl.setInstaHandleName(instaHandleName);
		}

		if (followUsLink == null) {
			instaOtherDetailsImpl.setFollowUsLink("");
		}
		else {
			instaOtherDetailsImpl.setFollowUsLink(followUsLink);
		}

		instaOtherDetailsImpl.resetOriginalValues();

		return instaOtherDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		otherDetid = objectInput.readLong();
		instaHandleName = objectInput.readUTF();
		followUsLink = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(otherDetid);

		if (instaHandleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(instaHandleName);
		}

		if (followUsLink == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(followUsLink);
		}
	}

	public long otherDetid;
	public String instaHandleName;
	public String followUsLink;

}