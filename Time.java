public class Time {
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public Time(int h, int m, int s) {
        this.hour = h;
        this.minute = m;
        this.second = s;
    }

    // getters
    public int getHour() {
        return hour;
    }
    public int getMinute() {
        return minute;
    }
    public int getSecond() {
        return second;
    }

    // setters
    public void setHour(int h) {
        this.hour = h;
    }
    public void setMinute(int m) {
        this.minute = m;
    }
    public void setSecond(int s) {
        this.second = s;
    }
    public void setTime(int h, int m, int s) {
        this.hour = h;
        this.minute = m;
        this.second = s;
    }


    public void print() {
        System.out.printf("%02d:%02d:%02d%n", hour, minute, second);
    }
        public void nextSecond() {
            second++;
            if (second >= 60) {
                second = 0;
                minute++;
                if (minute >= 60) {
                    minute = 0;
                    hour++;
                    if (hour >= 24) {
                        hour = 0;
                    }
                }
            }
        }

    public static void main(String[] args) {
        Time t = new Time(12, 5, 59);
        t.print();        
        t.nextSecond();   
        t.print();
        t.nextSecond();   
        t.print();           
    }
}
