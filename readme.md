# Sistema de Gestão de Clínica Médica

## Descrição

O **Sistema de Gestão de Clínica Médica** é uma aplicação web para gerenciar clínicas médicas de forma eficiente. Ele permite a administração de usuários (administradores, médicos e pacientes), agendamento de consultas, visualização de prontuários e histórico de diagnósticos, entre outras funcionalidades.

Este projeto está sendo desenvolvido com o objetivo de oferecer uma solução simples e eficaz para o gerenciamento de clínicas, facilitando o controle de consultas, prontuários médicos e usuários internos da clínica.

## Funcionalidades do MVP

O MVP do sistema cobre as seguintes funcionalidades:

### Área Administrativa (Admin)
- **Login** para administradores, médicos e pacientes.
- **Listar médicos**.
- **Cadastrar/Editar médico** (nome, CRM, especialidade).
- **Listar pacientes**.
- **Cadastrar/Editar paciente** (dados básicos).
- **Agendar consulta manualmente**.
- **Visualizar consultas** (por médico/paciente).
- **Visualizar prontuário**.
- **Inserir diagnóstico, receita e exames**.
- **Cadastro de usuários internos** (com permissão básica).

### Portal do Paciente
- **Login / Cadastro**.
- **Visualizar consultas** (próximas e passadas).
- **Agendar nova consulta**.
- **Cancelar consulta**.
- **Ver histórico de diagnósticos e receitas**.

### Painel do Médico
- **Ver agenda do dia**.
- **Preencher prontuário** (diagnóstico, receita, exame).
- **Ver histórico do paciente**.

### Total de Telas para o MVP: 18


# Divisão de Tarefas - Sistema de Gestão de Clínica Médica

## Objetivo
Divisão de tarefas para a construção do MVP do Sistema de Gestão de Clínica Médica.

---

## 🧑‍💼 **Murilo** - **Médicos e Consultas (Admin)**

- **Listar médicos**
  - Tela de listagem de médicos cadastrados na plataforma.
- **Cadastrar/Editar médico**
  - Tela de cadastro/edição de médicos com os campos: nome, CRM, especialidade.
- **Agendar consulta manualmente**
  - Tela de agendamento de consultas associando médico e paciente.
- **Visualizar consultas**
  - Tela para visualização das consultas realizadas por médico e paciente.

---

## 👤 **Lucas** - **Pacientes e Prontuário**

- **Listar pacientes**
  - Tela de listagem de pacientes cadastrados na plataforma.
- **Cadastrar/Editar paciente**
  - Tela de cadastro/edição de paciente com os campos: nome, dados básicos, telefone, RG.
- **Visualizar prontuário**
  - Tela para visualizar o prontuário médico de um paciente, com diagnóstico, receitas e exames.

---

## 👨‍💼 **Guilherme** - **Usuários e Configuração Admin**

- **Cadastro de usuários internos**
  - Tela de cadastro de usuários administrativos.
- **Ajustes gerais e configurações do sistema**
  - Configuração de permissões para cada tipo de usuário.
- **Validação e filtros da visualização de consultas**
  - Implementação de filtros para visualização de consultas (por médico/paciente).
- **Configuração de permissões básicas**
  - Definir as permissões de acesso de cada tipo de usuário no sistema.

---

## 👥 **Wilson** - **Consultas e Portal Paciente**

- **Visualizar consultas (próximas e passadas) no portal**
  - Tela para o paciente visualizar suas consultas agendadas, passadas e futuras.
- **Agendar nova consulta no portal**
  - Tela onde o paciente pode agendar novas consultas com médicos disponíveis.
- **Cancelar consulta no portal**
  - Funcionalidade para que o paciente possa cancelar consultas agendadas.
- **Ver histórico de diagnósticos e receitas**
  - Tela para o paciente visualizar o histórico de diagnósticos, exames e receitas médicas.

---

## 🧑‍⚕️ **Ednilton** - **Painel do Médico e Prontuário**

- **Ver agenda do dia**
  - Tela onde o médico pode visualizar as consultas agendadas para o dia.
- **Preencher prontuário**
  - Funcionalidade para o médico preencher o prontuário do paciente, com diagnóstico, receita e exames.
- **Ver histórico do paciente**
  - Tela onde o médico pode visualizar o histórico de consultas, diagnósticos e exames do paciente.

---

## 🔐 **Matheus** - **Login e Administração**

- **Login (Admin, Médico, Paciente)**
  - Tela de login para os três tipos de usuários (admin, médico, paciente).
- **Login / Cadastro (Portal Paciente)**
  - Tela de login para pacientes e cadastro de novos pacientes.
- **Cadastro de usuários internos (Admin)**
  - Tela para criar e editar usuários administrativos.
- **Configuração de permissões básicas (Admin)**
  - Implementação de configuração de permissões para administradores, médicos e pacientes.

---

## Observações Finais

- Todos os participantes devem seguir a estrutura de UI/UX definida.
- As telas devem ser responsivas e funcionais em dispositivos móveis e desktop.
- O foco inicial deve ser garantir a funcionalidade básica de login, agendamento e prontuário para médicos e pacientes.









## Banco de Dados

O banco de dados é composto pelas seguintes tabelas:

### 🧑‍💼 Usuários (Admin, Médico, Paciente)
```sql
-- 🧑‍💼 Usuários (admin, médico, paciente)
CREATE TABLE tb_usuario (
  pk_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  ds_nome VARCHAR(100) NOT NULL,
  ds_email VARCHAR(100) UNIQUE NOT NULL,
  ds_senha VARCHAR(255) NOT NULL,
  ds_tipo VARCHAR(20) NOT NULL, -- 'admin', 'medico', 'paciente'
  tg_ativo BOOLEAN DEFAULT TRUE
);

-- 🧑‍⚕️ Médicos
CREATE TABLE tb_medico (
  pk_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  fk_usuario BIGINT NOT NULL,
  ds_crm VARCHAR(20) NOT NULL,
  ds_especialidade VARCHAR(50) NOT NULL,
  FOREIGN KEY (fk_usuario) REFERENCES tb_usuario(pk_id)
);

-- 👤 Pacientes
CREATE TABLE tb_paciente (
  pk_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  fk_usuario BIGINT NOT NULL,
  dt_nascimento DATE,
  ds_telefone VARCHAR(20),
  ds_rg VARCHAR(20),
  FOREIGN KEY (fk_usuario) REFERENCES tb_usuario(pk_id)
);

-- 📅 Consultas
CREATE TABLE tb_consulta (
  pk_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  fk_medico BIGINT NOT NULL,
  fk_paciente BIGINT NOT NULL,
  dt_hora DATETIME NOT NULL,
  ds_status VARCHAR(20) NOT NULL DEFAULT 'confirmada', -- confirmada, realizada, faltou, cancelada
  FOREIGN KEY (fk_medico) REFERENCES tb_medico(pk_id),
  FOREIGN KEY (fk_paciente) REFERENCES tb_paciente(pk_id)
);

-- 📂 Prontuário
CREATE TABLE tb_prontuario (
  pk_id BIGINT PRIMARY KEY AUTO_INCREMENT,
  fk_consulta BIGINT NOT NULL,
  ds_diagnostico TEXT,
  ds_receita TEXT,
  ds_exames TEXT,
  dt_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (fk_consulta) REFERENCES tb_consulta(pk_id)
);



