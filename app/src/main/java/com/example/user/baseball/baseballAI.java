package com.example.user.baseball;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by user on 5/21/2017.
 */
public class baseballAI {
    private String number;
    private String guessNumber1 = "0";
    private String guessNumber2 = "0";
    private String guessNumber3 = "0";
    private ArrayList<String> guess1 = new ArrayList<>();
    private ArrayList<String> guess2 = new ArrayList<>();
    private ArrayList<String> guess3 = new ArrayList<>();

    String temp;
    public baseballAI()
    {
        Random random = new Random();
        number = Integer.toString(random.nextInt(900) + 100);
    }
    public String getNumber(){
        return number;
    }
    public void createRandomNumber(String s) {
        Random random = new Random();

        String status = baseballAlgorithm(s);

        switch (status)
        {
            case "OOO":
                guessNumber1 = Integer.toString(random.nextInt(9));
                while(guess1.indexOf(guessNumber1) != -1)
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                }
                guess1.add(guessNumber1);

                guessNumber2 = Integer.toString(random.nextInt(9));
                while(guess2.indexOf(guessNumber2) != -1)
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                }
                guess2.add(guessNumber2);

                guessNumber3 = Integer.toString(random.nextInt(9));
                while(guess3.indexOf(guessNumber3) != -1)
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                }
                guess3.add(guessNumber3);
                break;
            case "SOO":
                guessNumber2 = Integer.toString(random.nextInt(9));
                while(guess2.indexOf(guessNumber2) != -1)
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                }
                guess2.add(guessNumber2);

                guessNumber3 = Integer.toString(random.nextInt(9));
                while(guess3.indexOf(guessNumber3) != -1)
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                }
                guess3.add(guessNumber3);
                break;
            case "OSO":
                guessNumber1 = Integer.toString(random.nextInt(9));
                while(guess1.indexOf(guessNumber1) != -1)
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                }
                guess1.add(guessNumber1);
                guessNumber3 = Integer.toString(random.nextInt(9));
                while(guess3.indexOf(guessNumber3) != -1)
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                }
                guess3.add(guessNumber3);
                break;
            case "OOS":
                guessNumber1 = Integer.toString(random.nextInt(9));
                while(guess1.indexOf(guessNumber1) != -1)
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                }
                guess1.add(guessNumber1);

                guessNumber2 = Integer.toString(random.nextInt(9));
                while(guess2.indexOf(guessNumber2) != -1)
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                }
                guess2.add(guessNumber2);
                break;

            case "SSO":
                guessNumber3 = Integer.toString(random.nextInt(9));
                while(guess3.indexOf(guessNumber3) != -1)
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                }
                guess3.add(guessNumber3);
                break;
            case "SOS":
                guessNumber2 = Integer.toString(random.nextInt(9));
                while(guess2.indexOf(guessNumber2) != -1)
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                }
                guess2.add(guessNumber2);
                break;
            case "OSS":
                guessNumber1 = Integer.toString(random.nextInt(9));
                while(guess1.indexOf(guessNumber1) != -1)
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                }
                guess1.add(guessNumber1);
                break;

            case "SBB":
                temp = guessNumber2;

                if(guess2.indexOf(guessNumber3) != -1)
                    guessNumber2 = guessNumber3;
                else
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                    while(guess2.indexOf(guessNumber1) != -1)
                    {
                        guessNumber2 = Integer.toString(random.nextInt(9));
                    }
                    guess2.add(guessNumber2);
                }

                if(guess3.indexOf(temp) != -1)
                    guessNumber3 = temp;
                else
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                    while(guess3.indexOf(guessNumber3) != -1)
                    {
                        guessNumber3 = Integer.toString(random.nextInt(9));
                    }
                    guess3.add(guessNumber3);
                }

                break;
            case "BSB":
                temp = guessNumber1;

                if(guess1.indexOf(guessNumber3) != -1)
                    guessNumber1 = guessNumber3;
                else
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                    while(guess1.indexOf(guessNumber1) != -1)
                    {
                        guessNumber1 = Integer.toString(random.nextInt(9));
                    }
                    guess1.add(guessNumber1);
                }

                if(guess3.indexOf(temp) != -1)
                    guessNumber3 = temp;
                else
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                    while(guess3.indexOf(guessNumber3) != -1)
                    {
                        guessNumber3 = Integer.toString(random.nextInt(9));
                    }
                    guess3.add(guessNumber3);
                }
                break;
            case "BBS":
                temp = guessNumber1;
                if(guess1.indexOf(guessNumber2) != -1)
                    guessNumber1 = guessNumber2;
                else
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                    while(guess1.indexOf(guessNumber1) != -1)
                    {
                        guessNumber1 = Integer.toString(random.nextInt(9));
                    }
                    guess1.add(guessNumber1);
                }

                if(guess2.indexOf(temp) != -1)
                    guessNumber2 = temp;
                else
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                    while(guess2.indexOf(guessNumber3) != -1)
                    {
                        guessNumber2 = Integer.toString(random.nextInt(9));
                    }
                    guess2.add(guessNumber3);
                }
                break;

            case "BOO":
                guessNumber2 = guessNumber1;
                while(guess2.indexOf(guessNumber2) != -1)
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                }
                guess2.add(guessNumber2);

                guessNumber3 = guessNumber1;
                while(guess3.indexOf(guessNumber3) != -1)
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                }
                guess3.add(guessNumber3);

                guessNumber1 = Integer.toString(random.nextInt(9));
                while(guess1.indexOf(guessNumber1) != -1)
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                }
                guess1.add(guessNumber1);
                break;
            case "OBO":
                guessNumber1 = guessNumber2;
                while(guess1.indexOf(guessNumber1) != -1)
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                }
                guess1.add(guessNumber1);

                guessNumber3 = guessNumber2;
                while(guess3.indexOf(guessNumber3) != -1)
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                }
                guess3.add(guessNumber3);

                guessNumber2 = Integer.toString(random.nextInt(9));
                while(guess2.indexOf(guessNumber2) != -1)
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                }
                guess2.add(guessNumber2);
                break;
            case "OOB":
                guessNumber1 = guessNumber3;
                while(guess1.indexOf(guessNumber1) != -1)
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                }
                guess1.add(guessNumber1);

                guessNumber2 = guessNumber3;
                while(guess2.indexOf(guessNumber2) != -1)
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                }
                guess2.add(guessNumber2);

                guessNumber3 = Integer.toString(random.nextInt(9));
                while(guess3.indexOf(guessNumber3) != -1)
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                }
                guess3.add(guessNumber3);
                break;

            case "BBO":
                if(guess3.indexOf(guessNumber1) == -1)
                {
                    guessNumber3 = guessNumber1;
                    guess3.add(guessNumber1);
                }
                else if(guess3.indexOf(guessNumber2) == -1)
                {
                    guessNumber3 = guessNumber2;
                    guess3.add(guessNumber2);
                }
                else
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                    while(guess3.indexOf(guessNumber3) != -1)
                    {
                        guessNumber3 = Integer.toString(random.nextInt(9));
                    }
                    guess3.add(guessNumber3);
                }

                temp = guessNumber1;
                if(guess1.indexOf(guessNumber2) == -1)
                {
                    guessNumber1 = guessNumber2;
                    guess1.add(guessNumber2);
                }
                else
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                    while(guess1.indexOf(guessNumber1) != -1)
                    {
                        guessNumber1 = Integer.toString(random.nextInt(9));
                    }
                    guess1.add(guessNumber1);
                }

                if(guess2.indexOf(temp) == -1)
                {
                    guessNumber2 = temp;
                    guess2.add(temp);
                }
                else
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                    while(guess2.indexOf(guessNumber2) != -1)
                    {
                        guessNumber2 = Integer.toString(random.nextInt(9));
                    }
                    guess2.add(guessNumber2);
                }



                break;
            case "BOB":
                if(guess2.indexOf(guessNumber1) == -1)
                {
                    guessNumber2 = guessNumber1;
                    guess2.add(guessNumber1);
                }
                else if(guess2.indexOf(guessNumber3) == -1)
                {
                    guessNumber2 = guessNumber3;
                    guess2.add(guessNumber3);
                }
                else
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                    while(guess2.indexOf(guessNumber2) != -1)
                    {
                        guessNumber2 = Integer.toString(random.nextInt(9));
                    }
                    guess2.add(guessNumber2);
                }

                temp = guessNumber1;
                if(guess1.indexOf(guessNumber3) == -1)
                {
                    guessNumber1 = guessNumber3;
                    guess1.add(guessNumber3);
                }
                else
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                    while(guess1.indexOf(guessNumber1) != -1)
                    {
                        guessNumber1 = Integer.toString(random.nextInt(9));
                    }
                    guess1.add(guessNumber1);
                }

                if(guess3.indexOf(temp) == -1)
                {
                    guessNumber3 = temp;
                    guess3.add(temp);
                }
                else
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                    while(guess3.indexOf(guessNumber3) != -1)
                    {
                        guessNumber3 = Integer.toString(random.nextInt(9));
                    }
                    guess3.add(guessNumber3);
                }

                break;
            case "OBB":
                if(guess1.indexOf(guessNumber2) == -1)
                {
                    guessNumber1 = guessNumber2;
                    guess1.add(guessNumber2);
                }
                else if(guess1.indexOf(guessNumber3) == -1)
                {
                    guessNumber1 = guessNumber3;
                    guess1.add(guessNumber3);
                }
                else
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                    while(guess1.indexOf(guessNumber1) != -1)
                    {
                        guessNumber1 = Integer.toString(random.nextInt(9));
                    }
                    guess1.add(guessNumber1);
                }

                temp = guessNumber2;
                if(guess2.indexOf(guessNumber3) == -1)
                {
                    guessNumber2 = guessNumber3;
                    guess2.add(guessNumber3);
                }
                else
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                    while(guess2.indexOf(guessNumber2) != -1)
                    {
                        guessNumber2 = Integer.toString(random.nextInt(9));
                    }
                    guess2.add(guessNumber2);
                }

                if(guess3.indexOf(temp) == -1)
                {
                    guessNumber3 = temp;
                    guess3.add(temp);
                }
                else
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                    while(guess3.indexOf(guessNumber3) != -1)
                    {
                        guessNumber3 = Integer.toString(random.nextInt(9));
                    }
                    guess3.add(guessNumber3);
                }
                break;
            case "BSO":
                guessNumber3 = guessNumber1;
                guessNumber1 = Integer.toString(random.nextInt(9));
                while(guess1.indexOf(guessNumber1) != -1)
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                }
                break;
            case "OSB":
                guessNumber1 = guessNumber3;
                guessNumber3 = Integer.toString(random.nextInt(9));
                while(guess3.indexOf(guessNumber3) != -1)
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                }
                break;
            case "SBO":
                guessNumber3 = guessNumber2;
                guessNumber2 = Integer.toString(random.nextInt(9));
                while(guess2.indexOf(guessNumber2) != -1)
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                }
                break;
            case "SOB":
                guessNumber2 = guessNumber3;
                guessNumber3 = Integer.toString(random.nextInt(9));
                while(guess3.indexOf(guessNumber3) != -1)
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                }
                break;
            case "BOS":
                guessNumber2 = guessNumber1;
                guessNumber1 = Integer.toString(random.nextInt(9));
                while(guess1.indexOf(guessNumber1) != -1)
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                }
                break;
            case "OBS":
                guessNumber1 = guessNumber2;
                guessNumber2 = Integer.toString(random.nextInt(9));
                while(guess2.indexOf(guessNumber2) != -1)
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                }
                break;
            case "BBB":
                String temp = guessNumber1;
                guessNumber1 = guessNumber2;
                guessNumber2 = temp;
                break;
            case "SBS":
                guessNumber2 = Integer.toString(random.nextInt(9));
                while(guess2.indexOf(guessNumber2) != -1)
                {
                    guessNumber2 = Integer.toString(random.nextInt(9));
                }
                break;
            case "SSB":
                guessNumber3 = Integer.toString(random.nextInt(9));
                while(guess3.indexOf(guessNumber3) != -1)
                {
                    guessNumber3 = Integer.toString(random.nextInt(9));
                }
                break;
            case "BSS":
                guessNumber1 = Integer.toString(random.nextInt(9));
                while(guess1.indexOf(guessNumber1) != -1)
                {
                    guessNumber1 = Integer.toString(random.nextInt(9));
                }
                break;



        }

    }
    public String getGuessNumber()
    {
        return guessNumber1+guessNumber2+guessNumber3;
    }
    public boolean isFinish(String s)
    {
        if(s.substring(0,1) == guessNumber1 && s.substring(1,2) == guessNumber2 || s.substring(2,3) == guessNumber3)
            return true;
        else
            return false;
    }
    //Match guess number with user's number
    public String baseballAlgorithm(String s)
    {
        String r = "";
        if(guessNumber1.charAt(0) == s.charAt(0))
            r += "S";
        else if(guessNumber1.charAt(0) == s.charAt(1))
            r += "B";
        else if(guessNumber1.charAt(0) == s.charAt(2))
            r += "B";
        else r += "O";

        if(guessNumber2.charAt(0) == s.charAt(0))
            r += "B";
        else if(guessNumber2.charAt(0) == s.charAt(1))
            r += "S";
        else if(guessNumber2.charAt(0) == s.charAt(2))
            r += "B";
        else r += "O";

        if(guessNumber3.charAt(0) == s.charAt(0))
            r += "B";
        else if(guessNumber3.charAt(0) == s.charAt(1))
            r += "B";
        else if(guessNumber3.charAt(0) == s.charAt(2))
            r += "S";
        else r += "O";

        return r;
    }
    //Match user's number with guess number
    public ArrayList match(String s)
    {
        ArrayList<String> arr = new ArrayList<>();

        for(int i=0; i < s.length(); i++)
        {
            int count =0;
            for(int j=0; j< s.length(); j++)
            {
                if(s.substring(i,i+1).equals(number.substring(j,j+1)))
                {
                    count++;
                    if(i==j)
                        arr.add("S");
                    else
                        arr.add("B");
                }
            }
            if(count == 0)
                arr.add("O");
        }
        return arr;
    }
}
