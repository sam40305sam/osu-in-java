import osuParser.osuParser;
import play.music;

import javax.swing.*;
import java.awt.image.RescaleOp;
import java.awt.image.*;
import java.awt.*;

import javax.imageio.ImageIO;

import java.io.*;

public class hey {


  public static void main(String[] args) {
    JFrame f = new JFrame();// creating instance of JFrame
    ImageIcon bg = new ImageIcon("C:\\Users\\sam40305\\Desktop\\SET.png");
    JLabel background = new JLabel("", bg, JLabel.CENTER);
    background.setBounds(0, 0, 1600, 900);

    BufferedImage img = null;
    try {
      img = ImageIO.read(new File("C:\\Users\\sam40305\\Desktop\\SET.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    RescaleOp op = new RescaleOp(.5f, 0, null);
    img = op.filter(img, null);
    Image dimg = img.getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon imageIcon = new ImageIcon(dimg);
    background.setIcon(imageIcon);
    f.add(background);
    
    
    // circle.setVisible(false);

    f.setResizable(false);
    f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    f.setUndecorated(true);
    f.setSize(1600, 900);// 400 width and 500 height
    f.setLayout(null);// using no layout managers
    f.setVisible(true);// making the frame visible

    // music bg_music = new music("C:\\Users\\sam40305\\Desktop\\data1.mp3");
    osuParser a = new osuParser("C:\\Users\\sam40305\\Desktop\\data.osu");
    int CircleRadius=(int)((54.4f - 4.48f*4.0f)*1.9f*2);
    ImageIcon img_circle = new ImageIcon("C:\\Users\\sam40305\\Desktop\\circle.png");
    // JLabel circle[] = new JLabel[a.get_HitObjects().size()];
    JLabel circle = new JLabel("", img_circle, JLabel.CENTER);
    try {
      img = ImageIO.read(new File("C:\\Users\\sam40305\\Desktop\\circle.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    dimg = img.getScaledInstance(CircleRadius, CircleRadius, Image.SCALE_SMOOTH);
    imageIcon = new ImageIcon(dimg);

    for (String key : a.get_HitObjects()) {
      String[] data_Split = key.split(",");
      if (data_Split.length == 6) {

        int x=(int)(315f-((54.4f - 4.48f*4.0f)*1.9f)+(Integer.valueOf(data_Split[0])*1.9f));
        int y=(int)(100f-((54.4f - 4.48f*4.0f)*1.9f)+(Integer.valueOf(data_Split[1])*1.84f));
        
        circle.setBounds(x, y, CircleRadius, CircleRadius);
        
        circle.setIcon(imageIcon);
        f.add(circle);
      }
    }
    
    System.out.println("x");
    // bg_music.play_music();
    //System.out.println(a.get_file_format());
    // System.out.println(a.get_HitObjects());
    // System.out.println(a.get_nOfcircles());
    // System.out.println(a.get_nOfsliders());
    // System.out.println(a.get_nOfspinners());
  }
}
