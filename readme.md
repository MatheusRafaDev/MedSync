# 🏥 Sistema de Gestão para Clínica Médica

Este sistema contempla três áreas principais: **Administrativa**, **Portal do Paciente** e **Painel Médico**. Abaixo está a estrutura das funcionalidades planejadas.

---

## 🔧 1. Telas Administrativas (Área da Clínica)

### 🔐 Login e Acesso
- Tela de Login (Admin, Médico, Paciente)
- Recuperação de Senha *(para depois)*

### 🧑‍⚕️ Gestão de Médicos
- Listar Médicos
- Cadastrar Médico
- Editar Dados (nome, CRM, especialidade, etc.)
- Vincular horários disponíveis
- Histórico de consultas realizadas

### 👤 Gestão de Pacientes
- Listar Pacientes
- Cadastrar Paciente
- Editar Dados
- Histórico de atendimentos
- Anexos e documentos (RG, carteirinha, etc.)

### 🗓️ Agenda Geral *(para depois)*
- Visualização semanal/mensal por médico
- Filtro por especialidade e médico
- Status: Livre, Agendado, Finalizado, Cancelado

### 📋 Consultas
- Agendamento manual pela recepção
- Visualização por médico/paciente
- Status: Confirmada / Realizada / Faltou / Cancelada
- Reagendamento

### 🧾 Prontuários e Registros
- Visualizar prontuário por paciente
- Inserir diagnóstico, receita, exames

### 💵 Financeiro
- Faturamento por consulta ou convênio
- Tela de pagamento manual
- Filtros por período, médico ou paciente
- Exportar relatórios financeiros

### 🧠 Relatórios e Análises *(parcialmente para depois)*
- Relatório de consultas por período/médico
- Relatório financeiro *(para depois)*
- Relatório de atendimentos por convênio
- Relatório de pacientes novos

### ⚙️ Administração do Sistema
- Cadastro de usuários (funcionários da recepção, TI, etc.)
- Permissões por perfil
- Configurações gerais (logo, e-mail da clínica, horários padrão)

---

## 🌐 2. Telas do Portal do Paciente

### 🔐 Login e Acesso
- Login
- Cadastro de novo paciente
- Recuperação de senha

### 🗓️ Consultas
- Visualizar próximas e passadas
- Agendar nova consulta (selecionando especialidade, médico e horário)
- Cancelar agendamento
- Reagendar

### 📁 Prontuário Pessoal
- Histórico de diagnósticos
- Receitas médicas emitidas (PDF)
- Resultados de exames (upload pela clínica)

### 💳 Pagamentos
- Ver consultas pagas / pendentes
- Instruções de pagamento (boleto, Pix, etc.)
- Visualizar faturas anteriores

---

## 👩‍⚕️ 3. Telas do Médico (Painel Médico)

- Ver sua agenda do dia/semana
- Preencher prontuário
- Prescrever medicamentos
- Solicitar exames
- Ver histórico do paciente



# Sistema de Gestão para Clínica Médica

## Divisão de Tarefas por Desenvolvedor

### Murilo – Gestão de Médicos e Agenda
- Listar médicos  
- Cadastrar médico  
- Editar dados do médico (nome, CRM, especialidade etc.)  
- Vincular horários disponíveis  
- Histórico de consultas realizadas  
- (Pós MVP) Visualização semanal/mensal por médico  
- (Pós MVP) Filtro por especialidade e médico  

---

### Lucas – Gestão de Pacientes e Prontuário Pessoal (Portal do Paciente)
- Listar pacientes  
- Cadastrar paciente  
- Editar dados do paciente  
- Histórico de atendimentos  
- Anexos e documentos (RG, carteirinha etc.)  
- Histórico de diagnósticos (Portal)  
- Receitas médicas emitidas (PDF)  
- Resultados de exames (upload pela clínica)

---

### Gui – Autenticação e Cadastro (Admin + Portal Paciente)
- Tela de Login (Admin, Médico, Paciente)  
- Cadastro de novo paciente (Portal)  
- Recuperação de senha (Pós MVP)  
- Cadastro de usuários do sistema (Administração)  
- Permissões por perfil  

---

### Wilson – Consultas (Admin e Paciente)
- Agendamento manual pela recepção  
- Visualização por médico e por paciente  
- Status: Confirmada / Realizada / Faltou / Cancelada  
- Reagendamento  
- Agendar nova consulta (Portal do Paciente)  
- Cancelar / Reagendar (Portal)

---

### Edinilton – Painel Médico e Prontuários
- Ver agenda do médico (dia/semana)  
- Preencher prontuário  
- Prescrever medicamentos  
- Solicitar exames  
- Ver histórico do paciente  
- Visualizar prontuário por paciente (Admin)  
- Inserir diagnóstico, receita, exames

---

### Matheus – Financeiro, Relatórios e Configurações Gerais
- Faturamento por consulta ou convênio  
- Tela de pagamento manual  
- Filtros por período, médico ou paciente  
- Exportar relatórios financeiros  
- Relatórios:
  - Consultas por período/médico  
  - Atendimentos por convênio  
  - Pacientes novos  
  - Relatório financeiro (Pós MVP)  
- Configurações gerais (logo, e-mail da clínica, horários padrão)


