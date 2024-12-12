import java.util.Scanner;

class J1_08{
    
  public static void main(String[] args){
      
      Scanner scanner = new Scanner(System.in);

      Empresa nova_empresa = new Empresa(scanner.next(), scanner.next(), scanner.nextInt());

      for(int i=0; i<nova_empresa.departamentos.length; i++){

          Departamento novo_departamento = new Departamento(scanner.next(), scanner.nextInt());

          for(int j=0; j<novo_departamento.funcionarios.length; j++){

              Funcionario novo_funcionario = new Funcionario(scanner.next(), scanner.nextFloat(), scanner.next());

              novo_departamento.adicionaFuncionario(novo_funcionario);
          }

          nova_empresa.adicionaDepartamento(novo_departamento);
      }

      scanner.close();
  }
}

class Funcionario{
  
  String nome;
  String data_admissao;
  float salario;

  public Funcionario(String nome, float salario, String data_admissao){

      this.nome = nome;
      this.salario = salario;
      this.data_admissao = data_admissao;
  }
}

class Departamento{
  
  String nome;
  Funcionario funcionarios[];
  
  public Departamento(String nome, int n_funcionarios){
      
      this.nome = nome;
      funcionarios = new Funcionario[n_funcionarios];
  }

  public void adicionaFuncionario(Funcionario f){

      funcionarios[funcionarios.length] = f;
  }
}

class Empresa{
  
  String nome;
  String cnpj;
  Departamento departamentos[];
  
  public Empresa(String nome, String cnpj, int n_departamentos){
      
      //posso passar direto que ele já vai ser alocado devidamente
      this.nome = nome;
      //preciso usar o this quando os nomes das variaveis forem iguais, como nesse caso
      this.cnpj = cnpj;
      departamentos = new Departamento[n_departamentos];
  }
  
  public void adicionaDepartamento(Departamento d){

      departamentos[departamentos.length] = d;
  }
}