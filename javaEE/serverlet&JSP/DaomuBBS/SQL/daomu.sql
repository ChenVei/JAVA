use bbs;

create table daomu(
id int primary key auto_increment,
pid int,
rootID int,
cont text,
pdate date,
isleaf int #1-yes,0-no
)

insert into daomu values (null, 0, 1, '能不能不要在黑电视剧', now(), 0);
insert into daomu values (null, 1, 1, '最近一来盗墓吧就全部在黑电视剧吐槽电视剧而且最后还喜欢加上一句不要怪三叔他是无辜的', now(), 1);
insert into daomu values (null, 1, 1, '希望大家都可以理智对待谢谢', now(), 1);
insert into daomu values (null, 1, 1, '不吐槽怎么火，吐槽之后又不是不看……', now(), 0);
insert into daomu values (null, 4, 1, '很多人就是黑以后还要加一句 （其实我的重点是黑电视剧的人啊 ）我以后在也不看了', now(), 1);	
insert into daomu values (null, 4, 1, '要理解，这是傲娇。', now(), 1);
insert into daomu values (null, 1, 1, '( ´▽) 看了一集表示以后我只看小说，尽管我看了4遍', now(), 0);
insert into daomu values (null, 7, 1, '恭喜你 刚好只看了最差的一点 后面的很多原著剧情你完美的错过了', now(), 1);
insert into daomu values (null, 1, 1, '吐槽的不只是剧情，还有特效、演技、造型等等等，就算是部网络剧，这个也太不上心，对比其他的小成本剧都太烂！', now(), 0);
insert into daomu values (null, 9, 1, '淡定', now(), 0);
insert into daomu values (null, 10, 1, '只是你在说，我回答而已！', now(), 1);
insert into daomu values (null, 9, 1, '好吧', now(), 1);




1 能不能不要在黑电视剧
2 最近一来盗墓吧就全部在黑电视剧吐槽电视剧而且最后还喜欢加上一句不要怪三叔他是无辜的
3 希望大家都可以理智对待谢谢
4 不吐槽怎么火，吐槽之后又不是不看……
  5 很多人就是黑以后还要加一句 （其实我的重点是黑电视剧的人啊 ）我以后在也不看了
  6 要理解，这是傲娇。
7 ( ´▽) 看了一集表示以后我只看小说，尽管我看了4遍
  8 恭喜你 刚好只看了最差的一点 后面的很多原著剧情你完美的错过了
9 吐槽的不只是剧情，还有特效、演技、造型等等等，就算是部网络剧，这个也太不上心，对比其他的小成本剧都太烂！
  10 淡定
     11 只是你在说，我回答而已！
  12 好吧
