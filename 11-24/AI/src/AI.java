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
class MainCanvas extends Canvas implements Runnable
{

	/*
	����������
	�﷨���������� �������ƣ���ʶ����;

	*/
	Thread thread;
	Image heroImg[][]=new Image[4][3];
	Image currentImg;
	Image bossImg;
	int heroX,heroY,bossX,bossY;
	int flag;
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
			bossImg=Image.createImage("/ninjin.png");
			currentImg=heroImg[3][1];
			heroX=100;
			heroY=50;
			bossX=0;
			bossY=0;
			flag=1;
			thread=new Thread(this);
			thread.start();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(200);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(bossX<heroX){
				bossX++;
			}
			else{
				bossX--;
			}
			if(bossY<heroY){
				bossY++;
			}
			else{
				bossY--;
			}
			repaint();
		}

	}
	public void paint(Graphics g){
		g.setColor(255,165,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);//120��X���ꡢ100��Y����
		g.drawImage(bossImg,bossX,bossY,0);

	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action��ֵ��UP��DOWN��LEFT��RIGHT
		*/
		if(action==LEFT){			
			changePicAndDirection(0);
			heroX=heroX-1;
			repaint();
			
		}
		if(action==RIGHT){
			changePicAndDirection(1);
			heroX=heroX+1;
			repaint();
			
		}
		if(action==UP){	
			changePicAndDirection(2);
			heroY=heroY-1;		
			repaint();
		}
		if(action==DOWN){
			changePicAndDirection(3);
			heroY=heroY+1;
			repaint();
		}

	}
	
void changePicAndDirection(int direction){
		if(flag==1){
			currentImg=heroImg[direction][0];
			flag++;
		}

		else if(flag==2){
			currentImg=heroImg[direction][2];
			flag=1;
		}
		
	}
}