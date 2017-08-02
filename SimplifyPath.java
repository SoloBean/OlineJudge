package simplifyPath;

import java.awt.List;
import java.util.LinkedList;

public class SimplifyPath {
	public String simplifyPaht(String path){
		if(path.length() == 0){  
			return path;  
        }  
           
        String[] splits = path.split("/");  
        LinkedList<String> stack = new LinkedList<String>();  
        for (String s : splits) {  
            if(s.length()==0 || s.equals(".")){  
                continue;  
            }else if(s.equals("..")){  
                if(!stack.isEmpty()){  
                    stack.pop();  
                }  
            }else{  
                stack.push(s);  
            }  
        }  
          
        if(stack.isEmpty()){  
            stack.push("");  
        }  
        String ret = "";  
        while(!stack.isEmpty()){  
            ret += "/" + stack.removeLast();  
        }  
        return ret;
	}
	
	public static void main(String[] args){
		SimplifyPath t = new SimplifyPath();
		String path = "/abc/...";
		String res = t.simplifyPaht(path);
		System.out.println(res); 
	}
}
