package com.itfusen.comm.util;

import java.io.*;

/**
 * Created by qing on 11/16/17.
 */
public class JsonFileHelper {

    public static String readFromFile(String filePath,String fileName) throws IOException{
        String path = JsonFileHelper.class.getClassLoader().getResource(filePath+fileName).getPath().replace("%20", " ");
        File file = new File(path);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String lineTxt = null;
        StringBuilder sb = new StringBuilder();
        while((lineTxt = bufferedReader.readLine()) != null){
            sb.append(lineTxt);
        }
        reader.close();
        bufferedReader.close();
        return sb.toString();
    }
    public static void writeToFile(String filePath,String fileName, String json) throws IOException {
        String path = JsonFileHelper.class.getClassLoader().getResource(filePath+fileName).getPath().replace("%20", " ");
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.write(json);
        bw.flush();
        bw.close();
    }

   /* public static  void main(String[] args){
        String jsonString = null;
        try {
            jsonString = JsonFileHelper.readFromFile("json","/rateRank.json");
            RateLevelList rateLevelList= JSON.parseObject(jsonString,RateLevelList.class);
            rateLevelList.getRankData().get(0).setName("法师打发");
            JsonFileHelper.writeToFile("json","/rateRank.json",JSON.toJSONString(rateLevelList));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
