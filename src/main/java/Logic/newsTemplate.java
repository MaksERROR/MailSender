package Logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Aleks
 */
public class newsTemplate {



    private String title;
    private String date;
    private String path;
    private String imgPath;

    /**
     *
     * @param name title string
     * @param date date string
     * @param path path string
     * @param img image string
     */
    public newsTemplate(String name,String date,String path,String img){
        this.title = name;
        this.date = date;
        this.path = path;
        this.imgPath = img;
    }

    public static List<newsTemplate> SortByDate(List<newsTemplate> arr){
        ArrayList date = new ArrayList();
        
        ArrayList Date = new ArrayList();
        for(var obj:arr) {
            var dateTime =obj.date.split("T");
            var dateT = dateTime[0].split("-");
            dateT[0] = "0";
            var timeT = dateTime[1].split(":");
            timeT[timeT.length-1] = timeT[timeT.length-1].substring(0, timeT[timeT.length-1].length()-1);
            int timem =0;
            int count = 8;
            for(var obsj:dateT) {
                int exp = 1;
                for (int i = 0; i < count; i++) {
                    exp *=10;
                }
                timem += Integer.parseInt(obsj)*exp;
                count-=2;
            }
            for (int i = 0; i < timeT.length-1; i++) {
                int exp = 1;
                for (int j = 0; j < count; j++) {
                    exp *=10;
                }
                timem +=Integer.parseInt(timeT[i])*exp;
                count-=2;
            }
            Date.add(timem);
        }
        ArrayList rez = new ArrayList();
        ArrayList last = new ArrayList();
        last.addAll(Date);
        Collections.sort(last);
        for(var item:last){
            rez.add(arr.get(Date.indexOf(item)));
        }
        return rez;
    }
    
    public String GetName(){
        return title;
    }
    public String GetDate(){
        return date;
    }
    public String GetPath(){
        return path;
    }
    public String GetImgPath(){
        return imgPath;
    }
    
}
