create table if not exists customer (
    customer_id serial not null,
    firstname varchar not null ,
    lastname varchar not null ,
    email varchar not null unique,
    phone_number varchar not null,
    address_eth varchar(255) not null ,

    created_at timestamp not null,
    deleted_at timestamp,
    updated_at timestamp,
    store_id int8 not null,
    primary key (customer_id)
);

INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Leonard','England','l_england4481@hotmail.edu','1-465-537-6990','%B8516016871352188^SgdosdhJployb^1905434217?2','2023-02-12 01:26:01',null,null,3),
  ('Vera','Miles','m-vera1412@icloud.com','1-700-416-7460','%B6667125171211755^SrennexKktdon^6904303870?3','2023-02-20 17:46:21',null,null,4),
  ('Keely','Calhoun','keely-calhoun883@aol.ca','1-385-559-8169','%B3235215786838618^YejxgngQxjugl^5602213821?2','2023-01-07 21:33:36',null,null,3),
  ('Chiquita','Steele','chiquitasteele@icloud.edu','1-648-368-7565','%B7926645250147712^KrocpuhFqnlfr^58094322?7','2023-03-11 22:26:05',null,null,4),
  ('Emily','Mejia','e.mejia1942@outlook.ca','(215) 528-5934','%B9620178221206034^SutxhgpDeixjo^2907500377?2','2023-01-20 11:55:17',null,null,2),
  ('Gareth','Lindsey','lindseygareth@yahoo.com','(368) 114-4843','%B2020351219492612^PzmfuefUeouvt^48057481498?1','2023-03-12 08:03:24',null,null,3),
  ('Farrah','Roy','froy@outlook.edu','(319) 262-5713','%B4183578994726323^DrigqidRjjscr^93054818?7','2023-02-01 00:20:42',null,null,2),
  ('Gannon','Fisher','fishergannon6205@protonmail.net','1-213-964-7216','%B4475304524768824^OkubzhgHuywlr^80079705?1','2023-03-10 01:44:48',null,null,2),
  ('Marah','Orr','orr.marah7252@icloud.org','(724) 579-2761','%B5645581157155941^TbywuxdWldjqg^0305524967?5','2023-01-12 03:49:26',null,null,2),
  ('Hammett','Mcgee','mcgee.hammett1834@google.com','1-109-528-6433','%B1377947583233772^WtrmejxVthfxz^5808662151?4','2023-02-06 07:13:38',null,null,1);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Kitra','Burgess','kitra-burgess@yahoo.edu','(519) 442-8879','%B6476153788228826^KtqprhsQywrbl^3507135710?9','2023-01-27 08:49:35',null,null,3),
  ('Alexandra','Frank','a_frank3476@google.couk','(926) 630-1740','%B8038513442308813^WmieqsrUcbyqb^66011202?4','2023-03-01 07:01:14',null,null,4),
  ('Rajah','Frazier','frazier.rajah@yahoo.edu','1-660-413-5348','%B5727329271807134^TuvexivBloncj^35125594622?9','2023-02-01 04:40:00',null,null,2),
  ('Ashely','Grimes','grimes.ashely9974@google.edu','1-393-758-8268','%B8033438217919856^YltavgfKavijj^7410514437?5','2023-02-27 12:10:18',null,null,2),
  ('Aretha','Perez','perez_aretha1741@hotmail.net','(338) 596-7158','%B8466815521482775^EyxrpgmHvejin^3212702198?5','2023-01-29 15:18:09',null,null,4),
  ('George','Wright','g.wright@hotmail.couk','1-425-436-4198','%B8252581976592531^FwowoieVeoiqk^8409660727?5','2023-02-06 02:12:59',null,null,2),
  ('Yvonne','Branch','y-branch@protonmail.edu','1-801-252-7518','%B1638322108842154^FwivkbiChicel^3506712837?2','2023-03-07 12:52:40',null,null,1),
  ('Devin','Chaney','d_chaney@google.edu','1-554-742-4433','%B4587778524582624^AfwecedSnvrhp^5604163417?6','2023-01-15 14:37:26',null,null,2),
  ('Keiko','Mcdaniel','keiko.mcdaniel6531@aol.com','(888) 204-8752','%B8218803850214344^IrkfulrBqlfue^31075608?3','2023-01-13 02:18:14',null,null,4),
  ('Sophia','Sharp','sharp_sophia@outlook.edu','(951) 802-8598','%B6671739553244740^BqbfumrCzcehz^6409266785?4','2023-03-20 22:36:17',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Zane','Combs','zane_combs409@icloud.org','1-247-682-5425','%B7466665681870749^ShmtbesLyvfuw^0003684212?1','2023-01-12 18:57:27',null,null,3),
  ('Jaquelyn','Mclean','j.mclean@icloud.ca','1-512-352-1691','%B2844126108570742^JctzgrsKyeruo^8208929845?1','2023-02-04 22:11:24',null,null,3),
  ('Quail','Patrick','q.patrick@aol.com','1-855-427-3467','%B3838820034277394^IynylmkXvumly^97078592?3','2023-02-08 01:02:04',null,null,2),
  ('Dara','Hurley','d-hurley@outlook.couk','1-264-552-6779','%B6871311032259676^WdrtowxCuvwds^78013122?7','2023-01-30 10:20:34',null,null,3),
  ('Leslie','Church','l.church@icloud.org','1-340-815-3650','%B3144967283345156^FisyftmDuiqms^74074943?8','2023-02-19 22:06:36',null,null,1),
  ('Eliana','Ortega','o-eliana@aol.com','(805) 637-9318','%B6336249335302440^JdpihfhJyrqmh^6003374541?7','2023-02-07 17:37:42',null,null,2),
  ('Orla','Carrillo','corla7408@aol.edu','(838) 216-6074','%B7716619248356175^AypmgklZyjhqf^65081828?5','2023-03-13 21:23:15',null,null,3),
  ('Nathaniel','Ford','f.nathaniel4167@google.net','1-517-565-5973','%B9421608365731748^StcwuaoPqdteq^9004562735?3','2023-03-21 02:52:41',null,null,2),
  ('Candace','Cox','ccandace@outlook.org','(362) 600-5018','%B4637154653656553^QhpzfrtThcbll^0608233778?5','2023-02-23 13:50:56',null,null,1),
  ('Kevyn','Combs','c_kevyn3197@yahoo.net','(411) 890-6091','%B3476772413545627^EvplzcuPestts^14125806763?2','2023-02-12 13:42:29',null,null,3);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Farrah','Ford','farrah_ford1215@hotmail.org','1-813-291-3242','%B7354676028446235^JcvfqeuOfudbd^6602597172?9','2023-02-12 23:49:12',null,null,4),
  ('Athena','Ayala','a-ayala4685@hotmail.couk','(465) 347-5031','%B6839744889444781^BubqpnqSmlywl^83042522697? ','2023-02-16 02:33:14',null,null,2),
  ('Molly','Harrell','mharrell@aol.couk','(753) 939-3822','%B2438213482167536^XbdvijsOhoedc^99094498?3','2023-03-07 14:32:58',null,null,3),
  ('Hedda','Brennan','brennan.hedda68@google.couk','1-245-741-3242','%B4716156555288608^KqtubwrSejbxp^64093062?4','2023-01-19 01:00:21',null,null,3),
  ('Jin','Frank','j-frank2708@aol.ca','(497) 290-0968','%B7835747441719528^OpirlspLqtbyg^4411676893?1','2023-01-16 02:29:38',null,null,2),
  ('Vivien','Herrera','h_vivien9648@hotmail.couk','1-728-474-2271','%B4674208447454376^BtphvnqYfckfr^5910841558? ','2023-02-13 12:46:33',null,null,3),
  ('Ulla','Ellis','uellis1211@protonmail.edu','1-271-752-7655','%B5621220791377239^HnfitcvKnnblq^9405582495?1','2023-03-08 18:28:24',null,null,2),
  ('Cadman','Gordon','gcadman@icloud.edu','(177) 266-5332','%B6511682511635744^WmkrranBeunvj^6703588537?4','2023-03-23 11:49:05',null,null,4),
  ('Lee','Greer','greer_lee8771@yahoo.com','(877) 687-2634','%B7233595242830178^KtyjjgkGbtnoj^0707614687? ','2023-01-18 04:43:09',null,null,2),
  ('Candice','Mayo','mayo.candice@hotmail.org','1-856-434-2883','%B4246248392362830^UzcnofmJdpsep^9610320974?7','2023-02-18 13:02:32',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Drake','Jenkins','d_jenkins8741@icloud.com','(687) 456-2972','%B7670766401621067^RgqsnewBkhbbl^5807406455?5','2023-02-08 14:11:04',null,null,1),
  ('Kirestin','Holland','k.holland@yahoo.couk','1-811-256-8012','%B1382030060879736^CrhplnfNjkgpl^6203186843?5','2023-03-16 07:29:06',null,null,4),
  ('Melyssa','Blevins','m_blevins@icloud.edu','1-718-333-6386','%B2968482639157681^XyyltjbAoleca^11083684?1','2023-02-22 20:31:38',null,null,3),
  ('Hammett','Rogers','r.hammett@aol.com','1-499-312-7656','%B2522580379338937^AtmsrkvLrmkdm^3704370483?1','2023-02-25 08:06:15',null,null,3),
  ('Katelyn','Blanchard','blanchard-katelyn4066@google.org','1-363-606-1898','%B7803874508342522^LswwnlxFucdys^6306953633?4','2023-02-15 08:32:26',null,null,2),
  ('Hayden','Kelley','kelley.hayden2422@yahoo.com','1-886-426-2783','%B8228850991821737^TppivbhQbqgkc^63122137527?6','2023-03-05 20:35:55',null,null,4),
  ('Ashely','Herrera','herrera_ashely7802@protonmail.ca','(961) 404-9511','%B8766542412851640^QrjtfqnVlbhte^4806992475?6','2023-03-03 19:00:55',null,null,3),
  ('Colton','Foley','foley-colton@google.couk','(653) 435-1773','%B5348463058147559^MlcauskHgvnvf^62082328387?2','2023-02-06 02:51:56',null,null,4),
  ('August','Rose','roseaugust3548@icloud.org','(689) 654-1689','%B9020314873652817^FxsnvzuBmibmd^9310695923?6','2023-02-05 22:17:29',null,null,3),
  ('Merritt','Thompson','m.thompson7726@google.couk','1-312-615-4881','%B7588816308379371^IenvlcsLmguho^8504275706?8','2023-03-19 22:37:01',null,null,4);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Germaine','Watson','watson-germaine4131@icloud.org','1-807-504-3701','%B2076942376396492^RdunyyeQmttdh^8011546826?5','2023-03-26 19:25:31',null,null,3),
  ('Colette','Moon','colettemoon@aol.ca','1-138-915-2866','%B3544583832515955^RevgtjsFjmthn^47069683187?5','2023-01-04 19:58:01',null,null,1),
  ('Anjolie','Lowery','alowery@outlook.couk','(648) 463-5462','%B6085652925434541^YuhtrbgJoxapl^9204697294?7','2023-01-16 08:05:05',null,null,2),
  ('Blossom','Byrd','byrd-blossom@yahoo.org','1-454-411-8317','%B5764846123230537^PgdnelfIjayxb^56044617463?2','2023-01-08 00:39:35',null,null,2),
  ('Evangeline','Zamora','evangelinezamora4619@google.com','(879) 281-4546','%B9758065764845678^WcfjrbkDtqfmy^07089774?2','2023-02-10 03:32:05',null,null,3),
  ('Adara','Herring','aherring4009@google.net','1-118-432-8649','%B3769344470672341^RbwncvbNrgfuq^25128728836?2','2023-03-05 04:53:14',null,null,1),
  ('Fuller','Crawford','f_crawford@aol.org','1-578-233-2167','%B9245528485344506^NdzypeuRexwag^16102576?5','2023-02-06 03:40:59',null,null,3),
  ('Quynn','Carroll','quynn_carroll1629@aol.ca','1-436-835-1478','%B2331235191657495^DegbfveXxbxsn^04032406976? ','2023-02-23 03:21:14',null,null,2),
  ('Shad','Lee','s_lee4912@protonmail.couk','1-266-215-4436','%B7153013118174268^PgojsrpVpfdez^6904248397?2','2023-02-12 21:57:23',null,null,2),
  ('Connor','Reyes','reyesconnor@outlook.net','(648) 633-5291','%B4712752636612983^HfrcdadEqjmeb^5305851831?2','2023-01-09 07:02:36',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Daquan','Day','day.daquan@outlook.net','(738) 427-5539','%B3236858863616408^YdovdtkTbiupq^0308883856?7','2023-01-20 07:39:36',null,null,4),
  ('Justin','Atkins','justin_atkins@icloud.ca','(181) 511-6254','%B6643578816016216^DudyhywHneoze^4003896818?7','2023-03-27 15:42:04',null,null,3),
  ('Hilary','Huber','huber.hilary@protonmail.edu','(419) 664-7084','%B1273216173421481^IihtkuhRwnrpw^9809558270?7','2023-03-21 06:28:13',null,null,2),
  ('Cain','Bolton','boltoncain4359@hotmail.net','(855) 187-9470','%B2234365545726546^YcmyyxrDddecy^95051416046?1','2023-03-25 10:38:17',null,null,3),
  ('Zephania','Bean','zbean9701@icloud.net','(438) 621-3517','%B6683110951393626^OvunproRhvevq^9103565761?1','2023-03-22 12:36:16',null,null,2),
  ('Tucker','Cotton','t.cotton@yahoo.com','(242) 765-1009','%B3513094322267557^UuvlqevXtgexk^5412180738?7','2023-01-15 05:13:10',null,null,1),
  ('Mark','Reid','rmark2475@yahoo.edu','(776) 417-5131','%B3258685231488182^CthiemyHvyrri^3102939298?3','2023-03-18 13:10:57',null,null,3),
  ('Stella','Yang','s-yang@hotmail.couk','1-886-251-0615','%B9333431237683489^VdpbjhlMweogw^41108688?1','2023-01-02 07:05:22',null,null,4),
  ('Lucy','Watts','watts_lucy@outlook.edu','1-653-834-7375','%B3816787454123206^QmmnygdVgrowl^47045704253?5','2023-03-06 05:52:36',null,null,2),
  ('Rhiannon','Duran','d-rhiannon@aol.org','1-418-465-0454','%B8418802491815242^XqulabsUmtbgo^83116444572?5','2023-01-20 09:22:12',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Lars','Chavez','clars8003@outlook.org','(612) 882-5658','%B6762849899242572^PuudynqKkiacy^27059948?5','2023-03-10 05:09:35',null,null,1),
  ('Jescie','Beach','beach_jescie@protonmail.edu','1-792-553-7825','%B9528816494154237^NakzjfwQepxwn^48094694915?8','2023-03-25 12:01:03',null,null,3),
  ('Murphy','Weeks','weeks_murphy@icloud.ca','(927) 983-1328','%B5217033146175466^YvlchzyNauaay^7303162595?9','2023-02-07 09:25:29',null,null,3),
  ('Avye','Burris','burris_avye3450@aol.ca','(816) 262-4545','%B5485843657426320^PvkyvjrJkqorr^8407701243?7','2023-02-02 03:31:07',null,null,1),
  ('Bethany','Leon','leonbethany1374@google.edu','(481) 523-2654','%B4182525074978835^LogmkjzQovccc^1007572736?1','2023-01-07 02:18:59',null,null,2),
  ('William','Colon','william_colon@protonmail.edu','1-443-982-8915','%B2252744724192106^JlhvbpfPjimxl^29042321?5','2023-02-19 07:47:13',null,null,3),
  ('Ava','Frye','a_frye3278@outlook.com','(810) 724-2014','%B6154066073953714^EqhyanfDyfiht^1207654688?3','2023-01-31 02:00:22',null,null,4),
  ('Megan','Golden','g.megan4340@aol.couk','(417) 632-1324','%B4937727817288073^IetckgiRpjfup^09045715? ','2023-03-04 18:07:18',null,null,3),
  ('Fuller','Tyson','fuller.tyson@outlook.com','1-847-933-9264','%B3343537558611537^HmdsbwfAyhqnz^63105789?4','2023-02-10 12:24:00',null,null,2),
  ('Sybil','Harvey','harvey.sybil1693@yahoo.edu','1-357-785-3463','%B3549315455442683^GpxborgIynpwf^7507993480?8','2023-03-01 20:45:36',null,null,1);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Elliott','Estes','esteselliott@outlook.com','(840) 348-6417','%B7655652145655421^TkyerxuYqbjli^24071508?7','2023-03-09 21:59:53',null,null,3),
  ('Devin','Graham','devin-graham@protonmail.net','1-242-315-0750','%B4318502478279132^BgrsnpjDxuvlq^64057139672?1','2023-01-13 04:01:52',null,null,3),
  ('Holly','Vargas','vargas.holly9874@aol.couk','(369) 634-6236','%B7269865874643315^TeiyowtEiyhkn^26088787? ','2023-03-16 22:09:49',null,null,2),
  ('Ruby','Burke','burke_ruby3726@yahoo.couk','(711) 704-3191','%B3798725378664335^OplucgoUiirqm^98115321?7','2023-02-12 10:28:02',null,null,2),
  ('Bevis','Warner','wbevis@outlook.couk','1-604-553-8489','%B7908882126503992^LnxdjbeSbivjg^25106067925?2','2023-01-26 02:09:12',null,null,2),
  ('Myles','Horton','myleshorton@icloud.couk','1-357-737-1060','%B3773214452908776^LvqgpmjJhchjl^8906665879?2','2023-01-21 18:59:59',null,null,4),
  ('Halla','Francis','hallafrancis1373@aol.org','1-533-663-4693','%B7482187312886421^QrelvvwTwvdkd^00052459684?3','2023-01-02 18:37:59',null,null,3),
  ('Hannah','Stevens','h.stevens@hotmail.com','(134) 225-0983','%B6324746414169453^ManeoedWywdxr^8903402253?7','2023-02-20 17:00:29',null,null,2),
  ('Cynthia','Schmidt','cynthia_schmidt9485@icloud.edu','1-640-562-3553','%B8135754861051660^QwgikddWnrxmg^40078408165?6','2023-01-12 21:47:48',null,null,3),
  ('Baker','Hooper','bhooper4132@google.com','1-828-402-5432','%B8734654096144561^YswxkmbXnxwnc^3212167524?7','2023-02-12 08:20:25',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Brianna','Morton','b_morton@aol.edu','1-667-983-7816','%B8223177213467433^OtkwtqkRvvhyd^0102349651? ','2023-03-12 10:47:51',null,null,2),
  ('Rashad','Mathis','mrashad6473@icloud.ca','(896) 727-1442','%B9778174741877534^HmdbwdwPskqtj^97073462?4','2023-02-19 23:11:37',null,null,1),
  ('Kelly','Keller','k_kelly@aol.edu','1-678-340-4721','%B5177811187974947^LclevlhPkhwnw^67112722370?7','2023-03-15 16:54:52',null,null,3),
  ('Kiayada','Acosta','kiayada.acosta3758@hotmail.org','(221) 718-9561','%B6212185815485035^ChtbnprYwnnlp^6902305923?6','2023-01-28 21:29:53',null,null,3),
  ('Aimee','Daugherty','a.daugherty@icloud.net','1-540-808-5515','%B5895540748245744^QolfasyBocyhq^14058807?5','2023-03-24 01:11:55',null,null,3),
  ('Dora','Reynolds','dora_reynolds@aol.org','(780) 190-4267','%B5222444758428862^ZqmzewcCtlcdm^9702530258?8','2023-03-10 21:58:19',null,null,1),
  ('Elaine','Garcia','garcia.elaine@hotmail.org','(290) 832-6321','%B4328628161694128^UjnwmioFcrqdr^75115292057?4','2023-02-07 22:23:54',null,null,2),
  ('Xenos','Stevens','s-xenos@protonmail.couk','(682) 526-7438','%B4618047333371655^GyywvxwKvaoox^41114538540?5','2023-02-07 03:45:54',null,null,2),
  ('Macy','Thomas','thomas_macy5011@aol.org','(343) 935-5581','%B7591593301352529^OqkujdsYziefj^74028821316?8','2023-01-05 12:43:25',null,null,3),
  ('Galena','Zamora','g-zamora@hotmail.org','1-685-531-3805','%B7649692201855365^ZcbqwrjHjrxuh^3703522863?6','2023-01-27 05:33:36',null,null,1);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Nicholas','Avery','a_nicholas@google.couk','(327) 981-3618','%B7654625807128750^XssoyxyEjekck^0502758181?2','2023-01-26 22:09:27',null,null,4),
  ('Timon','Webb','wtimon@yahoo.ca','1-584-744-5441','%B4163240413272715^FiihasbWsgccp^9202248660? ','2023-02-14 05:52:29',null,null,2),
  ('Destiny','Tucker','t.destiny1997@protonmail.ca','1-581-951-6141','%B3564976645847697^AghbxurWrmcuy^78066258?7','2023-03-21 00:26:38',null,null,4),
  ('Jackson','Crosby','jcrosby@outlook.ca','1-215-970-7593','%B2832322919367162^TcyjhtkYctnem^01126762?8','2023-01-28 11:16:58',null,null,2),
  ('Chandler','Avery','c.avery8860@outlook.org','1-476-134-6873','%B3671043069933370^YwaruyjUkqoxg^5609956959?5','2023-03-10 18:24:10',null,null,3),
  ('Cairo','Brown','browncairo@protonmail.com','(542) 587-4728','%B7780226233520814^TougttkRxwtbc^7607713387? ','2023-03-01 09:48:15',null,null,4),
  ('Zachary','Nixon','zachary.nixon@google.net','(195) 864-5781','%B5346627803347344^OobbsseRcwckn^5004875210?2','2023-01-16 03:59:23',null,null,3),
  ('Kitra','England','kengland4996@hotmail.org','(418) 706-4559','%B5763985572872472^PkfdfzmDowrty^19121398?7','2023-01-16 09:44:43',null,null,3),
  ('Cameron','Bartlett','cameron_bartlett8347@google.edu','(451) 974-3438','%B8576816113072180^NuxskpmUwratd^1004892727?5','2023-02-06 15:49:15',null,null,2),
  ('Shaeleigh','Burris','burrisshaeleigh2968@hotmail.edu','(869) 764-9158','%B4662586835639632^JninfrvClohpw^2804135491?5','2023-02-23 07:25:08',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Lael','Hubbard','hubbardlael6727@outlook.ca','(925) 583-9564','%B9388664115322920^FygminjJtmwsh^7912549875?1','2023-02-09 02:08:39',null,null,3),
  ('Ora','Hobbs','o-hobbs@yahoo.com','1-945-141-1587','%B1481566827122248^HmcxbjgJgjrlc^7010692894?7','2023-03-06 05:08:14',null,null,2),
  ('Brendan','Marks','brendanmarks6453@icloud.edu','(616) 863-3167','%B5776889044814334^ObencsyTehjgr^5801850531?6','2023-02-11 01:15:58',null,null,3),
  ('Samson','Clements','clements_samson@outlook.couk','1-245-673-2515','%B6836380136858898^UxffnffQevjsc^0408924271?6','2023-02-15 07:33:40',null,null,3),
  ('Veda','Nichols','v-nichols@icloud.net','(828) 371-5398','%B2293841157573792^CkhbvjcDlcgvy^7811426467?5','2023-03-26 00:04:47',null,null,4),
  ('Raymond','Higgins','h.raymond6785@hotmail.net','(913) 984-0041','%B8568242733575443^EqevnbxVuwqgi^41055964126?1','2023-02-15 13:07:40',null,null,3),
  ('Gavin','Willis','g_willis@protonmail.org','1-450-652-9976','%B8877537696860615^VdxyppkFxqxfu^7812638630?8','2023-01-16 14:44:21',null,null,2),
  ('Kirestin','Hines','hineskirestin@aol.couk','(141) 456-5330','%B6918723077132715^WqyyywaEyaodu^6404791266?9','2023-01-23 06:25:53',null,null,2),
  ('Vincent','Ruiz','ruizvincent5370@outlook.edu','(586) 841-5253','%B8041233564728484^KpkoilpZnowhc^8811728390?6','2023-02-28 01:57:49',null,null,2),
  ('Farrah','Wright','f-wright7371@hotmail.edu','1-296-855-1021','%B9664656188785164^BfjvorsJvvruy^6906135491?2','2023-01-28 22:05:58',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Gretchen','Terry','terry-gretchen8975@yahoo.ca','1-584-642-5632','%B3782728857286268^VkvrvyzPjwixs^66095788832?6','2023-02-10 11:12:57',null,null,1),
  ('Dacey','Ryan','r.dacey@protonmail.org','1-184-384-8755','%B5856793126466124^PszfgowLehfcq^03074183?1','2023-03-17 02:46:26',null,null,3),
  ('Phoebe','Robinson','robinson_phoebe1085@protonmail.ca','1-253-535-5517','%B9624862529400217^CxwffngUpgfou^66084629314?3','2023-02-10 04:46:03',null,null,3),
  ('Bethany','Skinner','sbethany6798@outlook.edu','(378) 975-6645','%B8018796343234692^WqbskouUckdcm^2711841707?5','2023-02-17 15:14:30',null,null,2),
  ('Marshall','Pickett','marshall-pickett1425@aol.org','(754) 982-2554','%B9813420991841638^VfjmrjlDvdwof^03122058051?8','2023-01-18 14:00:09',null,null,3),
  ('Shoshana','Ewing','sewing3218@protonmail.org','(530) 557-7780','%B8866576533908622^AomfvydDobvfo^12111435047?6','2023-01-30 18:03:52',null,null,3),
  ('Phoebe','Payne','p.payne@yahoo.couk','1-236-531-1134','%B5556387744861213^VrkzndmHxysus^4809455180?5','2023-03-20 05:44:36',null,null,2),
  ('Stephen','Rodgers','srodgers4592@hotmail.com','(227) 173-9785','%B7857768542185234^SuhqsofGbdopf^3204993133?8','2023-02-23 14:30:44',null,null,1),
  ('Whitney','Marks','w-marks7424@protonmail.net','(686) 718-8225','%B5638630277682250^TnjojrkClcrkp^87029102278?6','2023-01-19 06:05:33',null,null,3),
  ('Edan','Roberts','eroberts5549@aol.couk','1-581-876-3477','%B7503487466588468^OuytpypExjspn^8703142621?4','2023-02-06 01:49:24',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Xena','Levy','l_xena2890@aol.org','1-950-482-3074','%B5849537543310650^KvifkpnFxrryq^38082365144?1','2023-03-17 20:12:11',null,null,1),
  ('Autumn','Olsen','a.olsen5764@icloud.org','(674) 236-2545','%B9622864092123654^YevtvlgOtttcs^7406499509?2','2023-02-23 05:53:50',null,null,1),
  ('Kelsie','Hammond','h-kelsie7329@outlook.com','(830) 884-0224','%B7714772428872475^XsvtleyLwyvna^6702464999?3','2023-01-23 17:44:54',null,null,2),
  ('Ann','Hodge','ann-hodge2562@yahoo.net','1-448-477-6698','%B7584338914205805^UokqluvRdhcjm^4711659617?8','2023-01-13 17:05:14',null,null,4),
  ('Kimberley','Spears','kimberley-spears1244@icloud.net','1-895-685-0515','%B4213456534574688^PcnxlkvJfhkcl^1511637736?9','2023-01-07 03:03:34',null,null,4),
  ('Kenyon','Briggs','kenyonbriggs@hotmail.org','1-684-812-7785','%B9960378461413227^PnmpuyoTvvvdj^0407339758?1','2023-02-27 11:24:39',null,null,3),
  ('Brianna','Sellers','b_sellers9257@outlook.ca','(557) 852-6670','%B3771931966644734^SfexfxfWojujn^49103125851?8','2023-01-23 23:36:41',null,null,3),
  ('Meredith','Avila','m-avila@google.edu','(479) 166-2985','%B3557128446430342^WlryzkbSkasxj^31066835?4','2023-01-09 09:02:53',null,null,3),
  ('Hanna','Hays','hays_hanna6143@google.com','(583) 260-6860','%B7608047969773132^VnlyqtvDlrroh^23125138501? ','2023-03-22 00:55:56',null,null,3),
  ('Thaddeus','Mccormick','tmccormick@outlook.org','(619) 688-3286','%B5306177746095516^LouinspNinimm^1807724716?8','2023-01-14 22:54:52',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Oliver','Wallace','w-oliver@icloud.ca','(891) 455-7255','%B4868522131112844^XrhdoynXgtvuu^6303234831?2','2023-01-07 16:01:18',null,null,3),
  ('Dacey','Lyons','lyons.dacey@protonmail.net','(522) 185-8518','%B7733359551171306^MtfysyuPcosii^48072362389?3','2023-01-09 21:19:29',null,null,3),
  ('Audrey','Cote','coteaudrey6526@protonmail.com','(335) 102-2052','%B6322978282420617^FksdgokItxtqu^1212466931?8','2023-03-23 18:35:58',null,null,4),
  ('Deacon','Chan','chandeacon@google.net','1-391-236-4941','%B7597455878807581^CwrcxjrGbtxpd^8908518411?7','2023-03-05 10:07:01',null,null,2),
  ('Honorato','Morales','morales_honorato@protonmail.org','(329) 359-1566','%B6672256063017913^JfgekeoQnbodm^75059541150?8','2023-03-12 11:51:58',null,null,1),
  ('Dante','Rodriguez','dante_rodriguez1549@google.couk','(814) 349-0814','%B8396185782825496^IxiglebHfogur^07119487?4','2023-01-11 23:41:41',null,null,2),
  ('Iris','Meadows','meadows_iris@icloud.couk','(376) 583-6128','%B7784159177432337^EvspcclPdoczl^08082959420?8','2023-02-18 21:42:22',null,null,3),
  ('Cullen','Ayers','c_ayers1899@yahoo.edu','(312) 307-5343','%B2283667448712023^BphvrmoKdpvyw^19127904? ','2023-01-15 11:11:28',null,null,3),
  ('Marvin','Stuart','marvin.stuart5420@yahoo.couk','1-728-382-9573','%B3777396032351082^QzvlvfqJcayhc^34061616?4','2023-02-23 03:13:46',null,null,2),
  ('Stephen','Hodge','shodge9862@protonmail.net','1-746-417-8726','%B4584001696126877^XjhjeogHkswqt^11049967?9','2023-02-28 18:50:06',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Graiden','Hayes','h_graiden6034@yahoo.com','(557) 955-4212','%B9977246217506375^UiyjqnmVgticb^7503228820?2','2023-03-04 07:09:53',null,null,3),
  ('Chiquita','Wiley','chiquita.wiley@icloud.edu','(873) 656-3135','%B3669287661231144^UeijhilKoqgxb^38061956?3','2023-01-19 23:05:33',null,null,4),
  ('Hunter','Livingston','livingstonhunter4888@hotmail.net','(251) 336-6885','%B7949757262334606^BniqkgcSfqbwu^46104915055?1','2023-01-20 11:49:59',null,null,1),
  ('Lois','Frank','frank-lois@google.ca','(697) 212-6673','%B6768408041676520^NmvnogvClqsfe^55077938087?8','2023-01-20 22:59:56',null,null,1),
  ('Tanner','Walters','t-walters6960@yahoo.net','(803) 324-3337','%B7787675637852427^GzxsvfiEpjogh^7109607920?2','2023-01-16 18:53:16',null,null,4),
  ('Otto','Mcbride','o.mcbride3666@aol.couk','(120) 492-9002','%B2188718146120492^IfuzlejKmudew^84034038?1','2023-01-13 04:22:36',null,null,3),
  ('Cynthia','Dodson','cdodson8046@protonmail.edu','(588) 360-2052','%B4226236363932653^QlfdhbsRwxnrw^45098944?4','2023-01-09 05:50:23',null,null,2),
  ('Elmo','Petersen','e.petersen@protonmail.ca','(758) 468-2381','%B1372181345206344^NhjsrfwIweivx^0708114196?7','2023-03-06 11:10:41',null,null,3),
  ('Herman','Acevedo','acevedo.herman@yahoo.net','1-291-725-8658','%B6423853169714217^IcsjrpuViygki^83083111828?1','2023-02-16 09:43:39',null,null,3),
  ('Honorato','Conrad','h_conrad@hotmail.org','(889) 164-4754','%B9227023977178847^LztasfiZwzzbo^85066334118? ','2023-03-13 15:09:40',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Quinlan','Robbins','robbins_quinlan@google.org','(796) 462-9072','%B7402456463168354^QijqgpcWcubmh^9208801122?5','2023-01-15 23:26:12',null,null,3),
  ('Malachi','Salinas','m.salinas@google.com','(666) 530-6739','%B7266956570710714^MofpkmuEqbrwq^16054623?3','2023-01-24 11:52:04',null,null,2),
  ('Luke','Holland','holland-luke@outlook.net','1-472-842-6524','%B3586125585237456^YdgeijzUisiud^38104081495?8','2023-02-14 08:02:12',null,null,3),
  ('Ulla','Bradshaw','u-bradshaw8613@yahoo.org','(832) 386-3630','%B2287795258778011^JilqbvtPaocni^43103395316?4','2023-02-27 23:34:41',null,null,3),
  ('Frances','Riggs','f-riggs1704@aol.edu','(649) 715-4019','%B4837335855964332^SuqwgxkGubevi^38081227485?5','2023-03-17 13:44:22',null,null,2),
  ('Rowan','Tran','tranrowan@outlook.net','(326) 740-4163','%B8871418308667028^PudrwfkAogyqx^8405891912?7','2023-03-18 19:43:25',null,null,2),
  ('Perry','Marks','marks_perry@hotmail.couk','(752) 526-4012','%B2414786771119144^CmkuilgWykujo^2604439856?7','2023-02-23 12:00:36',null,null,2),
  ('Candice','Parsons','parsons_candice@icloud.couk','1-281-268-1838','%B5727028540640572^OthjkqcSlfimp^55114372822?4','2023-01-23 10:20:05',null,null,2),
  ('Nehru','Greene','n_greene8745@aol.couk','(793) 953-0767','%B5885613641246623^FwpxehtEjycby^4108713397?7','2023-03-11 19:58:02',null,null,2),
  ('Odysseus','Raymond','o-raymond3444@icloud.edu','1-455-623-5993','%B5519754322051772^GmtjwomKgbwjh^1209489209?6','2023-01-18 17:45:45',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Wynter','Parrish','wparrish@icloud.net','1-362-861-1608','%B4093707921456589^FmqciobDikrqs^22028509?1','2023-02-03 03:30:05',null,null,4),
  ('Allen','Petersen','a-petersen125@hotmail.org','1-570-691-5443','%B7631543551234751^XvjrpfmEmycuu^51098868?1','2023-02-06 02:08:03',null,null,2),
  ('Conan','Crane','crane.conan@aol.couk','1-759-497-7328','%B7655923766545144^YvvvqahEfvbrc^68032995441?8','2023-01-27 12:43:13',null,null,3),
  ('Rafael','Lester','lester-rafael7221@outlook.net','(787) 335-0911','%B7464147883579515^KfmdyhkNmrmnx^02083417012?9','2023-02-16 03:25:42',null,null,4),
  ('Galena','Gross','g.gross@hotmail.net','1-307-942-0300','%B3989143496944965^GjjseduVasobz^7911352891?7','2023-01-31 22:39:49',null,null,4),
  ('Sawyer','Stokes','stokes-sawyer@icloud.couk','(693) 685-0019','%B4512508455215692^NxrpuknTbdubj^5203552932?2','2023-01-17 21:48:22',null,null,4),
  ('Bo','Larson','l.bo2532@aol.org','(788) 931-2506','%B8763871185761926^KynfuxqLvxjml^43067776052?8','2023-02-18 02:14:51',null,null,3),
  ('Dalton','Ayers','d.ayers805@hotmail.com','1-794-815-3135','%B3942619351470682^QleqowzTgwkbh^80099372?8','2023-03-02 19:57:47',null,null,4),
  ('Juliet','Black','jblack1915@hotmail.com','(244) 258-7626','%B4764845265841968^FzdmgkhCelaev^1510312174?3','2023-01-24 14:11:53',null,null,3),
  ('Glenna','Wood','g-wood3942@protonmail.couk','1-255-639-1429','%B3638136335828151^VcwcejjNjqsmp^1302682198?8','2023-02-14 08:05:49',null,null,1);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Zeph','Clayton','zeph.clayton@yahoo.ca','(751) 245-1069','%B1335268286815597^RmjgxtfPjqwdg^5205703846?1','2023-02-13 19:35:00',null,null,2),
  ('Asher','Burton','aburton8651@protonmail.com','1-745-175-6417','%B5322747977871845^UlmxeoiAtrlqu^47011997691?1','2023-01-09 04:17:10',null,null,1),
  ('Cullen','Wood','wood_cullen7652@google.net','1-736-215-6813','%B5122884461147785^RtpbtggLmwtpk^0908421123?6','2023-01-09 01:39:44',null,null,3),
  ('Cara','Hodge','c_hodge3095@hotmail.com','1-227-835-7186','%B7865191969029756^DoikaobPzwwgm^1604558120?5','2023-02-13 21:11:38',null,null,3),
  ('Victoria','Henson','victoriahenson5771@outlook.org','(984) 507-2273','%B6888385725672828^VitymkjPnrjsc^62021374?5','2023-01-13 19:51:09',null,null,2),
  ('Rosalyn','Browning','r.browning8815@protonmail.net','(815) 536-7769','%B8592187074657178^BjuetknEfslwb^7509488270?2','2023-01-19 16:43:30',null,null,1),
  ('Bell','Richmond','bell.richmond@google.net','1-884-611-8450','%B5135859228451623^WywlwydCxrsxr^27112884?8','2023-01-20 05:47:28',null,null,2),
  ('Amal','Mendoza','mendoza-amal9147@aol.com','1-392-429-2289','%B6135268583343815^HmhgflxXykmxu^85064073?8','2023-03-16 15:49:44',null,null,2),
  ('Keith','Douglas','douglas.keith33@icloud.net','1-983-441-7827','%B3652707725047359^NadmatoWvmmvn^70051124635?5','2023-01-09 12:33:15',null,null,3),
  ('Amber','Ballard','a_ballard7574@aol.ca','(336) 677-7143','%B2121068657159665^GfytbliQhhvym^8709877709?2','2023-01-19 21:15:25',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Thaddeus','Buckner','b-thaddeus@yahoo.edu','1-119-956-7296','%B6788463779846718^KvntwhmRfhyie^44092657867?6','2023-02-16 07:59:41',null,null,3),
  ('Xaviera','Ayers','xaviera.ayers936@icloud.net','1-685-797-7617','%B6919401719736891^DlpopztYrfreh^27034606?8','2023-02-17 18:33:52',null,null,2),
  ('Bruno','Battle','battle_bruno7375@icloud.ca','(553) 441-1425','%B8630211544501188^EzwxkmiRdgbux^5809173767?1','2023-02-28 21:47:11',null,null,2),
  ('Ferdinand','Pope','pope.ferdinand@outlook.org','(616) 238-5360','%B7274241556222477^RjrwcxeXqmtyd^2506213289?7','2023-03-27 18:45:02',null,null,2),
  ('Quentin','Golden','q.golden423@protonmail.edu','(772) 482-4196','%B4811887836375029^IcvhgsrQjwiyx^46106825045?2','2023-03-08 22:27:22',null,null,2),
  ('September','Benton','september_benton@hotmail.ca','1-184-948-5263','%B9756226621211841^DstsydoDxkson^81085683871?2','2023-02-19 18:39:25',null,null,3),
  ('Rhonda','Bolton','rhondabolton5027@aol.com','1-426-157-7534','%B8362612262666185^RsxogiiBfndlr^90117086097?9','2023-02-20 09:48:45',null,null,4),
  ('Jameson','Alvarez','alvarez-jameson7614@aol.org','1-784-313-8173','%B6305858448284361^PrxoxafJwjnie^5506681437?7','2023-01-07 15:40:55',null,null,4),
  ('Keefe','Walters','w.keefe@aol.couk','(824) 660-2362','%B2521950056227217^GbkbuteCgxkjt^44087665? ','2023-02-12 06:28:04',null,null,1),
  ('Camilla','Rutledge','rutledge.camilla@yahoo.edu','1-653-162-7496','%B2226293211895259^NimfwbqJpfoei^05046999? ','2023-02-04 04:59:40',null,null,3);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Faith','Keller','f-keller1508@outlook.edu','(451) 662-0341','%B8976710005246959^JajcfksImrdvx^02077178739?7','2023-01-31 13:53:56',null,null,1),
  ('Karen','Butler','kbutler@google.org','(122) 664-8257','%B9951033211766755^XcutmvmOhaxmi^9210903787?1','2023-01-29 15:43:42',null,null,4),
  ('Lisandra','Houston','hlisandra@yahoo.net','1-667-743-6712','%B2353341062733384^HmqsfkxUpbtig^53082212566?2','2023-02-16 07:15:32',null,null,2),
  ('Mona','Cash','m-cash@hotmail.ca','(833) 444-8310','%B3274492963416272^BwqiuzwRfmjpy^70022567795?3','2023-03-20 14:10:04',null,null,2),
  ('Isaac','Newton','newton.isaac@icloud.ca','(658) 234-2471','%B8037400872688954^LhnjhobVjphwz^91114473739?7','2023-02-28 22:15:47',null,null,1),
  ('Ray','Gutierrez','ray_gutierrez3698@icloud.net','1-737-220-9171','%B6873916287573152^YzmxkxnQcewug^6810930866?6','2023-01-16 20:20:10',null,null,1),
  ('Whilemina','Branch','bwhilemina2424@hotmail.edu','1-770-104-7544','%B6511379515744345^EraxakqEwdgff^88046455017?8','2023-01-18 05:32:40',null,null,1),
  ('Lee','Petty','petty.lee7163@hotmail.couk','(238) 731-2624','%B4752032361168916^UxabxrkCcxlks^69093178?1','2023-01-28 07:48:52',null,null,3),
  ('Sawyer','Erickson','erickson.sawyer@protonmail.edu','1-135-843-9227','%B8168058705541825^TjxyeskLuvgeo^50023202?7','2023-01-24 07:26:41',null,null,2),
  ('Russell','Holden','h.russell@yahoo.edu','1-908-180-3096','%B8262947730733130^QbbytdxVjgusw^2911254406?5','2023-01-15 09:21:51',null,null,4);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Hannah','Stephenson','h.stephenson1585@protonmail.net','1-473-685-5113','%B3854573121555696^RpsjjyyPdivul^3605165734?5','2023-02-18 06:44:25',null,null,2),
  ('Brian','Best','bestbrian4275@hotmail.net','1-438-242-7277','%B2437154868801709^IcgxchiFtqunk^9908981498? ','2023-03-25 15:35:06',null,null,3),
  ('Quynn','Cantrell','cantrell-quynn@icloud.ca','1-404-265-8817','%B3905882317337504^WxnvxmpHynnok^04014032297?7','2023-02-24 03:10:36',null,null,2),
  ('Harper','Adkins','h_adkins8172@outlook.org','(382) 807-3831','%B1915413375648955^BxsircrRhgefz^68018567?7','2023-01-17 19:58:29',null,null,3),
  ('Jarrod','Greene','j.greene@hotmail.com','(142) 262-2842','%B3352628387781679^XtudwiwCbtcvj^1609844883?2','2023-03-13 23:19:44',null,null,3),
  ('Audrey','Schneider','schneider_audrey5172@hotmail.ca','(853) 156-5965','%B6271278205716831^BcrrnepWpfbgj^48035166228?1','2023-02-24 23:16:18',null,null,3),
  ('Hammett','Stafford','hammett_stafford@google.com','1-812-404-1403','%B9362218617553331^PjqyewfRbpcuu^16042334259?2','2023-02-25 15:51:34',null,null,1),
  ('Kasimir','Church','church.kasimir2441@icloud.edu','(533) 833-6858','%B4311238787544226^GeklwquHqbynd^1405774186?6','2023-02-12 16:08:56',null,null,3),
  ('Lareina','Paul','p_lareina2069@hotmail.couk','(971) 854-3886','%B3249838866434293^UrcoteuElknfc^1201848226?1','2023-03-01 17:45:46',null,null,1),
  ('Joel','Zamora','joel-zamora3106@yahoo.com','1-307-313-5531','%B1793492729261604^XgjqwhiZisnrs^95086355?6','2023-02-24 21:11:18',null,null,3);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Trevor','Holman','holman.trevor557@hotmail.com','1-354-502-7376','%B2157656220746786^KwgiyjjImklqa^9401599434?4','2023-02-23 14:00:15',null,null,4),
  ('Kerry','Cotton','kcotton251@yahoo.org','(997) 841-6364','%B7426232319402559^XxaubuoTkfwwx^83082405?2','2023-03-08 23:22:44',null,null,4),
  ('Tatyana','Griffith','t.griffith@yahoo.net','1-134-722-0217','%B4738035588734551^WyortucHloygj^21036267?6','2023-03-09 00:51:10',null,null,2),
  ('Shay','Gamble','gamble_shay@outlook.com','(576) 758-5664','%B8157665249699362^YgzedaoLmqieb^6410932442?1','2023-01-19 17:30:08',null,null,3),
  ('Rahim','Bray','rahim-bray@hotmail.org','1-693-323-7871','%B4158784818737583^FnkmmnfPwnbhm^9107947488?6','2023-01-15 21:11:37',null,null,3),
  ('Suki','Lara','lara-suki@yahoo.com','1-813-423-4218','%B7141415783305428^QoyoukwSlxynr^64013055?8','2023-03-26 21:31:24',null,null,1),
  ('Angelica','Meyer','angelica_meyer5459@yahoo.net','1-838-362-8748','%B9544583525285377^XcuwfytUtduvp^5305573892?9','2023-01-25 02:56:15',null,null,4),
  ('Lana','Frederick','l.frederick2313@protonmail.org','1-755-218-9961','%B6318462535868376^KxqllwzNgxdlc^12074577875?4','2023-01-11 15:26:42',null,null,1),
  ('Colorado','Sloan','sloan-colorado@aol.com','(672) 771-6475','%B8555020307558387^XrrfwxpRgqtnq^57083156?8','2023-01-03 20:04:07',null,null,2),
  ('Alfonso','Chase','achase@icloud.ca','(973) 804-4513','%B7733379441758204^TilegcfMstgxt^29109099757?8','2023-01-25 13:51:53',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Destiny','Weeks','destiny-weeks7582@outlook.net','1-777-671-6782','%B7277666732523478^JccompyYmxuqp^00053459742?9','2023-03-28 17:33:00',null,null,2),
  ('Dalton','Cannon','d.cannon6132@icloud.ca','1-301-688-4340','%B6439872166716111^JowfcnvFtjfmo^7810629288?3','2023-01-27 01:08:50',null,null,3),
  ('Kevyn','Bowman','k_bowman6248@protonmail.org','(705) 332-6967','%B5241629148043149^KeyckquRdedbg^7302306208?9','2023-03-12 04:19:24',null,null,3),
  ('Simone','Padilla','s.padilla5906@google.org','(170) 343-6722','%B8433763240630569^GcjefqzOyfbqv^02076562964?2','2023-01-04 10:45:42',null,null,3),
  ('Vivien','Griffin','g-vivien4425@yahoo.ca','(926) 889-1581','%B5163623790876227^UjhcmgdDkbybq^4510597575?5','2023-03-20 18:15:15',null,null,3),
  ('Wynter','Burch','wynterburch@icloud.org','(696) 580-1415','%B8793854652455732^RmxsvibNjbqjx^31059324?8','2023-03-03 16:33:43',null,null,2),
  ('Samantha','Fuentes','f-samantha9413@icloud.net','(374) 175-9973','%B5775785115206302^YksvqmzLvjcqj^4804546307?7','2023-02-10 03:36:28',null,null,1),
  ('Barclay','Hebert','barclay.hebert@hotmail.edu','(597) 391-2504','%B2544558252518217^EfhylkiIevxwc^15041434004?2','2023-02-19 04:50:49',null,null,2),
  ('Nomlanga','Chan','chan_nomlanga7023@icloud.couk','1-966-730-2256','%B3759885611841438^HqxxshaLbunbe^7906460511?2','2023-01-19 12:15:46',null,null,2),
  ('Rooney','Tyson','rooney.tyson5312@yahoo.org','1-424-238-6542','%B6324266756235880^QdeqeakDyhxup^30109959?3','2023-02-18 02:58:36',null,null,4);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Kane','Dean','kdean9516@hotmail.ca','(348) 791-4569','%B6843782502539814^ApmhrnmQoxrbd^74057502?8','2023-03-08 14:12:55',null,null,3),
  ('Kevyn','Martin','k_martin@aol.com','1-507-129-4893','%B5321171860314473^OtfgyemXiikqj^81033626?4','2023-03-27 01:01:08',null,null,2),
  ('Lewis','Dickson','dickson_lewis6583@yahoo.net','(206) 686-6193','%B7007340718609645^EafmxebMbzmzx^64108867254? ','2023-01-08 06:36:29',null,null,1),
  ('Fritz','Holland','f.holland6132@icloud.net','1-330-631-5682','%B8586767388421883^FxicuvpPftjpr^80028823313?5','2023-01-11 17:26:25',null,null,3),
  ('Medge','Murray','murraymedge9190@icloud.net','1-348-572-3168','%B7159928061873211^NflwnxnIibviz^1310918630?1','2023-01-25 00:28:27',null,null,2),
  ('Aidan','Barton','barton-aidan@protonmail.org','1-272-337-1808','%B5235194471350195^VargwxrZmcdre^1409211469?5','2023-02-26 08:38:40',null,null,1),
  ('Arsenio','England','england.arsenio7330@protonmail.net','1-946-889-7254','%B4733116173682419^VckavhlHunvpt^39097323?3','2023-02-01 04:00:07',null,null,2),
  ('William','Diaz','williamdiaz@hotmail.com','1-463-655-9605','%B5936628520160139^MuqhcozJkkneb^6608147336?8','2023-02-04 06:47:56',null,null,4),
  ('Shad','Gilmore','s.gilmore@aol.edu','1-497-529-6713','%B4880936474737381^LdnqhfqTklghb^48033999?6','2023-01-08 23:12:27',null,null,3),
  ('Baxter','Mccoy','mccoy.baxter8361@outlook.org','1-538-445-6665','%B6238866655164738^YfffyixIswily^3508600759?6','2023-02-02 21:08:08',null,null,3);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Hayfa','Dean','d-hayfa2837@protonmail.ca','(257) 574-4584','%B5194072069127279^HcizlzkNbmcqh^7503237550?5','2023-03-14 09:40:28',null,null,1),
  ('Lacey','Vargas','l.vargas@google.edu','(253) 375-3098','%B4273575176553315^CoffkqoLjltto^9603600968?7','2023-01-15 15:16:15',null,null,4),
  ('Raymond','Ramirez','raymond_ramirez@yahoo.com','1-514-467-6848','%B6252205066022289^OnejnlwHmdgcs^16015608913?4','2023-03-05 00:19:06',null,null,3),
  ('Quamar','Mcintosh','q.mcintosh9217@google.net','1-777-868-7244','%B7616268458874266^KbyjnigRcinfm^45086668?5','2023-03-28 11:33:46',null,null,3),
  ('Yetta','Stone','yetta.stone38@protonmail.ca','(764) 794-4034','%B3883480886511325^DgkqcocDzjtpa^5604584489?2','2023-01-31 00:13:26',null,null,3),
  ('Adrian','Hale','haleadrian@yahoo.ca','(615) 601-4250','%B6666446711866719^FfrgroqNnuexq^5606905224?4','2023-01-22 08:27:52',null,null,1),
  ('Paula','Hale','halepaula@hotmail.com','(425) 814-1751','%B7034512236420438^NjqskjqJcpxbj^7604694812?3','2023-02-07 00:03:20',null,null,2),
  ('Lucius','Douglas','ldouglas@protonmail.ca','1-978-567-5919','%B8436517152964885^HvwwmpeDpbwdw^0703965970?1','2023-03-03 09:32:35',null,null,3),
  ('Halla','Tillman','tillmanhalla@yahoo.edu','(292) 671-6121','%B6521820877138472^XydsymqNdtlow^0109257206?2','2023-03-17 17:10:56',null,null,4),
  ('Mona','Gonzales','mona_gonzales8469@google.ca','(532) 861-3118','%B5312153562437521^SwlftgoNaqkfh^7002585867?7','2023-03-24 20:17:08',null,null,3);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Lareina','Medina','lareina-medina@aol.net','(854) 418-3114','%B7068173967814456^RbidpbhUigodd^65102667?5','2023-03-08 03:09:16',null,null,3),
  ('Ria','Dodson','r_dodson@google.net','(653) 828-9235','%B5955527987716432^YqgwckeBpuwek^23097589506?4','2023-03-09 06:50:43',null,null,2),
  ('Leigh','King','l.king@outlook.com','(922) 351-2491','%B5371204835323314^XddvgvlDeffdv^9408285609?5','2023-02-01 10:56:56',null,null,4),
  ('Nola','Allison','n_allison6335@icloud.org','(655) 246-6392','%B8324451326664436^JxlkaltNibteb^9710253493?7','2023-02-01 11:38:13',null,null,2),
  ('Peter','Fulton','fulton-peter8906@outlook.couk','1-253-544-6391','%B4128123743056394^OfegckbIwgdxc^6411812174?4','2023-02-27 06:40:13',null,null,2),
  ('Tanek','Strong','strong-tanek2593@yahoo.net','1-948-645-3497','%B7192441632874773^FymcoiqVdbqtx^0301257981?8','2023-03-03 00:50:09',null,null,1),
  ('Kiona','Mayo','k.mayo2524@hotmail.edu','(863) 840-6779','%B3039451233371123^GhlkgdyFkpwky^35075258014?7','2023-02-02 02:50:16',null,null,2),
  ('Lee','Price','lprice6857@google.com','(166) 744-8261','%B1968979355663729^BhnkcvbCqbdkq^60098904529?2','2023-01-27 12:28:41',null,null,2),
  ('Jayme','Gilliam','gjayme7798@hotmail.ca','(746) 836-6222','%B5431749678028625^PppqisiHxqudw^40064064?6','2023-01-04 02:11:25',null,null,2),
  ('Faith','Knapp','knapp.faith@yahoo.net','(623) 961-3384','%B8458693641765322^EkuyvkdIxqjet^36097303623?8','2023-02-01 11:50:13',null,null,1);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Wade','Lawrence','wade_lawrence@google.ca','(444) 672-2536','%B9583964723126570^DfxcoseOslxdr^48112201?3','2023-02-19 08:36:44',null,null,1),
  ('Samantha','Reese','samantha-reese@google.ca','1-682-211-7229','%B1668684333567934^NfmqqhfMwgcqc^9610646832?2','2023-02-17 18:09:33',null,null,3),
  ('Iola','Owens','owens.iola1017@yahoo.edu','1-451-337-1955','%B3606162446172079^DqlxrbqBdczep^9707582703?5','2023-01-14 12:58:32',null,null,1),
  ('Flavia','Chavez','f_chavez@hotmail.net','(778) 425-1692','%B7735442322885188^CuwjkpsDnvwid^9008335307?5','2023-03-05 22:08:11',null,null,3),
  ('Maxine','Espinoza','espinozamaxine@icloud.couk','1-591-537-9759','%B9356255515821827^WknxfftTcgmoo^24122498696?2','2023-01-27 04:26:16',null,null,1),
  ('Brittany','Glover','b_glover2548@hotmail.ca','1-626-331-9960','%B7573018545996313^AbucpoeSqckjf^43121567592?2','2023-03-04 04:23:09',null,null,2),
  ('Jenette','Beard','beardjenette16@hotmail.couk','(466) 602-1768','%B7088587365914448^ClmtlkuCwjexe^3111730416? ','2023-03-14 15:17:50',null,null,3),
  ('Zenia','Bird','zenia.bird@icloud.org','1-551-857-8322','%B5677444088917397^TpjhqevUxjelo^9508929351?4','2023-02-21 12:35:12',null,null,3),
  ('Harper','Collins','collins.harper@outlook.ca','(523) 568-6831','%B7174615456814081^GpjvkqtGwehyi^6710909802?1','2023-03-04 06:14:38',null,null,3),
  ('Samuel','Rose','s-rose4727@protonmail.com','1-816-927-2620','%B8174732861640039^NihldueRbpxpj^3502490644?3','2023-03-17 00:05:59',null,null,3);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Rudyard','Stewart','rstewart@yahoo.org','1-796-625-1098','%B6380322685884299^PhnlhqpQvbekk^23045167712?1','2023-01-01 20:45:25',null,null,2),
  ('Damon','Norton','dnorton@yahoo.ca','1-869-888-4217','%B4946631941511806^EjqdwvjGqyhvl^34119839?8','2023-02-25 14:02:17',null,null,2),
  ('Eagan','Mendez','e.mendez@outlook.com','(704) 420-4711','%B7672869411634843^ZfnjtvvWdoxfw^29117003516?6','2023-03-16 10:46:02',null,null,3),
  ('Lee','Parrish','l.parrish@google.ca','1-267-483-4625','%B3789373255178578^EsybtxoRbjjoi^1505160953?7','2023-02-14 20:01:06',null,null,1),
  ('Laurel','Gregory','g_laurel@protonmail.org','(486) 517-5698','%B5631912544782328^WpbjwfvMfptdv^31026263?3','2023-01-21 17:16:29',null,null,2),
  ('Bo','Strong','b.strong@hotmail.org','(492) 937-6531','%B8269967261911644^LryolciJzqfcs^2606969955?8','2023-01-06 17:11:20',null,null,4),
  ('Davis','Crosby','crosby_davis@protonmail.org','1-884-836-8420','%B2256465836484261^SquydpzFdnpei^0203919649?1','2023-01-05 07:22:25',null,null,2),
  ('David','Hewitt','d-hewitt3204@yahoo.org','1-421-248-4881','%B4548415222182333^CrxuterOgfbct^59075552?1','2023-03-15 22:10:19',null,null,2),
  ('Drake','Levy','levy.drake8291@protonmail.com','1-810-104-3763','%B2541217671020374^LhvnwgzJhwnwt^4105393763?8','2023-02-23 01:30:03',null,null,1),
  ('Bethany','Levy','b-levy483@aol.ca','(333) 985-5531','%B6787310063702458^NdsnvogVeeyik^44084038?6','2023-01-03 11:54:54',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Violet','Villarreal','v-villarreal3829@icloud.org','(867) 644-7541','%B2626854298258867^MeyincgYpbomj^93126534109?5','2023-02-14 16:53:44',null,null,2),
  ('Faith','Burks','burks_faith@outlook.couk','(373) 186-4272','%B4618968845311427^DggwawkXjetrc^9503206524?6','2023-03-13 12:08:19',null,null,3),
  ('Galvin','Stephens','stephens_galvin@yahoo.org','1-251-358-5014','%B3688652349092758^RvpiijgMwqhdc^20033122231?6','2023-03-13 03:39:05',null,null,3),
  ('Jamal','Hess','jhess9181@google.edu','1-530-127-7383','%B3834354493677695^HfuixfsBdnsqy^6204283770?5','2023-01-03 19:23:22',null,null,4),
  ('Raymond','Kelly','kellyraymond8497@google.ca','(537) 276-6194','%B5283143397588842^InryckuGocpsf^62102112?4','2023-02-25 03:34:08',null,null,3),
  ('Ashton','Hammond','a.hammond@protonmail.ca','(471) 863-5151','%B3120126085433268^MngfqcwJpojdv^1004357919?5','2023-03-03 06:24:24',null,null,1),
  ('Ginger','Lara','laraginger3944@protonmail.com','1-684-684-4457','%B4205465622352506^UalhyvuPujiiv^9501414997?6','2023-01-05 01:40:18',null,null,3),
  ('Pamela','Boyd','boyd.pamela@icloud.org','1-466-633-8958','%B7950452637113444^PdfsqssVrfbtw^91037217?7','2023-02-25 04:14:35',null,null,3),
  ('Joel','Porter','j-porter822@icloud.org','(217) 264-0634','%B3808222417147167^SugppxoLtgmar^4003348194?7','2023-02-06 21:10:35',null,null,1),
  ('Willa','Solis','willasolis@protonmail.edu','1-262-372-2788','%B3399504632462535^GuarposBeynqs^1109474401? ','2023-03-06 22:29:30',null,null,3);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Maggie','Cline','c-maggie@hotmail.edu','1-222-745-0821','%B5045427962415491^HwsvywfHohsyh^4809891657?6','2023-03-22 20:07:00',null,null,4),
  ('Pandora','Hunter','hunter_pandora6771@aol.org','1-480-560-4272','%B3242343815894361^IchvwysRkhrsk^3412659134?4','2023-01-14 16:35:38',null,null,3),
  ('Sylvia','Kline','kline-sylvia4525@google.edu','1-420-436-3066','%B7393598156367740^YykryvmMvroco^1310472835?5','2023-03-08 18:53:29',null,null,3),
  ('Lacy','Richard','richardlacy@icloud.com','1-213-276-1473','%B4134255238144048^TriqtliNynpsp^54022398?4','2023-01-07 19:14:51',null,null,3),
  ('Brett','Heath','heath_brett@yahoo.edu','1-698-334-9531','%B8935263122208539^AgvdwpfEbqtqt^72012645?4','2023-02-15 05:34:18',null,null,2),
  ('Abdul','Burris','babdul@aol.net','(256) 919-5704','%B2607547767456108^PkrkknlFdjxxd^2403193372?5','2023-01-21 07:11:32',null,null,2),
  ('Desirae','Schwartz','schwartz-desirae@yahoo.edu','1-889-575-3581','%B9321487072376828^UsflpgoDomncw^95018265?7','2023-01-04 23:01:19',null,null,2),
  ('Austin','Welch','welch-austin9272@aol.edu','1-318-313-3462','%B4847126247132711^GqeezypQpzdil^53119239441?6','2023-03-01 08:58:07',null,null,2),
  ('Karen','Hodge','h.karen@aol.com','1-823-289-6759','%B5150851755234629^PqarplgOshgkh^2912135697?1','2023-03-09 07:23:12',null,null,2),
  ('Craig','Graham','graham_craig3870@yahoo.couk','(924) 513-6531','%B2713914551360839^AhpqohtOuameg^8511712502?6','2023-03-07 02:35:54',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Charde','Ware','cware@outlook.org','(465) 426-4642','%B8035434925621757^PtopnvbRxyrrh^1602530376?3','2023-02-13 23:52:05',null,null,2),
  ('Wynter','Kerr','wynter.kerr@yahoo.couk','1-995-333-1791','%B4531435485722253^JlfjmhrFuuqzb^8008271772?3','2023-01-10 04:59:59',null,null,4),
  ('Zorita','Santiago','szorita@protonmail.ca','(674) 714-3741','%B1854482228474583^MheenxxOlgcav^6103665521?6','2023-03-25 21:28:28',null,null,2),
  ('Mona','Yates','y_mona@protonmail.couk','(837) 138-4324','%B7649193707721095^RghebovQxbkmv^5010346420?2','2023-03-20 00:08:29',null,null,2),
  ('Whoopi','Winters','w-whoopi@protonmail.org','1-917-997-1138','%B6254983244677092^XwqmqfnFgoxdm^39086954?7','2023-02-11 22:20:30',null,null,2),
  ('Colton','Wilson','colton_wilson6708@hotmail.edu','1-574-679-5075','%B7027403119865023^FpfwjhxEhwjky^0101660223?4','2023-02-03 00:41:09',null,null,1),
  ('Ivy','Mcpherson','m_ivy3001@aol.org','1-323-427-9248','%B8216763602559802^LrcckbuMcmbgb^1311674742?7','2023-03-18 18:49:36',null,null,3),
  ('Jemima','Workman','jemima.workman@icloud.edu','(207) 398-8688','%B2749373695728817^CtbbkwzNulgjf^04034492024?1','2023-01-13 11:07:03',null,null,2),
  ('Azalia','Hicks','azalia_hicks@outlook.edu','1-674-556-7914','%B8508908111294067^DeonyogJbpeof^73096567?5','2023-01-27 05:32:36',null,null,3),
  ('Maia','Chase','c-maia5120@aol.net','1-791-448-6317','%B3735946577921661^YcnesjiHtqjyn^15076585?5','2023-02-23 14:23:20',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Darrel','Barnett','dbarnett7831@yahoo.com','(463) 856-8471','%B2812482227817408^IetpgduNiodsn^7707183918?2','2023-03-02 01:49:13',null,null,3),
  ('Price','Shepherd','price.shepherd5256@icloud.ca','1-357-813-8485','%B7708644767065313^QqpuhmiWmayqb^9311823291?3','2023-03-15 03:45:11',null,null,4),
  ('Hammett','Goff','hammett-goff6694@protonmail.edu','1-457-329-7267','%B3686568110251625^AigxucmUuoorq^70076405?6','2023-03-06 04:40:36',null,null,1),
  ('Matthew','French','m_french@yahoo.com','(796) 871-6559','%B3196168788259165^FrzagnsKdtcpc^95111299785?9','2023-01-04 15:42:30',null,null,2),
  ('Jakeem','Decker','d-jakeem@protonmail.couk','(164) 417-8915','%B2957702272134763^PgitfefRygbpf^89072007671?9','2023-03-18 23:24:10',null,null,2),
  ('Candice','Michael','michaelcandice901@google.edu','(622) 743-1796','%B7111585647522480^UtmcrgiMwufcm^4403450561?4','2023-01-17 19:02:41',null,null,2),
  ('Joelle','Tate','t.joelle@yahoo.ca','1-579-125-3840','%B7737032380240316^ZsqttidEkydhc^0403904255?4','2023-01-24 10:21:17',null,null,3),
  ('Adam','Pope','pope_adam@google.edu','1-751-813-5875','%B7655475661479577^RnzodjuMqsghv^7802749228?3','2023-01-04 02:47:35',null,null,3),
  ('Fritz','Moses','f-moses@google.edu','1-563-675-8030','%B5346145448300070^RcjlnpdSwbkon^77104744?7','2023-03-06 14:34:22',null,null,1),
  ('Carissa','Nolan','carissa.nolan@google.couk','(246) 214-7022','%B3185710025386766^JbinifwQrioim^3910255780?6','2023-02-17 06:12:29',null,null,1);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Mona','Myers','mmona9897@icloud.com','(886) 613-2978','%B4712468620773530^QsmvubhEwjyyq^07117146525?1','2023-01-28 14:09:19',null,null,3),
  ('Damian','Mccormick','damian-mccormick6346@aol.couk','1-289-757-4116','%B5126543591806662^IjynppjRglnkw^7402218129?6','2023-03-09 13:04:06',null,null,4),
  ('Leonard','Michael','l.michael@google.org','(740) 724-6114','%B7861466124429566^YmbyqpyBrhgjg^2107970996?7','2023-03-06 06:28:12',null,null,1),
  ('Vance','Hardin','v.hardin@yahoo.edu','1-161-900-3248','%B6735471853295435^ClvjfytQklxoa^7708773732?6','2023-01-29 17:44:18',null,null,2),
  ('Adam','Merritt','adam-merritt@yahoo.org','1-886-351-7678','%B8504118307970393^GsrkgvnFhrxng^86091884414?4','2023-02-17 20:12:22',null,null,4),
  ('Flavia','Franco','francoflavia3982@hotmail.edu','(808) 871-3342','%B1581133244492402^JpslsbyKlbghg^97014153677?6','2023-01-27 23:08:05',null,null,3),
  ('Maisie','Kirk','maisie_kirk@yahoo.ca','1-665-213-8842','%B1260937586732566^DxhxcmcBkvgcc^49119656?2','2023-02-16 20:04:48',null,null,2),
  ('Deanna','Cervantes','cdeanna@google.net','(145) 689-7547','%B3352562544431435^CnofilcPxrywz^1401209474?7','2023-02-26 10:39:40',null,null,3),
  ('Leandra','Bradshaw','bradshaw.leandra9543@icloud.couk','1-356-114-2664','%B4724016165273274^IdjwhljBuopzr^15111498?5','2023-01-22 07:41:17',null,null,3),
  ('Thomas','Cote','cote.thomas@hotmail.ca','1-515-771-1235','%B6844921383487074^PbokumsFerxhn^9212421382?7','2023-02-21 05:30:13',null,null,1);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Deacon','Wynn','wynn.deacon7755@google.org','1-402-347-4808','%B5298556352817585^OatwupiNvqsbp^30061312?1','2023-01-18 00:40:02',null,null,3),
  ('Lance','Valentine','valentine_lance8977@yahoo.org','(531) 766-7798','%B3595257321758820^TvqvxfwHpdprr^2005508701?8','2023-01-18 07:45:56',null,null,2),
  ('Clayton','Griffith','cgriffith8363@outlook.edu','1-106-985-2855','%B2835091171931641^FbxncbmPeefgi^90054007?5','2023-03-26 13:38:25',null,null,3),
  ('Delilah','Petty','petty_delilah2825@icloud.com','1-852-451-9237','%B8357586454799604^YdpvnwkTtpsid^55123064220?3','2023-01-23 13:53:58',null,null,2),
  ('Hedy','Barr','barr.hedy@google.com','1-334-247-6538','%B1654848635638371^EfysnghBopvwb^3509443944?5','2023-02-12 04:07:34',null,null,2),
  ('Hayden','Webster','h.webster4501@outlook.edu','1-265-742-1359','%B5800933441626158^PrtryzvDsqjvx^1408681497?3','2023-01-11 19:17:45',null,null,3),
  ('Eaton','Hill','hill.eaton6318@google.com','(783) 646-1499','%B3482811257573755^QzlqmtoPihgqc^93029623467?5','2023-03-27 08:59:28',null,null,2),
  ('Indigo','Beard','i.beard3711@hotmail.com','(125) 720-7778','%B5348763823378615^UfldjulHoqvmg^3106739968?5','2023-01-28 16:58:47',null,null,2),
  ('Jacob','Mccray','jmccray@outlook.edu','1-924-239-7261','%B5783686218037088^QbbkfslHqvprk^51073408226?7','2023-03-26 23:18:08',null,null,2),
  ('Clarke','Hines','hinesclarke@protonmail.net','1-467-683-3011','%B4210351649259211^XnabykyCujris^61057276?2','2023-01-23 01:59:48',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Patrick','Webb','webb_patrick4719@icloud.couk','1-450-778-2476','%B4775468573535064^BqqrlgvNislio^8901920374?6','2023-02-15 18:04:40',null,null,3),
  ('Hilel','Rich','rhilel7208@protonmail.org','1-962-278-4101','%B2525604844851816^TcvsbwgBsokni^48091162?7','2023-01-21 09:53:51',null,null,1),
  ('Elliott','Pollard','e.pollard3612@yahoo.com','(326) 723-7927','%B5592874089391153^SdnosfqPfddlw^94053247?4','2023-03-16 07:35:52',null,null,3),
  ('Lesley','Barrett','b_lesley@yahoo.net','(718) 474-4185','%B4774453576304452^DhoxihdYidnxd^2302470432?6','2023-03-27 18:22:46',null,null,2),
  ('Wallace','Branch','b-wallace2183@icloud.net','1-431-689-5072','%B2531366043499442^MyghhrdDgpspb^9008983335?4','2023-03-20 06:03:56',null,null,4),
  ('Henry','Haynes','h-haynes265@yahoo.ca','(404) 948-5171','%B7695566030694161^YqlsdkbJfyofq^9408740566?5','2023-03-22 07:33:07',null,null,3),
  ('Porter','Burks','porter.burks@google.net','(370) 728-6891','%B3258116546647866^LawwthsEevmxj^8710748764?6','2023-02-27 11:18:02',null,null,3),
  ('Mannix','Daniels','mdaniels@yahoo.ca','1-211-147-5218','%B2434095963161346^VdxugozNoodxe^3105497784?1','2023-03-18 16:00:02',null,null,4),
  ('Roary','Griffith','griffith-roary@icloud.org','(272) 801-7564','%B2452662333840397^EqyolgoXaxjvl^80082663?3','2023-02-27 00:01:11',null,null,2),
  ('Brynn','Thornton','bthornton9530@hotmail.edu','(561) 314-8835','%B3521658655146211^UgykorwAtccvp^4002270667?6','2023-02-10 16:29:35',null,null,3);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Oleg','Clarke','coleg@google.ca','(641) 400-1651','%B3949918376766640^CqpwuwqMxgnes^6305636897?9','2023-03-21 16:53:02',null,null,4),
  ('Jack','Curtis','curtisjack@google.edu','1-685-599-3873','%B5564825651489368^OsbojimOwsnmq^2607963493?1','2023-03-06 14:47:51',null,null,4),
  ('Yeo','Mclaughlin','mclaughlinyeo@outlook.net','(312) 851-8645','%B5276965428822735^MoitpikQqegcr^62108154159? ','2023-02-22 09:00:38',null,null,3),
  ('Len','Berger','berger.len1447@hotmail.couk','1-376-338-0192','%B2384944222609868^RdnpxdlMppevi^95041608948?5','2023-03-20 07:12:41',null,null,3),
  ('Tamekah','Santos','tamekah-santos@yahoo.ca','(444) 361-4622','%B2611372776455847^BsfsxqbMvbjpc^01087872?5','2023-01-08 05:52:17',null,null,2),
  ('Richard','Dixon','dixon.richard@google.org','(323) 787-5542','%B6171957007419113^RxjmwxsPakwue^7602692735?8','2023-01-17 02:49:13',null,null,2),
  ('Ifeoma','Morse','ifeomamorse2805@icloud.edu','1-114-148-7632','%B4459615684821335^MxwemtrQqqsoz^76028107?8','2023-02-03 11:17:56',null,null,3),
  ('Brody','Davidson','b_davidson@hotmail.ca','(863) 579-8270','%B6410306120808685^WblqtzzKzqssq^2706615586?8','2023-03-16 00:23:28',null,null,3),
  ('Tyrone','Zimmerman','t.zimmerman@outlook.edu','(702) 488-8774','%B6163834734553101^RmmhqxvJcqwxb^2905958406?2','2023-03-14 07:59:20',null,null,4),
  ('Caldwell','Calderon','c-caldwell@protonmail.net','1-544-434-6924','%B6948041312747119^AnjrcivUvuvxw^86072545?8','2023-03-17 18:12:14',null,null,3);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Cole','Richard','rcole5899@hotmail.net','(550) 447-7116','%B3422217389117837^OxosuppSsmoop^96106338012? ','2023-02-18 04:28:01',null,null,2),
  ('Karly','Harmon','karly-harmon4247@hotmail.com','1-818-643-6770','%B5772167086657582^HfewgwrRlxptw^6404400905?7','2023-01-07 18:26:07',null,null,2),
  ('Fulton','Bentley','f.bentley@icloud.org','1-857-617-2762','%B7821634684283272^VsqfcghCqxvtc^27098732?2','2023-03-16 06:39:09',null,null,4),
  ('Ronan','Valenzuela','r-valenzuela@google.edu','(268) 543-3667','%B6195550074257765^MnqdgllUuqzno^1404148780?4','2023-03-10 11:52:37',null,null,3),
  ('Boris','Gilbert','boris_gilbert@hotmail.ca','(648) 335-1762','%B8727261654485452^BphcieePrbuje^23058804207?5','2023-03-03 12:11:27',null,null,2),
  ('Lunea','Haynes','l.haynes@hotmail.com','(812) 843-4935','%B2526787520881166^UhnheioVypydm^1807690475?7','2023-01-05 18:32:06',null,null,1),
  ('Sopoline','Gates','s_gates@hotmail.com','(448) 374-0638','%B5357331959342323^FzrpbxfGazjlm^5702528851?5','2023-02-03 12:56:51',null,null,2),
  ('Rana','Mullins','mullins.rana1922@icloud.org','1-976-659-6946','%B4833870545584535^OadvhjsRrhbet^09117034719?2','2023-01-22 20:36:19',null,null,2),
  ('Baker','French','b_french@google.net','(372) 665-7478','%B2888346655541726^GyppkkiWmvxjh^36106713?3','2023-01-17 18:56:47',null,null,4),
  ('Katelyn','Wiley','wileykatelyn@google.com','1-287-816-2616','%B6656126744028277^MpctgumUsqujv^2305865118?8','2023-01-11 00:29:44',null,null,3);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Daquan','Bennett','bdaquan@hotmail.ca','(934) 423-6358','%B3541972837280095^KgjuormWmuoie^86016244363? ','2023-01-21 00:18:50',null,null,2),
  ('Jonah','Gaines','jonah_gaines8342@google.couk','1-234-955-4641','%B6572575689883530^IvqmxgjWsgtrc^2410140996?5','2023-02-18 00:51:58',null,null,3),
  ('Anjolie','Callahan','c-anjolie@aol.ca','(434) 415-1194','%B7353577363468751^HfwilmdVhwrul^5408801744? ','2023-01-12 03:01:28',null,null,2),
  ('Todd','Ramirez','ramirez-todd6568@outlook.com','(517) 422-6868','%B4418486201483701^EypfbbhNbxqdv^35122821?3','2023-01-20 00:13:50',null,null,1),
  ('Harding','Harmon','harmon.harding320@yahoo.couk','(370) 266-6655','%B3661985472634477^SgocpipVcnnux^5002488318?5','2023-02-20 00:16:52',null,null,3),
  ('Jordan','Branch','branchjordan9697@outlook.couk','(163) 455-0553','%B8245726674437238^IyeihnfEftbns^9410484291?8','2023-03-16 04:12:41',null,null,3),
  ('Ora','Molina','omolina@hotmail.com','1-794-322-1780','%B6236322397622537^PfwmldvQktupu^9207723135?6','2023-01-22 05:47:51',null,null,3),
  ('Michael','Allison','mallison677@icloud.net','1-162-494-5058','%B8241481961554867^UulhsfhXnuxpt^9503990496?3','2023-02-15 22:48:23',null,null,3),
  ('Nero','Wilder','wilder_nero2413@outlook.org','1-158-471-9267','%B4372064812287576^YukbixnRboesi^30092777342?6','2023-01-23 01:58:49',null,null,2),
  ('Julian','Bell','j.bell@icloud.ca','(486) 871-2677','%B1121643602355718^ZtrhhgoImfzvf^66108087?1','2023-02-10 19:30:50',null,null,1);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Vera','Garza','v.garza@icloud.net','(551) 863-1542','%B5437151667874278^JsyjvlhQwkzoy^09028063?9','2023-02-22 08:03:21',null,null,3),
  ('Vance','Spencer','s_vance9375@google.com','1-202-245-2522','%B9827895122973343^LqnftfzYgbkwk^68076635991? ','2023-02-01 00:17:05',null,null,1),
  ('Elton','Glover','gloverelton9984@hotmail.ca','(416) 387-2060','%B2815955326163593^QzfgiakUoycsi^3006427593?6','2023-01-06 14:49:21',null,null,1),
  ('Allen','Burke','ballen@outlook.couk','(371) 737-8128','%B3446844026024738^NyanouyKxpfkg^80045568?7','2023-01-17 13:06:32',null,null,3),
  ('Jaquelyn','Hooper','jaquelyn_hooper5077@aol.com','1-100-473-1801','%B1784776848041624^YytkfkkJvqpbj^3305518455?6','2023-03-08 02:18:39',null,null,3),
  ('Acton','Kim','acton.kim5946@icloud.org','1-347-577-8216','%B3224196648366898^XczojajUderrc^20085362792?8','2023-01-30 17:11:48',null,null,1),
  ('Cairo','Conrad','c-conrad@icloud.edu','1-771-416-1889','%B5673324411648555^QwvxfufJhiqsg^70081637?7','2023-02-16 09:28:04',null,null,2),
  ('Matthew','Nielsen','m.nielsen2861@aol.org','1-695-288-7630','%B7495739245146576^SuordvhUxufdy^4509773221?6','2023-03-01 21:12:08',null,null,2),
  ('Lyle','Klein','lklein@icloud.edu','(416) 248-3757','%B7725626296086547^EnjlhsuFtihnu^83078861281?2','2023-01-12 21:38:06',null,null,2),
  ('Nathan','Wynn','w_nathan@yahoo.edu','(396) 574-2964','%B5137162772481419^IdsqqeoIuacln^7910230629?1','2023-03-07 15:04:12',null,null,4);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Fleur','Walton','walton.fleur2607@outlook.com','(928) 745-9842','%B7850256888842757^YwcarbkHuqset^01027076?6','2023-02-27 17:09:31',null,null,1),
  ('Beau','Rowland','rowlandbeau@yahoo.edu','(194) 877-1666','%B8223475032538577^EudgiabIxmkbt^5702832773?7','2023-03-20 11:21:24',null,null,2),
  ('Nell','Mcdowell','mcdowell-nell@icloud.net','1-782-213-2257','%B7076821725844455^JwfffiiYpwfvc^26085101754?8','2023-01-06 15:49:07',null,null,2),
  ('Ian','Hancock','ihancock@google.ca','(484) 450-4759','%B3154498677572445^BmzqmopQesrpe^4708562155?6','2023-03-12 13:31:40',null,null,3),
  ('Julie','Nash','j_nash@yahoo.net','1-787-608-7187','%B5326644796641147^LyywkbeJgnicp^51107057539?6','2023-03-28 05:33:01',null,null,2),
  ('Ira','Holt','iholt@hotmail.edu','1-216-593-4272','%B9734973187357094^HbllgowEsenko^1602165699?9','2023-01-02 04:01:52',null,null,4),
  ('Winter','Savage','w.savage@hotmail.org','1-285-285-1382','%B3064673624136181^BucedskFceygn^2109312702?9','2023-01-16 11:56:19',null,null,4),
  ('Keith','Davidson','davidson.keith@icloud.ca','(509) 355-2705','%B6317166083404785^RyjjcweEaqtoe^55044557?8','2023-01-07 21:22:46',null,null,1),
  ('Tanya','Orr','t.orr9460@hotmail.net','1-532-533-7174','%B8085482633166666^FvwbrgiUriitc^3211785815?9','2023-01-13 08:25:58',null,null,2),
  ('Benedict','Meyer','b.meyer@aol.com','1-927-224-3250','%B4868538921994569^NiqpwwdDbsbur^3105157906? ','2023-01-17 22:15:41',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Lani','Jensen','ljensen@aol.net','1-981-381-8046','%B3722926482064874^UhcskijHhjikm^1011137810? ','2023-02-18 19:35:06',null,null,3),
  ('Tanisha','Preston','preston-tanisha1430@aol.edu','(517) 716-2854','%B3267465114655266^VtmdxpwDehbkv^0108809304?1','2023-01-11 17:59:45',null,null,3),
  ('Jocelyn','Gibbs','jocelyngibbs8675@outlook.org','1-949-125-5341','%B4265055714257423^WbtdztgBsscqr^9110663579?1','2023-03-15 18:12:26',null,null,2),
  ('Hope','Richmond','h.richmond4282@outlook.ca','(383) 261-8703','%B4563785633036811^NqrvlitCwukbs^32024885302?1','2023-02-01 06:35:41',null,null,3),
  ('Fitzgerald','Morrow','fitzgeraldmorrow6681@aol.net','(461) 714-0310','%B5745637185509867^PxdithfJupusy^92037387?2','2023-01-27 12:37:13',null,null,2),
  ('Kristen','Santiago','santiago.kristen@protonmail.ca','1-325-684-3118','%B8484045773192782^OebgyvhPznqvl^31079167?7','2023-02-12 01:17:51',null,null,3),
  ('Lee','Jacobs','leejacobs4879@yahoo.edu','1-549-211-4134','%B6612913601102326^ZbmxsicDnxipg^3109731981? ','2023-02-09 19:00:30',null,null,1),
  ('Prescott','Colon','pcolon1943@aol.edu','1-746-851-3819','%B8876681431158272^PdbomcbIcmqip^6203833181?5','2023-02-05 13:19:26',null,null,3),
  ('Stone','Lucas','stonelucas8880@icloud.org','(581) 334-1888','%B4301494254672322^FbjtyfcDzqopa^73034599387?1','2023-03-09 19:02:32',null,null,3),
  ('Candace','Fields','candace-fields8872@icloud.net','1-476-177-6584','%B6641505832428887^YroiqofJcnbfs^76071623?9','2023-01-27 12:37:22',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Cassandra','Foster','foster.cassandra@hotmail.ca','1-515-611-2142','%B7696312815102066^XwynerhPlmlqv^71029164222? ','2023-02-28 21:53:40',null,null,2),
  ('Maryam','Bond','m.bond54@outlook.org','1-165-621-8971','%B7078176744166196^GklqsdnAsgmbx^78107589?4','2023-01-03 12:30:05',null,null,2),
  ('Salvador','Lamb','lamb-salvador@yahoo.net','1-414-250-5682','%B2318954134528083^JqndmpmVxpueu^8009695747? ','2023-02-01 12:45:01',null,null,3),
  ('Wanda','William','wanda-william5062@hotmail.org','(227) 963-2337','%B6430324279413355^YzweezvZupcyt^0905615415?4','2023-02-06 06:53:59',null,null,2),
  ('Buffy','Lynch','lynch.buffy@outlook.edu','1-981-519-1894','%B3698274580945211^OzbkmstFpjpak^6104738448? ','2023-03-22 13:47:17',null,null,3),
  ('Blythe','Sweet','sweet.blythe@aol.org','1-426-175-2321','%B1128560474394814^KbaypttHnuswh^38106692?2','2023-02-08 09:21:25',null,null,4),
  ('Selma','Carr','scarr@icloud.ca','(824) 851-1504','%B9793868770656371^BpruffrGkguup^73105502?1','2023-01-26 01:38:44',null,null,2),
  ('Gay','Shelton','g.shelton@protonmail.ca','1-815-428-1543','%B5850355752482304^ZbncgkmFwuqfm^3203320925?4','2023-03-13 19:40:04',null,null,2),
  ('Madeline','Freeman','freeman_madeline@aol.com','1-284-514-2326','%B9382037846824754^RoookxjLfeedd^71021198?6','2023-03-12 04:12:40',null,null,4),
  ('Rogan','Brady','brady_rogan@hotmail.couk','1-485-385-1315','%B3456467548124541^BrbgqkzNmbwgu^07041825035?3','2023-02-12 14:44:32',null,null,4);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Akeem','Fletcher','a-fletcher7131@yahoo.org','1-638-784-8439','%B8603464572705264^AecovxqRjidzh^27017802? ','2023-01-02 08:03:44',null,null,2),
  ('Kylee','Salas','kylee.salas@outlook.edu','(962) 664-5616','%B4435014881113631^HwagdpsJbasxp^22079153018?2','2023-01-03 09:29:45',null,null,3),
  ('Nina','Medina','medina-nina4718@hotmail.net','1-843-645-2805','%B6439127775762187^XxqjqgcQofppe^3807179530?4','2023-02-04 21:51:11',null,null,3),
  ('Olga','Neal','neal.olga7597@google.net','(178) 545-6748','%B4354375061135293^TsmywcwRtvaxd^93075319359? ','2023-03-23 21:01:01',null,null,3),
  ('Jasper','Knapp','jasperknapp@google.ca','(257) 846-9346','%B2202469666046885^EkpouxqSshjow^89115116?3','2023-01-11 08:41:14',null,null,3),
  ('Mona','Kramer','kramer_mona@yahoo.net','(992) 828-2108','%B7602613586867330^BxyevsbSqvity^59119741?1','2023-01-25 23:53:48',null,null,3),
  ('Jin','Daniel','danieljin@aol.ca','(146) 683-8864','%B1962767160116313^LjmjptpDqwrbr^8504640425?2','2023-02-18 21:17:35',null,null,2),
  ('Kylynn','Carr','carr.kylynn@outlook.net','(888) 997-3224','%B6560966508783352^HbilivtRktqgx^64095034?2','2023-02-14 13:53:14',null,null,3),
  ('Rhoda','Fulton','f_rhoda@outlook.couk','(563) 751-8616','%B8216880246339861^CdxqohnVebkwc^0401127112?5','2023-03-16 12:43:23',null,null,3),
  ('Troy','Dillon','t-dillon@aol.net','1-670-718-7861','%B6080187013845034^EfummtjCaoenc^24092838981?1','2023-03-28 08:17:11',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Hedda','Lopez','h.lopez33@hotmail.org','(211) 721-4015','%B3125815065825211^YxssnvdGbubsa^7108685244?1','2023-02-15 05:37:04',null,null,3),
  ('Wylie','Reynolds','wylie.reynolds@hotmail.com','(590) 364-9871','%B8262368542832787^VotocegVykafv^1702718446?5','2023-03-20 15:48:26',null,null,1),
  ('Tasha','Wilkerson','tasha-wilkerson@protonmail.couk','(244) 880-1262','%B2666155368600373^FmwhshvBjadmf^90025056?3','2023-01-02 16:24:49',null,null,3),
  ('Odessa','Owens','o-owens5387@aol.ca','(588) 656-0599','%B6436387436748100^BltfglnBdlocc^7209297500?7','2023-03-24 04:54:13',null,null,1),
  ('Jesse','Welch','w.jesse@aol.edu','(590) 713-8064','%B4922709425143431^UwpbrsuToqpcq^11129005?1','2023-03-07 10:35:25',null,null,2),
  ('Sharon','Lester','lester-sharon@google.ca','(861) 924-3560','%B9341222794464736^BlipxjqTylsul^2507349192?9','2023-03-03 13:28:31',null,null,2),
  ('Cade','Ruiz','cruiz@aol.edu','(954) 289-1389','%B5534589131242615^HxrrvboJfptgk^96062494?2','2023-02-08 02:46:15',null,null,3),
  ('Ciaran','Watson','c-watson@protonmail.net','1-686-285-3913','%B5311473540825634^AurfrlvGneduz^1804636947? ','2023-03-16 16:12:14',null,null,3),
  ('Yuli','Parrish','parrish-yuli@protonmail.edu','(269) 574-5148','%B2168787623720140^VufrxdkTlluhm^3204353408?6','2023-01-05 12:48:36',null,null,3),
  ('Geraldine','Alexander','galexander@aol.edu','(947) 345-7125','%B4588667233878196^YevywpcTuuqzk^21113563?5','2023-01-25 00:52:14',null,null,3);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Hedwig','Ramsey','h-ramsey@yahoo.edu','(454) 518-9664','%B1938327865232857^CyadczxMewdqm^0110783641?5','2023-03-20 10:31:54',null,null,3),
  ('Gretchen','Golden','g-golden2912@yahoo.net','1-435-782-3878','%B6125349112748241^RbfihxrWkpiei^4608963990?4','2023-01-30 12:35:14',null,null,1),
  ('Rinah','Huffman','huffmanrinah3810@hotmail.com','(368) 965-2234','%B3218766162497714^YxddedlFbggmf^5004791799?5','2023-01-31 06:56:19',null,null,1),
  ('Aurora','O''brien','oaurora771@protonmail.org','1-734-570-9690','%B6155076518801555^PlcomjgMkvoxo^55108237? ','2023-02-24 14:27:13',null,null,1),
  ('Zeus','Holder','z.holder7089@icloud.com','1-278-229-4831','%B8548146122255535^FntfyphImsgdx^5105522811?4','2023-01-13 07:24:32',null,null,4),
  ('Len','Craig','lcraig@hotmail.net','1-824-537-6195','%B8276552412234180^LvldpoxKsiqfe^98115732062?8','2023-03-15 02:33:07',null,null,4),
  ('Christine','Summers','christine_summers3597@yahoo.ca','1-659-311-1653','%B6678660936364932^VsovoeuPecydl^12102932362?7','2023-01-05 14:04:36',null,null,2),
  ('Felicia','Haley','haley-felicia@hotmail.org','1-373-737-2452','%B6314564258796349^CcotuuiHcjajr^85106675?4','2023-02-17 19:13:41',null,null,4),
  ('Daryl','Ewing','darylewing@hotmail.org','1-275-917-7245','%B6537906747678771^XckodmtWbahfb^3009544724?3','2023-02-04 04:36:24',null,null,3),
  ('Candace','Mcgee','cmcgee@protonmail.net','1-264-722-8753','%B7457631612165846^JwnrwhqFrwhdv^05051244455?7','2023-02-10 19:57:15',null,null,3);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Elijah','Mosley','e-mosley8174@icloud.edu','1-875-624-6718','%B5858263229122842^LnvehyeTchrpn^7302875743?5','2023-01-08 15:52:21',null,null,2),
  ('Grant','Whitehead','wgrant2314@aol.edu','1-371-616-4715','%B2272737402213287^XnebwrvVfqhnf^7712586357?9','2023-01-03 18:38:15',null,null,4),
  ('Dale','Pollard','d-pollard4914@outlook.ca','1-670-464-7855','%B2534251143384648^NepnjqdSdwtqf^3701128586?2','2023-03-08 04:34:58',null,null,1),
  ('Maxwell','Reilly','m-reilly4564@icloud.couk','1-677-737-6264','%B4863535622607887^FhpfpjrMekukc^67043456201?5','2023-01-06 21:03:29',null,null,1),
  ('Xandra','Fleming','fleming.xandra7586@outlook.com','(671) 783-7886','%B2233226937760551^EpolwwjTxviyp^8702729235?8','2023-02-14 12:55:25',null,null,3),
  ('Shay','Gallegos','g-shay6340@aol.org','(372) 962-0285','%B5262437966213782^BwyvovpZregfp^59092953920?5','2023-03-24 07:32:02',null,null,4),
  ('Maryam','Mooney','m.mooney9441@hotmail.org','1-369-771-1802','%B7158657488447461^RdoryziQozace^5510509463?2','2023-01-02 14:48:42',null,null,2),
  ('Jolene','Hahn','hahn-jolene@outlook.couk','(720) 668-5676','%B2822716262773639^QpdtiybIqnrsg^8104475806?1','2023-03-12 13:27:11',null,null,1),
  ('Erasmus','Mueller','e-mueller@outlook.edu','(585) 846-4706','%B4686771374746777^CglqwgwXsfotn^55076655?7','2023-01-25 13:55:30',null,null,4),
  ('Cain','Church','c.church9849@outlook.couk','(733) 717-1977','%B5757625777238661^PziasjcPihrpr^51118423?4','2023-01-12 04:15:09',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Yvette','Alford','y-alford@icloud.edu','(774) 534-5288','%B1267446762242627^IwxtsahEgiydm^04076548?7','2023-01-16 16:20:25',null,null,2),
  ('Alden','Humphrey','alden_humphrey@yahoo.edu','(586) 666-7126','%B4688362928460258^FhwngyvMhkeru^6903586915?8','2023-01-11 23:29:49',null,null,3),
  ('Fulton','Puckett','pfulton@aol.net','(826) 127-6395','%B2337425746912757^CecygipCsosyh^9503803322?1','2023-01-16 00:48:29',null,null,2),
  ('Russell','Church','c_russell6960@icloud.org','(226) 207-4686','%B2919868068157022^NuopkbrNoxvpd^6202710393?8','2023-03-19 18:10:27',null,null,2),
  ('Kennan','Holt','holtkennan@google.net','1-364-632-2233','%B3378479306660261^KuuistqEuopug^53056772?6','2023-03-20 04:23:07',null,null,1),
  ('Amanda','Yates','yatesamanda1986@yahoo.org','(690) 837-7466','%B6589744671219386^XclchfdGxidrv^04097929?6','2023-03-18 14:40:35',null,null,2),
  ('Elijah','Sullivan','sullivan_elijah@outlook.ca','1-374-725-8552','%B5254668383141371^LhdbcybSiosfy^0701734433?5','2023-03-15 07:47:53',null,null,3),
  ('Gisela','Winters','gwinters500@google.net','(751) 845-2893','%B5721927174664329^EwigrbrXkxvho^41038633?8','2023-03-12 07:51:07',null,null,3),
  ('Ulla','Hunter','hunter.ulla@protonmail.org','1-268-361-8329','%B5410204855301356^HliqpdgXqvcbr^05119415900?7','2023-02-24 15:32:20',null,null,3),
  ('Tashya','Steele','t.steele@outlook.edu','(299) 495-9234','%B7171326654141794^AjxxpocRvyyav^43094045901?7','2023-02-15 01:57:32',null,null,2);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Martina','Ochoa','m.ochoa6515@outlook.com','(587) 728-5231','%B6281215455662690^ElqasldPevbyb^2111372902?1','2023-01-03 01:54:36',null,null,1),
  ('Autumn','Moses','a.moses4410@hotmail.ca','1-981-953-1235','%B7245836615804895^EprsfhbBrvoxh^64125297?7','2023-01-12 03:40:11',null,null,2),
  ('Denton','Morrow','denton.morrow1822@google.edu','1-278-953-7565','%B2884760588328074^SwstaxuWbunri^3007709273?2','2023-02-05 09:09:33',null,null,3),
  ('Moses','Freeman','freeman_moses9423@yahoo.com','(741) 416-0574','%B6866835381323838^TkkqdhbMvopso^7803276894?8','2023-02-06 16:28:06',null,null,2),
  ('Kathleen','Morse','k_morse4681@yahoo.couk','1-894-883-9417','%B9852761829055065^XddgesbMlsqge^14063852589?2','2023-02-27 22:03:22',null,null,3),
  ('Cailin','Garrison','cgarrison7731@aol.net','1-647-222-4042','%B8795547697930517^SljxrjlNrjhac^13099832?1','2023-01-03 19:46:18',null,null,4),
  ('Timon','Webb','webbtimon7922@google.net','(542) 369-1873','%B3919861765222642^FuokvexBbbkoy^03103886?1','2023-02-18 02:03:56',null,null,3),
  ('Candice','Case','c.case@hotmail.org','1-148-579-5416','%B7511194324249236^LjjrtjpTeocig^26023298? ','2023-03-18 18:54:25',null,null,4),
  ('Nasim','Carver','carver_nasim@yahoo.org','1-544-603-7282','%B5646231416357935^RyfkhchLvtjtl^76099249?2','2023-01-16 14:22:40',null,null,3),
  ('Tara','Porter','p-tara@yahoo.org','1-224-513-6775','%B3637329383002220^AjtxbxaQvdcpr^22085002275?3','2023-03-21 23:16:00',null,null,1);
INSERT INTO customer (firstname,lastname,email,phone_number,address_eth,created_at,deleted_at,updated_at,store_id)
VALUES
  ('Phelan','Kent','phelan_kent5929@outlook.edu','1-532-326-6816','%B7743278416459299^BvnclykBxbrlu^2611240169?5','2023-02-17 23:48:08',null,null,1),
  ('Nero','Rollins','nerorollins2988@google.ca','(983) 914-7827','%B2760627137159729^VyhooebOkfote^83106156841?7','2023-03-09 17:07:32',null,null,3),
  ('Anastasia','O''Neill','oneill_anastasia@protonmail.couk','1-671-914-3406','%B4579203677386166^GfpoqguQmmnbw^7004912124?6','2023-02-10 16:18:13',null,null,2),
  ('Nehru','Peters','n_peters@yahoo.org','1-165-911-5730','%B6848204134777121^MrdbgshDskogd^09034086?4','2023-03-04 22:18:24',null,null,3),
  ('Gregory','Short','g-short@outlook.com','1-110-532-7317','%B4311779575872563^MuwwmsiPwootf^61023335?5','2023-01-18 02:28:58',null,null,4),
  ('Cain','Leach','l_cain@icloud.ca','1-734-447-6573','%B9415138368667395^JhridviWbhoek^6904202603?2','2023-02-11 03:27:34',null,null,3),
  ('Lilah','Santiago','l-santiago@outlook.ca','(768) 859-6748','%B2504000301387742^UlhodceVcnrug^4203927911?8','2023-02-01 00:56:26',null,null,4),
  ('Oprah','Hickman','h-oprah1517@hotmail.net','1-675-254-3584','%B2545377367126133^OnbpdvcWjcnwl^75028129? ','2023-01-25 23:32:39',null,null,3),
  ('Keefe','Franklin','franklin.keefe8949@icloud.ca','1-883-842-9685','%B7216433394291775^NuinndjCbhdgw^5605406694?4','2023-01-27 22:07:55',null,null,4),
  ('Rogan','Valenzuela','rogan.valenzuela9933@protonmail.org','(282) 517-2823','%B5085574327325682^IlwjnulFrneka^8011278722?6','2023-03-23 13:51:50',null,null,4);

