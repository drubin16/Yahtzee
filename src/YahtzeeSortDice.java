/**
 * Created by DanielRubin on 12/15/15.
 */
public class YahtzeeSortDice
{
    private int first;
    private int second;
    private int third;
    private int fourth;
    private int fifth;

    /* constructor: initializes the private data by sorting the order of the dice */
    public YahtzeeSortDice(int a, int b, int c, int d, int e) {
       // set Smallest
        if (a <= b && a <= c && a <= d && a <= e) {
            first = a;
            a = 7;
        } else if (b <= a && b <= c && b <= d && b <= e) {
            first = b;
            b = 7;
        } else if (c <= a && c <= b && c <= d && c <= e) {
            first = c;
            c = 7;
        } else if (d <= a && d <= b && d <= c && d <= e) {
            first = d;
            d = 7;
        } else {
            first = e;
            e = 7;
        }


        if (a <= b && a <= c && a <= d && a <= e) {
            second = a;
            a = 7;
        } else if (b <= a && b <= c && b <= d && b <= e) {
            second = b;
            b = 7;
        } else if (c <= a && c <= b && c <= d && c <= e) {
            second = c;
            c = 7;
        } else if (d <= a && d <= b && d <= c && d <= e) {
            second = d;
            d = 7;
        } else {
            second = e;
            e = 7;
        }
        if (a <= b && a <= c && a <= d && a <= e) {
            third = a;
            a = 7;
        } else if (b <= a && b <= c && b <= d && b <= e) {
            third = b;
            b = 7;
        } else if (c <= a && c <= b && c <= d && c <= e) {
            third = c;
            c = 7;
        } else if (d <= a && d <= b && d <= c && d <= e) {
            third = d;
            d = 7;
        } else {
            third = e;
            e = 7;
        }
        if (a <= b && a <= c && a <= d && a <= e) {
            fourth = a;
            a = 7;
        } else if (b <= a && b <= c && b <= d && b <= e) {
            fourth = b;
            b = 7;
        } else if (c <= a && c <= b && c <= d && c <= e) {
            fourth = c;
            c = 7;
        } else if (d <= a && d <= b && d <= c && d <= e) {
            fourth = d;
            d = 7;
        } else {
            fourth = e;
            e = 7;
        }
        if (a <= b && a <= c && a <= d && a <= e) {
            fifth = a;
            a = 7;
        } else if (b <= a && b <= c && b <= d && b <= e) {
            fifth = b;
            b = 7;
        } else if (c <= a && c <= b && c <= d && c <= e) {
            fifth = c;
            c = 7;
        } else if (d <= a && d <= b && d <= c && d <= e) {
            fifth = d;
            d = 7;
        } else {
            fifth = e;
            e = 7;
        }
    }
    /* returns the minimum of the five numbers */
    public int getFirst()
    {
        return first;
    }

    /* returns the second smallest of the five number */
    public int getSecond()
    {
        //your code here
        return second;
    }

    /* returns the middle of the five numbers */
    public int getThird()
    {
        //your code here
        return third;
    }

    /* returns the second largest of the five numbers */
    public int getFourth()
    {
        //your code here
        return fourth;
    }

    /* returns the biggest of the five numbers */
    public int getFifth()
    {
        //your code here
        return fifth;
    }
}
