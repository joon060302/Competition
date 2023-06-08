package Competition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

/*
RESET abracadabracabob
REPORT 3
REPORT 5
ADD BATH
DELETE boa
REPORT 5
DELETE drr
REPORT 5
RESET American Computer Science League
ADD Computer
DELETE Computer
DELETE COMPUTER
REPORT 10 
*/

public class ACSL1718_4adv {

    private static ArrayList<Character> letters =new ArrayList<Character>();
	private static ArrayList<Integer> counts=new ArrayList<Integer>();
	public static String[] history = new String[26];
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);

		for(int i=1;i<=13;i++)
		{
			String s=input.nextLine().toUpperCase();
			String com=s.substring(0,s.indexOf(" ")+1).trim();
			s=s.substring(s.indexOf(" ")+1).trim();
			int n=-1;
			if(s.matches("[0-9]*"))
			{
				n=Integer.parseInt(s)-1;
			}
			else
			{
				s=s.replaceAll("\\s","");
			}

			switch(com){
			case("RESET"):
				clearAllData();
				addData(s);
				break;
			case("ADD"):
				addData(s);
			    break;
			case("REPORT"):
				System.out.println(history[n]);
				break;
			case("DELETE"):
				deleteData(s);
			    break;
			}
		}
	}

	public static void clearAllData()
	{
		letters.clear();
		counts.clear();
		for(int i=0;i<history.length;i++)
		{
			history[i]="";
		}
	}
	
	public static void addData(String ss)
	{
		boolean first=false;
		if(letters.isEmpty() && counts.isEmpty())
		{
			first=true;
			letters.add(ss.charAt(0));
			counts.add(1);
			history[0] =history[0] + ss.charAt(0);
		}
		int f=0;
		if(first)
		{
			f=1;
		}
		for(int j=f;j<ss.length();j++)
		{
			for (int i = 0; i < letters.size(); i++)
			{
				if (ss.charAt(j) < letters.get(i))
				{
					letters.add(i, ss.charAt(j));
					counts.add(i, 1);
					for (int k = i; k < letters.size(); k++)
					{
						history[k] = history[k] + letters.get(k);
					}
					break;
				}
				else if (ss.charAt(j) == letters.get(i))
				{
					counts.set(i, counts.get(i)+1);
					break;
				}
				else if (i == letters.size()-1)
				{
					letters.add(i+1, ss.charAt(j));
					counts.add(i+1, 1);
					history[i+1] = history[i+1] + ss.charAt(j);
					break;
				}
			}
		}
	}
	
	public static void deleteData(String ss)
	{
		for(int i=0;i<ss.length();i++)
		{
			if(letters.contains(ss.charAt(i)))
			{
				int idx=letters.indexOf(ss.charAt(i));
				
				if(counts.get(idx)==1)
				{
					letters.remove(idx);
					counts.remove(idx);
					
					for (int k = idx; k < letters.size(); k++)
					{
						history[k] = history[k]+letters.get(k);
					}
				}
				else
				{
					int c=counts.get(idx)-1;
					counts.set(idx, c);
				}
			}
		}
	}
}
    /* 
    public static void main(String[] args) {
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
        ArrayList<String> index = new ArrayList<String>();
        ArrayList<Character> before = new ArrayList<Character>();
        ArrayList<Character> after = new ArrayList<Character>();
        Scanner sc = new Scanner(System.in);
        String command = "";
        String detail = "";
        String report = "";
        command = sc.next();
        detail = sc.nextLine().substring(1).toUpperCase();
        while(!command.equals("stop")){

            System.out.println(detail);
            System.out.println(before);
            System.out.println(index);

            after = before;

            if(command.equals("RESET")){
                table.clear();
                report = "";
                index.clear();
                before.clear();
                after.clear();

                for(int i=0; i<detail.length(); i++){
                    if(table.containsKey(detail.charAt(i))){
                        table.put(detail.charAt(i), table.get(detail.charAt(i))+1);
                    }
                    else{
                        table.put(detail.charAt(i), 1);
                        before.add(detail.charAt(i));
                    }
                    Collections.sort(before);
                    for(int j=0; j<before.size(); j++){
                        if(j<index.size()){
                            if(index.get(j).charAt(index.get(j).length()-1) != before.get(j)){
                                index.set(j, index.get(j)+before.get(j));
                            }
                        }
                        else{
                            index.add(before.get(j)+"");
                        }
                    }
                }
/* 
                Collections.sort(before);
                index.ensureCapacity(before.size());
                for(int i=0; i<index.size(); i++){
                    index.set(i, before.get(i)+"");
                }
            }


            else if(command.equals("ADD")){
                for(int i=0; i<detail.length(); i++){
                    if(table.containsKey(detail.charAt(i))){
                        table.put(detail.charAt(i), table.get(detail.charAt(i))+1);
                    }
                    else{
                        table.put(detail.charAt(i), 1);
                        after.add(detail.charAt(i));
                    }
                }
            }

            else if(command.equals("DELETE")){
                for(int i=0; i<detail.length(); i++){
                    if(table.containsKey(detail.charAt(i))){
                        table.remove(detail.charAt(i));     
                        after.remove(detail.charAt(i));   
                    }
                }
            }

            else if(command.equals("REPORT")){
                System.out.println(index.get(Integer.parseInt(detail)-1));
            }

            System.out.println(before);
            System.out.println(index);

            if(!command.equals("RESET")){
                Collections.sort(after);
                if(after.size()>before.size()){
                    before.ensureCapacity(after.size());
                }
                if(after.size()>index.size()){
                    index.ensureCapacity(after.size());
                }
                for(int i=0; i<before.size(); i++){
                    if(index.get(i).charAt(index.get(i).length()-1) != after.get(i)){
                        index.set(i, index.get(i)+after.get(i));
                    }
                }
            }

            command = sc.next();
            detail = sc.nextLine().substring(1);
        }
    }
}*/
