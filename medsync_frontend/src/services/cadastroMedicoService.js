import api from './api';

export const cadastrarMedico = async (medico) => {
  try {
    const response = await api.post('/api/medicos', medico, {
      headers: {
        'Content-Type': 'application/json',
      },
    });

    if (response.status === 201) {
      return response.status;
    } else {
      throw new Error('Erro inesperado ao cadastrar médico.');
    }
  } catch (error) {
    console.error(error);
    throw new Error('Erro ao cadastrar médico. Tente novamente.');
  }
};
