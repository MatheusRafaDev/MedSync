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

      localStorage.setItem('token', token);  // Armazena o token JWT
      alert('Login realizado com sucesso!');

      window.location.href = '/dashboard';
    } catch (err) {
      setErro(err.message);  
    }
  };

  return (
    <div className="login-container">
      <div className="login-box">
        <h2>Login</h2>
        <form onSubmit={handleLogin}>
          <div>
            <label>Email:</label>
            <input 
              type="email" 
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required />
          </div>
          <div>
            <label>Senha:</label>
            <input 
              type="password" 
              value={senha}
              onChange={(e) => setSenha(e.target.value)}
              required />
          </div>
          {erro && <p>{erro}</p>}
          <button type="submit">Entrar</button>
        </form>

        <p className="forgot-password">
          <a href="/recuperar-senha" className="btn-link">Esqueci minha senha</a>
        </p>
        <a onClick={() => window.location.href = 'http://localhost:3000/cadastro_paciente'} className="btn-cadastro"> 
          Cadastro de Paciente
        </a>


      </div>
    </div>
  );
}

export default Login;
