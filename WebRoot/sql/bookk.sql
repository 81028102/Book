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
insert into bookk values(seq_b.nextval,'西游记','吴承恩','小说','唐僧四人西天取经的故事',30,sysdate);
insert into bookk values(seq_b.nextval,'三国演义','罗贯中','历史','三国纷争的故事',40,sysdate);
insert into bookk values(seq_b.nextval,'红楼梦','曹雪芹','言情','家族故事',32,sysdate);
insert into bookk values(seq_b.nextval,'水浒传','施耐庵','历史','聚义水泊梁山的故事',55,sysdate);
