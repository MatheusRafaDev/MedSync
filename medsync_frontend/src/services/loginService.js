
import api from './api';

export const loginUsuario = async (email, senha) => {
  try {
    const response = await api.post('http://localhost:7070/api/usuarios', { email, senha });
    return response.data; 
  } catch (error) {
    throw new Error('Usuário ou senha inválidos'); 
  }
};
