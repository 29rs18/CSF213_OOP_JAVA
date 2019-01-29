/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textapp;
import java.util.*;


public class Token {
	String input;
	
	public Token(String entry)
	{
		input = entry;
	}
	String[] Split()
	{
		//String token[];
		StringTokenizer st = new StringTokenizer(this.input," #");
		System.out.println(st.countTokens());
                String token[] = new String[st.countTokens()];
		for(int i =0;st.hasMoreTokens();i++)
		{
			token[i] = st.nextToken();
                        System.out.println(token[i]);
		}
		return token;
			
	}
	String[] UniqueLabels(String words[])
	{
		
            for(int i = 0;i<words.length;i++)
            {
                words[i].toLowerCase();
            }
		int k = 0;
		int flag = 0;
                int count=1;
                for(int i = 0;i<words.length;i++)
                {
                    count = 1;
                    
                }
                Vector v = new Vector();
                v.
                System.out.println(" Unique "+ count);
		String[] x = new String[count];
		
		for(int i = 0;i<words.length;i++)
		{
			for(int j=i;j>=0;j--)
			{
				if(words[i].equals(words[j]))
				{
					flag = 1;
				}
				if(flag == 0)
				{
					x[k] = words[i]; 
					//this.wordlist[k] = x[k];
					k++;
				}
			}
		}
		return x;
	}
	String[] Count(String words[],String labels[])
	{
		int count;
		String freq[] = new String[labels.length];
		int freq1[] = new int[labels.length];
		
		for(int i = 0;i<labels.length;i++)
		{
			count = 0;
			for(int j = 0;j<words.length;j++)
				{
					if (labels[i]==words[j])
					{
						count++;
					}
				}
			freq1[i] = count;
			freq[i] = String.valueOf(freq1[i]);
//			
		}
		
		return freq;		
	}
	void display(int n)
	{
            String[] first = this.Split();
            String[] second = this.UniqueLabels(first);
            String[] ghost = this.Count(first, second);
            int[] third = new int[ghost.length];
            for(int i =0;i<third.length;i++)
                    {
                        third[i] = Integer.parseInt(ghost[i]); 
                        System.out.println(ghost[i]);
                    }
                    //Integer.parseInt(this.Count(first, second));
		String sorted[] = new String[n];
		int freqsorted[] = new int[n];
		int tracker = 0,k=0;
		for(int i = n ;i>0;i-- )
		{
			int max = 0;
			for(int j = 0;j<third.length;j++)
			{
				if(max<(third[j]))
				{
					max = third[j];
					tracker = j;
                                        System.out.println(third[j]);
				}
			}
			freqsorted[k]= max;
			sorted[k] = second[tracker];
			third[tracker] = -1;
			k++;
		}
		for(int i = 0;i<n;i++)
		{
			System.out.println(sorted[i]+" | " + freqsorted[i]);
		}
	}

}
