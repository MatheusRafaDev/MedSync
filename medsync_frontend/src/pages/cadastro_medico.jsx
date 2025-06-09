import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { cadastrarMedico } from "../services/cadastroMedicoService"; 
import "../styles/cadastro_medico.css";

export default function CadastroMedicoForm() {
  const [form, setForm] = useState({
    nome: "",
    crm: "",
    especialidade: "",
    email: "",
    senha: "",
    status: "ativo",
  });

  const [erro, setErro] = useState("");
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm({ ...form, [name]: value });
  };

  const handleStatusChange = (e) => {
    setForm({ ...form, status: e.target.value });
  };

  const handleSubmit = async () => {
    try {
      const status = await cadastrarMedico(form);
      if (status === 201) {
        navigate("/login");
      }
    } catch (error) {
      setErro(error.message);
    }
  };

  return (
    <div className="container">
      <h2>Cadastro Médico</h2>

      {erro && <p className="error">{erro}</p>}

      <div>
        <label htmlFor="nome">Nome Completo</label>
        <input
          type="text"
          name="nome"
          id="nome"
          value={form.nome}
          onChange={handleChange}
        />
      </div>

      <div>
        <label htmlFor="crm">CRM</label>
        <input
          type="text"
          name="crm"
          id="crm"
          value={form.crm}
          onChange={handleChange}
        />
      </div>

      <div>
        <label htmlFor="especialidade">Especialidade</label>
        <input
          type="text"
          name="especialidade"
          id="especialidade"
          value={form.especialidade}
          onChange={handleChange}
        />
      </div>

      <div>
        <label htmlFor="email">E-mail</label>
        <input
          type="email"
          name="email"
          id="email"
          value={form.email}
          onChange={handleChange}
        />
      </div>

      <div>
        <label htmlFor="senha">Senha</label>
        <input
          type="password"
          name="senha"
          id="senha"
          value={form.senha}
          onChange={handleChange}
        />
      </div>

      <div>
        <label>Status Ativo</label>
        <div className="status-container">
          <label>
            <input
              type="radio"
              name="status"
              value="ativo"
              checked={form.status === "ativo"}
              onChange={handleStatusChange}
            />
            Ativo
          </label>
          <label>
            <input
              type="radio"
              name="status"
              value="inativo"
              checked={form.status === "inativo"}
              onChange={handleStatusChange}
            />
            Inativo
          </label>
        </div>
      </div>

      <div className="button-group">
        <button onClick={handleSubmit} className="primary">Salvar novo</button>
        <button className="secondary">Editar</button>
        <button className="secondary">Ativar/Inativar</button>
      </div>
    </div>
  );
}
