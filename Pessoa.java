public class Pessoa
{
    public Pessoa(){

    }

    public Pessoa(String sexo, int idade){
        this.sexo = sexo;
        this.idade = idade;
    }

    private String sexo;
    private int idade;    

    public String getSexo(){
        return sexo;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    @Override
    public String toString() {
        return sexo + idade;         
    }
}