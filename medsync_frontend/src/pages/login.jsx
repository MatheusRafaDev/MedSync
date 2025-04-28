import React, { useState } from 'react';
import { loginUsuario } from '../services/loginService';
import '../styles/login.css';

function Login() {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [erro, setErro] = useState('');

  const handleLogin = async (e) => {
    e.preventDefault();
    setErro('');

    try {
      const token = await loginUsuario(email, senha);
      localStorage.setItem('token', token);
      alert('Login realizado com sucesso!');
      window.location.href = '/dashboard';
    } catch (err) {
      setErro('Email ou senha inválidos.');
    }
  };

  return (
    <div className="login-container">
      <div className="login-box">
        <h2 className="login-title">Login</h2>
        <form onSubmit={handleLogin}>
          <div className="form-group">
            <label htmlFor="email">Email:</label>
            <input 
              id="email"
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          
          <div className="form-group">
            <label htmlFor="senha">Senha:</label>
            <input 
              id="senha"
              type="password"
              value={senha}
              onChange={(e) => setSenha(e.target.value)}
              required
            />
          </div>

          {erro && <div className="erro">{erro}</div>}

          <button type="submit" className="btn-login">Entrar</button>
        </form>

        <div className="action-links">
          <a href="/recuperar-senha">Esqueci minha senha</a>
          
        </div>

      </div>
    </div>
  );
}

export default Login;
