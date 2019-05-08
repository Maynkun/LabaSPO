package lexer;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.util.regex.Pattern;

class ListOfLexems {
    public String lexem;
    public String value;

    public ListOfLexems (String lexem, String value)
    {
        this.lexem = lexem;
        this.value=value;
    }
    public void setlexem(String lexem, String value)
    {
        this.lexem = lexem;
        this.value=value;
    }
    public String printLexem()
    {
        return(lexem);
    }
    public String printValue()
    {
        return(value);
    }
}

class LexerClass
{
    ArrayList<ListOfLexems> program = new ArrayList<ListOfLexems>();

    int i = 0;
    public LexerClass () {}
    public ArrayList<ListOfLexems> lexemSintex () throws Exception {
        FileReader file = new FileReader("Program.txt");
        Scanner scan = new Scanner (file);
        while (scan.hasNextLine())
        {
            String phrase = scan.nextLine();
            String[] words = phrase.split("[ \\t]");
            for(int j=0;j<words.length;j++)
            {

                if (Pattern.matches("^if$",words[j]))
                {
                    ListOfLexems KeyWordsIf = new ListOfLexems(words[j],"KeyWordIf");
                    program.add(KeyWordsIf);
                    //System.out.println(words[j]+"  KeyWord");
                }

                else if (Pattern.matches("^while$",words[j]))
                {
                    ListOfLexems KeyWordWhile = new ListOfLexems(words[j],"KeyWordWhile");
                    program.add(KeyWordWhile);
                    //	System.out.println(words[j]+"  Equally");
                }

                else if (Pattern.matches("^for$",words[j]))
                {
                    ListOfLexems KeyWordFor = new ListOfLexems(words[j],"KeyWordFor");
                    program.add(KeyWordFor);
                    //System.out.println(words[j]+"  Equally");
                }
                else if (Pattern.matches("^else$",words[j]))
                {
                    ListOfLexems KeyWordElse = new ListOfLexems(words[j],"KeyWordElse");
                    program.add(KeyWordElse);
                    //System.out.println(words[j]+"  Equally");
                }
                else for (int k =0; k<words[j].length();k++) {
                        char[] chars = words[j].toCharArray();

                        String 	Sem = new String();
                        Sem = String.valueOf(chars[k]);

                        if (chars[k]==';')
                        {
                            ListOfLexems Semicolon = new ListOfLexems(Sem,"Semicolon");
                            program.add(Semicolon);
                            //	System.out.println(words[j]+"  Equally");
                        }

                        else if (chars[k]=='+'|chars[k]=='-'|chars[k]=='*'|chars[k]=='/')
                        {
                            ListOfLexems Operation = new ListOfLexems(Sem,"Operation");
                            program.add(Operation);
                            //	System.out.println(words[j]+"  Operation");
                        }

                        else if (chars[k]=='>'|chars[k]=='<'|Pattern.matches("!=|==|>=|<=",words[j])) /// доисправить
                        {
                            ListOfLexems booleanOP = new ListOfLexems(Sem,"booleanOP");
                            program.add(booleanOP);
                            //	System.out.println(words[j]+"  Operation");
                        }

                        else if (chars[k]==':')
                        {
                            ListOfLexems Colon = new ListOfLexems(Sem,"Colon");
                            program.add(Colon);
                            //	System.out.println(words[j]+"  Equally");
                        }

                        else if (chars[k]=='{')
                        {
                            ListOfLexems Open_brace = new ListOfLexems(Sem,"Open_brace");
                            program.add(Open_brace);
                            //	System.out.println(words[j]+"  Equally");
                        }

                        else if (chars[k]=='}')
                        {
                            ListOfLexems Close_brace = new ListOfLexems(Sem,"Close_brace");
                            program.add(Close_brace);
                            //	System.out.println(words[j]+"  Equally");
                        }

                        else if (chars[k]=='(')
                        {
                            ListOfLexems Open_bracket = new ListOfLexems(Sem,"Open_bracket");
                            program.add(Open_bracket);
                            //	System.out.println(words[j]+"  Equally");
                        }

                        else if (chars[k]==')')
                        {
                            ListOfLexems Close_bracket = new ListOfLexems(Sem,"Close_bracket");
                            program.add(Close_bracket);
                            //	System.out.println(words[j]+"  Equally");
                        }

                        else if (chars[k]=='=')
                        {
                            ListOfLexems Equally = new ListOfLexems(Sem,"Equally");
                            program.add(Equally);
                            //	System.out.println(words[j]+"  Equally");
                        }


                        else if (Character.isDigit(chars[k]))  // доработать
                        {
                            ListOfLexems Number = new ListOfLexems(Sem,"Number");
                            program.add(Number);
                            //	System.out.println(words[j]+"  Number");
                        }

                        else if (Character.isLetter(chars[k])) // доработать
                        {
                            ListOfLexems Var = new ListOfLexems(Sem,"Var");
                            program.add(Var);
                            //System.out.println(words[j]+"  Var");
                        }

                        else if (Pattern.matches(".+",words[j]))
                        {
                            ListOfLexems Error = new ListOfLexems(words[j],"Error");
                            program.add(Error);
                            //System.out.println(words[j]+"  Error!");
                        }
                    }
            }


        }

        ArrayList<ListOfLexems> massivOfLexems = new ArrayList<ListOfLexems>();

        int i = 0;

        while(i<program.size())
        {
            //System.out.println(i);

            if(i<program.size())
                if(program.get(i).value.equals("Var"))
                {
                    String Krya = "";
                    while(program.size()>i&program.get(i).value.equals("Var"))
                    {
                        //System.out.println(program.get(i).lexem);
                        Krya += program.get(i).lexem;
                        i++;
                    }
//				System.out.println(Krya);
                    ListOfLexems Var = new ListOfLexems(Krya,"Var");
                    massivOfLexems.add(Var);
                } else if(program.get(i).value.equals("Number"))
                {
                    String Krya = "";
                    while(program.size()>i&program.get(i).value.equals("Number"))
                    {
                        //System.out.println(program.get(i).lexem);
                        Krya += program.get(i).lexem;
                        i++;
                    }
//					System.out.println(Krya);
                    ListOfLexems Number = new ListOfLexems(Krya,"Number");
                    massivOfLexems.add(Number);
                } else
                {
                    ListOfLexems Other = new ListOfLexems(program.get(i).lexem,program.get(i).value);
                    massivOfLexems.add(Other);
                    //System.out.println(program.get(i).lexem);
                    i++;

                }


        }


        for(i=0;i<massivOfLexems.size();i++)
        {
            System.out.println(massivOfLexems.get(i).printLexem()+"  "+massivOfLexems.get(i).printValue());
        }
        file.close();
        scan.close();
        return(massivOfLexems);}

}
class PlotoyadnyKeksik extends Exception{

    String str;
    PlotoyadnyKeksik(){}
    PlotoyadnyKeksik(String msg){
        str=msg;
    }
}

public class Lexer
{
    public static void main (String args[])
    {
        boolean parser;
        LexerClass MetodLexer = new LexerClass ();
        ArrayList<ListOfLexems> program = new ArrayList<ListOfLexems>();
        Poliz object = new Poliz(program);
        ArrayList<String> poliz = new ArrayList<String>();
        try {program = MetodLexer.lexemSintex();}
        catch (Exception e) {e.printStackTrace();}
        Parser pars = new Parser(program);
        parser = pars.lang(program);
		Poliz object1 = new Poliz(program);
//      System.out.println(parser);
        if (parser)
		poliz = object1.Polish();
    }
}