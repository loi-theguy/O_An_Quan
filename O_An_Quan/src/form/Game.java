package form;
import static java.awt.Color.black;
import static java.awt.Color.blue;
import static java.awt.Color.red;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.Time;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Game extends javax.swing.JFrame {
public int ViTri,PL_score=0,CP_score=0,Huong,Luot=1,PL_No=0,CP_No=0,TT=0;
public int S_PL_score,S_CP_score,S_Huong,S_ViTri,Quan1=1,Quan2=1,S_Quan1,S_Quan2;
public int[] a = new int[12];
public int[] b = new int[12];
ArrayList<JButton> list=new ArrayList<JButton>();

    /**
     * Creates new form Form
     */
    public Game() {
        initComponents();
        khoitaolist();
        batdau();
//        Random rd = new Random();
//        int thutu = rd.nextInt(2);
//        if(thutu==0)
//        {   
//            if(JOptionPane.showConfirmDialog(this,"Lượt Chơi Đầu Của Máy")==JOptionPane.OK_OPTION)
//            {
//                Luot=0;
//                 minimax();
//            }
//        }
//        else
//        {
//            JOptionPane.showMessageDialog(this,"Lượt Chơi Đầu Của Người Chơi");
//        }
         }
    public void batdau()
    {
           for(int i=0;i<12;i++)
        {
            if(i==0||i==6)
            {
                a[i]=10;
                b[i]=a[i];
            }
            else
            {
            a[i]=5;
            b[i]=a[i];
            }
        }
            tinhtam();
            Quan1=1;
            Quan2=1;
            PL_No=0;
            CP_No=0;
    }
    public void khoitaolist ()
    {
        list.add(jb0);
        list.add(jb1);
        list.add(jb2);
        list.add(jb3);
        list.add(jb4);
        list.add(jb5);
        list.add(jb6);
        list.add(jb7);
        list.add(jb8);
        list.add(jb9);
        list.add(jb10);
        list.add(jb11);
    }
    public void update_score(int i)
    {
        try{
            if(Luot==1)
            {
                list.get(i).setForeground(red);
            }
            else
            {
                list.get(i).setForeground(blue);
            }
                list.get(i).setText(""+a[i]);
                 Thread.sleep(1200);
                 list.get(i).setForeground(black);
//        list.get(3).setForeground();
//        this.invalidate();
//        this.revalidate();
//        this.repaint();
       

//        this.update(grphcs);

    
        
    } catch (InterruptedException ex) {
        Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
    }
      
        
    }
    public void tinhtam()
    {
        for(int i =0;i<12;i++)
        {
            list.get(i).setText(""+a[i]);
            Font ft = new Font("Serif",Font.BOLD,24);
            list.get(i).setFont(ft);
        }
    }
    public void TinhDiem()
    {
        int Diem=0;
        if(Huong==1)
          {
              int KT;
               int Lap;
              if(ViTri==11 && a[ViTri]==0)
              {
                  KT=0;
                  Lap=1;
              }
              else if(a[ViTri]==0)
              {
                  Lap=1;
                  KT=ViTri+1;     
              }
              else
              {
                  return;
              }
             
              while(Lap==1)
              {
                  if(a[KT]!=0)
                  {
                      if(KT==0 && a[0]>=15)
                      {
                          Quan1=-1;
                      }
                         if(KT==6 && a[6]>=15)
                      {
                          Quan2=-1;
                      }
                      if(KT==0 && a[0]<15)
                      {
                          break;
                      }
                      else if(KT==6 && a[6]<15)
                      {
                          break;
                      }
                      else
                      {
                      Diem += a[KT];
                      a[KT]=0;
                      list.get(KT).setText(""+a[KT]);
                      int th = KT+1;
                      if(th>11)
                          th=0;
                      if(a[th]==0)
                      {
                          KT=th+1;
                          if(KT>11)
                              KT=0;
                      }
                      else
                      {
                          Lap=0;
                      }
                  }
                  }
                  else
                  {
                      Lap=0;
                  }
              }
              
          }
          else
          {
              int KT;
               int Lap;
              if(ViTri==0 && a[ViTri]==0)
              {
                  KT=11;
                  Lap=1;
              }
              else if(a[ViTri]==0)
              {
                  Lap=1;
                  KT=ViTri-1;     
              }
              else
              {
                  return;
              }
             
              while(Lap==1)
              {
                  if(a[KT]!=0)
                  {
                        if(KT==0 && a[0]>=15)
                      {
                          Quan1=-1;
                      }
                          if(KT==6 && a[6]>=15)
                      {
                          Quan2=-1;
                      }
                      if(KT==0 && a[0]<15)
                      {
                          break;
                      }
                      else if(KT==6 && a[6]<15)
                      {
                          break;
                      }
                      else
                      {
                      Diem += a[KT];
                      a[KT]=0;
                      list.get(KT).setText(""+a[KT]);
                      int th = KT-1;
                      if(th<0)
                          th=11;
                      if(a[th]==0)
                      {
                          KT=th-1;
                          if(KT<0)
                              KT=11;
                      }
                      else
                      {
                          Lap=0;
                      }
                  }
                  }
                  else
                  {
                      Lap=0;
                  }
              }
          }
      if(Luot==1)
      {
          PL_score += Diem;
      }
      else
      {
        CP_score += Diem;
      }
     }
    public void play()
    {
        
if(Huong==1)
        {
            
        int Raiquan = a[ViTri];
        int Flag = ViTri+1;
        a[ViTri]=0;
        list.get(ViTri).setText(""+a[ViTri]);
        int lap =1;
        if(Raiquan==0)
        {
      
            return;
        }
        while(lap==1)
        {
        while(Raiquan!=0)
        {
            if(Flag>11)
            {
                Flag=0;
            }
            a[Flag]++;
            update_score(Flag);
             Thread t2= new Thread(
                new Runnable(){
                    @Override
                    public void run()
                    {
                       
                            Game.this.revalidate();
                            Game.this.repaint();
                    }
                }
        );
             t2.start();
            Flag++;
            Raiquan--;
        }
        if(Flag>11)
        {
            Flag=0;
        }
        if(Flag==0||Flag==6)
        {
            ViTri=Flag;
            break;
        }
        if(a[Flag]!=0)
        {
            lap=1;
            Raiquan=a[Flag];
            a[Flag]=0;
            list.get(Flag).setText(""+a[Flag]);
            Flag++;
        }
        else
        {
            ViTri=Flag;
            lap=0;
        }
        }
          TinhDiem();
        txtCP.setText(""+CP_score);
        txtPlay.setText(""+PL_score);
       
        }
else
     {
            int Raiquan = a[ViTri];
        int Flag = ViTri-1;
        a[ViTri]=0;
        list.get(ViTri).setText(""+a[ViTri]);
        int lap =1;
        if(Raiquan==0)
        {

            return;
        }
        while(lap==1)
        {
        while(Raiquan!=0)
        {
            if(Flag<0)
            {
                Flag=11;
            }
            a[Flag]++;
            update_score(Flag);
               Thread t2= new Thread(
                new Runnable(){
                    @Override
                    public void run()
                    {
                            Game.this.revalidate();
                            Game.this.repaint();
                    }
                }
        );
             t2.start();
            Flag--;
            Raiquan--;
        }
        if(Flag<0)
        {
            Flag=11;
        }
        if(Flag==0||Flag==6)
        {
            ViTri = Flag;
            break;
        }
        if(a[Flag]!=0)
        {
            lap=1;
            Raiquan=a[Flag];
            a[Flag]=0;
            list.get(Flag).setText(""+a[Flag]);
            Flag--;
        }
        else
        {
            ViTri=Flag;
            lap=0;
        }
        System.out.println(ViTri);
        }
        TinhDiem();
        txtCP.setText(""+CP_score);
        txtPlay.setText(""+PL_score);
    }
    }
    public void backup()
    {
        S_PL_score=PL_score; S_CP_score=CP_score;
        S_Quan1=Quan1;S_Quan2=Quan2;
        for(int i = 0;i<12;i++)
            b[i]=a[i];
    }
    public void restore()
    {
        PL_score=S_PL_score; CP_score= S_CP_score;
        for(int i =0;i<12;i++)
        a[i]=b[i];
        Quan1=S_Quan1;Quan2=S_Quan2;
        tinhtam();
    }
    public int h()
    {
        return CP_score - PL_score;
    }
    public void minimax()
    {
        backup();
        int max = -1000;
        for(int i =1;i<6;i++)
        {
            for(int j =0;j<2;j++)
            {
                int o=a[i];
                ViTri=i;
                Huong=j;
                play_1();
                int t =h();
                if(t>max)
                {
                    max=t;
                    S_ViTri=i;
                    S_Huong=j;
                }
                if(t==max)
                {
                    if(o!=0)
                    {
                        S_ViTri=i;
                        S_Huong=j;
                    }
                }
                restore();
            }
        }
        ViTri=S_ViTri;
        Huong=S_Huong;
        play();
        Luot=1;
    }
    public int end ()
    {
        int kq =2;
        int player = PL_score+a[6]+a[7]+a[8]+a[9]+a[10]+a[11]+CP_No;
        int computer = CP_score+a[0]+a[1]+a[2]+a[3]+a[4]+a[5]+PL_No;
        player = player - PL_No;
        computer = computer - CP_No;
        
        if(Quan1 == -1 && Quan2 == -1 )
        {
            
            if(player > computer)
            {
                
                kq = 1;
            }
            else
            {
                kq=0;
                            }
        }
        return kq;
    }
    public void KT_Quan()
    {
        int CP = a[1]+a[2]+a[3]+a[4]+a[5];
        int PL = a[7]+a[8]+a[9]+a[10]+a[11];
          if(CP==0 && Luot==0)
          {
              if(CP_score>=5)
              {
                  for(int i =1;i<6;i++)
                  {
                      a[i] = 1;
                  }
                  CP_score = CP_score-5;
              }
              else
              {
                  for(int i =1;i<6;i++)
                  {
                      a[i] = 1;
                  }
                  CP_No = CP_No + 5;
                  PL_score = PL_score-5;
              }
              tinhtam();
               txtCP.setText(""+CP_score);
                txtPlay.setText(""+PL_score);
              
          }
          if(PL==0 && Luot==1)
          {
              if(PL_score>=5)
              {
                  for(int i =7;i<12;i++)
                  {
                      a[i] = 1;
                  }
                  PL_score = PL_score-5;
              }
              else
              {
                  for(int i =7;i<12;i++)
                  {
                      a[i] = 1;
                  }
                  PL_No = PL_No + 5;
                  CP_score = CP_score-5;
              }
              tinhtam();
               txtCP.setText(""+CP_score);
            txtPlay.setText(""+PL_score);
          }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
 regenerated by the Game Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb2 = new javax.swing.JButton();
        jb0 = new javax.swing.JButton();
        jb3 = new javax.swing.JButton();
        jb1 = new javax.swing.JButton();
        jb5 = new javax.swing.JButton();
        jb4 = new javax.swing.JButton();
        jb10 = new javax.swing.JButton();
        jb9 = new javax.swing.JButton();
        jb11 = new javax.swing.JButton();
        jb7 = new javax.swing.JButton();
        jb6 = new javax.swing.JButton();
        jb8 = new javax.swing.JButton();
        txtCP = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        txtPlay = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        Trai = new javax.swing.JButton();
        Phai = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BD = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 102));

        jb2.setEnabled(false);
        jb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb2ActionPerformed(evt);
            }
        });

        jb0.setText("10");
        jb0.setEnabled(false);

        jb3.setEnabled(false);
        jb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb3ActionPerformed(evt);
            }
        });

        jb1.setEnabled(false);
        jb1.setName(""); // NOI18N

        jb5.setEnabled(false);
        jb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb5ActionPerformed(evt);
            }
        });

        jb4.setEnabled(false);

        jb10.setText("5");
        jb10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb10ActionPerformed(evt);
            }
        });

        jb9.setText("5");
        jb9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb9ActionPerformed(evt);
            }
        });

        jb11.setText("5");
        jb11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb11ActionPerformed(evt);
            }
        });

        jb7.setText("5");
        jb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb7ActionPerformed(evt);
            }
        });

        jb6.setText("10");
        jb6.setEnabled(false);

        jb8.setText("5");
        jb8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb8ActionPerformed(evt);
            }
        });

        txtCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPActionPerformed(evt);
            }
        });

        jButton13.setText("jButton13");
        jButton13.setPreferredSize(new java.awt.Dimension(15, 15));
        jButton13.setSelected(true);
        jButton13.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flag.jpg"))); // NOI18N

        jButton14.setText("jButton13");
        jButton14.setPreferredSize(new java.awt.Dimension(15, 15));
        jButton14.setSelected(true);
        jButton14.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flag.jpg"))); // NOI18N

        Trai.setText("left");
        Trai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TraiActionPerformed(evt);
            }
        });

        Phai.setText("right");
        Phai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 124, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("Computer_score:");

        jLabel2.setText("Player_score:");

        BD.setText("Bắt Đầu Chơi");
        BD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDActionPerformed(evt);
            }
        });

        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jb0, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jb1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jb2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jb3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Trai)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jb11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jb10, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jb9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jb4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jb8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jb6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Phai)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(171, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BD)
                .addGap(31, 31, 31)
                .addComponent(jButton2)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jb1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jb2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jb3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jb4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jb5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jb11, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jb10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jb9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jb7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jb8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jb0, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jb6, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Phai, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Trai, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BD)
                    .addComponent(jButton2))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb2ActionPerformed

    private void jb7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb7ActionPerformed
        // TODO add your handling code here:
        ViTri=7;
    }//GEN-LAST:event_jb7ActionPerformed

    private void jb10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb10ActionPerformed
        // TODO add your handling code here:
        ViTri=10;
    }//GEN-LAST:event_jb10ActionPerformed

    private void jb8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb8ActionPerformed
        // TODO add your handling code here:
        ViTri=8;
    }//GEN-LAST:event_jb8ActionPerformed

    private void jb11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb11ActionPerformed
        // TODO add your handling code here:
       ViTri=11;
    }//GEN-LAST:event_jb11ActionPerformed

    private void jb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb3ActionPerformed

    private void jb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jb5ActionPerformed

    private void jb9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb9ActionPerformed
        // TODO add your handling code here:
        ViTri=9;
    }//GEN-LAST:event_jb9ActionPerformed
public void tt ()
{
    if(TT==1)
    {
        this.setEnabled(false);
        if(JOptionPane.showConfirmDialog(this,"Bạn Có Muốn Chơi Lại")==JOptionPane.YES_OPTION)
        {
             this.setEnabled(true);
            PL_score=0;
            CP_score=0;
            txtCP.setText(""+CP_score);
            txtPlay.setText(""+PL_score);
            batdau();
           
            TT=0;
        }
    }
}
    private void TraiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TraiActionPerformed
        // TODO add your handling code here:
        Huong=1;
         Thread t1;
    t1 = new Thread(
            new Runnable(){
                @Override
                public void run()
                {
                    Trai.setEnabled(false);
                    Phai.setEnabled(false);
                    BD.setEnabled(false);
                    int k  =1,h=1;
                    while(k==1)
                    {
                        if(h==1)
                        {
                           
                            play();
                            h=0;
                            if(end()==1)
                            {
                                JOptionPane.showMessageDialog(Game.this,"NGUOI CHOI CHIEN THANG");
                                TT=1;
                                break;
                            }
                        }
                        else
                        {                            
                            Luot=0;
                            KT_Quan();
                            minimax();
                            if(end()==0)
                            {
                                JOptionPane.showMessageDialog(Game.this,"MAY CHIEN THANG");
                                TT=1;
                            }
                            k=0;
                             KT_Quan();    
                        }
                    }
                    tt();
                     Trai.setEnabled(true);
                    Phai.setEnabled(true);
                    BD.setEnabled(true);
                }
            }
    );
        t1.start();
        
//        end();
//        end();
    }//GEN-LAST:event_TraiActionPerformed

    private void PhaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhaiActionPerformed
        // TODO add your handling code here:
        
        Huong=0;
             Thread t1;
    t1 = new Thread(
            new Runnable(){
                @Override
                public void run()
                {
                    Trai.setEnabled(false);
                    Phai.setEnabled(false);
                    BD.setEnabled(false);
                    int k  =1,h=1;
                    while(k==1)
                    {
                        if(h==1)
                        {
                            
                            play();
                            h=0;
                            if(end()==1)
                            {
                                JOptionPane.showMessageDialog(Game.this,"NGUOI CHOI CHIEN THANG");
                                TT=1;
                                break;
                            }
                        }
                        else
                        {
                            Luot=0;
                            KT_Quan();
                            minimax();
                            if(end()==0)
                            {
                                JOptionPane.showMessageDialog(Game.this,"MAY CHIEN THANG");
                                TT=1;
                            }
                            k=0;
                            KT_Quan();
                        }
                    }
                        tt();
                     Trai.setEnabled(true);
                     Phai.setEnabled(true);
                     BD.setEnabled(true);
                }
            }
    );
        t1.start();
        
       
//        end();
//        end();
    }//GEN-LAST:event_PhaiActionPerformed
public void play_1()
    {
        
        if(Huong==1)
        {
            
        int Raiquan = a[ViTri];
        int Flag = ViTri+1;
        a[ViTri]=0;
        int lap =1;
        if(Raiquan==0)
        {
            return;
        }
        while(lap==1)
        {
        while(Raiquan!=0)
        {
            if(Flag>11)
            {
                Flag=0;
            }
            a[Flag]++;
            Flag++;
            Raiquan--;
        }
        if(Flag>11)
        {
            Flag=0;
        }
        if(Flag==0||Flag==6)
        {
            ViTri=Flag;
            break;
        }
        if(a[Flag]!=0)
        {
            lap=1;
            Raiquan=a[Flag];
            a[Flag]=0;
            Flag++;
        }
        else
        {
            ViTri=Flag;
            lap=0;
        }
        }
        TinhDiem();
        }
        else
        {
            int Raiquan = a[ViTri];
        int Flag = ViTri-1;
        a[ViTri]=0;
        int lap =1;
        if(Raiquan==0)
        {
            return;
        }
        while(lap==1)
        {
        while(Raiquan!=0)
        {
            if(Flag<0)
            {
                Flag=11;
            }
            a[Flag]++;
            Flag--;
            Raiquan--;
        }
        if(Flag<0)
        {
            Flag=11;
        }
        if(Flag==0||Flag==6)
        {
            ViTri = Flag;
            break;
        }
        if(a[Flag]!=0)
        {
            lap=1;
            Raiquan=a[Flag];
            a[Flag]=0;
            Flag--;
        }
        else
        {
            ViTri=Flag;
            lap=0;
        }
        System.out.println(ViTri);
        }
        TinhDiem();
        }
         
    }
    private void txtCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this,"bạn muốn thoát trò chơi")==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDActionPerformed
        // TODO add your handling code here:
        TT=0;
        PL_score=0;
        CP_score=0;
        txtCP.setText(""+CP_score);
        txtPlay.setText(""+PL_score);
        batdau();
    }//GEN-LAST:event_BDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BD;
    private javax.swing.JButton Phai;
    private javax.swing.JButton Trai;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jb0;
    private javax.swing.JButton jb1;
    private javax.swing.JButton jb10;
    private javax.swing.JButton jb11;
    private javax.swing.JButton jb2;
    private javax.swing.JButton jb3;
    private javax.swing.JButton jb4;
    private javax.swing.JButton jb5;
    private javax.swing.JButton jb6;
    private javax.swing.JButton jb7;
    private javax.swing.JButton jb8;
    private javax.swing.JButton jb9;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtPlay;
    // End of variables declaration//GEN-END:variables
}
