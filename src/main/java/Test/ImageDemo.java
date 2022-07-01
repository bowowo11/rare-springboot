package Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageDemo {
    // 将图片插入数据库
    public static void putImage()
    {
        String path = "src/main/resources/picture/CardPicture/god/uzi.png";
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream in = null;
        try
        {
            in = ImageUtil.readImage(path);
            conn = DBUtil.getConn();
            String sql = "insert into card (name,description,rarerank,image)values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "乌兹");//卡名
            ps.setString(2, "乌兹，永远的神！");//卡的简介
            ps.setInt(3,1);//稀有度
            ps.setBinaryStream(4, in, in.available());//这个不动
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            DBUtil.closeConn(conn);
            if (null != ps)
            {
                try
                {
                    ps.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }

    }

    // 读取数据库中图片
    public static void readImage() {
        String targetPath = "C:/game/mogen.jpg";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            String sql = "select * from card where id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            while (rs.next()) {
                InputStream in = rs.getBinaryStream("image");
                ImageUtil.readBin2Image(in, targetPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


//        //测试

        }
    }
    public static void main(String[] args){
        putImage();
        //readImage();

    }
}


