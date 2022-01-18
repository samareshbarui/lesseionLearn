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

import jwc.insta.model.InstaSiteImages;

/**
 * The cache model class for representing InstaSiteImages in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class InstaSiteImagesCacheModel
	implements CacheModel<InstaSiteImages>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InstaSiteImagesCacheModel)) {
			return false;
		}

		InstaSiteImagesCacheModel instaSiteImagesCacheModel =
			(InstaSiteImagesCacheModel)obj;

		if (instaSiteImageId == instaSiteImagesCacheModel.instaSiteImageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, instaSiteImageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{instaSiteImageId=");
		sb.append(instaSiteImageId);
		sb.append(", pageKey=");
		sb.append(pageKey);
		sb.append(", mediaUrl=");
		sb.append(mediaUrl);
		sb.append(", instaimageUrl=");
		sb.append(instaimageUrl);
		sb.append(", timestamp=");
		sb.append(timestamp);
		sb.append(", otherDetid=");
		sb.append(otherDetid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InstaSiteImages toEntityModel() {
		InstaSiteImagesImpl instaSiteImagesImpl = new InstaSiteImagesImpl();

		instaSiteImagesImpl.setInstaSiteImageId(instaSiteImageId);

		if (pageKey == null) {
			instaSiteImagesImpl.setPageKey("");
		}
		else {
			instaSiteImagesImpl.setPageKey(pageKey);
		}

		if (mediaUrl == null) {
			instaSiteImagesImpl.setMediaUrl("");
		}
		else {
			instaSiteImagesImpl.setMediaUrl(mediaUrl);
		}

		if (instaimageUrl == null) {
			instaSiteImagesImpl.setInstaimageUrl("");
		}
		else {
			instaSiteImagesImpl.setInstaimageUrl(instaimageUrl);
		}

		if (timestamp == null) {
			instaSiteImagesImpl.setTimestamp("");
		}
		else {
			instaSiteImagesImpl.setTimestamp(timestamp);
		}

		instaSiteImagesImpl.setOtherDetid(otherDetid);

		instaSiteImagesImpl.resetOriginalValues();

		return instaSiteImagesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		instaSiteImageId = objectInput.readLong();
		pageKey = objectInput.readUTF();
		mediaUrl = objectInput.readUTF();
		instaimageUrl = objectInput.readUTF();
		timestamp = objectInput.readUTF();

		otherDetid = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(instaSiteImageId);

		if (pageKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pageKey);
		}

		if (mediaUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mediaUrl);
		}

		if (instaimageUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(instaimageUrl);
		}

		if (timestamp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(timestamp);
		}

		objectOutput.writeLong(otherDetid);
	}

	public long instaSiteImageId;
	public String pageKey;
	public String mediaUrl;
	public String instaimageUrl;
	public String timestamp;
	public long otherDetid;

}