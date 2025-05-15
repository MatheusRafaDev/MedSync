import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import InputMask from 'react-input-mask';
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
      const response = await axios.post('http://localhost:7070/api/usuarios', {
        nome,
        email,
        senha,
        tipo: 'PACIENTE',
      });

      const usuarioId = response.data.pkId;

      const pacienteData = {
        fk_usuario: usuarioId,
        dt_nascimento: nascimento,
        ds_telefone: telefone,
        ds_rg: rg,
      };

      await axios.post('http://localhost:7070/api/pacientes', pacienteData);

      if (response.status === 200) {
        navigate('/login');
      }
    } catch (error) {
      setErro('Erro ao criar a conta. Tente novamente.');
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
          <InputMask
            mask="99/99/9999"
            value={nascimento}
            onChange={(e) => setNascimento(e.target.value)}
          >
            {(inputProps) => (
              <input
                {...inputProps}
                type="text"
                id="nascimento"
                required
              />
            )}
          </InputMask>
        </div>

        <div className="form-group">
          <label htmlFor="telefone">Telefone</label>
          <InputMask
            mask="(99) 99999-9999"
            value={telefone}
            onChange={(e) => setTelefone(e.target.value)}
          >
            {(inputProps) => (
              <input
                {...inputProps}
                type="text"
                id="telefone"
                required
              />
            )}
          </InputMask>
        </div>

        <div className="form-group">
          <label htmlFor="rg">RG</label>
          <InputMask
            mask="99.999.999-9"
            value={rg}
            onChange={(e) => setRg(e.target.value)}
          >
            {(inputProps) => (
              <input
                {...inputProps}
                type="text"
                id="rg"
                required
              />
            )}
          </InputMask>
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
