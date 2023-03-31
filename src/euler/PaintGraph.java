/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

//import static java.awt.Color.red;
import java.awt.Graphics;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */

 

public class PaintGraph extends JPanel
{
 public int sw=0;   
 private int ny , nx , oyn , oyk , oyx , oxn , oxk , oxy , ly , lx , xln, l2;
 private    float xng , kx , ky , hx , yg , xk;
 
        static int x, y,x_,y_,p, povtor=0;
        static final double Pi =355.0/113.0;
        static double x1, y1, phi=0, x2, y2,x3,y3,t,k,b,n=1000,m,R,R1,R2,R3,r,r9,k12,k13,k23,b12,b13,b23;
        static double l1,l22,l3,alpha1,alpha2,alpha3,xc,yc,xrc,yrc,xh,yh,xm,ym,Euler_k, Euler_b;
        static double dphi, da1, da2,xc00,yc00;
        static double xc9, yc9;


 public PaintGraph()
 {
  ny = 10;// цена деления  по шкалам
  ky = (float)0.5; // коэф шкалы по у
  kx = (float)0.5; // коэф шкалы по x
  oyn = 50; // начальный отступ по y
  oxn = 50 ; //начальный отступ по х
  ly = 400; // длина оси у
  lx = 600; // длина оси х
  // по умолчанию в начале на экран выводится график y=x
  sw = 5; // свич для переключения графика функции
  hx = (float)0.011;//шаг табуляции
  


       /*  R=200;
        phi=140.0;
	dphi=0;
        da1=59.7;  // прямоугольный треугольник
        da2=136.7;
        povtor=0;
        n=500;
        xc=735.1151266;
        yc=455.2881737;/**/

        
        /*  R=200;
        phi=80.0;
	dphi=0;
        da1=59.7;  // прямоугольный треугольник
        da2=86.7;
        povtor=0;
        n=500;
        xc=735.1151266;
        yc=455.2881737;/**/
        
          R=200;
        phi=-80.0;
	dphi=0;
        da1=59.7;  // прямоугольный треугольник
        da2=86.7;
        povtor=0;
        n=500;
        xc=735.1151266;
        yc=455.2881737;/**/
        
        
        

        /*  R=200;
        phi=-290.0;
	dphi=0;
        da1=40;      // остроугольный треугольник
        da2=137;
        povtor=0;
        n=500;
        xc=735.1151266;
        yc=455.2881737;/**/


        /*  R=200;
        phi=-290.0;
	dphi=0;
        da1=40;      // остроугольный треугольник
        da2=167;
        povtor=0;
        n=500;
        xc=735.1151266;
        yc=455.2881737;/**/
        

       /*  R=200;
        phi=160.0;
	dphi=0;
        da1=20;      // тупоугольный треугольник
        da2=-67;
        povtor=0;
        n=500;
        xc=735.1151266;
        yc=455.2881737;/**/
        
      /*    R=150;
        phi=60.0;
	dphi=0;
        da1=30;      // тупоугольный треугольник
        da2=-147;
        povtor=0;
        n=500;
        xc=735.1151266;
        yc=455.2881737;/**/
        
        /*  R=150;
        phi=100.0;
	dphi=0;
        da1=30;      // тупоугольный треугольник
        da2=-147;
        povtor=0;
        n=500;
        xc=735.1151266;
        yc=455.2881737;/**/
        
      /*    R=200;
        phi=100.0;
	dphi=0;
        da1=30;      // тупоугольный треугольник
        da2=-147;
        povtor=0;
        n=500;
        xc=735.1151266;
        yc=455.2881737;/**/
        
        
        
        xc00=700;
        yc00=450;/**/
  
  
 }

 //@Override
 //public void paint(int sw,Graphics g)
 public void paint(Graphics g)
 {  

          /*R=200;
        phi=20.0;
	dphi=0;
        da1=120;
        da2=30;
        povtor=0;
        n=300;
        xc=535.1151266;
        yc=355.2881737;/**/
     
  switch (sw)
  {   
   case 0:
        {
          InitPaintObject(g);
          break;
        }
          
   case 4:
        { 
          Fugure_coord(g);
          break;
        }
   
   case 5:
       {
          Fugure_triangle(g);
          break;
       }
  }
 
 }


 
         void trinagle()
        {            
            

            l1 = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
            l2 = (int)(Math.sqrt((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3)));
            l3 = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));

            //l1 = 360; l2 = 300; l3 = 450;


            alpha1 = Math.acos((l2 * l2 + l3 * l3 - l1 * l1) / (2 * l2 * l3));
            R1 = l1 / Math.sin(alpha1)/2; //Console.WriteLine("R=", R);
            R = R1;

            alpha2 = Math.acos((l1 * l1 + l3 * l3 - l2 * l2) / (2 * l1 * l3));
            R2 = l2 / Math.sin(alpha2)/2; //Console.WriteLine("R=", R);

            alpha3 = Math.acos((l1 * l1 + l2 * l2 - l3 * l3) / (2 * l1 * l2));
            R3 = l3 / Math.sin(alpha3)/2; //Console.WriteLine("R=", R);


            R1 = (l1 + l2 + l3) / 2;

            r = (l1 * l2*Math.sin(alpha3)/2 ) / R1;
            //r = l1 * l2 * l3 / (4*R)/R1;



            r9 = R / 2;
        }

void putpixel(Graphics g, int x, int y, int color) // Рисование пикселя
        {
            g.drawLine(x-1 , y-1, x,y); 
        }         

 
void InitPaintObject(Graphics g)
{
     
     //super.paint(g);
     //super.repaint();
     
     
     Dimension d = this.getPreferredSize();
     int fontSize = 20;
     g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));     
     g.setColor(Color.red);    
     //g.drawString("www.java2s.com", 10, 20);
        
        
        //int betax = 130; int betay = 90;
                
                
                
                
  int km = 0;

           //while (true)
            
                //super.paint(g);
                //super.repaint();
                km++;                

                phi += dphi;
                //da1 += 0.0411345*180/Pi; 
                //da2 += 0.0591345*180/Pi;

             


                x1 = (int)(xc + R * Math.cos(phi));
                y1 = (int)(yc + R * Math.sin(phi));

                //x2 = xc + R * Math.Cos(phi + 2*Math.Asin(l3 / (2 * R)));
                //y2 = xc + R * Math.Sin(phi + 2*Math.Asin(l3 / (2 * R)));

                x2 = (int)(xc + R * Math.cos(phi + da1)); // xml: da2
                y2 = (int)(yc + R * Math.sin(phi + da1)); // xml: da3

                x3 = (int)(xc + R * Math.cos(phi + da2));
                y3 = (int)(yc + R * Math.sin(phi + da2));

                trinagle();
                
                k23 = (y2 - y3) / (x2 - x3); b23 = (y3 * x2 - y2 * x3) / (x2 - x3);
                k12 = (y2 - y1) / (x2 - x1); b12 = (y1 * x2 - y2 * x1) / (x2 - x1);
                k13 = (y1 - y3) / (x1 - x3); b13 = (y3 * x1 - y1 * x3) / (x1 - x3);



                xrc = -(.5000000000 * (Math.sqrt(k12 * k12 + 1) * Math.sqrt(k23 * k23 + 1) * b12 - 1 * Math.sqrt(k12 * k12 + 1) * Math.sqrt(k23 * k23 + 1) * b23 + Math.sqrt(k13 * k13 + 1) * Math.sqrt(k23 * k23 + 1) * b12 - 1 * Math.sqrt(k13 * k13 + 1) * Math.sqrt(k23 * k23 + 1) * b23 + Math.sqrt(k13 * k13 + 1) * Math.sqrt(k12 * k12 + 1) * b12 - 1 * Math.sqrt(k13 * k13 + 1) * Math.sqrt(k12 * k12 + 1) * b23 + b12 * k23 * k23 + b13 * k12 * k12 - 1 * b13 * k23 * k23 - 1 * b23 * k12 * k12 + b12 - 1 * b23)) * (Math.sqrt(k12 * k12 + 1) * Math.sqrt(k23 * k23 + 1) * k13 - 1 * Math.sqrt(k13 * k13 + 1) * Math.sqrt(k23 * k23 + 1) * k12 - 1 * Math.sqrt(k13 * k13 + 1) * Math.sqrt(k12 * k12 + 1) * k23 + k12 * k13 * k23 + k12 - 1 * k13 + k23) / ((k12 * k12 - 1 * k23 * k23) * (k13 - 1 * k23) * (k12 - 1 * k13));
                yrc = (.5000000000 * (-1 * Math.sqrt(k13 * k13 + 1) * Math.sqrt(k23 * k23 + 1) + Math.sqrt(k12 * k12 + 1) * Math.sqrt(k23 * k23 + 1) - 1 * Math.sqrt(k13 * k13 + 1) * Math.sqrt(k12 * k12 + 1) + k12 * k13 - 1 * k23 * k12 + k23 * k13 + 1)) * (-1 * Math.sqrt(k13 * k13 + 1) * Math.sqrt(k23 * k23 + 1) * b12 * k12 * k23 + Math.sqrt(k13 * k13 + 1) * Math.sqrt(k23 * k23 + 1) * b23 * k12 * k12 - 1 * Math.sqrt(k12 * k12 + 1) * Math.sqrt(k23 * k23 + 1) * b12 * k13 * k23 + Math.sqrt(k12 * k12 + 1) * Math.sqrt(k23 * k23 + 1) * b23 * k12 * k13 - 1 * Math.sqrt(k13 * k13 + 1) * Math.sqrt(k12 * k12 + 1) * b12 * k23 * k23 + Math.sqrt(k13 * k13 + 1) * Math.sqrt(k12 * k12 + 1) * b23 * k12 * k23 - 1 * b12 * k12 * k13 * k23 * k23 + k12 * k12 * b23 * k13 * k23 - 1 * b12 * k12 * k13 + b13 * k12 * k12 - 1 * b13 * k23 * k23 + b23 * k13 * k23) / ((k12 * k12 - 1 * k23 * k23) * (k12 - 1 * k13) * (k13 - 1 * k23));


                xh = (k12 * k23 * y1 - k12 * k23 * y3 + k12 * x1 - k23 * x3) / (k12 - k23);
                yh = (k12 * y3 - k23 * y1 - x1 + x3) / (k12 - k23);


                xm = x1/3 + x2/3 + x3/3;
                ym = y1/3 + y2/3 + y3/3;

                

                //xrc = -(.5000000000 * (sqrt(k12 ^ 2 + 1.) * sqrt(k23 ^ 2 + 1.) * b12 - 1.* sqrt(k12 ^ 2 + 1.) * sqrt(k23 ^ 2 + 1.) * b23 + sqrt(k13 ^ 2 + 1.) * sqrt(k23 ^ 2 + 1.) * b12 - 1.* sqrt(k13 ^ 2 + 1.) * sqrt(k23 ^ 2 + 1.) * b23 + sqrt(k13 ^ 2 + 1.) * sqrt(k12 ^ 2 + 1.) * b12 - 1.* sqrt(k13 ^ 2 + 1.) * sqrt(k12 ^ 2 + 1.) * b23 + b12 * k23 ^ 2 + b13 * k12 ^ 2 - 1.* b13 * k23 ^ 2 - 1.* b23 * k12 ^ 2 + b12 - 1.* b23)) * (sqrt(k12 ^ 2 + 1.) * sqrt(k23 ^ 2 + 1.) * k13 - 1.* sqrt(k13 ^ 2 + 1.) * sqrt(k23 ^ 2 + 1.) * k12 - 1.* sqrt(k13 ^ 2 + 1.) * sqrt(k12 ^ 2 + 1.) * k23 + k12 * k13 * k23 + k12 - 1.* k13 + k23) / ((k12 ^ 2 - 1.* k23 ^ 2) * (k13 - 1.* k23) * (k12 - 1.* k13)); 
                //yrc = (.5000000000 * (-1.* sqrt(k13 ^ 2 + 1.) * sqrt(k23 ^ 2 + 1.) + sqrt(k12 ^ 2 + 1.) * sqrt(k23 ^ 2 + 1.) - 1.* sqrt(k13 ^ 2 + 1.) * sqrt(k12 ^ 2 + 1.) + k12 * k13 - 1.* k23 * k12 + k23 * k13 + 1.)) * (-1.* sqrt(k13 ^ 2 + 1.) * sqrt(k23 ^ 2 + 1.) * b12 * k12 * k23 + sqrt(k13 ^ 2 + 1.) * sqrt(k23 ^ 2 + 1.) * b23 * k12 ^ 2 - 1.* sqrt(k12 ^ 2 + 1.) * sqrt(k23 ^ 2 + 1.) * b12 * k13 * k23 + sqrt(k12 ^ 2 + 1.) * sqrt(k23 ^ 2 + 1.) * b23 * k12 * k13 - 1.* sqrt(k13 ^ 2 + 1.) * sqrt(k12 ^ 2 + 1.) * b12 * k23 ^ 2 + sqrt(k13 ^ 2 + 1.) * sqrt(k12 ^ 2 + 1.) * b23 * k12 * k23 - 1.* b12 * k12 * k13 * k23 ^ 2 + b23 * k12 ^ 2 * k13 * k23 - 1.* b12 * k12 * k13 + b13 * k12 ^ 2 - 1.* b13 * k23 ^ 2 + b23 * k13 * k23) / ((k12 ^ 2 - 1.* k23 ^ 2) * (k12 - 1.* k13) * (k13 - 1.* k23));


                 
                

                xc9 = (xc + xh) / 2; 
                yc9 = (yc + yh) / 2;

                
                Euler_k = (yc - yh) / (xc - xh);
                Euler_b = (yh * xc - yc * xh) / (xc - xh);

                
              

                m = 0;
                p = 0;
                
     fontSize = 15;
     g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));     
     g.setColor(Color.magenta);    
                
                g.drawString("Э - центр окружности 9 точек: ["+(int)xc9+"; "+(int)yc9+"]", 50, 50); 
                g.drawString("М - центроид или центр тяжести - точка пересечения медиан: ["+(int)xm+"; "+(int)ym+"]", 50, 70); 
                g.drawString("H - ортоцетр - точка пересечения высот: ["+(int)xh+"; "+(int)yh+"]", 50, 90); //  
                g.drawString("O -  центр описанной окружности: ["+(int)xc+"; "+(int)yc+"]", 50, 110); // 
                g.drawString("о - центр вписанной окружности: ["+(int)xrc+"; "+(int)yrc+"]", 50, 130); //  
                
     fontSize = 15;
     g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));     
     g.setColor(Color.black);    
     g.drawString("{1}", (int)x1-10, (int)y1-10); //  
     g.drawString("{2}", (int)x2-10, (int)y2-10); //  
     g.drawString("{3}", (int)x3-10, (int)y3-10); //  

                
     fontSize = 15;
     g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));     
     g.setColor(Color.magenta);    
               /*
        R=200;
        phi=20.0;
	dphi=0;
        da1=120;
        da2=30;
        povtor=0;
        n=300;
        xc=535.1151266;
        yc=455.2881737;/**/

                g.drawString("                       R = "+(int)R, 50, 170); 
                g.drawString("                     phi = "+(int)phi, 50, 190); 
                g.drawString("                    dphi = "+(int)dphi, 50, 210); //                  
                g.drawString("                   dphi1 = "+(int)da1, 50, 230); //  
                g.drawString("                   dphi2 = "+(int)da2, 50, 250); //  
                g.drawString("число вращений треугольника: "+povtor, 50, 270); //  
                g.drawString("                число точек: "+n, 50, 290); //  
                g.drawString("                      центр: ["+(int)xc+"; "+(int)yc+"]", 50, 310); //  
                
                g.drawString("    сторона  треугольника l1="+(int)l1+"; ", 50, 340); //  
                g.drawString("    сторона  треугольника l2="+(int)l2, 50, 360); //  
                g.drawString("    сторона  треугольника l3="+(int)l3, 50, 380); //  
                
                g.drawString("    [x1,y1]=["+(int)x1+"; "+(int)y1+"]", 50, 420); //  
                g.drawString("    [x2,y2]=["+(int)x2+"; "+(int)y2+"]", 50, 440); // 
                g.drawString("    [x3,y3]=["+(int)x3+"; "+(int)y3+"]", 50, 460); //  
                
                
                //g.drawString("", 50, 330); //  
                
                
                fontSize = 15;
     g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));     
     g.setColor(Color.blue);    
                
                
                
                g.drawString("Э", (int)xc9+5, (int)yc9); // центр окружности 9 точек
                g.drawString("М", (int)xm+5, (int)ym); // центроид или центр тяжести - точка пеересечения медиал
                g.drawString("H", (int)xh+5, (int)yh); //  ортоцетр - точка пересечения высот
                g.drawString("O", (int)xc+5, (int)yc); //  центр описанной окружности  
                g.drawString("о", (int)xrc+5, (int)yrc); //  центр вписанной окружности 
                
                g.drawString("alpha1="+(int)(Math.round(alpha1*180./Pi)), (int)x1+5, (int)y1); //  центр вписанной окружности 
                g.drawString("alpha2="+(int)(Math.round(alpha2*180./Pi)), (int)x2+5, (int)y2); //  центр вписанной окружности 
                g.drawString("alpha3="+(int)(Math.round(alpha3*180./Pi)), (int)x3+5, (int)y3); //  центр вписанной окружности 
                
                g.drawString("l1="+(int)l1, (int)((x2+x3)/2)+10, (int)((y2+y3)/2)); //  центр вписанной окружности 
                g.drawString("l2="+(int)l2, (int)((x1+x3)/2)+10, (int)((y1+y3)/2)); //  центр вписанной окружности 
                g.drawString("l3="+(int)l3, (int)((x1+x2)/2)-30, (int)((y1+y2)/2)); //  центр вписанной окружности 
                
                
                fontSize = 15;
     g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));     
     g.setColor(Color.red);    
}
 
 void Fugure_coord(Graphics g) 
 {           
        //InitPaintObject(g);
                while (p < n)
                {
                    x = (int)((xc00-300)+(600)*m/n);
                    y = (int)(yc00-300);                    
                    putpixel(g, x-1 , y-1, 355113); 
                    
                    if(m%50==0)
                    {
                      for(int v=0;v<20;v++){
                          int x0 = (int)(x);
                          int y0 = (int)((y-10)+(20)*v/25);                    
                          putpixel(g, x0-1 , y0-1, 355113); 
                          g.drawString(""+((int)x0), (int)x, (int)(y-20)); 
                      }    
                    }
                    
                    
                    x = (int)((xc00-300));
                    y = (int)((yc00-300)+(600)*m/n);                    
                    putpixel(g, x-1 , y-1, 355113); 
                    
                    if(m%50==0)
                    {
                      for(int v=0;v<25;v++){
                          int x0 = (int)((x-10)+(20)*v/25);
                          int y0 = (int)(y);                    
                          putpixel(g, x0 , y0, 0); 
                          g.drawString(""+((int)y0), (int)(x-40), (int)(y)); 
                      }    
                    }
                    
                    
                    //char[] ch={'E','E'};
                    
                    
     
                    


                    m++;
                    p++;

                }


                p = 0;

                
//        if (km > povtor) return;/ break;
                //if (Console.ReadKey()='y') break;
            }

        
 void Fugure_triangle(Graphics g) 
 {            
        InitPaintObject(g);
        
                while (p < n)
                {

                    x = (int)((xc00-300)+(600)*m/n);
                    y = (int)(yc00-300);                    
                    putpixel(g, x-1 , y-1, 355113); 
                    
                    if(m%50==0)
                    {
                      for(int v=0;v<20;v++){
                          int x0 = (int)(x);
                          int y0 = (int)((y-10)+(20)*v/25);                    
                          putpixel(g, x0-1 , y0-1, 355113); 
                          g.drawString(""+((int)x0), (int)x, (int)(y-20)); 
                      }    
                    }
                    
                    
                    x = (int)((xc00-300));
                    y = (int)((yc00-300)+(600)*m/n);                    
                    putpixel(g, x-1 , y-1, 355113); 
                    
                    if(m%50==0)
                    {
                      for(int v=0;v<25;v++){
                          int x0 = (int)((x-10)+(20)*v/25);
                          int y0 = (int)(y);                    
                          putpixel(g, x0 , y0, 0); 
                          g.drawString(""+((int)y0), (int)(x-40), (int)(y)); 
                      }    
                    }
                    
                    x = (int)(xh + (xc - xh) * m / n);
                    y = (int)(Euler_k * (xh + (xc - xh) * m / n) + Euler_b);                    
                    putpixel(g, x , y, 355113); 

                    x = (int)(x1 + (x2 - x1) * m / n);
                    y = (int)(k12 * (x1 + (x2 - x1) * m / n) + b12);                    
                    putpixel(g, x , y, 355113); 

                    x = (int)(x3 + (x2 - x3) * m / n);
                    y = (int)(k23 * (x3 + (x2 - x3) * m / n) + b23);                    
                    putpixel(g, x , y, 355113); 

                    x = (int)(x3 + (x1 - x3) * m / n);
                    y = (int)(k13 * (x3 + (x1 - x3) * m / n) + b13);
                    putpixel(g, x-1 , y-1, 355113); 

                    //putpixel((int)(x1 + (x2 - x1) * m / n),100,blue);
                    //putpixel((int)100,(int)(y1 + (y2 - y1) * m / n), blue);

                    t = (2 * Pi) * m / n;
                    x = (int)(xc + R * Math.cos(t));
                    y = (int)(yc + R * Math.sin(t));
                    putpixel(g, x-1 , y-1, 355113); 
                    if (p % 50 == 0)
                    {
                        //drawPoint = new PointF(x, y);
                        //drawString = "["+p+"]:{x=" + x + "; y=" + y + "}";
                        //g.DrawString(drawString, drawFont, drawPointBrush, drawPoint);
                    }


                    t = (2 * Pi) * m / n;
                    x = (int)(xrc + r * Math.cos(t));
                    y = (int)(yrc + r * Math.sin(t));                    
                    putpixel(g, x-1 , y-1, 355113); 


                    t = (2 * Pi) * m / n;
                    x = (int)(xc9 + r9 * Math.cos(t));
                    y = (int)(yc9 + r9 * Math.sin(t));                    
                    putpixel(g, x-1 , y-1, 355113); 


                    x = (int)(xrc + 3 * Math.cos(t));
                    y = (int)(yrc + 3* Math.sin(t));                    
                    putpixel(g, x-1 , y-1, 355113); 

                    x = (int)(xc + 3 * Math.cos(t));
                    y = (int)(yc + 3 * Math.sin(t));                    
                    putpixel(g, x-1 , y-1, 355113); 

                    x = (int)(xh + 3 * Math.cos(t));
                    y = (int)(yh + 3 * Math.sin(t));                    
                    putpixel(g, x-1 , y-1, 355113); 

                    x = (int)(xm + 3 * Math.cos(t));
                    y = (int)(ym + 3 * Math.sin(t));                    
                    putpixel(g, x-1 , y-1, 355113); 

                    x = (int)(xc9 + 3 * Math.cos(t));
                    y = (int)(yc9 + 3 * Math.sin(t));                    
                    putpixel(g, x-1 , y-1, 355113); 
                    //char[] ch={'E','E'};
                    
                    
     
                    


                    m++;
                    p++;

                }


                p = 0;

                
//        if (km > povtor) return;/ break;
                //if (Console.ReadKey()='y') break;
            }

        
  


  
 
 
 // группа getXXX(), setXXX() - методов
 



public int getNx() {
  return nx;
 }

public void setNx(int nx) {
  this.nx = nx;
 }
 public int getNy() {
  return ny;
 }
 public void setNy(int ny) {
  this.ny = ny;
 }
 public float getKy() {
  return ky;
 }
 public void setKy(float ky) {
  this.ky = ky;
 }
 public float getKx() {
  return kx;
 }
 public void setKx(float kx) {
  this.kx = kx;
 }
 public float getHx() {
  return hx;
 }
 public void setHx(float hx) {
  this.hx = hx;
 }
 public int getLx() {
  return lx;
 }
 public void setLx(int lx) {
  this.lx = lx;
 }
 public int getLy() {
  return ly;
 }
 public void setLy(int ly) {
  this.ly = ly;
 }
 public int getSw() {
  return sw;
 }
 public void setSw(int sw) {
  this.sw = sw;
 }
 public int getOyn() {
  return oyn;
 }
 public void setOyn(int oyn) {
  this.oyn = oyn;
 }
 public int getOxn() {
  return oxn;
 }
 public void setOxn(int oxn) {
  this.oxn = oxn;
 }
}

