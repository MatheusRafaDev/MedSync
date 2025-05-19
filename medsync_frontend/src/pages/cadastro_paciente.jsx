import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { IMaskInput } from 'react-imask';
import { cadastrarPaciente } from '../services/cadastroPacienteService'; 
import '../styles/cadastro_paciente.css';

const CadastroPaciente = () => {
  const navigate = useNavigate();

  const [nome, setNome] = useState('');
  const [nascimento, setNascimento] = useState('');
  const [telefone, setTelefone] = useState('');

  const [cpf, setCpf] = useState('');
  const [endereco, setEndereco] = useState('');
  const [planoSaude, setPlanoSaude] = useState('');
  const [erro, setErro] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const status = await cadastrarPaciente(nome, nascimento, telefone, cpf, endereco, planoSaude);

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
          <label htmlFor="cpf">CPF</label>
          <IMaskInput
            mask="000.000.000-00"
            value={cpf}
            onAccept={(value) => setCpf(value)}
            placeholder="000.000.000-00"
            id="cpf"
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
          <label htmlFor="endereco">Endereço</label>
          <input
            type="text"
            id="endereco"
            value={endereco}
            onChange={(e) => setEndereco(e.target.value)}
            required
          />
        </div>

        <div className="form-group">
          <label htmlFor="planoSaude">Plano de Saúde</label>
          <input
            type="text"
            id="planoSaude"
            value={planoSaude}
            onChange={(e) => setPlanoSaude(e.target.value)}
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
