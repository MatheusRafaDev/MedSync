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

# 📦 Estrutura de Banco de Dados – Sistema de Gestão para Clínica Médica

## 🧑‍⚕️ TB_MEDICO
| Campo         | Tipo         | Descrição                      |
|---------------|--------------|--------------------------------|
| ID_MEDICO     | INT (PK)     | Identificador do médico        |
| NM_MEDICO     | VARCHAR(100) | Nome do médico                 |
| NR_CRM        | VARCHAR(20)  | Número do CRM                  |
| DS_ESPECIALIDADE | VARCHAR(100) | Especialidade médica       |
| VL_EMAIL      | VARCHAR(100) | E-mail do médico (único)       |
| VL_SENHA      | VARCHAR(255) | Senha do médico (criptografada)|
| ST_ATIVO      | BOOLEAN      | Status de ativo/inativo        |

---

## 👤 TB_PACIENTE
| Campo         | Tipo         | Descrição                      |
|---------------|--------------|--------------------------------|
| ID_PACIENTE   | INT (PK)     | Identificador do paciente      |
| NM_PACIENTE   | VARCHAR(100) | Nome completo do paciente      |
| DT_NASCIMENTO | DATE         | Data de nascimento             |
| NR_CPF        | VARCHAR(14)  | CPF do paciente (único)        |
| VL_EMAIL      | VARCHAR(100) | E-mail do paciente (único)     |
| VL_SENHA      | VARCHAR(255) | Senha do paciente              |
| NR_TELEFONE   | VARCHAR(20)  | Telefone de contato            |
| DS_GENERO     | VARCHAR(20)  | Gênero                         |

---

## 📎 TB_PACIENTE_DOCUMENTO
| Campo             | Tipo         | Descrição                    |
|------------------|--------------|------------------------------|
| ID_DOCUMENTO      | INT (PK)     | Identificador do documento   |
| ID_PACIENTE       | INT (FK)     | Paciente relacionado         |
| DS_TIPO_DOCUMENTO | VARCHAR(50)  | Tipo de documento (ex: RG)   |
| VL_CAMINHO_ARQUIVO| TEXT         | Caminho do arquivo no servidor|

---

## ⏰ TB_HORARIO_MEDICO
| Campo         | Tipo         | Descrição                      |
|---------------|--------------|--------------------------------|
| ID_HORARIO    | INT (PK)     | Identificador do horário       |
| ID_MEDICO     | INT (FK)     | Médico relacionado             |
| DS_DIA_SEMANA | VARCHAR(20)  | Dia da semana                  |
| HR_INICIO     | TIME         | Hora de início                 |
| HR_FIM        | TIME         | Hora de fim                    |

---

## 📋 TB_CONSULTA
| Campo        | Tipo         | Descrição                      |
|--------------|--------------|--------------------------------|
| ID_CONSULTA  | INT (PK)     | Identificador da consulta      |
| ID_PACIENTE  | INT (FK)     | Paciente da consulta           |
| ID_MEDICO    | INT (FK)     | Médico responsável             |
| DT_CONSULTA  | DATE         | Data da consulta               |
| HR_CONSULTA  | TIME         | Hora da consulta               |
| DS_STATUS    | VARCHAR(20)  | Status da consulta             |
| VL_VALOR     | DECIMAL(10,2)| Valor da consulta              |

---

## 📂 TB_PRONTUARIO
| Campo         | Tipo        | Descrição                      |
|---------------|-------------|--------------------------------|
| ID_PRONTUARIO | INT (PK)    | Identificador do prontuário    |
| ID_CONSULTA   | INT (FK)    | Consulta relacionada           |
| DS_DIAGNOSTICO| TEXT        | Diagnóstico do paciente        |
| DS_RECEITA    | TEXT        | Receita médica emitida         |
| DS_EXAMES     | TEXT        | Exames solicitados             |

---

## 💳 TB_PAGAMENTO
| Campo         | Tipo         | Descrição                      |
|---------------|--------------|--------------------------------|
| ID_PAGAMENTO  | INT (PK)     | Identificador do pagamento     |
| ID_CONSULTA   | INT (FK)     | Consulta relacionada           |
| VL_PAGO       | DECIMAL(10,2)| Valor pago                     |
| DT_PAGAMENTO  | DATE         | Data do pagamento              |
| DS_FORMA_PAGAMENTO | VARCHAR(50) | Forma (boleto, pix, etc.) |

---

## 📊 TB_RELATORIO_LOG
| Campo         | Tipo        | Descrição                      |
|---------------|-------------|--------------------------------|
| ID_RELATORIO  | INT (PK)    | Identificador do relatório     |
| TP_RELATORIO  | VARCHAR(50) | Tipo do relatório              |
| DT_GERACAO    | TIMESTAMP   | Data/hora de geração           |
| DS_FILTRO     | TEXT        | Filtros aplicados              |

---

## 👥 TB_USUARIO_INTERNO
| Campo        | Tipo         | Descrição                      |
|--------------|--------------|--------------------------------|
| ID_USUARIO   | INT (PK)     | Identificador do usuário       |
| NM_USUARIO   | VARCHAR(100) | Nome do usuário interno        |
| VL_EMAIL     | VARCHAR(100) | E-mail                         |
| VL_SENHA     | VARCHAR(255) | Senha                          |
| DS_PERFIL    | VARCHAR(50)  | Perfil (admin, recepção, TI)   |

---

## ⚙️ TB_CONFIGURACAO
| Campo       | Tipo         | Descrição                      |
|-------------|--------------|--------------------------------|
| ID_CONFIG   | INT (PK)     | Identificador da configuração  |
| DS_CHAVE    | VARCHAR(100) | Nome da chave de configuração  |
| VL_VALOR    | TEXT         | Valor da configuração          |

---

