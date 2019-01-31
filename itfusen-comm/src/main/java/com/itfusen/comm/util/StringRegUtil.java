package com.itfusen.comm.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by qing on 11/20/17.
 */
public class StringRegUtil {

    public static void main(String[] args) {


        String str = "{377}:{987}[]";
        str = str.replace("[",":");
        str = StringFilter(str);
        String[] tempArray= str.split(":");

        String firstStr = tempArray[0];

        String seconndStr = tempArray[1];

        String[] thirdStr;
        if(tempArray.length >2)
            thirdStr= tempArray[2].split("\\,");

    }

    /**
     * 去除大括号中括号
     * @param str
     * @return
     * @throws PatternSyntaxException
     */
    public static String StringFilter(String str) throws PatternSyntaxException {
        String regEx = "[{} \\[\\]]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

}
