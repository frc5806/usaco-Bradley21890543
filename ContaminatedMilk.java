import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ContaminatedMilk {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner r=new Scanner(System.in);
        String first=r.nextLine();
        int n=Integer.parseInt(first.split(" ")[0]);
        int m=Integer.parseInt(first.split(" ")[1]);
        int d=Integer.parseInt(first.split(" ")[2]);
        int s=Integer.parseInt(first.split(" ")[3]);
        ArrayList<Integer> milks=new ArrayList<Integer>();
        ArrayList<ArrayList<int[]>> list=new ArrayList<ArrayList<int[]>>();
        int total=0;
        for(int i=1; i<m+1; i++){
            milks.add(new Integer(i));
            total+=1;
        }
        for(int i=0; i<n; i++){
            list.add(new ArrayList<int[]>());

        }
        for(int i=0; i<d; i++){
            String line=r.nextLine();
            int person=Integer.parseInt(line.split(" ")[0])-1;
            //System.out.println(n);
            list.get(person).add(new int[]{Integer.parseInt(line.split(" ")[1]),Integer.parseInt(line.split(" ")[2]) });
        }
        ArrayList<int[]> sicks=new  ArrayList<int[]>();

        for(int i=0; i<s; i++){
            String line=r.nextLine();
            int person=Integer.parseInt(line.split(" ")[0]);
            sicks.add(new int[]{person, Integer.parseInt(line.split(" ")[1])});
        }

        //System.out.println(sicks.size());
        for(int i=0; i<sicks.size(); i++){
            int person=sicks.get(i)[0]-1;
            int time=sicks.get(i)[1];
            //System.out.println("PPOP");
            ArrayList<Integer> newArray=new ArrayList<Integer>();
            for(int a=0; a<list.get(person).size(); a++){
                if(list.get(person).get(a)[1]<=time){
                    //System.out.println(list.get(person).get(a)[1]);
                    newArray.add(list.get(person).get(a)[0]);
                    System.out.println("KEEPING: "+String.valueOf(list.get(person).get(a)[0]));
                    //System.out.println(milks.remove(new Integer(list.get(person).get(a)[0])));
                }
            }

            ArrayList<Integer> newArray2=(ArrayList<Integer>) milks.clone();
            newArray2.removeAll(newArray);
            milks.removeAll(newArray2);
            //			ArrayList milks2=(ArrayList) milks.clone();
            //			Iterator<Integer> b=milks.iterator();
            //			while(b.hasNext()){
            //				Integer next=b.next();
            //				if(!list.get(person).contains(next)){
            //					System.out.println("Removing: "+String.valueOf(next));
            //					milks2.remove(next);
            //				}
            //			}
            //			milks=milks2;
        }
        int count=0;
        for(int i=0; i<milks.size(); i++){

            for(int a=0; a<list.size(); a++){
                drinks:
                    for(int b=0; b<list.get(a).size(); b++){
                        if(new Integer(list.get(a).get(b)[0]).equals(milks.get(i))){
                            count++;
                            System.out.println("Person: "+String.valueOf(a));
                            list.remove(a);
                            break drinks;
                        }
                    }
            }
        }
        System.out.println(count);
    }

}
