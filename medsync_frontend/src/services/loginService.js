import api from './api';

export const loginUsuario = async (email, senha) => {
  try {
    const response = await api.post('/api/usuarios/login', { email, senha });
    const token = response.data; 
    localStorage.setItem('token', token); 
    return token;
  } catch (error) {
    throw new Error('Usuário ou senha inválidos'); 
  }
};
