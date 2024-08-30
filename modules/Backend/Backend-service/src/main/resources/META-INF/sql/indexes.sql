create index IX_B50C4CC3 on Timekeeping_Chucvu (groupId);

create index IX_D91B2176 on Timekeeping_Phongban (groupId);

create index IX_87F2026B on Timekeeping_Users (groupId);
create index IX_FF978E59 on Timekeeping_Users (userId);

create index IX_FD8822A0 on Timekeeping_adminphieudiem (uuid_[$COLUMN_LENGTH:75$]);