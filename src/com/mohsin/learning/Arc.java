package com.mohsin.learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Date : 05-Jul-2021
 * Description :
 */
public class Arc {

    static String str = " 715K 2009-09-23 system.zip~";

    public static void main(String[] args) throws ParseException {
        System.out.println(finmin());
    }

    static String finmin() throws ParseException {
            String[] lines = str.split("\\r?\\n");
            int min = Integer.MAX_VALUE;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date lastModDate=sdf.parse("1990-01-31");
            for (int i = 0; i < lines.length; i++) {
                String s = lines[i];
                if (s.charAt(s.length() - 1) == '~') {
                    String[] dir = s.trim().split(" ");
                    //size
                    Boolean isSize = true;
                    switch (dir[0].charAt(dir[0].length() - 1)) {
                        case 'K':
                            isSize = true;
                            break;
                        case 'M':
                            if (Integer.valueOf(dir[0].trim().substring(0, 3)) > 14) {
                                isSize = false;
                            } else {
                                isSize = true;
                            }
                            break;
                        case 'G':
                            isSize = false;
                            break;
                        default:
                            isSize = true;
                            break;
                    }
                    if (!isSize) continue;
                    //date
                    Date date=sdf.parse(dir[1]);
                    if(!date.after(lastModDate)) continue;
                    //min
                    min = Math.min(min, dir[2].substring(0, dir[2].indexOf('.')).length());
                }
            }
            return min==Integer.MAX_VALUE?"NO FILES": String.valueOf(min);
    }
}
