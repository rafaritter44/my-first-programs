public class Aluno
{
    private String nome, matricula;
    private double frequencia, p1, p2, p3, mediaExercicios;
    /**
     * Cria um aluno com nome e matrícula informados por parâmetro. Os demais atributos inicializam como -1.
     * @param nome Nome do aluno.
     * @param matricula Número de matrícula do aluno. Deve ser composta por 9 dígitos.
     */
    public Aluno(String nome, String matricula)
    {
        if(nome!=null)this.nome=nome;
        if(matricula!=null && matricula.length()==9)this.matricula=matricula;
        frequencia = 100;
        p1 = -1;
        p2 = -1;
        p3 = -1;
        mediaExercicios = -1;
    }
    /**
     * Devolve o nome do aluno.
     */
    public String getNome()
    {
        return nome;
    }
    /**
     * Devolve o número de matrícula do aluno.
     */
    public String getMatricula()
    {
        return matricula;
    }
    /**
     * Devolve a frequência do aluno.
     */
    public double getFrequencia()
    {
        return frequencia;
    }
    /**
     * Devolve a nota da primeira prova.
     */
    public double getP1()
    {
        return p1;
    }
    /**
     * Devolve a nota da segunda prova.
     */
    public double getP2()
    {
        return p2;
    }
    /**
     * Devolve a nota da terceira prova.
     */
    public double getP3()
    {
        return p3;
    }
    /**
     * Devolve a nota média dos exercícios.
     */
    public double getMediaExercicios()
    {
        return mediaExercicios;
    }
    /**
     * Ajusta a frequência do aluno.
     * @param frequencia Novo valor da frequência. Deve ser um valor dentro do intervalo [0,100].
     */
    public void setFrequencia(double frequencia)
    {
        if(frequencia>=0 && frequencia<=100)this.frequencia = frequencia;
    }
    /**
     * Altera a nota da primeira prova.
     * @param p1 Novo valor da primeira prova. Deve ser um valor dentro do intervalo [0,10].
     */
    public void setP1(double p1)
    {
        if(p1>=0 && p1<=10)this.p1=p1;
    }
    /**
     * Altera a nota da segunda prova.
     * @param p2 Novo valor da segunda prova. Deve ser um valor dentro do intervalo [0,10].
     */
    public void setP2(double p2)
    {
        if(p2>=0 && p2<=10)this.p2=p2;
    }
    /**
     * Altera a nota da terceira prova.
     * @param p3 Novo valor da terceira prova. Deve ser um valor dentro do intervalo [0,10].
     */
    public void setP3(double p3)
    {
        if(p3>=0 && p3<=10)this.p3=p3;
    }
    /**
     * Altera a nota média dos exercícios.
     * @param mediaExercicios Novo valor da média dos exercícios. Deve ser um valor dentro do intervalo [0,10].
     */
    public void setMediaExercicios(double mediaExercicios)
    {
        if(mediaExercicios>=0 && mediaExercicios<=10)this.mediaExercicios=mediaExercicios;
    }
    /**
     * Calcula a nota obtida no grau 1.
     * @return nota g1.
     */
    public double g1()
    {
        return (p1+2*p2+3*p3+mediaExercicios)/7;
    }
    /**
     * Verifica se o aluno foi ou não aprovado.
     * @return aprovação.
     */
    public boolean aprovado()
    {
        if(frequencia>=75 && g1()>=7)return true;
        return false;
    }
    public String toString()
    {
        return "Nome: " + nome + "\nMatrícula: " + matricula + "\nP1: " + p1 + "\nP2: " + p2 + "\nP3: " +
        p3 + "\nMédia dos Exercícios: " + mediaExercicios + "\nG1: " + g1();
    }
}