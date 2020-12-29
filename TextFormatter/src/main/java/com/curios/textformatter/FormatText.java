package com.curios.textformatter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatText {

    /**
     *  All the processing is done under a try catch block so if there is any exceptions it will return the text as it is and print the exception stacktrace.
     **/

    /**
     * Any text enclosed between *s i.e *text* will be bolded
     * @param  text
     * @returns bolded and formatted text as a charsequence
     */
    public static CharSequence bold(CharSequence text) {

        try{
            Pattern pattern = Pattern.compile("\\*(.*?)\\*");
            SpannableStringBuilder ssb = new SpannableStringBuilder( text );

            if( pattern != null )
            {
                Matcher matcher = pattern.matcher( text );
                int matchesSoFar = 0;
                while( matcher.find() )
                {
                    int start = matcher.start() - (matchesSoFar * 2);
                    int end = matcher.end() - (matchesSoFar * 2);
                    CharacterStyle span = new StyleSpan(android.graphics.Typeface.BOLD);
                    ssb.setSpan( span, start + 1, end - 1, 0 );
                    ssb.delete(start, start + 1);
                    ssb.delete(end - 2, end -1);
                    matchesSoFar++;
                }
            }
            return ssb;
        }
        catch (Exception e){
            e.printStackTrace();
            return text;
        }
    }

    /**
     * Any text enclosed between _s i.e _text_ will be shown in italics
     * @param  text
     * @returns italicized formatted text as a charsequence
     */

    public static CharSequence italics(CharSequence text) {

        try{
            Pattern pattern = Pattern.compile("_(.*?)_");

            SpannableStringBuilder ssb = new SpannableStringBuilder( text );

            if( pattern != null )
            {
                Matcher matcher = pattern.matcher( text );
                int matchesSoFar = 0;
                while( matcher.find() )
                {
                    int start = matcher.start() - (matchesSoFar * 2);
                    int end = matcher.end() - (matchesSoFar * 2);
                    CharacterStyle span = new StyleSpan(Typeface.ITALIC);
                    ssb.setSpan( span, start + 1, end - 1, 0 );
                    ssb.delete(start, start + 1);
                    ssb.delete(end - 2, end -1);
                    matchesSoFar++;
                }
            }
            return ssb;
        }
        catch (Exception e){
            e.printStackTrace();
            return text;
        }
    }

    /**
     * Any text enclosed between *s i.e * text * will be bolded and any text enclosed within _s will shown in italics
     * @param  text
     * @returns bolded and italicized formatted text as a charsequence
     */

    public static CharSequence boldAndItalics(CharSequence text) {

        try{
            Pattern pattern = Pattern.compile("\\*(.*?)\\*");

            SpannableStringBuilder ssb = new SpannableStringBuilder( text );

            if( pattern != null )
            {
                Matcher matcher = pattern.matcher( text );
                int matchesSoFar = 0;
                while( matcher.find() )
                {
                    int start = matcher.start() - (matchesSoFar * 2);
                    int end = matcher.end() - (matchesSoFar * 2);
                    CharacterStyle span = new StyleSpan(android.graphics.Typeface.BOLD);
                    ssb.setSpan( span, start + 1, end - 1, 0 );
                    ssb.delete(start, start + 1);
                    ssb.delete(end - 2, end -1);
                    matchesSoFar++;
                }
            }
            pattern = Pattern.compile("_(.*?)_");
            if( pattern != null )
            {
                Matcher matcher = pattern.matcher( text );
                int matchesSoFar = 0;
                while( matcher.find() )
                {
                    int start = matcher.start() - (matchesSoFar * 2);
                    int end = matcher.end() - (matchesSoFar * 2);
                    CharacterStyle span = new StyleSpan(Typeface.ITALIC);
                    ssb.setSpan( span, start + 1, end - 1, 0 );
                    ssb.delete(start, start + 1);
                    ssb.delete(end - 2, end -1);
                    matchesSoFar++;
                }
            }
            return ssb;
        }
        catch (Exception e){
            e.printStackTrace();
            return text;
        }
    }

    /**
     * Any text enclosed between #s i.e * text * will be colored with a background color passed as the argument
     * @param  text
     * @param color : which color to put as background passed as hex color string
     * @param isBackground : True then color is set to background of text , if False then the text color is changed
     * @returns colored formatted text as a charsequence
     */

    public static CharSequence colorText(CharSequence text , String color, boolean isBackground) {
        try{
            Pattern pattern = Pattern.compile("#(.*?)#");
            SpannableStringBuilder ssb = new SpannableStringBuilder( text );

            if( pattern != null )
            {
                Matcher matcher = pattern.matcher( text );
                int matchesSoFar = 0;
                while( matcher.find() )
                {
                    int start = matcher.start() - (matchesSoFar * 2);
                    int end = matcher.end() - (matchesSoFar * 2);
                    Log.d("color","msg: "+color);
                    CharacterStyle span;
                    if(isBackground)
                        span = new BackgroundColorSpan(Color.parseColor(color));
                    else
                        span = new ForegroundColorSpan(Color.parseColor(color));
                    ssb.setSpan( span, start + 1, end - 1, 0 );
                    ssb.delete(start, start + 1);
                    ssb.delete(end - 2, end -1);
                    matchesSoFar++;
                }
            }
            return ssb;
        }
        catch (Exception e){
            e.printStackTrace();
            return text;
        }
    }
}
