import axios from 'axios';

export const cadastrarPaciente = async (nome, email, senha, nascimento, telefone, rg) => {
  try {
    // Cadastra o usuário
    const response = await axios.post('http://localhost:7070/api/usuarios', {
      nome,
      email,
      senha,
      tipo: 'PACIENTE',
    });

    const usuarioId = response.data.pkId;

    // Dados do paciente, incluindo os novos campos
    const pacienteData = {
      fk_usuario: usuarioId,
      dt_nascimento: nascimento,
      ds_telefone: telefone,
      ds_rg: rg,
    };

    // Cadastra o paciente
    await axios.post('http://localhost:7070/api/pacientes', pacienteData);

    return response.status; // Retorna o status de sucesso
  } catch (error) {
    // Em caso de erro, lança uma exceção
    throw new Error('Erro ao criar a conta. Tente novamente.');
  }
};
