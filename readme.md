# Modelo de Dados - Sistema de Consultas Médicas

## Tabelas

### 1. **TB_USUARIOS**
Armazena os dados dos usuários do sistema (recepcionista, médico, administrador).
- **ID_USUARIO** (INT): Identificador único do usuário.
- **DS_NOME** (VARCHAR(100)): Nome completo do usuário.
- **DS_EMAIL** (VARCHAR(100)): E-mail do usuário (único).
- **DS_SENHA** (VARCHAR(255)): Senha criptografada do usuário.
- **DS_PERFIL** (ENUM): Tipo de perfil do usuário (Recepcionista, Médico, Administrador).

### 2. **TB_PACIENTES**
Armazena as informações dos pacientes.
- **ID_PACIENTE** (INT): Identificador único do paciente.
- **DS_NOME** (VARCHAR(100)): Nome completo do paciente.
- **DS_CPF** (VARCHAR(14)): CPF do paciente (único).
- **DT_NASCIMENTO** (DATE): Data de nascimento do paciente.
- **DS_TELEFONE** (VARCHAR(20)): Telefone de contato do paciente.
- **DS_ENDERECO** (TEXT): Endereço do paciente.
- **DS_PLANO_SAUDE** (VARCHAR(50)): Plano de saúde do paciente.

### 3. **TB_MEDICOS**
Armazena as informações dos médicos.
- **ID_MEDICO** (INT): Identificador único do médico.
- **DS_NOME** (VARCHAR(100)): Nome completo do médico.
- **DS_ESPECIALIDADE** (VARCHAR(100)): Especialidade do médico.
- **DS_CRM** (VARCHAR(20)): Número do CRM do médico (único).

### 4. **TB_CONSULTAS**
Armazena as consultas agendadas ou realizadas.
- **ID_CONSULTA** (INT): Identificador único da consulta.
- **ID_PACIENTE** (INT): Referência ao paciente (FK).
- **ID_MEDICO** (INT): Referência ao médico (FK).
- **DT_CONSULTA** (DATETIME): Data e hora da consulta.
- **DS_STATUS** (ENUM): Status da consulta (Agendada, Realizada, Cancelada).
- **DS_OBSERVACOES** (TEXT): Observações sobre a consulta.

### 5. **TB_PRONTUARIOS**
Armazena os prontuários médicos de cada paciente.
- **ID_PRONTUARIO** (INT): Identificador único do prontuário.
- **ID_PACIENTE** (INT): Referência ao paciente (FK).
- **ID_MEDICO** (INT): Referência ao médico que registrou o prontuário (FK).
- **DT_REGISTRO** (DATETIME): Data e hora do registro.
- **DS_DESCRICAO** (TEXT): Descrição do atendimento registrado.

### 6. **TB_RECEITAS**
Armazena as receitas médicas.
- **ID_RECEITA** (INT): Identificador único da receita.
- **ID_CONSULTA** (INT): Referência à consulta associada à receita (FK).
- **DS_MEDICAMENTOS** (TEXT): Lista de medicamentos prescritos.
- **DS_ORIENTACOES** (TEXT): Orientações fornecidas ao paciente.
- **DT_EMISSAO** (DATETIME): Data e hora de emissão da receita.

## Fluxo das Funcionalidades

### 1. **Login**
- Usuário se autentica utilizando e-mail e senha.
- Redirecionamento para a página inicial (Dashboard) ou exibição de erro de login.

### 2. **Cadastro de Paciente**
- Campos: Nome, CPF, Data de Nascimento, Telefone, Endereço, Plano de Saúde.
- Verifica a duplicidade de CPF antes de salvar no banco.

### 3. **Agendamento de Consulta**
- Escolha do paciente, médico, data e horário disponível.
- Confirmação do agendamento ou cancelamento.

### 4. **Consulta/Prontuário**
- Histórico médico do paciente.
- Registro de novo atendimento com descrição.
- Prescrição de receita.

### 5. **Emissão de Receita**
- Campos para medicamentos prescritos e orientações ao paciente.
- Opção de salvar e imprimir a receita.

### 6. **Gerenciamento de Usuários**
- Listagem de usuários cadastrados.
- Botões para adicionar, editar e excluir usuários.

# Tarefas de Desenvolvimento - Sistema de Consultas Médicas

## **Matheus**
### **Cadastro de Pacientes (CRUD):**
- Desenvolvimento do formulário de cadastro de paciente (Nome, CPF, Data de Nascimento, Telefone, Endereço, Plano de Saúde).
- Validação de CPF duplicado.
- Criação da funcionalidade de listagem, edição e exclusão de pacientes.

### **Login e Autenticação:**
- Implementação do sistema de login (autenticação via E-mail e Senha).
- Lógica de redirecionamento após login.

### **Consultas Realizadas:**
- Exibição e organização de consultas realizadas, com a possibilidade de visualização e edição de observações.


## **Murilo**
### **Cadastro de Médicos (CRUD):**
- Desenvolvimento do formulário de cadastro de médico (Nome, Especialidade, CRM).
- Criação da funcionalidade de listagem, edição e exclusão de médicos.

### **Agendamento de Consultas:**
- Criação do formulário para agendamento de consultas (Escolha de Paciente, Médico, Data e Hora).
- Implementação da confirmação e cancelamento de agendamentos.

## **Guilherme**
### **Consulta e Prontuário:**
- Criação de tela para visualização do histórico médico de pacientes.
- Implementação da funcionalidade para registro de novos atendimentos e descrição no prontuário.
- Vinculação de consultas e prontuários.
  
### **Dashboard:**
- Implementação do dashboard principal com as principais informações do sistema, como consultas agendadas, prontuários e usuários.

## **Ednilton**
### **Emissão de Receitas:**
- Criação do formulário para emissão de receitas médicas (Medicamentos, Orientações).
- Lógica de salvar e imprimir a receita.

### **Gerenciamento de Usuários (Administração):**
- Desenvolvimento das funcionalidades para a administração de usuários: adicionar, editar, listar e excluir.
- Definição de permissões de acesso de acordo com o perfil (Recepcionista, Médico, Administrador).

## **Wilson**
### **Consultas (CRUD):**
- Implementação de CRUD completo para consultas médicas: Agendamento, Visualização, Edição e Cancelamento.
- Lógica de alteração de status da consulta (Agendada → Realizada ou Cancelada).

### **Gerenciamento de Consultas Realizadas:**
- Exibição e organização de consultas realizadas, com a possibilidade de visualização e edição de observações.

## **Lucas**
### **Prontuário Médico (CRUD):**
- Desenvolvimento do CRUD para prontuários médicos: Registro, Visualização, Edição e Exclusão.
- Vinculação entre prontuários, pacientes e médicos.



