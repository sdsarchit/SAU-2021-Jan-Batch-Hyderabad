import java.io.*;
import java.util.*;
class para extends Thread{
	int count=0;
	int i;
	int n;
	ArrayList<String> st;
	public para(ArrayList<String> st,int i,int n) {
		// TODO Auto-generated constructor stub
		this.st=st;
		this.i=i;
		this.n=n;
	}
	@Override
	public synchronized void run() {
		while(i<n) {
			if(st.get(i).contains("\n"))
			{++count;}
			i++;
		}
	}
}
public class paragraph {
	public static ArrayList<String> st;
	public static void init() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader("Book.txt"));
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		String ls = System.getProperty("line.separator");
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(ls);
		}
		// delete the last new line separator
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		reader.close();

		String t = stringBuilder.toString();
		String[] t1=t.split(" ");
		st=new ArrayList<String>();
		for(String s: t1) {
			st.add(s);
		}
	}

	public static void main(String[] arg) {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int len=10;
		int[] arr= {0,15,70,150,500,1600,2990,14447,33333,40348};
		para[] m=new para[len-1];
        long startTime = System.nanoTime();
		for(int i=0;i<len-1;i++) {
			m[i]=new para(st,arr[i],arr[i+1]);
			m[i].run();
		}
        long time = System.nanoTime() - startTime;
        int total=0;
        for(para w:m) {
        	try {
				w.join();
				total+=w.count;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        System.out.println("total no of words:"+" "+total);
		System.out.println("time required for execution"+" "+time/(1e+6)+" milliseconds");
	}
}
