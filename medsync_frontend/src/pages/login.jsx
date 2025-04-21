import React, { useState } from 'react';
import api from '../services/api';
import '../styles/login.css';


function Login() {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [erro, setErro] = useState('');

  const handleLogin = async (e) => {
    e.preventDefault();
    setErro('');

    try {
      const response = await api.post('http://localhost:7070/api/usuarios', { email, senha });
      
      // Sucesso → guarda o usuário no localStorage
      localStorage.setItem('usuario', JSON.stringify(response.data));
      alert('Login realizado com sucesso!');
      
      // Redireciona (exemplo)
      window.location.href = '/dashboard';
    } catch (err) {
      setErro('Usuário ou senha inválidos');
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
          <a href="/recuperar-senha">Esqueci minha senha</a>
        </p>
      </div>
    </div>
  );
}

export default Login;
