package lexer;

import java.util.ArrayList;

public class Parser {

 //   boolean flagList = false;

    boolean flag = false;
    boolean flag2 = false;
    int brascets = 0;
    int i=-1;
    int error = 0;
    ArrayList<ListOfLexems> lexems = new ArrayList<ListOfLexems>();

    public Parser (ArrayList<ListOfLexems> lexems )
    {
        //this.i=i;
        this.lexems = lexems;
    }

    public boolean lang (ArrayList<ListOfLexems> lexems)
    {
        while (i<lexems.size()-1)
        {
            expr ();
        }

        System.out.println("\n\n error = " + error);
        return (error==0);}

    public void expr () {

        if (i<lexems.size()-1) {
            if (lexems.get(i+1).value=="Var")
            {
                expr_value ();
                //System.out.println(lexems.get(i+1).lexem);
            }
            //System.out.println("loop");
            else if (lexems.get(i+1).value.equals("KeyWordList"))
            {myList ();}
            else if (lexems.get(i+1).value.equals("KeyWordAdd"))
            {AddElement ();}
            else if (lexems.get(i+1).value.equals("KeyWordRemove"))
            {RemoveElement ();}
            else if (lexems.get(i+1).value.equals("KeyWordGetSize"))
            {getSize ();}
            else if (lexems.get(i+1).value.equals("KeyWordGetElement"))
            {getElement ();}
            else if (lexems.get(i+1).value.equals("KeyWordFor"))
            {expr_for ();}
            else if (lexems.get(i+1).value.equals("KeyWordWhile"))
            {expr_wile ();}
            else if (lexems.get(i+1).value.equals("KeyWordIf"))
            {expr_if ();}
            else if (true)
            {System.out.println("error near" + lexems.get(i).lexem); i++; error++; return;}
        }
        //else return;
        //System.out.println("krya");
        //System.out.println(lexems.get(i+1).lexem);
    }
    public void myList ()
    {
        try {mList ();}
        catch (PlotoyadnyKeksik e) {}

        try {var ();}
        catch (PlotoyadnyKeksik e) {}

        try {Semicolon ();}
        catch (PlotoyadnyKeksik e) {}
    }
    public void AddElement ()
    {
        try {AddElements ();}
        catch (PlotoyadnyKeksik e) {}

        try {var ();}
        catch (PlotoyadnyKeksik e) {}

        try {Comma();}
        catch (PlotoyadnyKeksik e) {}

        try {value();}
        catch (PlotoyadnyKeksik e) {}

        try {Semicolon ();}
        catch (PlotoyadnyKeksik e) {}
    }
    public void RemoveElement ()
    {
        try {Remove ();}
        catch (PlotoyadnyKeksik e) {}

        try {var ();}
        catch (PlotoyadnyKeksik e) {}

        try {Semicolon ();}
        catch (PlotoyadnyKeksik e) {}
    }
    public void getSize ()
    {
        try {GetSize ();}
        catch (PlotoyadnyKeksik e) {}

        try {var ();}
        catch (PlotoyadnyKeksik e) {}

        try {Semicolon ();}
        catch (PlotoyadnyKeksik e) {}
    }
    public void getElement ()
    {
        try {GetElement ();}
        catch (PlotoyadnyKeksik e) {}

        try {var ();}
        catch (PlotoyadnyKeksik e) {}

        try {Comma();}
        catch (PlotoyadnyKeksik e) {}

        try {value();}
        catch (PlotoyadnyKeksik e) {}

        try {Semicolon ();}
        catch (PlotoyadnyKeksik e) {}
    }

    public void expr_value () {

        brascets = 0;

        try {var ();}
        catch (PlotoyadnyKeksik e) {}
        //System.out.println(i+"   0");

        try {Equally ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return;
        //System.out.println(i+"   1");

        //while (lexems.get(i+1).value!="Semicolon")


        try {value_brasket ();}
        catch (PlotoyadnyKeksik e) {}
        //System.out.println(i+"   2");

        if ((i<lexems.size()-1))
            while (!lexems.get(i+1).value.equals("Semicolon"))
            {
                // System.out.println(lexems.get(i+1).lexem);
                if (lexems.get(i+1).value =="Operation")
                    try {Operation();}
                    catch (PlotoyadnyKeksik e) {}
                if (lexems.get(i).value =="Semicolon") return;

                // проследить индекс в этом методе
                try {value_brasket ();}
                catch (PlotoyadnyKeksik e) {}
                if (lexems.get(i).value =="Semicolon") return;
            }

        if (lexems.size()!=i+1)
        try {Semicolon();}
        catch (PlotoyadnyKeksik e) {}

        if (brascets > 0)
        {
            System.out.println("May be you forgot ')'  ");
            error++;
        }
        else if (brascets < 0)
        {
            System.out.println("May be you forgot '('  ");
            error++;
        }
        //if (lexems.get(i).value =="Semicolon") return ();
        //System.out.println(i+"   3");
    }

    public void expr_for ()
    {
        try {KeyWordFor ();}
        catch (PlotoyadnyKeksik e) {}

        try {Open_bracket ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {var ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {Equally ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {value ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {Colon ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {var ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {booleanOP();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {value ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {Colon ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {var ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {Equally ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {var ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {Operation();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {value ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {Close_bracket ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;



        try {Open_brace();}
        catch (PlotoyadnyKeksik e) {}

        if ((i<lexems.size()-1))
            while (!lexems.get(i+1).value.equals("Close_brace"))
                if (!lexems.get(i+1).value.equals("Var")&!lexems.get(i+1).value.equals("KeyWordWhile")
                        &!lexems.get(i+1).value.equals("KeyWordFor")&!lexems.get(i+1).value.equals("KeyWordIf")
                        &!lexems.get(i+1).value.equals("KeyWordElse")
                        &!lexems.get(i+1).value.equals("KeyWordList")&!lexems.get(i+1).value.equals("KeyWordAdd")
                        &!lexems.get(i+1).value.equals("KeyWordRemove")&!lexems.get(i+1).value.equals("KeyWordGetElement")
                        &!lexems.get(i+1).value.equals("KeyWordGetSize"))
                {
                    System.out.println("error near" + lexems.get(i).lexem);
                    break;
                }
                else
                    expr ();


        try {Close_brace();}
        catch (PlotoyadnyKeksik e) {}



    }
    public void expr_wile ()
    {
        try {KeyWordWile ();}
        catch (PlotoyadnyKeksik e) {}

        try {Open_bracket ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {value ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {booleanOP ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {value ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {Close_bracket ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        //try {Semicolon();}
        // catch (PlotoyadnyKeksik e) {}

        try {Open_brace();}
        catch (PlotoyadnyKeksik e) {}

        if ((i<lexems.size()-1))
            while (!lexems.get(i+1).value.equals("Close_brace"))
                if (!lexems.get(i+1).value.equals("Var")&!lexems.get(i+1).value.equals("KeyWordWhile")
                        &!lexems.get(i+1).value.equals("KeyWordFor")&!lexems.get(i+1).value.equals("KeyWordIf")
                        &!lexems.get(i+1).value.equals("KeyWordElse") &!lexems.get(i+1).value.equals("KeyWordList")&!lexems.get(i+1).value.equals("KeyWordAdd")
                        &!lexems.get(i+1).value.equals("KeyWordRemove")&!lexems.get(i+1).value.equals("KeyWordGetElement")
                        &!lexems.get(i+1).value.equals("KeyWordGetSize"))
                {
                    System.out.println("error near" + lexems.get(i).lexem);
                    break;
                }
                else
                    expr ();


        try {Close_brace();}
        catch (PlotoyadnyKeksik e) {}


    }
    public void expr_else ()
    {
        try {KeyWordElse ();}
        catch (PlotoyadnyKeksik e) {}


        try {Open_brace();}
        catch (PlotoyadnyKeksik e) {}


        while ((i<lexems.size()-1)&(!lexems.get(i+1).value.equals("Close_brace")))
            if (!lexems.get(i+1).value.equals("Var")&lexems.get(i+1).value.equals("KeyWordWhile")
                    &!lexems.get(i+1).value.equals("KeyWordFor")&!lexems.get(i+1).value.equals("KeyWordIf")
                    &!lexems.get(i+1).value.equals("KeyWordElse") &!lexems.get(i+1).value.equals("KeyWordList")&!lexems.get(i+1).value.equals("KeyWordAdd")
                    &!lexems.get(i+1).value.equals("KeyWordRemove")&!lexems.get(i+1).value.equals("KeyWordGetElement")
                    &!lexems.get(i+1).value.equals("KeyWordGetSize"))
            {
                System.out.println("error near" + lexems.get(i).lexem);
                break;
            }
            else
                expr ();


        try {Close_brace();}
        catch (PlotoyadnyKeksik e) {}
    }
    public void expr_if ()
    {
        try {KeyWordIf ();}
        catch (PlotoyadnyKeksik e) {}


        try {Open_bracket ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {value ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {booleanOP ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {value ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        try {Close_bracket ();}
        catch (PlotoyadnyKeksik e) {}
        if (lexems.get(i).value.equals("Semicolon")) return ;

        // try {Semicolon();}
        //catch (PlotoyadnyKeksik e) {}


        try {Open_brace();}
        catch (PlotoyadnyKeksik e) {}


        while ((i<lexems.size()-1)&(!lexems.get(i+1).value.equals("Close_brace")))
            if (!lexems.get(i+1).value.equals("Var")&!lexems.get(i+1).value.equals("KeyWordWhile")
                    &!lexems.get(i+1).value.equals("KeyWordFor")&!lexems.get(i+1).value.equals("KeyWordIf")
                    &!lexems.get(i+1).value.equals("KeyWordElse") &!lexems.get(i+1).value.equals("KeyWordList")&!lexems.get(i+1).value.equals("KeyWordAdd")
                    &!lexems.get(i+1).value.equals("KeyWordRemove")&!lexems.get(i+1).value.equals("KeyWordGetElement")
                    &!lexems.get(i+1).value.equals("KeyWordGetSize"))
            {
                System.out.println("error near  " + lexems.get(i).lexem);
                break;
            }
            else
                expr ();


        try {Close_brace();}
        catch (PlotoyadnyKeksik e) {}

//        System.out.println(lexems.get(i+1).lexem);
        if (i+1<lexems.size()-1)
        if(lexems.get(i+1).lexem.equals("else"))
            expr_else ();
        // если  не конец программы и следующее елсе то вызвать елс

    }
    public void brasket() throws PlotoyadnyKeksik
    {
        //System.out.println(lexems.get(this.i).lexem+"    " + i + "  " + (!flag2));
        if(!flag2)i++;
        flag=true;

        try {Open_bracket ();}
        catch (PlotoyadnyKeksik e)
        {
            try {Close_bracket ();}
            catch (PlotoyadnyKeksik ex)
            {
                if (!flag2)
                {
                    error++;
                    System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting value or brascet");
                }
                else throw  new PlotoyadnyKeksik ("Waiting brasket");
            }
        }
        this.flag=false;
    }
    public void value_brasket () throws PlotoyadnyKeksik
    {
        //System.out.println(lexems.get(this.i).lexem+"    " + i + "  " );
        i++;
        this.flag2=true;
        try {value();}
        catch (PlotoyadnyKeksik e)
        {
            try {brasket();}
            catch (PlotoyadnyKeksik ex)
            {

                System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting value or brascet");
                error++;
            }
        }
        flag2=false;

    }
    public void value () throws PlotoyadnyKeksik
    {
        //System.out.println(lexems.get(this.i).lexem+"    " + i + "  " + (!flag2));
        if(!flag2)i++;
        flag=true;
        try {var();}
        catch (PlotoyadnyKeksik e)
        {
            try {Number();}
            catch (PlotoyadnyKeksik ex)
            {
                if (!flag2)
                {
                    error++;
                    System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting value");
                }
                else throw  new PlotoyadnyKeksik ("Waiting value");
            }
        }
        flag=false;
    }
    public void var  () throws PlotoyadnyKeksik
    {
        //System.out.println(lexems.get(this.i+1).lexem+"    " + i + "  " + (!flag));
        if (!flag)i++;
        if (!lexems.get(i).value.equals("Var"))
        {
            //System.out.println(lexems.get(this.i).lexem);
            if(!flag)
            {
                error++;
                System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting Var");
            }
            throw  new PlotoyadnyKeksik ("Waiting Var");
        }

    }
    public void Number () throws PlotoyadnyKeksik
    {
        //System.out.println(lexems.get(this.i).lexem+"    " + i + "  " + (!flag));
        if(!flag) i++;
        if (!lexems.get(i).value.equals("Number"))
        {
            if(!flag) {
                error ++;
                System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting Number");
            }

            throw new PlotoyadnyKeksik ("Waiting Number");
        }
    }
    public void Open_bracket () throws PlotoyadnyKeksik
    {
        if(!flag) i++;
        if (!lexems.get(this.i).value.equals("Open_bracket"))
        {
            if (!flag)
            {
                error++;
                System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting Open_bracket");
            }
            throw  new PlotoyadnyKeksik ("Waiting Open_bracket");
        } else brascets ++;
    }
    public void Close_bracket () throws PlotoyadnyKeksik
    {
        if(!flag) i++;
        if (!lexems.get(this.i).value.equals("Close_bracket"))
        {
            if(!flag)
            {
                error++;
                System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting Close_bracket");
            }
            throw  new PlotoyadnyKeksik ("Waiting Close_bracket");
        }  else brascets --;
    }
    public void Equally () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("Equally"))
        {
            error++;
            System.out.println("See  "+lexems.get(i).value+ " "+lexems.get(i).lexem+" but  waiting Equally");
            throw  new PlotoyadnyKeksik ("Waiting Equally");
        }
    }
    public void Semicolon () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(i).value.equals("Semicolon"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting Semicolon");
            throw new PlotoyadnyKeksik ("Waiting Semicolon");
        }
    }
    public void Operation() throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("Operation"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting Operation");
            throw  new PlotoyadnyKeksik ("Waiting Operation");
        }
    }
    public void KeyWordWile () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("KeyWordWhile"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting while");
            throw  new PlotoyadnyKeksik ("Waiting while");
        }
    }
    public void KeyWordFor () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("KeyWordFor"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting for");
            throw  new PlotoyadnyKeksik ("Waiting for");
        }
    }
    public void KeyWordIf () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("KeyWordIf"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting if");
            throw  new PlotoyadnyKeksik ("Waiting if");
        }
    }
    public void KeyWordElse () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("KeyWordElse"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting else");
            throw  new PlotoyadnyKeksik ("Waiting else");
        }
    }
    public void booleanOP() throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("booleanOP"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting booleanOP");
            throw  new PlotoyadnyKeksik ("Waiting booleanOP");
        }
    }
    public void Open_brace() throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("Open_brace"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting Open_brace");
            throw  new PlotoyadnyKeksik ("Waiting Open_brace");
        }
    }

    public void Close_brace() throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("Close_brace"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting Close_brace");
            throw  new PlotoyadnyKeksik ("Waiting Close_brace");
        }
    }

    public void Colon () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("Colon"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting Colon");
            throw  new PlotoyadnyKeksik ("Waiting Colon");
        }
    }

    public void mList () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("KeyWordList"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting KeyWordList");
            throw  new PlotoyadnyKeksik ("Waiting KeyWordList");
        }
    }
    public void AddElements () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("KeyWordAdd"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting KeyWordAdd");
            throw  new PlotoyadnyKeksik ("Waiting KeyWordAdd");
        }
    }
    public void Remove () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("KeyWordRemove"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting KeyWordRemove");
            throw  new PlotoyadnyKeksik ("Waiting KeyWordRemove");
        }
    }

    public void GetSize () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("KeyWordGetSize"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting KeyWordGetSize");
            throw  new PlotoyadnyKeksik ("Waiting KeyWordGetSize");
        }
    }

    public void GetElement () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("KeyWordGetElement"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  waiting KeyWordGetElement");
            throw  new PlotoyadnyKeksik ("Waiting KeyWordGetElement");
        }
    }

    public void Comma () throws PlotoyadnyKeksik
    {
        i++;
        if (!lexems.get(this.i).value.equals("Comma"))
        {
            error++;
            System.out.println("See  "+lexems.get(this.i).value+ " "+lexems.get(this.i).lexem+" but  Comma");
            throw  new PlotoyadnyKeksik ("Waiting Comma");
        }
    }
