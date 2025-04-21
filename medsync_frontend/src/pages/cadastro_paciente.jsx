import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { IMaskInput } from 'react-imask';
import { cadastrarPaciente } from '../services/cadastroPacienteService'; 
import '../styles/cadastro_paciente.css';

const CadastroPaciente = () => {
  const navigate = useNavigate();

  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [confirmarSenha, setConfirmarSenha] = useState('');

  const [nascimento, setNascimento] = useState('');
  const [telefone, setTelefone] = useState('');
  const [rg, setRg] = useState('');

  const [erro, setErro] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (senha !== confirmarSenha) {
      setErro('As senhas não coincidem.');
      return;
    }

    try {
      const status = await cadastrarPaciente(nome, email, senha, nascimento);

      if (status === 200) {
        navigate('/login');
      }
    } catch (error) {
      setErro(error.message); 
    }
  };

  return (
    <div className="form-container">
      <h2>Cadastro de Paciente</h2>
      {erro && <p className="error">{erro}</p>}
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="nome">Nome</label>
          <input
            type="text"
            id="nome"
            value={nome}
            onChange={(e) => setNome(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
        <label htmlFor="senha">Senha</label>
        <input
            type="password"
            id="senha"
            value={senha}
            onChange={(e) => setSenha(e.target.value)}
            required
        />
        </div>

        <div className="form-group">
        <label htmlFor="confirmarSenha">Confirmar Senha</label>
        <input
            type="password"
            id="confirmarSenha"
            value={confirmarSenha}
            onChange={(e) => setConfirmarSenha(e.target.value)}
            required
        />
        </div>


        <div className="form-group">
          <label htmlFor="nascimento">Data de Nascimento</label>
          <IMaskInput
            mask="00/00/0000"
            value={nascimento}
            onAccept={(value) => setNascimento(value)}
            placeholder="dd/mm/aaaa"
            id="nascimento"
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="telefone">Telefone</label>
          <IMaskInput
            mask="(00) 00000-0000"
            value={telefone}
            onAccept={(value) => setTelefone(value)}
            placeholder="(99) 99999-9999"
            id="telefone"
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="rg">RG</label>
          <IMaskInput
            mask="00.000.000-0"
            value={rg}
            onAccept={(value) => setRg(value)}
            placeholder="00.000.000-0"
            id="rg"
            required
          />
        </div>

        <button type="submit" className="submit-button">
          Criar Conta
        </button>
      </form>

      <p>
        Já tem uma conta? <a href="/login">Faça login</a>
      </p>
    </div>
  );
};

export default CadastroPaciente;
