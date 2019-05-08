package lexer;

import java.util.ArrayList;
import java.util.Stack;

public class Poliz {
    ArrayList<Data> data = new ArrayList<Data>();
    ArrayList<ListOfLexems> program = new ArrayList<ListOfLexems>();
    ArrayList<String> poliz = new ArrayList<String>();
    int iPol = 0;
    public Poliz(ArrayList<ListOfLexems> program)
    {
        this.program = program;
    }


    public void For ()
    {
        int i = poliz.size();

        poliz.add(program.get(iPol+2).lexem);
        poliz.add(program.get(iPol+4).lexem);
        poliz.add(program.get(iPol+3).lexem);

        int k = poliz.size()-3+link(iPol)-iPol+1; // ????? ??????
        if (Index(iPol)==program.size())
            k--;
        //      System.out.println(k);//Stack<String> stack = new Stack<String>();
        poliz.add(Integer.toString(k));

        poliz.add(program.get(iPol+6).lexem);
        poliz.add(program.get(iPol+8).lexem);
        poliz.add(program.get(iPol+7).lexem);

        poliz.add(program.get(iPol+10).lexem);
        poliz.add(program.get(iPol+12).lexem);
        poliz.add(program.get(iPol+14).lexem);
        poliz.add(program.get(iPol+13).lexem);
        poliz.add(program.get(iPol+11).lexem);
        poliz.add("!F");

        iPol+=17;
        while(!program.get(iPol).lexem.equals("}"))
            convert();

        poliz.add(Integer.toString(i+3));
        poliz.add("!");
        iPol++;
 //       System.out.println(poliz.get(k));
    }


    public void If ()
    {
     //   int i = iPol;
        int k = poliz.size()+link(iPol)-iPol+1;
        int i= Index(iPol);
        if (i==program.size())
        k--;
        else if (i+2<program.size())
            if (program.get(i).lexem.equals("else")&program.get(i+2).lexem.equals("}")&(i+3)>=program.size())
                k--;
 //       System.out.println(k);
        poliz.add(Integer.toString(k));
        //Stack<String> stack = new Stack<String>();
	//	poliz.add(k);
        poliz.add(program.get(iPol+2).lexem);
        poliz.add(program.get(iPol+4).lexem);
        poliz.add(program.get(iPol+3).lexem);
        poliz.add("!F");

        iPol+=7;

        while(!program.get(iPol).lexem.equals("}"))
            convert();

        int b = poliz.size();
        if (iPol+1<program.size())
        {
            if (program.get(iPol+1).lexem.equals("else"))
            {
                b =b +link(iPol+1) - iPol;
                System.out.println(program.get(i+2).lexem.equals("}"));
                if ((i+3)<program.size()&(program.get(i+2).lexem.equals("}")|Index(iPol+1)<program.size())) b++;
            }   else b +=2;
        } else b++;
 //       System.out.println(poliz.get(b));
        poliz.add(Integer.toString(b));
        poliz.add("!");
        iPol++; // ??????? ???
        if(iPol<program.size()-1)
        if (program.get(iPol).lexem.equals("else"))
        Else ();
    }


    public void Else ()
    {

    iPol+=2; // ????? ???

        while(!program.get(iPol).lexem.equals("}"))
            convert();

     //   if (iPol+1<program.size())
        iPol++;

    }
    public void While ()
    {
        int i = poliz.size();
        int k = poliz.size()+link(iPol)-iPol+1;
        if (Index(iPol)==program.size())
            k--;
//        System.out.println(poliz.size());
//        System.out.println(k);
        //Stack<String> stack = new Stack<String>();
        poliz.add(Integer.toString(k));
        poliz.add(program.get(iPol+2).lexem);
        poliz.add(program.get(iPol+4).lexem);
        poliz.add(program.get(iPol+3).lexem);
        poliz.add("!F");
//		poliz.add(program.get(iPol+7).lexem);

        iPol+=7;
//		System.out.println(program.size());
//		System.out.println(iPol);
//		System.out.println(program.get(iPol).lexem);
        while(!program.get(iPol).lexem.equals("}"))
            convert();

        poliz.add(Integer.toString(i));
        poliz.add("!");
        iPol++;
//        System.out.println(poliz.get(k));
    }
    public int Index (int iPol)
    {
        int a = iPol;
        int brace = 0;
        do
        {
            if (program.get(a).lexem.equals("if"))
            {
                brace++;
            }
            else if (program.get(a).lexem.equals("while"))
            {
                brace++;
            }
            else if (program.get(a).lexem.equals("for"))
            {
                brace++;
            }
            else if (program.get(a).lexem.equals("else"))
            {
                brace++;
            }
            else if (program.get(a).lexem.equals("}"))
            {
                brace--;
            }
            a++;
        }while (brace!=0);
        return (a);
    }
    public int link (int iPol)
    {
        int a = iPol;
        int brace = 0;
        int minus = 0;
        do
        {
//            System.out.println(program.get(a).lexem);
            if (program.get(a).lexem.equals("if"))
            {
                brace++;
                if (brace>1) minus++;
            }
            else if (program.get(a).lexem.equals("while"))
            {
                brace++;
                if (brace>1) minus++;
            }
            else if (program.get(a).lexem.equals("for"))
            {
                brace++;
                if (brace>1) minus++;
            }
            else if (program.get(a).lexem.equals("else"))
            {
                brace++;
                minus-=3;
            }
            else if (program.get(a).lexem.equals("}"))
            {
                brace--;
            }
            else if (program.get(a).lexem.equals(";")|program.get(a).lexem.equals("(")|program.get(a).lexem.equals(")")|program.get(a).lexem.equals(":"))
            {
                minus--;
            }

            a++;
        }while (brace!=0);
 //       if (program.size()==a)
 //           minus--;
        a+=minus;
//        System.out.println(iPol);
//        System.out.println(a-iPol);
        return (a);
    }
    public void Var ()
    {
        Stack<String> stack = new Stack<String>();
        poliz.add(program.get(iPol).lexem);
        stack.push(program.get(iPol+1).lexem);
        iPol+=2;

        while(!program.get(iPol).value.equals("Semicolon"))
        {
            if (program.get(iPol).value.equals("Var")|program.get(iPol).value.equals("Number"))
            {
                poliz.add(program.get(iPol).lexem);
                iPol++;
            }

            else if (program.get(iPol).value.equals("Operation")&stack.peek().equals("=")|program.get(iPol).lexem.equals("("))
            {
                stack.push(program.get(iPol).lexem);
                iPol++;
            }
            else if (program.get(iPol).lexem.equals("+")|program.get(iPol).lexem.equals("-"))
            {
//                boolean flag = false;
                while  (!stack.empty())
                    if (stack.peek().equals("(")|stack.peek().equals("="))
                    {
                        stack.push(program.get(iPol).lexem);
                        iPol++;
 //                       flag = true;
                        break;
                    }
                    else
                        poliz.add(stack.pop());
//                if (!flag)
//                stack.push(program.get(iPol).lexem);
//                iPol++;
            }
            else if (program.get(iPol).lexem.equals("*")|program.get(iPol).lexem.equals("/"))
            {
                if (stack.peek().equals("*")|stack.peek().equals("/"))
                {
                    poliz.add(stack.pop());
                    stack.push(program.get(iPol).lexem);
                    iPol++;
                }
                else
                {
                    stack.push(program.get(iPol).lexem);
                    iPol++;
                }

            }
            else if (program.get(iPol).lexem.equals(")"))
            {
                while  (!stack.peek().equals("("))
                    poliz.add(stack.pop());
                stack.pop();
                iPol++;
            }
        }
        if (program.get(iPol).value.equals("Semicolon"))
        {
//			System.out.println(program.get(iPol).value == "Semicolon");
            while (!stack.empty())
                poliz.add(stack.pop());
        }

        iPol++;

    }

    public boolean eq (String dataName)
    {
        for(int k=0;k<data.size();k++)
        {
            if (data.get(k).name.equals(dataName))
            {
                return (true);
            }
        }
        return (false);
    }

    public int eqIndex (String dataName)
    {
        for(int k=0;k<data.size();k++)
            if (data.get(k).name.equals(dataName))
                return (k);
        return (0);  //  здесь искать причину ошибок
    }

    public void initialization ()
    {
        int i;
        for(i=0;i<program.size();i++)
            if (program.get(i).value.equals("Var"))
            {
                if (!eq(program.get(i).lexem))
                {
                    Data variable = new Data(program.get(i).lexem,0);
                    data.add(variable);
                }
            }
//		for(int k=0;k<data.size();k++)
//		System.out.println(data.get(k).name+ "  " + data.get(k).value);
    }

    public ArrayList<String> Polish ()
    {
        while (iPol<program.size())
            convert ();

        for(int k=0;k<poliz.size();k++)
            System.out.print(poliz.get(k)+" ");
        return (poliz);
    }


    public void convert ()
    {

        if (program.get(iPol).value.equals("Var"))
            Var();
        else if (program.get(iPol).lexem.equals("while"))
            While();
        else if (program.get(iPol).lexem.equals("if"))
            If();
        else if (program.get(iPol).lexem.equals("for"))
            For();
    }
}