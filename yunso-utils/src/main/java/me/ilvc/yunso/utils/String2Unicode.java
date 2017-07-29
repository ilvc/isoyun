package me.ilvc.yunso.utils;

public class String2Unicode {

	  
		/** 
		 * 字符串转换unicode 
		 */  
		public static String string2Unicode(String string) {  
		   
		    StringBuffer unicode = new StringBuffer();  
		   
		    for (int i = 0; i < string.length(); i++) {  
		   
		        // 取出每一个字符  
		        char c = string.charAt(i);  
		   
		        // 转换为unicode  
		        unicode.append("\\u" + Integer.toHexString(c));  
		    }  
		   
		    return unicode.toString();  
		}  
		/*unicode转换字符串java方法代码片段：  
		复制代码 代码如下:*/  
		  
		/** 
		 * unicode 转字符串 
		 */  
		public static String unicode2String(String unicode) {  
		   
		    StringBuffer string = new StringBuffer();  
		   
		    String[] hex = unicode.split("\\\\u");  
		   
		    for (int i = 1; i < hex.length; i++) {  
		   
		        // 转换出每一个代码点  
		        int data = Integer.parseInt(hex[i], 16);  
		   
		        // 追加成string  
		        string.append((char) data);  
		    }  
		   
		    return string.toString();  
		}  
}
