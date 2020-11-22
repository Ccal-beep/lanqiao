import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;

	*/
	Image heroImg[][]=new Image[4][3];
	Image currentImg;
	int x,y;
	int leftFlag,rightFlag,upFlag,downFlag;
	public MainCanvas(){
		try
		{
			/*left=0;
			  right=1;
			  up=2;
			  down=3;
			  
			  */
			for(int i=0;i<heroImg.length;i++)
				for(int j=0;j<heroImg[i].length;j++)
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			/*
			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img2=Image.createImage("/sayo14.png");
			img3=Image.createImage("/sayo16.png");
			
			
			//左
			img4=Image.createImage("/sayo02.png");
			img5=Image.createImage("/sayo22.png");
			
			//right

			img6=Image.createImage("/sayo06.png");
			img7=Image.createImage("/sayo26.png");
			
			//上
			img8=Image.createImage("/sayo04.png");
			img9=Image.createImage("/sayo24.png");
			//下

			img10=Image.createImage("/sayo00.png");
			img11=Image.createImage("/sayo20.png");
			*/
			
	
			currentImg=heroImg[3][1];
			x=100;
			y=50;
			leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(255,165,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
		
		
			if(leftFlag==1){
				currentImg=heroImg[0][0];
				leftFlag++;

			}

			else if(leftFlag==2){
				currentImg=heroImg[0][2];
				leftFlag=1;
			}

			x=x-1;
			repaint();
		}
		if(action==RIGHT){
			
			
			if(rightFlag==1){
				currentImg=heroImg[1][0];
				rightFlag++;

			}
			else if(rightFlag==2){
				currentImg=heroImg[1][2];
				rightFlag=1;
			}
			x=x+1;
			repaint();
		}
		if(action==UP){
			
			
			if(upFlag==1){
				currentImg=heroImg[2][0];
				upFlag++;

			}

			else if(upFlag==2){
				currentImg=heroImg[2][2];
				upFlag=1;
			}
			
			y=y-1;
			repaint();
		}
		if(action==DOWN){
			
			if(downFlag==1){
				currentImg=heroImg[3][0];
				downFlag++;

			}

			else if(downFlag==2){
				currentImg=heroImg[3][2];
				downFlag=1;
			}
			y=y+1;
			repaint();
		}
	}
}