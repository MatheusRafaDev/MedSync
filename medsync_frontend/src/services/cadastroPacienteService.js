import axios from 'axios';

export const cadastrarPaciente = async (nome, email, senha, nascimento, telefone, rg) => {
  try {
    // Preparar os dados para o DTO
    const pacienteDTO = {
      usuarioNome: nome,
      usuarioEmail: email,
      usuarioSenha: senha,
      nascimento: nascimento,
      telefone: telefone,
      rg: rg,
    };

    // Enviar a requisição diretamente usando axios
    const response = await axios.post('http://localhost:7070/api/pacientes', pacienteDTO, {
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
