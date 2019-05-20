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
                }
                else if (Pattern.matches("^List$",words[j]))
                {
                    ListOfLexems KeyWordList = new ListOfLexems(words[j],"KeyWordList");
                    program.add(KeyWordList);
                }
                else if (Pattern.matches("^remove$",words[j]))
                {
                    ListOfLexems KeyWordRemove = new ListOfLexems(words[j],"KeyWordRemove");
                    program.add(KeyWordRemove);
                }
                else if (Pattern.matches("^Add$",words[j]))
                {
                    ListOfLexems KeyWordAdd = new ListOfLexems(words[j],"KeyWordAdd");
                    program.add(KeyWordAdd);
                }
                else if (Pattern.matches("^getElement$",words[j]))
                {
                    ListOfLexems KeyWordGetElement = new ListOfLexems(words[j],"KeyWordGetElement");
                    program.add(KeyWordGetElement);
                }
                else if (Pattern.matches("^getSize$",words[j]))
                {
                    ListOfLexems KeyWordGetSize = new ListOfLexems(words[j],"KeyWordGetSize");
                    program.add(KeyWordGetSize);
                }

                else if (Pattern.matches("^while$",words[j]))
                {
                    ListOfLexems KeyWordWhile = new ListOfLexems(words[j],"KeyWordWhile");
                    program.add(KeyWordWhile);
                }

                else if (Pattern.matches("^HashAdd$",words[j]))
                {
                    ListOfLexems KeyWordHashAdd = new ListOfLexems(words[j],"KeyWordHashAdd");
                    program.add(KeyWordHashAdd);
                }
                else if (Pattern.matches("^HashRemove$",words[j]))
                {
                    ListOfLexems KeyWordHashRemove = new ListOfLexems(words[j],"KeyWordHashRemove");
                    program.add(KeyWordHashRemove);
                }
                else if (Pattern.matches("^HashContain$",words[j]))
                {
                    ListOfLexems KeyWordHashContain = new ListOfLexems(words[j],"KeyWordHashContain");
                    program.add(KeyWordHashContain);
                }
                else if (Pattern.matches("^HashSet$",words[j]))
                {
                    ListOfLexems KeyWordHashSet = new ListOfLexems(words[j],"KeyWordHashSet");
                    program.add(KeyWordHashSet);
                }

                else if (Pattern.matches("^for$",words[j]))
                {
                    ListOfLexems KeyWordFor = new ListOfLexems(words[j],"KeyWordFor");
                    program.add(KeyWordFor);
                }
                else if (Pattern.matches("^else$",words[j]))
                {
                    ListOfLexems KeyWordElse = new ListOfLexems(words[j],"KeyWordElse");
                    program.add(KeyWordElse);
                }
                else for (int k =0; k<words[j].length();k++) {
                        char[] chars = words[j].toCharArray();

                        String 	Sem = new String();
                        Sem = String.valueOf(chars[k]);

                        if (chars[k]==';')
                        {
                            ListOfLexems Semicolon = new ListOfLexems(Sem,"Semicolon");
                            program.add(Semicolon);
                        }

                        else if (chars[k]=='+'|chars[k]=='-'|chars[k]=='*'|chars[k]=='/')
                        {
                            ListOfLexems Operation = new ListOfLexems(Sem,"Operation");
                            program.add(Operation);
                        }

                        else if (chars[k]=='>'|chars[k]=='<'|Pattern.matches("!=|==|>=|<=",words[j])) /// доисправить
                        {
                            ListOfLexems booleanOP = new ListOfLexems(Sem,"booleanOP");
                            program.add(booleanOP);
                        }

                        else if (chars[k]==':')
                        {
                            ListOfLexems Colon = new ListOfLexems(Sem,"Colon");
                            program.add(Colon);
                        }

                        else if (chars[k]=='{')
                        {
                            ListOfLexems Open_brace = new ListOfLexems(Sem,"Open_brace");
                            program.add(Open_brace);
                        }

                        else if (chars[k]=='}')
                        {
                            ListOfLexems Close_brace = new ListOfLexems(Sem,"Close_brace");
                            program.add(Close_brace);
                        }

                        else if (chars[k]==',')
                        {
                            ListOfLexems Comma = new ListOfLexems(Sem,"Comma");
                            program.add(Comma);
                        }

                        else if (chars[k]=='(')
                        {
                            ListOfLexems Open_bracket = new ListOfLexems(Sem,"Open_bracket");
                            program.add(Open_bracket);
                        }

                        else if (chars[k]==')')
                        {
                            ListOfLexems Close_bracket = new ListOfLexems(Sem,"Close_bracket");
                            program.add(Close_bracket);
                        }

                        else if (chars[k]=='=')
                        {
                            ListOfLexems Equally = new ListOfLexems(Sem,"Equally");
                            program.add(Equally);
                        }
                        
                        else if (Character.isDigit(chars[k])) 
                        {
                            ListOfLexems Number = new ListOfLexems(Sem,"Number");
                            program.add(Number);
                        }

                        else if (Character.isLetter(chars[k]))
                        {
                            ListOfLexems Var = new ListOfLexems(Sem,"Var");
                            program.add(Var);
                        }

                        else if (Pattern.matches(".+",words[j]))
                        {
                            ListOfLexems Error = new ListOfLexems(words[j],"Error");
                            program.add(Error);
                        }
                    }
            }


        }

        ArrayList<ListOfLexems> massivOfLexems = new ArrayList<ListOfLexems>();

        int i = 0;

        while(i<program.size())
        {
            if(i<program.size())
                if(program.get(i).value.equals("Var"))
                {
                    String Krya = "";
                    while(program.size()>i&program.get(i).value.equals("Var"))
                    {
                        Krya += program.get(i).lexem;
                        i++;
                    }
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
                    ListOfLexems Number = new ListOfLexems(Krya,"Number");
                    massivOfLexems.add(Number);
                } else
                {
                    ListOfLexems Other = new ListOfLexems(program.get(i).lexem,program.get(i).value);
                    massivOfLexems.add(Other);
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
        try {program = MetodLexer.lexemSintex();}
        catch (Exception e) {e.printStackTrace();}
        Parser pars = new Parser(program);
        parser = pars.lang(program);
		Poliz object1 = new Poliz(program);
        if (parser)
		object1.Polish();

    }
