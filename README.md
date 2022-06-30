# rare-springboot
groupwork

要插入图片到数据库，先上传图片到src/main/resources/picture，
再在src/main/java/Test/ImageDemo.java中修改String path和这三个部分的第二个实参：
```ps.setString(1, "乌兹");//卡名
ps.setString(2, "乌兹，永远的神！");//卡的简介
ps.setInt(3,1);//稀有度
```
