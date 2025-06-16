//Os pacotes servem pra modularizar a parada aqui no java (tipo TADs). Nao sao necessarios pro que
//eu to querendo fazer nesse projeto, que eh so guardar um monte de executaveis no mesmo lugar
//mas como o vscode reclamou pra caralho, ca estamos, serve de introducao pra parada.
//Declaramos um package current, agora o java espera que se deem os comandos todos pelo dir
//padrao, que eh o src, entao nele escrevemos javac current/J1_08.java pra compilar de dentro
//do pacote e java current.Main pra executar e dai funciona como se esperaria.

package current;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

//Nesse exercicio inclusive teria sido melhor ter usado um ArrayList, visto que tem aquela parte de 
//transferencia de funcionarios do exercicio que exige que aumente ou diminua o tamanho de um vetor
//(arrays em java tem tamanho fixo a partir do momento que sao criados arr[tam])

class J1_08{
    
  public static void main(String[] args){
      
      Scanner scanner = new Scanner(System.in);

      Empresa nova_empresa = new Empresa(scanner.next(), scanner.next(), scanner.nextInt());

      for(int i=0; i<nova_empresa.departamentos.length; i++){

          Departamento novo_departamento = new Departamento(scanner.next(), scanner.nextInt());

          for(int j=0; j<novo_departamento.n_funcionarios; j++){

              Funcionario novo_funcionario = new Funcionario(scanner.next(), scanner.nextFloat(), scanner.next());

              novo_departamento.adicionaFuncionario(novo_funcionario);
          }

          nova_empresa.adicionaDepartamento(novo_departamento);
      }

      scanner.close();

      // Aumenta salario dos funcionarios do primeiro departamento
      for(int i=0; i<nova_empresa.departamentos[0].n_funcionarios; i++){
        nova_empresa.departamentos[0].funcionarios[i].alteraSalario(10);
      }

      // Transfere o primeiro funcionario do primeiro departamento para o segundo
      nova_empresa.transfereFuncionario(0, 1, 0);
      
      // Configuração para usar vírgula como separador decimal
      DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
      simbolos.setDecimalSeparator(',');

      // Formato com padrão
      DecimalFormat formatador = new DecimalFormat("#.00", simbolos);
      
      for(int i=0; i<nova_empresa.n_departamentos; i++){
            
          // Resultado formatado
          String total_salarios = formatador.format(nova_empresa.departamentos[i].totalSalarios());
  
          System.out.printf("%s R$ ", nova_empresa.departamentos[i].nome);
          System.out.println(total_salarios);
      }
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

  public void alteraSalario(float porcentagem){

      if(porcentagem < 0){
        salario -= salario * porcentagem / 100;
      }

      else{
        salario += salario * porcentagem / 100;
      }
    }
}

class Departamento{
  
  String nome;
  Funcionario funcionarios[];
  int n_funcionarios;
  
  public Departamento(String nome, int n_funcionarios){
      
      this.nome = nome;
      this.n_funcionarios = 0;
      funcionarios = new Funcionario[n_funcionarios];
  }

  public void adicionaFuncionario(Funcionario f){

      // Aumenta capacidade
      if(funcionarios.length == n_funcionarios){
        
        Funcionario funcionarios_novo[] = new Funcionario[funcionarios.length * 2];
        System.arraycopy(funcionarios, 0, funcionarios_novo, 0, funcionarios.length);
        funcionarios = funcionarios_novo;
      }

      funcionarios[n_funcionarios] = f;
      n_funcionarios++;
  }

  public void removeFuncionario(int idx){

      for(int i=idx; i<n_funcionarios - 1; i++){
        funcionarios[i] = funcionarios[i + 1];
      }

      n_funcionarios--;
  }

  public float totalSalarios(){

      float salario_total = 0;

      // for(Funcionario f : funcionarios){
      //     salario_total += f.salario;
      // }

      for(int i=0; i<n_funcionarios; i++){
          salario_total += funcionarios[i].salario;
      }

      return salario_total;
  }
}

class Empresa{
  
  String nome;
  String cnpj;
  Departamento departamentos[];
  int n_departamentos;
  
  public Empresa(String nome, String cnpj, int n_departamentos){
      
      //posso passar direto que ele já vai ser alocado devidamente
      this.nome = nome;
      //preciso usar o this quando os nomes das variaveis forem iguais, como nesse caso
      this.cnpj = cnpj;
      this.n_departamentos = 0;
      departamentos = new Departamento[n_departamentos];
  }
  
  public void adicionaDepartamento(Departamento d){

      departamentos[n_departamentos] = d;
      n_departamentos++;
  }

  public void transfereFuncionario(int idx_dept_orig, int idx_dept_dest, int idx_funcionario){

    departamentos[idx_dept_dest].adicionaFuncionario(departamentos[idx_dept_orig].funcionarios[idx_funcionario]);
    departamentos[idx_dept_orig].removeFuncionario(idx_funcionario);
  }
}