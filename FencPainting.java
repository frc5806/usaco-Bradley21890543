import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
//This used to be fence painting. Now its bessie on a tractor
public class FencPainting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//FileInputStream i=new FileInputStream(new File(""));
		//BufferedReader r=new BufferedReader(new InputStreamReader(i));
		Scanner r=new Scanner(System.in);
		String line=r.nextLine();
		int count1=Integer.parseInt(line.split(" ")[0]);
		int count2=Integer.parseInt(line.split(" ")[1]);
int[][] roadsegments = new int[count1][3];
int[][] besssegments = new int[count2][3];
int totallength=0;
int highest=0;
for(int i=0; i<count1; i++){
	String a=r.nextLine();
	int length=Integer.parseInt(a.split(" ")[0]);
	int speed=Integer.parseInt(a.split(" ")[1]);
	roadsegments[i][0]=totallength;
	roadsegments[i][1]=totallength+length;
	roadsegments[i][2]=speed;
	
	totallength+=length;
}
totallength=0;
for(int i=0; i<count2; i++){
	String a=r.nextLine();
	int length=Integer.parseInt(a.split(" ")[0]);
	int speed=Integer.parseInt(a.split(" ")[1]);
	besssegments[i][0]=totallength;
	besssegments[i][1]=totallength+length;
	besssegments[i][2]=speed;
	
	totallength+=length;
}

for(int i=0; i<count2; i++){
	for(int b=0; b<count1; b++){
		if(roadsegments[b][2]<besssegments[i][2]){
			if((roadsegments[b][0]<besssegments[i][0]&&roadsegments[b][1]>besssegments[i][0])||(roadsegments[b][0]>besssegments[i][0]&&besssegments[i][1]>roadsegments[b][0])){
				if(besssegments[i][2]-roadsegments[b][2]>highest){
					highest=besssegments[i][2]-roadsegments[b][2];
				}
			}
		}
	}
	
}
System.out.println(highest);
		
		}
	

}
