import api from './api';

export const cadastrarPaciente = async (nome, nascimento, telefone, cpf, endereco, planoSaude) => {
  try {

    const formatarData = (data) => {
      const [dia, mes, ano] = data.split('/');
      return `${ano}-${mes}-${dia}`; // yyyy-MM-dd
    };

    const paciente = {
      nome: nome,
      cpf: cpf,
      nascimento: formatarData(nascimento), 
      telefone: telefone,
      endereco: endereco,
      planoSaude: planoSaude, 
    };

    // Enviar a requisição diretamente usando axios
    const response = await api.post('/api/pacientes', paciente, {
      headers: {
        'Content-Type': 'application/json',
      }
    });

    // Verifica se a requisição foi bem-sucedida
    if (response.status === 201) {
      return response.status; // Retorna o status da resposta
    } else {
      throw new Error('Erro inesperado ao criar a conta');
    }

  } catch (error) {
    console.error(error);
    throw new Error('Erro ao criar a conta. Tente novamente.');
  }
};
