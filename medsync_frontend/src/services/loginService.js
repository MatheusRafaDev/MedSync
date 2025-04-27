import api from './api';

export const loginUsuario = async (email, senha) => {
  try {
    const response = await api.post('/api/usuarios/login', { email, senha });
    const token = response.data.token; // Assume que a resposta contém um token
    const tipoUsuario = response.data.tipo; // Assume que o tipo do usuário vem na resposta
    localStorage.setItem('token', token); 

    // Redirecionamento com base no tipo de usuário
    if (tipoUsuario === 'ADMIN') {
      window.location.href = '/admin/dashboard'; // Página do administrador
    } else if (tipoUsuario === 'MEDICO') {
      window.location.href = '/medico/dashboard'; // Página do médico
    } else if (tipoUsuario === 'PACIENTE') {
      window.location.href = '/paciente/dashboard'; // Página do paciente
    } else {
      throw new Error('Tipo de usuário desconhecido');
    }

    return token; // Retorna o token em caso de sucesso
  } catch (error) {
    throw new Error('Usuário ou senha inválidos');
  }
};
