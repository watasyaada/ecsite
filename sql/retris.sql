set names utf8;
set foreign_key_checks=0;

drop database if exists retris;
create database if not exists retris;

use retris;


create table user_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) unique not null comment "ユーザーID",
password varchar(16) not null comment "パスワード",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
sex tinyint not null default 0 comment "性別:男=0,女=1",
email varchar(32) not null comment "メールアドレス",
status tinyint not null comment "管理者フラグ:一般ユーザー=0,管理者=1",
logined tinyint not null comment "ログインフラグ:未ログイン=0,ログイン済=1",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日"
);

insert into user_info values
(1,"guest","guest","ゲスト","ユーザー","げすと","ゆーざー",0,"guest@gmail.com",0,0,now(),now()),
(2,"guest2","guest2","ゲスト2","ユーザー2","げすと2","ゆーざー2",0,"guest2@gmail.com",0,0,now(),now()),
(3,"guest3","guest3","ゲスト3","ユーザー3","げすと3","ゆーざー3",0,"guest3@gmail.com",0,0,now(),now()),
(4,"guest4","guest4","ゲスト4","ユーザー4","げすと4","ゆーざー4",0,"guest4@gmail.com",0,0,now(),now()),
(5,"guest5","guest5","ゲスト5","ユーザー5","げすと5","ゆーざー5",0,"guest5@gmail.com",0,0,now(),now()),
(6,"guest6","guest6","ゲスト6","ユーザー6","げすと6","ゆーざー6",0,"guest6@gmail.com",0,0,now(),now()),
(7,"guest7","guest7","ゲスト7","ユーザー7","げすと7","ゆーざー7",0,"guest7@gmail.com",0,0,now(),now()),
(8,"guest8","guest8","ゲスト8","ユーザー8","げすと8","ゆーざー8",0,"guest8@gmail.com",0,0,now(),now()),
(9,"guest9","guest9","ゲスト9","ユーザー9","げすと9","ゆーざー9",0,"guest9@gmail.com",0,0,now(),now()),
(10,"guest10","guest10","ゲスト10","ユーザー10","げすと10","ゆーざー10",0,"guest10@gmail.com",0,0,now(),now()),
(11,"guest11","guest11","ゲスト11","ユーザー11","げすと11","ゆーざー11",0,"guest11@gmail.com",0,0,now(),now()),
(12,"guest12","guest12","ゲスト12","ユーザー12","げすと12","ゆーざー12",0,"guest12@gmail.com",0,0,now(),now()),
(13,"admin","admin","管理者","ユーザー","かんりしゃ","ゆーざー",0,"admin@gmail.com",1,0,now(),now()),
(14,"admin2","admin2","管理者2","ユーザー2","かんりしゃ2","ゆーざー2",0,"admin2@gmail.com",1,0,now(),now()),
(15,"admin3","admin3","管理者3","ユーザー3","かんりしゃ3","ゆーざー3",0,"admin3@gmail.com",1,0,now(),now()),
(16,"admin4","admin4","管理者4","ユーザー4","かんりしゃ4","ゆーざー4",0,"admin4@gmail.com",1,0,now(),now()),
(17,"admin5","admin5","管理者5","ユーザー5","かんりしゃ5","ゆーざー5",0,"admin5@gmail.com",1,0,now(),now()),
(18,"admin6","admin6","管理者6","ユーザー6","かんりしゃ6","ゆーざー6",0,"admin6@gmail.com",1,0,now(),now()),
(19,"admin7","admin7","管理者7","ユーザー7","かんりしゃ7","ゆーざー7",0,"admin7@gmail.com",1,0,now(),now()),
(20,"admin8","admin8","管理者8","ユーザー8","かんりしゃ8","ゆーざー8",0,"admin8@gmail.com",1,0,now(),now()),
(21,"admin9","admin9","管理者9","ユーザー9","かんりしゃ9","ゆーざー9",0,"admin9@gmail.com",1,0,now(),now()),
(22,"admin10","admin10","管理者10","ユーザー10","かんりしゃ10","ゆーざー10",0,"admin10@gmail.com",1,0,now(),now()),
(23,"admin11","admin11","管理者11","ユーザー11","かんりしゃ11","ゆーざー11",0,"admin11@gmail.com",1,0,now(),now()),
(24,"admin12","admin12","管理者12","ユーザー12","かんりしゃ12","ゆーざー12",0,"admin12@gmail.com",1,0,now(),now());


create table product_info(
id int primary key not null auto_increment comment "ID",
product_id int unique not null comment "商品ID",
product_name varchar(100) unique not null comment "商品名",
product_name_kana varchar(100) unique not null comment "商品名かな",
product_description varchar(255) not null comment "商品詳細",
category_id int not null comment "カテゴリID",
price int comment "価格",
image_file_path varchar(100) comment "画像ファイルパス",
image_file_name varchar(50) comment "画像ファイル名",
release_date datetime not null comment "発売年月",
release_company varchar(50) comment "発売会社",
status tinyint not null default 0 comment "ステータス:無効=0,有効=1",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日",
foreign key(category_id) references m_category(category_id)
);

insert into product_info values
(1,1,"ドラゴンクエスト","どらごんくえすと","国民的ゲーム、ドラゴンクエストのシリーズ一作目",2,5500,"./images/package","id_1.jpg","1986-05-27 00:00:00","エニックス",0,now(),now()),
(2,2,"ドラゴンクエスト2","どらごんくえすと2","国民的ゲーム、ドラゴンクエストのシリーズ二作目",2,5500,"./images/package","id_2.jpg","1987-01-26 00:00:00","エニックス",0,now(),now()),
(3,3,"第２次スーパーロボット対戦","だい2じすーぱーろぼっとたいせん","スーパーロボット対戦シリーズの第二作目",2,12800,"./images/package","id_3.jpg","1991-12-29 00:00:00","バンプレスト",0,now(),now()),
(4,4,"ゾイド2","ぞいど2","共和国ゾイドを駆使し、与えられた指令をこなしていく",2,5900,"./images/package","id_4.jpg","1989-01-27 00:00:00","東芝EMI",0,now(),now()),
(5,5,"ファイナルファンタジー","ふぁいなるふぁんたじー","国民的ゲーム、ファイナルファンタジーのシリーズ一作目",2,5900,"./images/package","id_5.jpg","1987-12-18 00:00:00","スクウェア",0,now(),now()),
(6,6,"スーパーマリオブラザーズ","すーぱーまりおぶらざーず","配管工の兄弟マリオとルイージはピーチを助け出すため、クッパが率いる敵たちを倒して陸海空を突き進み、いざクッパがいる城へ向かう",3,4900,"./images/package","id_6.jpg","1985-09-13 00:00:00","任天堂",0,now(),now()),
(7,7,"アイスクライマー","あいすくらいまー","ポポとナナを操作して山の頂上を目指す",3,4500,"./images/package","id_7.jpg","1985-01-30 00:00:00","任天堂",0,now(),now()),
(8,8,"スペースインベーダー","すぺーすいんべーだー","迫り来るインベーダーを全滅させろ！",3,4500,"./images/package","id_8.jpg","1985-04-17 00:00:00","タイトー",0,now(),now()),
(9,9,"ゼビウス","ぜびうす","ソルバルウを操作して敵ゼビウス軍機を撃ち落していく",3,4500,"./images/package","id_9.jpg","1984-11-08 00:00:00","ナムコ",0,now(),now()),
(10,10,"スペランカー","すぺらんかー","迷宮の最下層を目指す",3,4900,"./images/package","id_10.jpg","1985-12-07 00:00:00","アイレム",0,now(),now()),
(11,11,"テトリス","てとりす","テトリミノを組み合わせてラインを消していく",4,4900,"./images/package","id_11.jpg","1988-12-22 00:00:00","BPS",0,now(),now()),
(12,12,"パックマン","ぱっくまん","モンスター達の追跡をかわしながらに迷路内に配置された244個のドットを食べ尽くせ！",4,4500,"./images/package","id_12.jpg","1984-11-02 00:00:00","ナムコ",0,now(),now()),
(13,13,"ロードランナー","ろーどらんなー","ステージ内にある金塊を敵に捕まらずに回収し脱出する",4,4900,"./images/package","id_13.jpg","1983-10-13 00:00:00","システムソフト",0,now(),now()),
(14,14,"スターソルジャー","すたーそるじゃー","キミの任務は全宇宙から選出された、ただ一人の宇宙戦士としてシーザーに乗り込み浮遊大陸をコントロールしている人工頭脳を破壊することだ",3,4900,"./images/package","id_14.jpg","1986-06-13 00:00:00","ハドソン",0,now(),now()),
(15,15,"桃太郎伝説","ももたろうでんせつ","イヌ、サル、キジをお供に引き連れて鬼ヶ島の鬼を退治する",2,5800,"./images/package","id_15.jpg","1987-10-26 00:00:00","ハドソン",0,now(),now()),
(16,16,"ドラゴンボール神龍の謎","どらごんぼーるしぇんろんのなぞ","孫悟空を操作し、ドラゴンボールを集めよう！",3,5300,"./images/package","id_16.jpg","1986-11-27 00:00:00","バンダイ",0,now(),now()),
(17,17,"ドンキーコング","どんきーこんぐ","ドンキーコングにさらわれた恋人のレディを救い出せ！",3,3800,"./images/package","id_17.jpg","1983-07-15 00:00:00","任天堂",0,now(),now()),
(18,18,"パックランド","ぱっくらんど","迷子になった妖精をフェアリーの国まで連れて行き、無事に送り届けよう",3,4500,"./images/package","id_18.jpg","1985-11-21 00:00:00","ナムコ",0,now(),now()),
(19,19,"バルーンファイト","ばるーんふぁいと","画面内にいる全ての敵の風船を割り、面をクリアしていく",3,5500,"./images/package","id_19.jpg","1985-01-22 00:00:00","任天堂",0,now(),now()),
(20,20,"ボンバーマン","ぼんばーまん","ボンバーマンは人間になり自由を得るため、地上への脱出を決意した",3,4900,"./images/package","id_20.jpg","1985-12-20 00:00:00","ハドソン",0,now(),now()),
(21,21,"高橋名人の冒険島","たかはしめいじんのぼうけんじま","高橋名人は恋人を救出するため広大なステージに立ち向かう",3,4900,"./images/package","id_21.jpg","1986-09-12 00:00:00","ハドソン",0,now(),now()),
(22,22,"星のカービィ夢の泉の物語","ほしのかーびぃゆめのいずみのものがたり","夢を見られなくなった住民達のため、自分自身の御昼寝タイムを取り戻すために、カービィが立ち上がる",3,6500,"./images/package","id_22.jpg","1993-03-23 00:00:00","任天堂",0,now(),now()),
(23,23,"忍者じゃじゃ丸くん","にんじゃじゃじゃまるくん","じゃじゃ丸を操り、ステージ内にいる敵をすべて倒せ",3,4900,"./images/package","id_23.jpg","1985-11-15 00:00:00","ジャレコ",0,now(),now()),
(24,24,"魔界村","まかいむら","主人公の騎士アーサーを操り、さらわれたプリンセスを助け出せ！",3,5500,"./images/package","id_24.jpg","1986-06-13 00:00:00","カプコン",0,now(),now()),
(25,25,"忍者ハットリくん","にんじゃはっとりくん","あの忍者ハットリくんがゲームになって登場",3,4900,"./images/package","id_25.jpg","1986-03-05 00:00:00","ハドソン",0,now(),now());


create table cart_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
temp_user_id varchar(16) comment "仮ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日"
);


create table purchase_history_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
destination_id int not null comment "宛先情報ID",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日",
delete_flg tinyint not null comment "購入履歴表示フラグ:表示=0,非表示=1",
foreign key(user_id) references user_info(user_id),
foreign key(product_id) references product_info(product_id)
);

insert into purchase_history_info values
(1,13,1,5,27500,1,now(),now(),1),
(2,14,5,4,23600,2,now(),now(),1),
(3,15,3,3,38400,3,now(),now(),1),
(4,16,2,2,11000,4,now(),now(),1),
(5,17,6,5,24500,5,now(),now(),1),
(6,18,8,4,18000,6,now(),now(),1),
(7,19,19,3,16500,7,now(),now(),1),
(8,20,20,2,9800,8,now(),now(),1),
(9,21,11,5,24500,9,now(),now(),1),
(10,22,12,4,18000,10,now(),now(),1),
(11,23,13,3,14700,11,now(),now(),1);


create table destination_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
email varchar(32) not null comment "メールアドレス",
tel_number varchar(13) not null comment "電話番号",
user_address varchar(50) not null comment "住所",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日"
);

insert into destination_info values
(1,"guest","ゲスト","ユーザー","げすと","ゆーざー","guest@gmail.com","080-1234-5678","東京都千代田区三番町１－１ KY三番町ビル１F",now(),"0000-00-00 00:00:00");


create table m_category(
id int primary key not null auto_increment comment "ID",
category_id int not null unique comment "カテゴリID",
category_name varchar(20) not null unique comment "カテゴリ名",
category_description varchar(100) comment "カテゴリ詳細",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
);

insert into m_category values
(1,1,"全てのカテゴリ","RPG,シューティング・アクション,パズル・クイズ全てのカテゴリが対象となります",now(),null),
(2,2,"RPG","RPGに関するカテゴリが対象となります",now(),null),
(3,3,"シューティング・アクション","シューティング・アクションに関するカテゴリが対象となります",now(),null),
(4,4,"パズル・クイズ","パズル・クイズに関するカテゴリが対象となります",now(),null);
