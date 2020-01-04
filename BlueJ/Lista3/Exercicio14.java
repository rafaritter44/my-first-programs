public class Exercicio14
{
    public static void main(String args[])
    {
        System.out.println("\fSeg\tTer\tQua\tQui\tSex\tSab\tDom");
        System.out.print("\t\t");
        for(int dia = 1; dia<=30; dia++)
        {
            System.out.print(dia + "\t");
            if(dia==5||dia==12||dia==19||dia==26)System.out.print("\n");
        }
    }
}