# TextFormatter
For formatting text in android like what whatsapp does. Any text enclosed with *s will be bolded, any text enclosed within _s will be italicized. 
Example :
"*Hello* World!" will become "**Hello** World" and "_Hello_ World!" will become "*Hello* World"

* Library Functions: 
### 1) FormatText.bold(String text) :
       The function will return a charSequence with *..text..* replaced by the text within *s bolded.
       
### 2) FormatText.italics(String text) :
       The function will return a charSequence with _..text.._ replaced by the text within _s italicized.

### 3) FormatText.boldAndItalics(String text) :
       The function will return a charSequence with texts enclosed in *s and _s replaced by those texts bolded and italicized.
       
### 4) FormatText.colorText(String text,String hexColor,boolean isBackground) :
       The function will return a charSequence with #..text..# replaced by ..text.. colored as hexColor
       (if isBackground is true, the color will be in the ..text.. beckground else the text will be colored with the hexColor).
       
* Example code: 
```java
        boldText = "*hello* world! Just *Coding*!!";
        italicsText = "_hello_ world! Just _Coding_!!";
        boldItalicsText = "_hello_ world! Just *Coding*!!";
        colorText = "hello world! #Just# Coding!!";

        FormatText.bold(boldText); 
        FormatText.italics(italicsText);
        FormatText.boldAndItalics(boldItalicsText);
        FormatText.colorText(colorText,"#b5bf50",true);
        
        FormatText.colorText(colorText,
                            "#cd001a",
                            false);
```
