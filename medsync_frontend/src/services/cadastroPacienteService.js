import api from './api';

export const cadastrarPaciente = async (nome, email, senha, nascimento, telefone, rg) => {
  try {

    const formatarData = (data) => {
      const [dia, mes, ano] = data.split('/');
      return `${ano}-${mes}-${dia}`; // yyyy-MM-dd
    };

    // Preparar os dados para o DTO
    const pacienteDTO = {
      usuarioNome: nome,
      usuarioEmail: email,
      usuarioSenha: senha,
      nascimento: formatarData(nascimento), // formata antes de enviar
      telefone: telefone,
      rg: rg,
    };

    // Enviar a requisição diretamente usando axios
    const response = await await api.post('/api/pacientes', pacienteDTO, {
      headers: {
        'Content-Type': 'application/json',
      }
    });

    // Verifica se a requisição foi bem-sucedida
    if (response.status === 201) {
      window.location.href = '/login'; // Redireciona para o login
    } else {
      throw new Error('Erro inesperado ao criar a conta');
    }

    return response.status; // Retorna o status da resposta
  } catch (error) {
    console.error(error);
    throw new Error('Erro ao criar a conta. Tente novamente.');
  }
};
