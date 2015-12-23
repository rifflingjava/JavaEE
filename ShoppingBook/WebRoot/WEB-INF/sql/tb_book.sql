create table tb_book                 
(
  bookId int primary key auto_increment,     
  superTypeId int,                                        
  subTypeId int,                                            
  bookName varchar(200),						
  ISBN varchar(20),                           
  introduce text,                                                     
  price float,                                                     
  nowPrice float,                                          
  picture varchar(200),  						
  pages int,									
  publisher varchar(40),						
  author varchar(20),                                  
  inTime timestamp,                                            
  newBooks int,                                          
  saleBooks int,                                               
  hostBooks int,                                
  specialBooks int,                            
  bookNum  int,                                               
  foreign key(subTypeId ) references tb_subType(subTypeId),
  foreign key(superTypeId) references tb_superType (superTypeId)
 );
 
 
 insert into tb_book values(null,1,1,'皇帝柠檬2','200907046','《皇帝与柠檬经济学中的人性》讲述了：皇帝和柠檬有什么关系？如果我们把皇帝和大臣之间的关系看作一种交易，皇帝和大臣的关系就是柠檬市场，由于信息的不对称而引发种种问题。现实中许多我们认为很抽象很感性的事物，实际上都有其理性的根源....',25,16.8,'images/book1.jpg',320,'文学出版社','布鲁斯',null,1,1,0,0,120); 
 insert into tb_book values(null,1,1,'我们的杜拉拉2','200907047','《我们的杜拉拉》收录了李可独家访谈，柳传志、徐静蕾、姚晨、赵赵、郎平以及千万读者感动热评，杜拉拉经典语录....',36,22.4,'images/book5.jpg',230,'新华出版社','爱死布鲁斯',null,0,1,0,1,120); 
 insert into tb_book values(null,1,1,'佐藤可士和的超整理术2','200907048','《佐藤可士和的超整理术》：如果说原研哉奠定了无印良品的设计哲学的话,那佐藤可士和就创造了UNIQLO优衣库的视觉精神,而现在UNIQLO已经成为了一个新的日本设计象征....',56,49.8,'images/book3.jpg',412,'新华出版社','桑德勒',null,0,1,1,1,120); 
 insert into tb_book values(null,1,1,'EnglishBook2','200907049','This is the Asian adaptation of N. Gregory Mankiw s market leading textbook Principles of Economics. While maintaining all the strengths of the original book, Professor Euston Quah and Dr. Peter Wilson have provided materials and examples that are most relevant to students in Asia.',39,37.4,'images/book9.jpg',502,'新华出版社','希特勒桑德勒',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'晚间西红柿减肥','9787531723950','本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，“日本第一的西红柿博士”——唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦',22,11.6,'images/1.jpg',128,'北方文艺出版社','（日）唐泽明　著，周晓晗　译',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'晚间西红柿','9787531723987','本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，“日本第一的西红柿博士”——唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦',54,46.6,'images/7.jpg',128,'北方文艺出版社','（日）唐泽明　著，周晓晗　译',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'西红柿','97875317239657','本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，“日本第一的西红柿博士”——唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦',34,26.6,'images/8.jpg',128,'北方文艺出版社','（日）唐泽明　著，周晓晗　译',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'西红柿平','978753176657','本书是日本销量第一的美容减肥畅销书，上市3个月狂卖85万册。本书作者，“日本第一的西红柿博士”——唐泽明告诉大家，西红柿减肥好吃、轻松、易瘦、健康、美肤，在3个月内减掉11斤并且使肌肤回到21岁时的状态。不管大家是否爱吃西红柿，晚间西红柿减肥都能持续下去，因为晚间西红柿有如下秘诀：清清爽爽的血液、滑溜溜的肌肤、美美地吃、舒舒服服、瘦！来自西红柿的美丽瘦身+美肤过程，你一定要亲身体验一番哦',44,36.6,'images/9.jpg',128,'北方文艺出版社','（日）唐泽明　著，周晓晗　译',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'郎咸平说','9787531723951','在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势',25,13.6,'images/2.jpg',128,'北方文艺出版社','郎咸平',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'郎咸平说234','97875317239511','在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势',25,13.6,'images/3.jpg',128,'北方文艺出版社','郎咸平',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'郎咸平说6767','97875317239512','在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势',25,13.6,'images/4.jpg',128,'北方文艺出版社','郎咸平',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'郎咸平说897','97875317239514','在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势',34,23.6,'images/5.jpg',128,'北方文艺出版社','郎咸平',null,1,1,1,1,120); 
 insert into tb_book values(null,1,1,'郎咸平说455','97875317239517','在本书中，郎咸平教授谈兴甚浓，兴致盎然，语言大胆诙谐，而且看问题一针见血，直达事件最真实层面。从3.14事件中CNN对中国的诋毁、到汶川大地震的众志成城；从大众对奥运经济的过度期盼到奥运礼仪的中华风采；还有海峡两岸对台湾现状的真实解读，功夫熊猫凸显的文化融合以及诸葛亮能否成为优秀的企业家；郎教授都做了最真切的解读，全部都是在电视、平面媒体上闻所未闻的观点，这是在郎教授对东西两种文化体系透彻理解的基础上并且从社会民众中的普遍的小细节中展示出大事件的根本趋势',39,37.6,'images/6.jpg',128,'北方文艺出版社','郎咸平',null,1,1,1,1,120); 
 
