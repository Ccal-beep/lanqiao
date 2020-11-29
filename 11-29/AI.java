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
//Image img,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,currentImg;
Image currentImg;
Image heroleftImg[]=new Image[3];
Image herorightImg[]=new Image[3];
Image heroupImg[]=new Image[3];
Image herodownImg[]=new Image[3];
Image heroImg[][]=new Image[4][3];


int heroX,heroY;
//int leftFlag,rightFlag,upFlag,downFlag;
int Flag;
	public MainCanvas(){
		try{
		/*for(int i=0;i<heroleftImg.length;i++)
			heroleftImg[i]=Image.createImage("/sayo"+i+"2.png");
		for(int i=0;i<herorightImg.length;i++)
			herorightImg[i]=Image.createImage("/sayo"+i+"6.png");
		for(int i=0;i<heroupImg.length;i++)
			heroupImg[i]=Image.createImage("/sayo"+i+"4.png");
		for(int i=0;i<herodownImg.length;i++)
			herodownImg[i]=Image.createImage("/sayo"+i+"0.png");
			*/
			
		for(int i=0;i<heroImg.length;i++)//left=0,right=1,up=2,down=3
			for(int j=0;j<heroImg[i].length;j++)
			heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
		
		//left
		/*img2=Image.createImage("/sayo12.png");
		img4=Image.createImage("/sayo02.png");
		img5=Image.createImage("/sayo22.png");
		
		
		//right
		img3=Image.createImage("/sayo16.png");
		img6=Image.createImage("/sayo06.png");
		img7=Image.createImage("/sayo26.png");

		//up
		img1=Image.createImage("/sayo14.png");
		img8=Image.createImage("/sayo04.png");
		img9=Image.createImage("/sayo24.png");

		//down
		img=Image.createImage("/sayo10.png");
		img10=Image.createImage("/sayo00.png");
		img11=Image.createImage("/sayo20.png");
		*/
		currentImg=heroImg[3][1];
		heroX=120;
		heroY=100;
		/*leftFlag=0;
		rightFlag=0;
		upFlag=0;
		downFlag=0;
		*/
		Flag=0;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT)
		{
			picAndDirectionChange(0);
			/*if(leftFlag==0)
			{
				currentImg=heroImg[0][0];
				leftFlag++;			
			}
			else if(leftFlag==1)
			{
				currentImg=heroImg[0][2];
				leftFlag=0;
			}*/
			heroX--;			
			repaint();
		}
		if(action==RIGHT)
		{
			picAndDirectionChange(1);
			/*if(rightFlag==0)
			{
				currentImg=heroImg[1][0];
				rightFlag++;			
			}
			else if(rightFlag==1)
			{
				currentImg=heroImg[1][2];
				rightFlag=0;
			}*/
			heroX++;
			repaint();
		}
		if(action==UP)
		{
			picAndDirectionChange(2);
			/*if(upFlag==0)
			{
				currentImg=heroImg[2][0];
				upFlag++;			
			}
			else if(upFlag==1)
			{
				currentImg=heroImg[2][2];
				upFlag=0;
			}*/
			heroY--;
			repaint();
		}
		if(action==DOWN)
		{	
			picAndDirectionChange(3);
			/*if(downFlag==0)
			{
				currentImg=heroImg[3][0];
				downFlag++;			
			}
			else if(downFlag==1)
			{
				currentImg=heroImg[3][2];
				downFlag=0;
			}*/
			heroY++;			
			repaint();
		}
		

	}
	void  picAndDirectionChange(int directions){//left=0,right=1,up=2,down=3;
		if(Flag==0)
			{
				currentImg=heroImg[directions][0];
				Flag++;			
			}
			else if(Flag==1)
			{
				currentImg=heroImg[directions][2];
				Flag=0;
			}

	}
	

}