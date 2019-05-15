package lexer;

public class List {
    Node first;
    Node last;
    int size = 0;


    public int getSize()
    {
        return size;
    }

    public void addBack (int value)
    {
        size++;
        if (first==null)
        {
            first = new Node(null,null,value);
            last=first;
        } else
            {
                Node node = new Node(null,last,value);
                this.last.next=node;
                this.last=node;
            }
    }

    public String removeBack()
    {
        String element = "List is empty";
        if (first!=null)
        {
            size--;
            element = "You killed "+ last.value;
            if (last.prev != null)
            {
                last.prev.next = null;
                last = last.prev;
            }
            else
                {
                first = null;
                last = null;
                }
        }

    return (element);
    }
    public int getElement (int index)
    { int element = 0;
    if (index <size)
    { Node node = first;
    if (index==0) return (first.value);
    else
    while (index>0)
    {
        index--;
        node = node.next;
        element = node.value;
    }

    }
    else System.out.println("This element doesn't exist");
       return element;
    }

}
