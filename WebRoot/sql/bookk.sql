select * from bookk;
create table bookk(
id number primary key ,
name varchar2(20) not null,
author varchar2(20) not null,
type varchar2(20) not null,
intro varchar2(200) not null,
price number not null,
publishdate	 date not null
);
create sequence seq_b;
insert into bookk values(seq_b.nextval,'���μ�','��ж�','С˵','��ɮ��������ȡ���Ĺ���',30,sysdate);
insert into bookk values(seq_b.nextval,'��������','�޹���','��ʷ','���������Ĺ���',40,sysdate);
insert into bookk values(seq_b.nextval,'��¥��','��ѩ��','����','�������',32,sysdate);
insert into bookk values(seq_b.nextval,'ˮ䰴�','ʩ����','��ʷ','����ˮ����ɽ�Ĺ���',55,sysdate);
