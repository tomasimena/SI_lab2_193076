import java.util.ArrayList;
import java.util.List;

class Time {
    int hours;
    int minutes;
    int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}

public class SILab2 {

    public static List<Integer> function(List<Time> timesList) {//1  -1h:18min:15sec

        List<Integer> result = new ArrayList<>();//2

        for (int i = 0; i < timesList.size(); i++) {//3
            int hr = timesList.get(i).getHours();//4
            int min = timesList.get(i).getMinutes();//4
            int sec = timesList.get(i).getSeconds();//4
            if (hr < 0 || hr > 24){//5    TX,FT,FF
                if (hr < 0){//6
                    throw new RuntimeException("The hours are smaller than the minimum");//7
                }
                else {//8
                    throw new RuntimeException("The hours are grater than the maximum");//8
                }
            }
            else if (hr < 24) {//9
                if (min < 0 || min > 59)//10       TX,FT,FF
                    throw new RuntimeException("The minutes are not valid!");//11
                else {//12
                    if (sec >= 0 && sec <= 59)//12     FX, TF, TT
                        result.add(hr * 3600 + min * 60 + sec);//13
                    else//14
                        throw new RuntimeException("The seconds are not valid");//14
                }
            }
            else if (hr == 24 && min == 0 && sec == 0) {//15 FXX, TFX, TTF, TTT
                result.add(hr * 3600 + min * 60 + sec);//16
            }
            else {//17
                throw new RuntimeException("The time is greater than the maximum");//17
            }
        }//18
        return result;//19
    }//20
}
