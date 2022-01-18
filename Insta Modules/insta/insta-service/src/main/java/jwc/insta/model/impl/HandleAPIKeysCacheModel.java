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

import jwc.insta.model.HandleAPIKeys;

/**
 * The cache model class for representing HandleAPIKeys in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class HandleAPIKeysCacheModel
	implements CacheModel<HandleAPIKeys>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HandleAPIKeysCacheModel)) {
			return false;
		}

		HandleAPIKeysCacheModel handleAPIKeysCacheModel =
			(HandleAPIKeysCacheModel)obj;

		if (handleAPIKeyId == handleAPIKeysCacheModel.handleAPIKeyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, handleAPIKeyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{handleAPIKeyId=");
		sb.append(handleAPIKeyId);
		sb.append(", handleName=");
		sb.append(handleName);
		sb.append(", pageKey=");
		sb.append(pageKey);
		sb.append(", apiKey=");
		sb.append(apiKey);
		sb.append(", instagramWidgetFlag=");
		sb.append(instagramWidgetFlag);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HandleAPIKeys toEntityModel() {
		HandleAPIKeysImpl handleAPIKeysImpl = new HandleAPIKeysImpl();

		handleAPIKeysImpl.setHandleAPIKeyId(handleAPIKeyId);

		if (handleName == null) {
			handleAPIKeysImpl.setHandleName("");
		}
		else {
			handleAPIKeysImpl.setHandleName(handleName);
		}

		if (pageKey == null) {
			handleAPIKeysImpl.setPageKey("");
		}
		else {
			handleAPIKeysImpl.setPageKey(pageKey);
		}

		if (apiKey == null) {
			handleAPIKeysImpl.setApiKey("");
		}
		else {
			handleAPIKeysImpl.setApiKey(apiKey);
		}

		handleAPIKeysImpl.setInstagramWidgetFlag(instagramWidgetFlag);

		handleAPIKeysImpl.resetOriginalValues();

		return handleAPIKeysImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		handleAPIKeyId = objectInput.readLong();
		handleName = objectInput.readUTF();
		pageKey = objectInput.readUTF();
		apiKey = objectInput.readUTF();

		instagramWidgetFlag = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(handleAPIKeyId);

		if (handleName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(handleName);
		}

		if (pageKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pageKey);
		}

		if (apiKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(apiKey);
		}

		objectOutput.writeBoolean(instagramWidgetFlag);
	}

	public long handleAPIKeyId;
	public String handleName;
	public String pageKey;
	public String apiKey;
	public boolean instagramWidgetFlag;

}