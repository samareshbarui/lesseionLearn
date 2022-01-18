create index IX_4091137D on JWC_HandleAPIKeys (pageKey[$COLUMN_LENGTH:75$]);

create index IX_F82FE55F on JWC_InstaSiteImages (instaimageUrl[$COLUMN_LENGTH:10000000$], mediaUrl[$COLUMN_LENGTH:50000000$], timestamp[$COLUMN_LENGTH:75$]);
create index IX_FF300EC9 on JWC_InstaSiteImages (pageKey[$COLUMN_LENGTH:75$]);