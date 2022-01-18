create table JWC_HandleAPIKeys (
	handleAPIKeyId LONG not null primary key,
	handleName VARCHAR(75) null,
	pageKey VARCHAR(75) null,
	apiKey TEXT null,
	instagramWidgetFlag BOOLEAN
);

create table JWC_InstaOtherDetails (
	otherDetid LONG not null primary key,
	instaHandleName VARCHAR(75) null,
	followUsLink VARCHAR(75) null
);

create table JWC_InstaSiteImages (
	instaSiteImageId LONG not null primary key,
	pageKey VARCHAR(75) null,
	mediaUrl TEXT null,
	instaimageUrl TEXT null,
	timestamp VARCHAR(75) null,
	otherDetid LONG
);