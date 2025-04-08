# 🏥 Sistema de Gestão para Clínica Médica

Este sistema contempla três áreas principais:

- **Área Administrativa**
- **Portal do Paciente**
- **Painel Médico**

---

## 🔧 1. Telas Administrativas (Área da Clínica)

### 🔐 Login e Acesso
- 🔑 Tela de Login (Admin, Médico, Paciente)
- 🔄 Recuperação de Senha *(para depois)*

### 🧑‍⚕️ Gestão de Médicos
- 📄 Listar médicos  
- ➕ Cadastrar médico  
- ✏️ Editar dados (nome, CRM, especialidade)  
- 🗓️ Vincular horários disponíveis  
- 📚 Histórico de consultas realizadas  

### 👤 Gestão de Pacientes
- 📄 Listar pacientes  
- ➕ Cadastrar paciente  
- ✏️ Editar dados  
- 📚 Histórico de atendimentos  
- 📎 Anexos/documentos (RG, carteirinha)

### 🗓️ Agenda Geral *(para depois)*
- 📆 Visualização semanal/mensal por médico  
- 🧭 Filtro por especialidade e médico  
- 🟢🔴 Status: Livre, Agendado, Finalizado, Cancelado

### 📋 Consultas
- 🏥 Agendamento manual pela recepção  
- 👨‍⚕️👩‍⚕️ Visualização por médico/paciente  
- 📌 Status: Confirmada / Realizada / Faltou / Cancelada  
- 🔁 Reagendamento

### 🧾 Prontuários e Registros
- 📂 Visualizar prontuário por paciente  
- 📝 Inserir diagnóstico, receita e exames

### 💵 Financeiro
- 📊 Faturamento por consulta ou convênio  
- 💳 Tela de pagamento manual  
- 🔍 Filtros por período, médico ou paciente  
- 📤 Exportar relatórios financeiros

### 📈 Relatórios e Análises
- 📅 Relatório de consultas por período/médico  
- 🧾 Relatório de atendimentos por convênio  
- 🆕 Relatório de pacientes novos  
- 💰 Relatório financeiro *(para depois)*

### ⚙️ Administração do Sistema
- 👥 Cadastro de usuários (recepção, TI etc.)  
- 🔐 Permissões por perfil  
- 🛠️ Configurações gerais (logo, e-mail da clínica, horários padrão)

---

## 🌐 2. Telas do Portal do Paciente

### 🔐 Login e Acesso
- 🔑 Login  
- 🆕 Cadastro de novo paciente  
- 🔄 Recuperação de senha

### 🗓️ Consultas
- 📅 Visualizar próximas e passadas  
- 🩺 Agendar nova consulta (especialidade, médico e horário)  
- ❌ Cancelar agendamento  
- 🔁 Reagendar

### 📁 Prontuário Pessoal
- 📚 Histórico de diagnósticos  
- 💊 Receitas médicas emitidas (PDF)  
- 🧪 Resultados de exames (upload pela clínica)

### 💳 Pagamentos
- 💰 Ver consultas pagas / pendentes  
- 🧾 Instruções de pagamento (boleto, Pix etc.)  
- 🗂️ Visualizar faturas anteriores

---

## 👨‍⚕️ 3. Telas do Médico (Painel Médico)

- 📆 Ver agenda do dia/semana  
- 📝 Preencher prontuário  
- 💊 Prescrever medicamentos  
- 🧪 Solicitar exames  
- 📚 Ver histórico do paciente

---

## 👨‍💻 Divisão de Tarefas por Desenvolvedor

### 🧑 Murilo – Gestão de Médicos e Agenda
- 📄 Listar médicos  
- ➕ Cadastrar médico  
- ✏️ Editar dados (nome, CRM, especialidade etc.)  
- 🗓️ Vincular horários disponíveis  
- 📚 Histórico de consultas realizadas  
- 📆 *(Pós-MVP)* Visualização semanal/mensal  
- 🔍 *(Pós-MVP)* Filtro por especialidade e médico

---

### 👨 Lucas – Gestão de Pacientes e Prontuário Pessoal
- 📄 Listar pacientes  
- ➕ Cadastrar paciente  
- ✏️ Editar dados  
- 📚 Histórico de atendimentos  
- 📎 Anexos e documentos  
- 📋 Histórico de diagnósticos  
- 💊 Receitas médicas (PDF)  
- 🧪 Resultados de exames (upload)

---

### 👨 Guilherme – Autenticação e Cadastro
- 🔑 Tela de login  
- 🆕 Cadastro de novo paciente  
- 🔄 Recuperação de senha *(pós-MVP)*  
- 👥 Cadastro de usuários internos  
- 🔐 Permissões por perfil

---

### 👨 Wilson – Consultas (Admin e Paciente)
- 📅 Agendamento manual pela recepção  
- 👨‍⚕️👩‍⚕️ Visualização por médico e paciente  
- 📌 Status da consulta  
- 🔁 Reagendamento  
- 🌐 Agendamento/Cancelamento/Reagendamento (Portal)

---

### 👨 Ednilton – Painel Médico e Prontuários
- 📆 Ver agenda do médico  
- 📝 Preencher prontuário  
- 💊 Prescrever medicamentos  
- 🧪 Solicitar exames  
- 📚 Ver histórico do paciente  
- 📂 Visualizar prontuário (Admin)  
- 🧾 Inserir diagnóstico, receita, exames

---

### 👨 Matheus – Financeiro, Relatórios e Configurações
- 💰 Faturamento por consulta/convênio  
- 💳 Tela de pagamento manual  
- 🔍 Filtros por período, médico e paciente  
- 📤 Exportar relatórios  
- 📈 Relatórios:
  - 📅 Consultas por período/médico  
  - 🧾 Atendimentos por convênio  
  - 🆕 Pacientes novos  
  - 💰 *(Pós-MVP)* Relatório financeiro  
- ⚙️ Configurações gerais do sistema

---
