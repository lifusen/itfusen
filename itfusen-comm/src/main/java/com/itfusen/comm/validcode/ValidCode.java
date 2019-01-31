package com.itfusen.comm.validcode;

import java.util.Random;

/**
 *author lifusen
 *date 2018年10月31日
 *description 验证码生成
 */
public class ValidCode {
	
	/**
	 *author lifusen
	 *date 2018年10月31日
	 *description 数字验证码生成
	 */
    public static String getValidCode(int size) 
    {
        String str = "0123456789";
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++)
        {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) 
    {
		System.out.println(getValidCode(4));
		System.out.println(getValidCode(5));
		System.out.println(getValidCode(6));
	}
    
}
